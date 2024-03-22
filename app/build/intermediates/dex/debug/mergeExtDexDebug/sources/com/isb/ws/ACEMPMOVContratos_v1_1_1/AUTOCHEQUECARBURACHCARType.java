package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AUTOCHEQUE_CARBUR_ACHCAR_Type", propOrder = {"seriecheque", "numeroautocheque"})
public class AUTOCHEQUECARBURACHCARType {
    @XmlElement(name = "NUMERO_AUTOCHEQUE", required = true)
    protected String numeroautocheque;
    @XmlElement(name = "SERIE_CHEQUE", required = true)
    protected String seriecheque;

    public String getSERIECHEQUE() {
        return this.seriecheque;
    }

    public void setSERIECHEQUE(String str) {
        this.seriecheque = str;
    }

    public String getNUMEROAUTOCHEQUE() {
        return this.numeroautocheque;
    }

    public void setNUMEROAUTOCHEQUE(String str) {
        this.numeroautocheque = str;
    }
}
