package es.santander.justicia.minisJusticia.models.requests;

import org.simpleframework.xml.Element;

public class DatosFiltradoRequest {
    @Element(name = "jfechareDe", required = false)
    private String jfechareDe;
    @Element(name = "jfechareHasta", required = false)
    private String jfechareHasta;
    @Element(name = "jimpnomiDe", required = false)
    private String jimpnomiDe;
    @Element(name = "jimpnomiHasta", required = false)
    private String jimpnomiHasta;
    @Element(name = "tipsel", required = false)
    private String tipsel;

    public DatosFiltradoRequest(String jfechareDe2, String jfechareHasta2, String jimpnomiDe2, String jimpnomiHasta2, String tipsel2) {
        if (jfechareDe2 != null) {
            this.jfechareDe = jfechareDe2;
        }
        if (jfechareHasta2 != null) {
            this.jfechareHasta = jfechareHasta2;
        }
        if (jimpnomiDe2 != null) {
            this.jimpnomiDe = jimpnomiDe2;
        }
        if (jimpnomiHasta2 != null) {
            this.jimpnomiHasta = jimpnomiHasta2;
        }
        if (tipsel2 != null) {
            this.tipsel = tipsel2;
        }
    }
}
