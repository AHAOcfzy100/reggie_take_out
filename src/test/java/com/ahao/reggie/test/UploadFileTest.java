package com.ahao.reggie.test;


import org.junit.jupiter.api.Test;

public class UploadFileTest {
    @Test
    public void uploadTest(){
        String fileName = "test.jpg";
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        System.out.println(suffix);
    }
}
