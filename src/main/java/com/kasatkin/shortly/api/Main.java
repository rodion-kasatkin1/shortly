package com.kasatkin.shortly.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Main {

   @Value("${spring.profile.active}")
   private String profile;

   @GetMapping
   public String getIndex(Model model) {
      model.addAttribute("isDevMode", "dev".equals(profile));
      return "index";
   }
}
