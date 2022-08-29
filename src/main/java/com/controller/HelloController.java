package com.controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@RestController
public class HelloController {

    // http://192.168.50.60:30300/hello
    @RequestMapping("/hello")
    public String hello(HttpServletRequest request, HttpServletResponse response){
        print(request, response);
        return "hello world";
    }

    @RequestMapping("/hello2")
    public String hello(HttpServletRequest request, HttpServletResponse response,
                        @RequestBody String body){
        System.out.println("RequestBody = "+body);
        print(request, response);
        return "hello world";
    }

    private void print(HttpServletRequest request, HttpServletResponse response){
        System.out.println("\r\n"+new java.util.Date());

        System.out.println("Method = "+request.getMethod());
        System.out.println("RemoteAddr = "+request.getRemoteAddr());
        System.out.println("RequestURL = "+request.getRequestURL());
        /*
        System.out.println("RequestURI = "+request.getRequestURI());
        System.out.println("AuthType = "+request.getAuthType());
        System.out.println("PathInfo = "+request.getPathInfo());
        System.out.println("QueryString = "+request.getQueryString());
        */
        Enumeration<String> headers =  request.getHeaderNames();
        while(headers.hasMoreElements()){
            String header = headers.nextElement();
            System.out.println("Header\t"+header+" = "+request.getHeader(header));
        }

        headers =  request.getParameterNames();
        while(headers.hasMoreElements()){
            String header = headers.nextElement();
            System.out.println("Parameter\t"+header+" = "+request.getParameter(header));
        }
/*
        headers =  request.getAttributeNames();
        while(headers.hasMoreElements()){
            String header = headers.nextElement();
            System.out.println("Attribute\t"+header+" = "+request.getAttribute(header));
        }
*/
    }
}