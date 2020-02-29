package com.vkotecha.springsecuritydemo.service;

import com.vkotecha.springsecuritydemo.dao.UserDao;
import com.vkotecha.springsecuritydemo.model.user.User;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author Vishal Kotecha
 */
@Service
public class AdminUserServiceImpl implements UserService {

  private final UserDao userDao;

  public AdminUserServiceImpl(UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public List<User> getAll() {
    return userDao.findAll();
  }
}
