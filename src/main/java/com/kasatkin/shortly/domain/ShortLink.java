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

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;

      ShortLink link = (ShortLink) o;

      if (id != link.id)
         return false;
      if (requestCount != link.requestCount)
         return false;
      if (originalLink != null ? !originalLink.equals(link.originalLink) : link.originalLink != null)
         return false;
      if (shortLink != null ? !shortLink.equals(link.shortLink) : link.shortLink != null)
         return false;
      return lastDateRequested != null ? lastDateRequested.equals(link.lastDateRequested) : link.lastDateRequested == null;
   }

   @Override
   public int hashCode() {
      int result = (int) (id ^ (id >>> 32));
      result = 31 * result + (originalLink != null ? originalLink.hashCode() : 0);
      result = 31 * result + (shortLink != null ? shortLink.hashCode() : 0);
      result = 31 * result + (int) (requestCount ^ (requestCount >>> 32));
      result = 31 * result + (lastDateRequested != null ? lastDateRequested.hashCode() : 0);
      return result;
   }

   @Override
   public String toString() {
      return "ShortLink{" + "id=" + id + ", originalLink='" + originalLink + '\'' + ", shortLink='" + shortLink + '\'' + ", requestCount=" + requestCount + ", lastDateRequested=" + lastDateRequested + '}';
   }
}
