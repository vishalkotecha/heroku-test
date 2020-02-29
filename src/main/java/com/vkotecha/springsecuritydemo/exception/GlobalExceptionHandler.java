package com.vkotecha.springsecuritydemo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
  private final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @ExceptionHandler(ValidationException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public @ResponseBody
  ErrorPayload processValidationError(ValidationException validationException) {
    LOG.error("{} - {}", HttpStatus.BAD_REQUEST, validationException.getMessage(), validationException);
    return ErrorPayload.of(validationException.getLocalizedMessage(), HttpStatus.BAD_REQUEST.value());
  }

  @ExceptionHandler(ObjectNotFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public @ResponseBody
  ErrorPayload processObjectNotFoundError(ObjectNotFoundException objectNotFoundException) {
    LOG.warn("{} - {} - {}", HttpStatus.NOT_FOUND, objectNotFoundException.getMessage(), objectNotFoundException);
    return ErrorPayload.of(objectNotFoundException.getLocalizedMessage(), HttpStatus.NOT_FOUND.value());
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public @ResponseBody
  ErrorPayload processServerError(Exception exception) {
    LOG.error("{} - {}", HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
    return ErrorPayload.of("Something went wrong!", HttpStatus.INTERNAL_SERVER_ERROR.value());
  }


  static class ErrorPayload {
    String errorMessage;
    Integer errorCode;

    public String getErrorMessage() {
      return errorMessage;
    }

    void setErrorMessage(String errorMessage) {
      this.errorMessage = errorMessage;
    }

    public Integer getErrorCode() {
      return errorCode;
    }

    void setErrorCode(Integer errorCode) {
      this.errorCode = errorCode;
    }


    static ErrorPayload of(final String errorMessage, final Integer errorCode) {
      ErrorPayload errorPayload = new ErrorPayload();
      errorPayload.setErrorMessage(errorMessage);
      errorPayload.setErrorCode(errorCode);
      return errorPayload;
    }
  }
}
