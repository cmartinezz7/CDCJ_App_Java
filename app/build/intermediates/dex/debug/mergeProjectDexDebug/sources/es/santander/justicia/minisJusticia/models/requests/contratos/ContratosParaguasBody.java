package es.santander.justicia.minisJusticia.models.requests.contratos;

import es.santander.justicia.minisJusticia.models.DatosCabecera;
import es.santander.justicia.minisJusticia.models.DatosConexion;
import org.simpleframework.xml.Element;

public class ContratosParaguasBody {
    @Element(name = "v1:listarContratosParaguas_LA", required = false)
    private ContratosEntrada contratosEntrada;
    @Element(name = "datosCabecera", required = false)
    private DatosCabecera datosCabecera = new DatosCabecera();
    @Element(name = "datosConexion", required = false)
    private DatosConexion datosConexion = new DatosConexion();

    public ContratosParaguasBody(ContratosEntrada contratosEntrada2) {
        this.contratosEntrada = contratosEntrada2;
    }
}
