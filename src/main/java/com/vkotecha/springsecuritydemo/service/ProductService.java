package com.vkotecha.springsecuritydemo.service;

import com.vkotecha.springsecuritydemo.dao.ProductDao;
import com.vkotecha.springsecuritydemo.model.Products;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author Vishal Kotecha
 */
@Service
public class ProductService {

  private final ProductDao productDao;

  public ProductService(ProductDao productDao) {
    this.productDao = productDao;
  }

  public List<Products> getAll() {
    return productDao.findAll();
  }
}
