package es.santander.justicia.minisJusticia.models.requests.contratos;

import es.santander.justicia.minisJusticia.models.DatosCabecera;
import es.santander.justicia.minisJusticia.models.DatosConexion;
import org.simpleframework.xml.Element;

public class ContratosParaguasBody {
   @Element(
      name = "v1:listarContratosParaguas_LA",
      required = false
   )
   private ContratosEntrada contratosEntrada;
   @Element(
      name = "datosConexion",
      required = false
   )
   private DatosConexion datosConexion;
   @Element(
      name = "datosCabecera",
      required = false
   )
   private DatosCabecera datosCabecera;

   public ContratosParaguasBody(ContratosEntrada contratosEntrada) {
      this.contratosEntrada = contratosEntrada;
      this.datosConexion = new DatosConexion();
      this.datosCabecera = new DatosCabecera();
   }
}
