package com.kasatkin.shortly.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

   @Autowired
   private MessageSource messageSource;

   @ResponseBody
   @ResponseStatus(HttpStatus.BAD_REQUEST)
   @ExceptionHandler(MethodArgumentNotValidException.class)
   public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException e, Locale locale) {
      Map<String, String> errors = new HashMap<>();
      e.getBindingResult().getAllErrors().forEach(error -> {
         String fieldName = ((FieldError) error).getField();
         String errorKey = error.getDefaultMessage();
         String errorMessage = messageSource.getMessage(errorKey, null, locale);
         errors.put(fieldName, errorMessage);
      });
      return errors;
   }

   @ResponseBody
   @ResponseStatus(HttpStatus.NOT_FOUND)
   @ExceptionHandler(BadShortURLException.class)
   public Map<String, String> handleBadShortURl(BadShortURLException e, Locale locale) {
      return Map.of("errorMessage", messageSource.getMessage(e.getMessageKey(), new Object[]{e.getUrl()}, locale));
   }
}
