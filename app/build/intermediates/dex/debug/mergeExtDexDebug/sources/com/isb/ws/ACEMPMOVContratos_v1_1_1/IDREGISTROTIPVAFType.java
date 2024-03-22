package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_REGISTRO_TIP_VAF_Type", propOrder = {"codregistro", "codtiporegustro"})
public class IDREGISTROTIPVAFType {
    @XmlElement(name = "COD_REGISTRO", required = true)
    protected String codregistro;
    @XmlElement(name = "COD_TIPO_REGUSTRO", required = true)
    protected String codtiporegustro;

    public String getCODREGISTRO() {
        return this.codregistro;
    }

    public void setCODREGISTRO(String str) {
        this.codregistro = str;
    }

    public String getCODTIPOREGUSTRO() {
        return this.codtiporegustro;
    }

    public void setCODTIPOREGUSTRO(String str) {
        this.codtiporegustro = str;
    }
}
