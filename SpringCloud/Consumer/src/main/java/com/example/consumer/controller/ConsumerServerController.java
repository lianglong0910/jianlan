package com.example.consumer.controller;

import com.example.consumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 木马
 * @title: ConsumerServerController
 * @projectName SpringCloud
 * @date 2020/11/19 15:16
 */
@RestController
@RequestMapping("/Consumer")
public class ConsumerServerController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private ConsumerService consumerService;

    @RequestMapping(value = "/test1",method = RequestMethod.GET)
    public String testMethod1(){
        //此参数为注册在Eureka中的服务
        String string = restTemplate.getForObject("http://eureka-provider//Provider/providerServer", String.class);
        System.out.println("string11111 = " + string);
        return string;
    }

    @RequestMapping(value = "/test2",method = RequestMethod.GET)
    public String testMethod2(){

        String string = consumerService.providerServer();
        System.out.println("string22222 = " + string);
        return string;

    }

}
