package com.kasatkin.shortly.service;

import com.kasatkin.shortly.domain.ShortLink;
import com.kasatkin.shortly.dto.shortlink.ShortLinkInputDTO;
import com.kasatkin.shortly.generator.ShortLinkGenerator;
import com.kasatkin.shortly.repo.ShortLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortLinkGeneratorService {

   private ShortLinkRepository shortLinkRepository;
   private ShortLinkGenerator shortLinkGenerator;

   @Autowired
   public ShortLinkGeneratorService(ShortLinkRepository shortLinkRepository, ShortLinkGenerator shortLinkGenerator) {
      this.shortLinkRepository = shortLinkRepository;
      this.shortLinkGenerator = shortLinkGenerator;
   }

   public ShortLink generateShortLink(ShortLinkInputDTO dto) {
      ShortLink existedShortlink = shortLinkRepository.findByOriginalLink(dto.getInputLink());
      if (existedShortlink != null) {
         return existedShortlink;
      }
      ShortLink link = new ShortLink();
      link.setOriginalLink(dto.getInputLink());
      link.setShortLink(shortLinkGenerator.generateRandomShortLink());
      return shortLinkRepository.save(link);

   }

}
