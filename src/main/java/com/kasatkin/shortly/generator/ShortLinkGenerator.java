package com.kasatkin.shortly.generator;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

@Component
public class ShortLinkGenerator {

   private static final int SHORT_LINK_LENGTH = 6;
   static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
   static SecureRandom rnd = new SecureRandom();

   public String generateRandomShortLink() {
      StringBuilder sb = new StringBuilder(SHORT_LINK_LENGTH);
      for (int i = 0; i < SHORT_LINK_LENGTH; i++) {
         sb.append(ALPHABET.charAt(rnd.nextInt(ALPHABET.length())));
      }
      return sb.toString();

   }

}
