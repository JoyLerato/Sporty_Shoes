package com.Sporty_Shoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sportyshoes.model.User;
import com.sportyshoes.repository.UserRepository;

@SpringBootApplication
public class SportyShoesApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SportyShoesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Check if admin user exists, if not, create one
        if (userRepository.findByEmail("admin@sportyshoes.com") == null) {
            User admin = new User();
            admin.setName("Admin");
            admin.setEmail("admin@sportyshoes.com");
            admin.setPassword(passwordEncoder.encode("admin123"));
            userRepository.save(admin);
        }
    }
}
