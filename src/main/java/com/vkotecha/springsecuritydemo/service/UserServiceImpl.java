package com.vkotecha.springsecuritydemo.service;

import com.vkotecha.springsecuritydemo.dao.UserDao;
import com.vkotecha.springsecuritydemo.model.user.User;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 * @author Vishal Kotecha
 */
@Service
public class UserServiceImpl implements UserService {

  private final UserDao userDao;

  public UserServiceImpl(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public List<User> getAll() {
    return userDao.findAll()
        .stream()
        .filter(user -> !user.getRolesStr().contains("admin"))
        .collect(Collectors.toList());
  }
}
