package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MODULO_NEGOCIO_TITUS_Type", propOrder = {"codproyectotitus", "codigoalfanum8"})
public class MODULONEGOCIOTITUSType {
    @XmlElement(name = "CODIGO_ALFANUM_8", required = true)
    protected String codigoalfanum8;
    @XmlElement(name = "COD_PROYECTO_TITUS", required = true)
    protected String codproyectotitus;

    public String getCODPROYECTOTITUS() {
        return this.codproyectotitus;
    }

    public void setCODPROYECTOTITUS(String str) {
        this.codproyectotitus = str;
    }

    public String getCODIGOALFANUM8() {
        return this.codigoalfanum8;
    }

    public void setCODIGOALFANUM8(String str) {
        this.codigoalfanum8 = str;
    }
}
