package es.santander.justicia.minisJusticia.models.responses;

import org.simpleframework.xml.Element;

public class ErrorResponse {
   @Element(
      name = "Fault",
      required = false
   )
   private ErrorResponseDetail errorResponseDetail;

   public ErrorResponseDetail getErrorResponseDetail() {
      return this.errorResponseDetail;
   }
}
