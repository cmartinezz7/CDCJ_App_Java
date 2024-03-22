package es.santander.justicia.minisJusticia.models.requests.contratos;

import es.santander.justicia.minisJusticia.models.DatosCabecera;
import es.santander.justicia.minisJusticia.models.DatosConexion;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

public class ContratosEntrada {
    @Element(name = "entrada", required = false)
    private ContratoEntradaDetail contratoEntradaDetail;
    @Element(name = "datosCabecera", required = false)
    private DatosCabecera datosCabecera;
    @Element(name = "datosConexion", required = false)
    private DatosConexion datosConexion;
    @Attribute(name = "facade")
    private String facade = "ACEMPMOVContratos";

    public ContratosEntrada(ContratoEntradaDetail contratoEntradaDetail2) {
        this.contratoEntradaDetail = contratoEntradaDetail2;
        this.datosCabecera = new DatosCabecera();
        this.datosConexion = new DatosConexion();
    }
}
