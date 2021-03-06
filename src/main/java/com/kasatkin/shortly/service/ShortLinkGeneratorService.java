package com.kasatkin.shortly.service;

import com.kasatkin.shortly.domain.ShortLink;
import com.kasatkin.shortly.dto.shortlink.InputLinkDTO;
import com.kasatkin.shortly.generator.ShortLinkGenerator;
import com.kasatkin.shortly.repo.ShortLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortLinkGeneratorService {

   private static final String HTTPS = "https://";
   private static final String HTTP = "http://";

   private ShortLinkRepository shortLinkRepository;
   private ShortLinkGenerator shortLinkGenerator;

   @Autowired
   public ShortLinkGeneratorService(ShortLinkRepository shortLinkRepository, ShortLinkGenerator shortLinkGenerator) {
      this.shortLinkRepository = shortLinkRepository;
      this.shortLinkGenerator = shortLinkGenerator;
   }

   public ShortLink generateShortLink(InputLinkDTO dto) {
      String inputLink = dto.getInputLink();
      if (!(inputLink.contains(HTTPS) || inputLink.contains(HTTP))) {
         inputLink = HTTP + inputLink;
      }
      ShortLink existedShortlink = shortLinkRepository.findByOriginalLink(inputLink);
      if (existedShortlink != null) {
         return existedShortlink;
      }
      ShortLink link = new ShortLink();
      link.setOriginalLink(inputLink);
      link.setShortLink(shortLinkGenerator.generateRandomShortLink());
      return shortLinkRepository.save(link);
   }

}
