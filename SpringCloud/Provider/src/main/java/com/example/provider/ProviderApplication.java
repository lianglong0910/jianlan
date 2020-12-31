package com.example.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class ProviderApplication {

    public static void main(String[] args) {

        System.out.println(">>>>>>>>>>>>>>> 启动ProviderServer <<<<<<<<<<<<<<<");

        SpringApplication.run(ProviderApplication.class, args);

        System.out.println(">>>>>>>>>>>>>>> 运行ProviderServer成功 <<<<<<<<<<<<<<<");

    }


}

