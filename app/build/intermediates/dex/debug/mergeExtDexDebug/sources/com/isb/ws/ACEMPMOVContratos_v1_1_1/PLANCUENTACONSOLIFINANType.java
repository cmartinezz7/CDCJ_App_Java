package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PLAN_CUENTA_CONSOLI_FINAN_Type", propOrder = {"entorno", "codalfanum8"})
public class PLANCUENTACONSOLIFINANType {
    @XmlElement(name = "COD_ALFANUM_8", required = true)
    protected String codalfanum8;
    @XmlElement(name = "ENTORNO", required = true)
    protected ENTORNOCONSOLIDACFINANType entorno;

    public ENTORNOCONSOLIDACFINANType getENTORNO() {
        return this.entorno;
    }

    public void setENTORNO(ENTORNOCONSOLIDACFINANType eNTORNOCONSOLIDACFINANType) {
        this.entorno = eNTORNOCONSOLIDACFINANType;
    }

    public String getCODALFANUM8() {
        return this.codalfanum8;
    }

    public void setCODALFANUM8(String str) {
        this.codalfanum8 = str;
    }
}
