package com.kasatkin.shortly.exception;

public class BadShortURLException extends RuntimeException {

   private String url;
   private String messageKey;

   public BadShortURLException(String url, String messageKey) {
      this.url = url;
      this.messageKey = messageKey;
   }

   public String getUrl() {
      return url;
   }

   public void setUrl(String url) {
      this.url = url;
   }

   public String getMessageKey() {
      return messageKey;
   }

   public void setMessageKey(String messageKey) {
      this.messageKey = messageKey;
   }
}
