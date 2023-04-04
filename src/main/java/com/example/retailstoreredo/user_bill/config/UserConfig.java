package com.example.retailstoreredo.user_bill.config;

import com.example.retailstoreredo.user_bill.repo.UserRepo;
import com.example.retailstoreredo.user_bill.enums.UserType;
import com.example.retailstoreredo.user_bill.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            UserRepo userRepo) {
        return args -> {
            User david = new User();
            david.setEmail("");
            david.setName("");
            david.setUserType(UserType.EMPLOYEE);

            User stephen = new User();
            stephen.setEmail("");
            stephen.setName("");
            stephen.setUserType(UserType.AFFILIATE);

            User ben = new User();
            ben.setEmail("");
            ben.setName("");
            ben.setUserType(UserType.EMPLOYEE);

            User daniel = new User();
            daniel.setEmail("");
            daniel.setName("");
            daniel.setUserType(UserType.AFFILIATE);

            userRepo.saveAll(
                    List.of(david,stephen,ben,daniel)
            );
        };
    }
}
