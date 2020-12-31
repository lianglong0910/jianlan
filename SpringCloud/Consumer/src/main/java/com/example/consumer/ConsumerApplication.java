package com.example.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @EnableFeignClients 启动feign客户端
 * @EnableEurekaClient 负责与 Eureka Server 配合向外提供注册与发现服务接口
 * @return
**/
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class ConsumerApplication {

    public static void main(String[] args) {

        System.out.println(">>>>>>>>>>>>>>> 启动ConsumerServer <<<<<<<<<<<<<<<");

        SpringApplication.run(ConsumerApplication.class, args);

        System.out.println(">>>>>>>>>>>>>>> 运行ConsumerServer成功 <<<<<<<<<<<<<<<");

    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }



}
