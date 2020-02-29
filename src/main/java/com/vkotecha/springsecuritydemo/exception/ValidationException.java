package com.vkotecha.springsecuritydemo.exception;

/**
 * @author Vishal Kotecha
 */
public class ValidationException extends RuntimeException {

  public ValidationException(String message) {
    super(message);
  }
}
