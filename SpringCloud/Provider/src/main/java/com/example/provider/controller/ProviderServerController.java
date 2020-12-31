package com.example.provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 木马
 * @title: ProviderServerController
 * @projectName SpringCloud
 * @date 2020/11/19 14:45
 * Feign远程服务调用与正常暴露接口是一样的,所以我们只需要仿照接口暴露编写
 */
@RestController
@RequestMapping("/Provider")
public class ProviderServerController {

    @RequestMapping("/providerServer")
    public String providerServer(){

        return "Hello SpringCloud！";

    }
}
