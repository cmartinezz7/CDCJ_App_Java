package es.santander.justicia.minisJusticia.common.dto;

import java.io.Serializable;

public class SaldoExpedientDTO implements Serializable {
   private String impSaldo;
   private String codmon;
   private String moneda;

   public SaldoExpedientDTO(String impSaldo, String codmon, String moneda) {
      this.impSaldo = impSaldo;
      this.codmon = codmon;
      this.moneda = moneda;
   }

   public String getCodmon() {
      return this.codmon;
   }

   public String getImpSaldo() {
      return this.impSaldo;
   }

   public String getMoneda() {
      return this.moneda;
   }
}
