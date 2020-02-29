package com.vkotecha.springsecuritydemo.controller;

import com.vkotecha.springsecuritydemo.model.user.User;
import com.vkotecha.springsecuritydemo.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vishal Kotecha
 */
@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  public UserController(@Qualifier("userServiceImpl") UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public List<User> getAll() {
    return userService.getAll();
  }
}
