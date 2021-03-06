package com.coffeebrew.contentproviderservice;

import com.coffeebrew.contentproviderservice.configs.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class ContentProviderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContentProviderServiceApplication.class, args);
    }

}
