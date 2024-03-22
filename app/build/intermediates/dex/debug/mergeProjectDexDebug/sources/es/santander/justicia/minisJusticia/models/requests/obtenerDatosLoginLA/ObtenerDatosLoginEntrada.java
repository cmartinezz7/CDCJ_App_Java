package es.santander.justicia.minisJusticia.models.requests.obtenerDatosLoginLA;

import es.santander.justicia.minisJusticia.models.DatosCabecera;
import es.santander.justicia.minisJusticia.models.DatosConexion;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

public class ObtenerDatosLoginEntrada {
    @Element(name = "datosCabecera", required = false)
    private DatosCabecera datosCabecera;
    @Element(name = "datosConexion", required = false)
    private DatosConexion datosConexion;
    @Attribute(name = "facade")
    private String facade = "ACEMPMOVContratos";
    @Element(name = "entrada", required = false)
    private ObtenerDatosLoginEntradaDetail obtenerDatosLoginEntradaDetail;

    public ObtenerDatosLoginEntrada(ObtenerDatosLoginEntradaDetail obtenerDatosLoginEntradaDetail2) {
        this.obtenerDatosLoginEntradaDetail = obtenerDatosLoginEntradaDetail2;
    }
}
