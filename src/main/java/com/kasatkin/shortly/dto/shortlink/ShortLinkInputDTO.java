package com.kasatkin.shortly.dto.shortlink;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ShortLinkInputDTO {

   @NotNull
   @NotBlank
   @Pattern(regexp = "([--:\\w?@%&+~#=]*\\.[a-z]{2,4}\\/{0,2})((?:[?&](?:\\w+)=(?:\\w+))+|[--:\\w?@%&+~#=]+)?")
   private String inputLink;

   public ShortLinkInputDTO() {
   }

   public ShortLinkInputDTO(@Pattern(regexp = "([--:\\w?@%&+~#=]*\\.[a-z]{2,4}\\/{0,2})((?:[?&](?:\\w+)=(?:\\w+))+|[--:\\w?@%&+~#=]+)?") String inputLink) {
      this.inputLink = inputLink;
   }

   public String getInputLink() {
      return inputLink;
   }

   public void setInputLink(String inputLink) {
      this.inputLink = inputLink;
   }
}
