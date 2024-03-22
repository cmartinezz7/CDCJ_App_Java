package es.santander.justicia.minisJusticia.common.dto;

import java.io.Serializable;

public class PeticionDTO implements Serializable {
   private String codExpediente;
   private String fecacept;
   private String fecpetic;
   private String jestactu;

   public PeticionDTO(String codExpediente, String fecacept, String fecpetic, String jestactu) {
      this.codExpediente = codExpediente;
      this.fecacept = fecacept;
      this.fecpetic = fecpetic;
      this.jestactu = jestactu;
   }

   public String getCodExpediente() {
      return this.codExpediente;
   }

   public String getFecacept() {
      return this.fecacept;
   }

   public String getFecpetic() {
      return this.fecpetic;
   }

   public String getJestactu() {
      return this.jestactu;
   }
}
