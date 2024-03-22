package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UBICACION_OVERRIDE_Type", propOrder = {"codalfanum3", "codubicacion"})
public class UBICACIONOVERRIDEType {
    @XmlElement(name = "COD_ALFANUM_3", required = true)
    protected String codalfanum3;
    @XmlElement(name = "COD_UBICACION", required = true)
    protected String codubicacion;

    public String getCODALFANUM3() {
        return this.codalfanum3;
    }

    public void setCODALFANUM3(String str) {
        this.codalfanum3 = str;
    }

    public String getCODUBICACION() {
        return this.codubicacion;
    }

    public void setCODUBICACION(String str) {
        this.codubicacion = str;
    }
}
