package es.santander.justicia.minisJusticia.common.dto;

import es.santander.justicia.utils.Constants.ResultResponse;

public class ResponseServiceDTO {
   private ResultResponse resultResponse;
   private String mensajse;

   public ResultResponse getResultResponse() {
      return this.resultResponse;
   }

   public void setResultResponse(ResultResponse resultResponse) {
      this.resultResponse = resultResponse;
   }

   public String getMensajse() {
      return this.mensajse;
   }

   public void setMensajse(String mensajse) {
      this.mensajse = mensajse;
   }
}
