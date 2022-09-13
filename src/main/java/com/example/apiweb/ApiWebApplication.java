package com.example.apiweb;

import com.example.apiweb.Entity.RoleEntity;
import com.example.apiweb.Entity.UserEntity;
import com.example.apiweb.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiWebApplication {
    @Autowired
    UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(ApiWebApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            RoleEntity admin = new RoleEntity("admin");
            userService.createRole(admin);
            RoleEntity qtv = new RoleEntity("qtv");
            userService.createRole(qtv);

            RoleEntity userR = new RoleEntity("user");
            userService.createRole(userR);

            UserEntity user = new UserEntity();
            user.setUsername("admin");
            user.setPassword("$2a$12$u5r/Aev7zk0L6VAkxM6d6.PhQlDaS1TvwTqLcyqkZm1swPHYq7yk2"); //admin
            user.setExp(10000);
            user.setName("Admin");
            user.setRoleId(1);
            userService.createUser(user);
        };
    }

}
