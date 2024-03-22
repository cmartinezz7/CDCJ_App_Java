package es.santander.justicia.minisJusticia.models.requests.authJuzgados;

import org.simpleframework.xml.Element;

public class AuthJuzgadosArg0 {
   @Element(
      name = "arg0",
      required = false
   )
   private AuthJuzgadosArg0Detail authJuzgadosArg0Detail;

   public void setAuthJuzgadosArg0Detail(AuthJuzgadosArg0Detail authJuzgadosArg0Detail) {
      this.authJuzgadosArg0Detail = authJuzgadosArg0Detail;
   }
}
