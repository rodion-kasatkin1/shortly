package com.kasatkin.shortly.api.generator;

import com.kasatkin.shortly.domain.ShortLink;
import com.kasatkin.shortly.dto.shortlink.InputLinkDTO;
import com.kasatkin.shortly.logging.Loggable;
import com.kasatkin.shortly.service.ShortLinkGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/generate")
public class ShortLinkGeneratorController {

   @Autowired
   private ShortLinkGeneratorService generatorService;

   @Loggable
   @PostMapping
   @ResponseBody
   public ShortLink generateNewShortLink(@RequestBody @Valid InputLinkDTO dto) {
      return generatorService.generateShortLink(dto);
   }
}
