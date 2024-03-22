package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BRASILUNIORG_Type", propOrder = {"tipobrasiluniorg", "codigocentro"})
public class BRASILUNIORGType {
    @XmlElement(name = "CODIGO_CENTRO", required = true)
    protected String codigocentro;
    @XmlElement(name = "TIPO_BRASILUNIORG", required = true)
    protected String tipobrasiluniorg;

    public String getTIPOBRASILUNIORG() {
        return this.tipobrasiluniorg;
    }

    public void setTIPOBRASILUNIORG(String str) {
        this.tipobrasiluniorg = str;
    }

    public String getCODIGOCENTRO() {
        return this.codigocentro;
    }

    public void setCODIGOCENTRO(String str) {
        this.codigocentro = str;
    }
}
