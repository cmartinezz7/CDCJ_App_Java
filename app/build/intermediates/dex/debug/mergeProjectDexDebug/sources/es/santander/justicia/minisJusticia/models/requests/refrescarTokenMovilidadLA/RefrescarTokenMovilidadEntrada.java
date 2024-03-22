package es.santander.justicia.minisJusticia.models.requests.refrescarTokenMovilidadLA;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

public class RefrescarTokenMovilidadEntrada {
    @Attribute(name = "facade")
    private String facade = "ACEMPMOVContratos";
    @Element(name = "entrada", required = false)
    private RefrescarTokenMovilidadEntradaDetail refrescarTokenMovilidadEntradaDetail;

    public RefrescarTokenMovilidadEntrada(RefrescarTokenMovilidadEntradaDetail refrescarTokenMovilidadEntradaDetail2) {
        this.refrescarTokenMovilidadEntradaDetail = refrescarTokenMovilidadEntradaDetail2;
    }
}
