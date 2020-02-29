package com.vkotecha.springsecuritydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringSecurityDemoApplication  implements CommandLineRunner {

  @Autowired
  private PasswordEncoder passwordEncoder;

  public static void main(String[] args) {
    SpringApplication.run(SpringSecurityDemoApplication.class, args);
  }

  @Override
  public void run(String... args) {
    String password = passwordEncoder.encode("test");
    System.out.println(password);
  }
}
