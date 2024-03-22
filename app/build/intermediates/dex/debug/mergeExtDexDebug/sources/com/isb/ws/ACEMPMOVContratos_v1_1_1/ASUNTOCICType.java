package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ASUNTO_CIC_Type", propOrder = {"conversacioncic", "codigoasuntocic"})
public class ASUNTOCICType {
    @XmlElement(name = "CODIGO_ASUNTO_CIC", required = true)
    protected String codigoasuntocic;
    @XmlElement(name = "CONVERSACION_CIC", required = true)
    protected CONVERSACIONCICType conversacioncic;

    public CONVERSACIONCICType getCONVERSACIONCIC() {
        return this.conversacioncic;
    }

    public void setCONVERSACIONCIC(CONVERSACIONCICType cONVERSACIONCICType) {
        this.conversacioncic = cONVERSACIONCICType;
    }

    public String getCODIGOASUNTOCIC() {
        return this.codigoasuntocic;
    }

    public void setCODIGOASUNTOCIC(String str) {
        this.codigoasuntocic = str;
    }
}
