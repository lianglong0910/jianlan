package com.example.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 木马
 * @title: ConsumerService
 * @projectName SpringCloud
 * @date 2020/11/19 15:17
 * @FeignClient : feign客户端
 * name属性 ：提供者的服务名称
 */
@FeignClient(name = "eureka-provider")
public interface ConsumerService {

    @RequestMapping(method = RequestMethod.GET ,path = "/Provider/providerServer")
    String providerServer();

}