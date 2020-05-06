package com.kasatkin.shortly.api;

import com.kasatkin.shortly.logging.Loggable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/")
public class Main {

   public static final String ERROR_MESSAGE_KEY = "errorMessage";

   @Loggable
   @GetMapping
   public String getIndex(Model model) {
      Object em = model.asMap().get(ERROR_MESSAGE_KEY);
      if (em != null) {
         model.addAttribute("frontendData", Map.of(ERROR_MESSAGE_KEY, em));
      }
      return "index";
   }
}
