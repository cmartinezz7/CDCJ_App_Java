package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ITEM_TRADUCIBLE_Type", propOrder = {"claveconcatenada", "codigotipodedato"})
public class ITEMTRADUCIBLEType {
    @XmlElement(name = "CLAVE_CONCATENADA", required = true)
    protected String claveconcatenada;
    @XmlElement(name = "CODIGO_TIPO_DE_DATO", required = true)
    protected String codigotipodedato;

    public String getCLAVECONCATENADA() {
        return this.claveconcatenada;
    }

    public void setCLAVECONCATENADA(String str) {
        this.claveconcatenada = str;
    }

    public String getCODIGOTIPODEDATO() {
        return this.codigotipodedato;
    }

    public void setCODIGOTIPODEDATO(String str) {
        this.codigotipodedato = str;
    }
}
