package com.cobi.transactional.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Slf4j
@SpringBootApplication
public class AopApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
    }

    @Bean
    CommandLineRunner onStartUp(UserService userService){
        return args -> {
            try {
                userService.createUserListWithTrans();
            } catch (Exception e){
                //..ignore
            }
                
                
            List<User> allUser = userService.findAllUser();
            log.info("created size : {}", allUser.size());
            log.info("created user : {}", allUser);
        };
    }
}
