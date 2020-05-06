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
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
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

   @ExceptionHandler(BadShortURLException.class)
   public Object handleBadShortURl(BadShortURLException e, Locale locale, RedirectAttributes redirectAttributes) {
      redirectAttributes.addFlashAttribute("errorMessage", messageSource.getMessage(e.getMessageKey(), new Object[]{e.getUrl()}, locale));
      return "redirect:/";
   }

   @ExceptionHandler(NoHandlerFoundException.class)
   public Object handleStaticResourceNotFound(final NoHandlerFoundException ex, HttpServletRequest req, RedirectAttributes redirectAttributes, Locale locale) {
      redirectAttributes.addFlashAttribute("errorMessage", messageSource.getMessage("exception.noController", new Object[]{req.getRequestURI()}, locale));
      return "redirect:/";
   }

}
