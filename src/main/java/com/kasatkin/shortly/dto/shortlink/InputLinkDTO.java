package com.kasatkin.shortly.dto.shortlink;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class InputLinkDTO {

   @NotNull(message = "validation.dto.inputLink.blank")
   @NotBlank(message = "validation.dto.inputLink.null")
   @Pattern(regexp = "([--:\\w?@%&+~#=]*\\.[a-z]{2,4}\\/{0,2})((?:[?&](?:\\w+)=(?:\\w+))+|[--:\\w?@%&+~#=]+)?", message = "validation.dto.inputLink.pattern.invalid")
   private String inputLink;

   public InputLinkDTO() {
   }

   public InputLinkDTO(@Pattern(regexp = "([--:\\w?@%&+~#=]*\\.[a-z]{2,4}\\/{0,2})((?:[?&](?:\\w+)=(?:\\w+))+|[--:\\w?@%&+~#=]+)?") String inputLink) {
      this.inputLink = inputLink;
   }

   public String getInputLink() {
      return inputLink;
   }

   public void setInputLink(String inputLink) {
      this.inputLink = inputLink;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;

      InputLinkDTO that = (InputLinkDTO) o;

      return inputLink != null ? inputLink.equals(that.inputLink) : that.inputLink == null;
   }

   @Override
   public int hashCode() {
      return inputLink != null ? inputLink.hashCode() : 0;
   }

   @Override
   public String toString() {
      return "InputLinkDTO{" + "inputLink='" + inputLink + '\'' + '}';
   }
}
