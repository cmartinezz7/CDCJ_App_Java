package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AREA_FUNCIONAL_TITUS_Type", propOrder = {"modulonegociotitus", "codigoalfanum"})
public class AREAFUNCIONALTITUSType {
    @XmlElement(name = "CODIGO_ALFANUM", required = true)
    protected String codigoalfanum;
    @XmlElement(name = "MODULO_NEGOCIO_TITUS", required = true)
    protected MODULONEGOCIOTITUSType modulonegociotitus;

    public MODULONEGOCIOTITUSType getMODULONEGOCIOTITUS() {
        return this.modulonegociotitus;
    }

    public void setMODULONEGOCIOTITUS(MODULONEGOCIOTITUSType mODULONEGOCIOTITUSType) {
        this.modulonegociotitus = mODULONEGOCIOTITUSType;
    }

    public String getCODIGOALFANUM() {
        return this.codigoalfanum;
    }

    public void setCODIGOALFANUM(String str) {
        this.codigoalfanum = str;
    }
}
