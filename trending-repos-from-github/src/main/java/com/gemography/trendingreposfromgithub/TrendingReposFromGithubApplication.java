package com.gemography.trendingreposfromgithub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TrendingReposFromGithubApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrendingReposFromGithubApplication.class, args);
    }

}
