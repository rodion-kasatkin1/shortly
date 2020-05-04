package com.kasatkin.shortly.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class ShortLink {

   @Id
   @GeneratedValue
   private long id;
   private String originalLink;
   private String shortLink;
   private long requestCount;
   private LocalDateTime lastDateRequested;

   public ShortLink() {
   }

   public ShortLink(long id, String originalLink, String shortLink, long requestCount, LocalDateTime lastDateRequested) {
      this.id = id;
      this.originalLink = originalLink;
      this.shortLink = shortLink;
      this.requestCount = requestCount;
      this.lastDateRequested = lastDateRequested;
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getOriginalLink() {
      return originalLink;
   }

   public void setOriginalLink(String originalLink) {
      this.originalLink = originalLink;
   }

   public String getShortLink() {
      return shortLink;
   }

   public void setShortLink(String shortLink) {
      this.shortLink = shortLink;
   }

   public long getRequestCount() {
      return requestCount;
   }

   public void setRequestCount(long requestCount) {
      this.requestCount = requestCount;
   }

   public LocalDateTime getLastDateRequested() {
      return lastDateRequested;
   }

   public void setLastDateRequested(LocalDateTime lastDateRequested) {
      this.lastDateRequested = lastDateRequested;
   }
}
