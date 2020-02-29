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
@RequestMapping("/admin/users")
public class AdminUserController {

  private final UserService adminUserService;

  public AdminUserController(@Qualifier("adminUserServiceImpl") UserService adminUserService) {
    this.adminUserService = adminUserService;
  }

  @GetMapping
  public List<User> getAll() {
    return adminUserService.getAll();
  }


}
