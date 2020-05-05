package com.kasatkin.shortly.api.generator;

import com.kasatkin.shortly.service.ShortLinkRedirectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/{shortURL}")
public class ShortUrlRedirectController {

   @Autowired
   private ShortLinkRedirectService redirectService;

   @GetMapping
   ModelAndView redirectByShortLink(@PathVariable String shortURL) {
      String redirectUrl = redirectService.getRedirect(shortURL);
      RedirectView redirectView = new RedirectView(redirectUrl);
      redirectView.setStatusCode(HttpStatus.TEMPORARY_REDIRECT);
      ModelAndView modelAndView = new ModelAndView(redirectView);
      // md.addObject("param1", "hello"); //Add your params here
      return modelAndView;
   }
}
