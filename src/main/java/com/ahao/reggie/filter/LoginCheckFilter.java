package com.ahao.reggie.filter;

import com.ahao.reggie.common.BaseContext;
import com.ahao.reggie.common.R;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 检查用户是否已经完成登录
 */
@Slf4j
@WebFilter(filterName = "loginCheckFilter",urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    //路径匹配器，支持通配符
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 1.获取本次请求的URI
        String requestURI = request.getRequestURI();
        log.info("拦截到请求:{}", requestURI);
        // 定义不需要处理的请求路径
        String[] urls = new String[] {
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**",
                "/common/**",
                "/user/sendMsg",
                "/user/login"
        };
        // 2.判断本此请求是否需要处理
        boolean check = check(urls, requestURI);
        // 3.如果不需要处理，则直接放行
        if (check) {
            log.info("本此请求{}不需要处理",requestURI);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        // 4-1.判断登录状态，如果已登录，则直接放行
        HttpSession session = request.getSession();
        if (session.getAttribute("employee") != null) {
            log.info("用户已登录，用户id为:{}", session.getAttribute("employee"));
            Long empId = (Long) session.getAttribute("employee");
            BaseContext.setCurrentId(empId);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        // 4-2.判断登录状态，如果已登录，则直接放行
        if (session.getAttribute("user") != null) {
            log.info("用户已登录，用户id为:{}", session.getAttribute("user"));
            Long userId = (Long) session.getAttribute("user");
            BaseContext.setCurrentId(userId);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        log.info("用户未登录");
        // 5. 如果未登录则返回未登录结果，因为前端会统一拦截响应，所以通过输出流的方式向客户端页面响应规定好的拦截信息
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
        return;
    }

    /**
     * 路径匹配，检查本此请求是否需要放行
     * @param urls
     * @param requestURI
     * @return
     */
    public boolean check(String[] urls,String requestURI) {
        for (String url : urls) {
            if (PATH_MATCHER.match(url, requestURI)) {
                return true;
            }
        }
        return false;
    }
}
