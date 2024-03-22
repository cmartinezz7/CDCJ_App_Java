package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LITERAL_DE_TEXTO_Type", propOrder = {"idioma", "literaldetexto"})
public class LITERALDETEXTOType {
    @XmlElement(name = "IDIOMA", required = true)
    protected String idioma;
    @XmlElement(name = "LITERAL_DE_TEXTO", required = true)
    protected String literaldetexto;

    public String getIDIOMA() {
        return this.idioma;
    }

    public void setIDIOMA(String str) {
        this.idioma = str;
    }

    public String getLITERALDETEXTO() {
        return this.literaldetexto;
    }

    public void setLITERALDETEXTO(String str) {
        this.literaldetexto = str;
    }
}
