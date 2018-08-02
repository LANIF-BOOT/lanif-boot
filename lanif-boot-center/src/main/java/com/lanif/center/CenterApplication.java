package com.lanif.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**   
* @Description: 启动一个服务注册中心提供给其他应用进行对话
* @author weiq
* @date 2018年7月27日 下午4:29:40 
*/

@EnableEurekaServer
@SpringBootApplication
public class CenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(CenterApplication.class, args);
    }
}

