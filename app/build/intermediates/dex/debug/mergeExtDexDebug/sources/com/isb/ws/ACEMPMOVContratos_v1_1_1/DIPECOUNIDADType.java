package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DIPECO_UNIDAD_Type", propOrder = {"codsociedad", "codunidad"})
public class DIPECOUNIDADType {
    @XmlElement(name = "COD_SOCIEDAD", required = true)
    protected String codsociedad;
    @XmlElement(name = "COD_UNIDAD", required = true)
    protected String codunidad;

    public String getCODSOCIEDAD() {
        return this.codsociedad;
    }

    public void setCODSOCIEDAD(String str) {
        this.codsociedad = str;
    }

    public String getCODUNIDAD() {
        return this.codunidad;
    }

    public void setCODUNIDAD(String str) {
        this.codunidad = str;
    }
}
