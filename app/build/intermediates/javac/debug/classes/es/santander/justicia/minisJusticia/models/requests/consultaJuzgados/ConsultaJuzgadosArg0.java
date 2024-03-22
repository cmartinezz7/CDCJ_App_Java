package es.santander.justicia.minisJusticia.models.requests.consultaJuzgados;

import org.simpleframework.xml.Element;

public class ConsultaJuzgadosArg0 {
   @Element(
      name = "arg0",
      required = false
   )
   private ConsultaJuzgadosArg0Detail consultaJuzgadosArg0Detail;

   public ConsultaJuzgadosArg0(ConsultaJuzgadosArg0Detail consultaJuzgadosArg0Detail) {
      this.consultaJuzgadosArg0Detail = consultaJuzgadosArg0Detail;
   }
}
