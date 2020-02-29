package com.vkotecha.springsecuritydemo.exception;

/**
 * @author Vishal Kotecha
 */
public class ObjectNotFoundException extends RuntimeException {

  public ObjectNotFoundException(String message) {
    super(message);
  }

}
