package com.dulianbin.dockerdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/testdockerfile")
    @ResponseBody
    public String dockerfile(){

        return "hello docker";
    }
}
