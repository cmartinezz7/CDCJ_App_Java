package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COB_TAREA_Type", propOrder = {"codtarea", "codigoalfanum4"})
public class COBTAREAType {
    @XmlElement(name = "CODIGO_ALFANUM_4", required = true)
    protected String codigoalfanum4;
    @XmlElement(name = "COD_TAREA", required = true)
    protected COBSOLICITUDType codtarea;

    public COBSOLICITUDType getCODTAREA() {
        return this.codtarea;
    }

    public void setCODTAREA(COBSOLICITUDType cOBSOLICITUDType) {
        this.codtarea = cOBSOLICITUDType;
    }

    public String getCODIGOALFANUM4() {
        return this.codigoalfanum4;
    }

    public void setCODIGOALFANUM4(String str) {
        this.codigoalfanum4 = str;
    }
}
