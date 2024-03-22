package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_SUBTIPO_INCIDENCIA_ALM_Type", propOrder = {"codtipoincidenciaalm", "codsubtipincidenciaalm"})
public class IDSUBTIPOINCIDENCIAALMType {
    @XmlElement(name = "COD_SUBTIP_INCIDENCIA_ALM", required = true)
    protected String codsubtipincidenciaalm;
    @XmlElement(name = "COD_TIPO_INCIDENCIA_ALM", required = true)
    protected String codtipoincidenciaalm;

    public String getCODTIPOINCIDENCIAALM() {
        return this.codtipoincidenciaalm;
    }

    public void setCODTIPOINCIDENCIAALM(String str) {
        this.codtipoincidenciaalm = str;
    }

    public String getCODSUBTIPINCIDENCIAALM() {
        return this.codsubtipincidenciaalm;
    }

    public void setCODSUBTIPINCIDENCIAALM(String str) {
        this.codsubtipincidenciaalm = str;
    }
}
