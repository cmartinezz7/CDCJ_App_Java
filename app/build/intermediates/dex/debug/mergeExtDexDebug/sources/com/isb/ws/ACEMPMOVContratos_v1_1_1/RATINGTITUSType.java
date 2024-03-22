package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RATING_TITUS_Type", propOrder = {"codigoagenciatitus", "codrating"})
public class RATINGTITUSType {
    @XmlElement(name = "CODIGO_AGENCIA_TITUS", required = true)
    protected String codigoagenciatitus;
    @XmlElement(name = "COD_RATING", required = true)
    protected String codrating;

    public String getCODIGOAGENCIATITUS() {
        return this.codigoagenciatitus;
    }

    public void setCODIGOAGENCIATITUS(String str) {
        this.codigoagenciatitus = str;
    }

    public String getCODRATING() {
        return this.codrating;
    }

    public void setCODRATING(String str) {
        this.codrating = str;
    }
}
