package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "USO_INMUEBLE_SEGUROS_Type", propOrder = {"campo", "valorcampo"})
public class USOINMUEBLESEGUROSType {
    @XmlElement(name = "CAMPO", required = true)
    protected String campo;
    @XmlElement(name = "VALOR_CAMPO", required = true)
    protected String valorcampo;

    public String getCAMPO() {
        return this.campo;
    }

    public void setCAMPO(String str) {
        this.campo = str;
    }

    public String getVALORCAMPO() {
        return this.valorcampo;
    }

    public void setVALORCAMPO(String str) {
        this.valorcampo = str;
    }
}
