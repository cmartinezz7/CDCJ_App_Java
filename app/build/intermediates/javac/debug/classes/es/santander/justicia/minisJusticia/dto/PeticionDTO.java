package es.santander.justicia.minisJusticia.dto;

import android.util.Log;
import es.santander.justicia.utils.DateUtils;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PeticionDTO implements Serializable, Comparable<PeticionDTO> {
   private String codExpediente;
   private String fecacept;
   private String fecpetic;
   private String jestactu;

   public PeticionDTO() {
   }

   public PeticionDTO(String codExpediente, String fecacept, String fecpetic, String jestactu) {
      this.codExpediente = codExpediente;
      this.fecacept = fecacept;
      this.fecpetic = fecpetic;
      this.jestactu = jestactu;
   }

   public void setCodExpediente(String codExpediente) {
      this.codExpediente = codExpediente;
   }

   public void setFecacept(String fecacept) {
      this.fecacept = fecacept;
   }

   public void setFecpetic(String fecpetic) {
      this.fecpetic = fecpetic;
   }

   public void setJestactu(String jestactu) {
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

   public int compareTo(PeticionDTO petition) {
      try {
         SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
         Date date = sdf.parse(DateUtils.formatDate(this.fecpetic));
         Date dateToCompare = sdf.parse(DateUtils.formatDate(petition.getFecpetic()));
         return dateToCompare.compareTo(date);
      } catch (ParseException var5) {
         Log.e("PeticionDTO", "ParseException", var5);
         return 0;
      }
   }
}
