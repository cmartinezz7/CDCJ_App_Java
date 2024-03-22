package es.santander.justicia.minisJusticia.models.requests.consultaOperacion;

import org.simpleframework.xml.Element;

public class ConsultaOperacionRequestBody {
   @Element(
      name = "wsj:consultaOperaciones",
      required = false
   )
   private ConsultaOperacionArg0 consultaOperacionArg0;

   public ConsultaOperacionRequestBody(ConsultaOperacionArg0 consultaOperacionArg0) {
      this.consultaOperacionArg0 = consultaOperacionArg0;
   }
}
