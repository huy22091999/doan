package com.huyphungkien;

import com.huyphungkien.config.StorageProperties;
import com.huyphungkien.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class Start {
    public static void main(String[] args) {
        SpringApplication.run(Start.class,args);
    }
    @Bean
    CommandLineRunner init(StorageService ss) {
        return(args->{
            ss.init();
        });
    }

}
