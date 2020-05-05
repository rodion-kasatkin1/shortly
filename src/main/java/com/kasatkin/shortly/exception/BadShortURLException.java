package com.kasatkin.shortly.exception;

public class BadShortURLException extends RuntimeException {

   public BadShortURLException(String message) {
      super(message);
   }
}
