/**
 * 
 */
package com.lanif.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**   
* @author weiq
* @date 2018年8月2日 上午10:16:30 
*/

@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class ConfigApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConfigApplication.class, args);
    }
}
