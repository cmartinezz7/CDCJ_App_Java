package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_SUBTIP_ERROR_INC_ALM_Type", propOrder = {"codigotipoerrorincalm", "codigosubtipoerrorinc"})
public class IDSUBTIPERRORINCALMType {
    @XmlElement(name = "CODIGO_SUBTIPO_ERROR_INC", required = true)
    protected String codigosubtipoerrorinc;
    @XmlElement(name = "CODIGO_TIPO_ERROR_INC_ALM", required = true)
    protected String codigotipoerrorincalm;

    public String getCODIGOTIPOERRORINCALM() {
        return this.codigotipoerrorincalm;
    }

    public void setCODIGOTIPOERRORINCALM(String str) {
        this.codigotipoerrorincalm = str;
    }

    public String getCODIGOSUBTIPOERRORINC() {
        return this.codigosubtipoerrorinc;
    }

    public void setCODIGOSUBTIPOERRORINC(String str) {
        this.codigosubtipoerrorinc = str;
    }
}
