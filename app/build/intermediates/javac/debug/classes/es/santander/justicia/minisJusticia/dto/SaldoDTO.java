package es.santander.justicia.minisJusticia.dto;

import java.io.Serializable;

public class SaldoDTO implements Serializable {
   private String codmon;
   private String ingpendconso;
   private String moneda;
   private String pagopendconf;
   private String pagopendconso;
   private String saldoconso;
   private String saldodia;
   private String saldodisp;
   private String saldoingdeposito;
   private String saldoingerroneo;
   private String principal;

   public String getCodmon() {
      return this.codmon;
   }

   public void setCodmon(String codmon) {
      this.codmon = codmon;
   }

   public String getMoneda() {
      return this.moneda;
   }

   public void setMoneda(String moneda) {
      this.moneda = moneda;
   }

   public String getIngpendconso() {
      return this.ingpendconso;
   }

   public void setIngpendconso(String ingpendconso) {
      this.ingpendconso = ingpendconso;
   }

   public String getPagopendconf() {
      return this.pagopendconf;
   }

   public void setPagopendconf(String pagopendconf) {
      this.pagopendconf = pagopendconf;
   }

   public String getPagopendconso() {
      return this.pagopendconso;
   }

   public void setPagopendconso(String pagopendconso) {
      this.pagopendconso = pagopendconso;
   }

   public String getSaldoconso() {
      return this.saldoconso;
   }

   public void setSaldoconso(String saldoconso) {
      this.saldoconso = saldoconso;
   }

   public String getSaldodia() {
      return this.saldodia;
   }

   public void setSaldodia(String saldodia) {
      this.saldodia = saldodia;
   }

   public String getSaldodisp() {
      return this.saldodisp;
   }

   public void setSaldodisp(String saldodisp) {
      this.saldodisp = saldodisp;
   }

   public String getSaldoingdeposito() {
      return this.saldoingdeposito;
   }

   public void setSaldoingdeposito(String saldoingdeposito) {
      this.saldoingdeposito = saldoingdeposito;
   }

   public String getSaldoingerroneo() {
      return this.saldoingerroneo;
   }

   public void setSaldoingerroneo(String saldoingerroneo) {
      this.saldoingerroneo = saldoingerroneo;
   }

   public String getPrincipal() {
      return this.principal;
   }

   public void setPrincipal(String principal) {
      this.principal = principal;
   }
}
