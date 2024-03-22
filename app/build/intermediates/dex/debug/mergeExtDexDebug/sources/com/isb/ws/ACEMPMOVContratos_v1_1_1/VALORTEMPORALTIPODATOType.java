package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VALOR_TEMPORAL_TIPO_DATO_Type", propOrder = {"codigotipodedato", "valortemporal"})
public class VALORTEMPORALTIPODATOType {
    @XmlElement(name = "CODIGO_TIPO_DE_DATO", required = true)
    protected String codigotipodedato;
    @XmlElement(name = "VALOR_TEMPORAL", required = true)
    protected String valortemporal;

    public String getCODIGOTIPODEDATO() {
        return this.codigotipodedato;
    }

    public void setCODIGOTIPODEDATO(String str) {
        this.codigotipodedato = str;
    }

    public String getVALORTEMPORAL() {
        return this.valortemporal;
    }

    public void setVALORTEMPORAL(String str) {
        this.valortemporal = str;
    }
}
