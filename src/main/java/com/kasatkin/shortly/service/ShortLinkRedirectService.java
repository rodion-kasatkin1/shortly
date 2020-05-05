package com.kasatkin.shortly.service;

import com.kasatkin.shortly.domain.ShortLink;
import com.kasatkin.shortly.exception.BadShortURLException;
import com.kasatkin.shortly.repo.ShortLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.time.LocalDateTime;

@Service
public class ShortLinkRedirectService {

   @Autowired
   private ShortLinkRepository shortLinkRepository;

   public String getRedirect(String url) {
      ShortLink link = shortLinkRepository.findByShortLink(url);
      if (link != null) {
         link.setLastDateRequested(LocalDateTime.now());
         link.setRequestCount(link.getRequestCount() + 1);
         shortLinkRepository.save(link);
         return link.getOriginalLink();
      }
      throw new BadShortURLException("Bad URL " + url);
   }
}
