package com.vkotecha.springsecuritydemo.service;

import com.vkotecha.springsecuritydemo.dao.ProductDao;
import com.vkotecha.springsecuritydemo.dao.UserDao;
import com.vkotecha.springsecuritydemo.model.Products;
import com.vkotecha.springsecuritydemo.model.user.User;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author Vishal Kotecha
 */
public interface UserService {

  List<User> getAll();
}
