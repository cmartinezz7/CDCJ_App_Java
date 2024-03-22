package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NATURALEZA_PLAN_CONSOLI_Type", propOrder = {"entorno", "codalfanum2"})
public class NATURALEZAPLANCONSOLIType {
    @XmlElement(name = "COD_ALFANUM_2", required = true)
    protected String codalfanum2;
    @XmlElement(name = "ENTORNO", required = true)
    protected ENTORNOCONSOLIDACFINANType entorno;

    public ENTORNOCONSOLIDACFINANType getENTORNO() {
        return this.entorno;
    }

    public void setENTORNO(ENTORNOCONSOLIDACFINANType eNTORNOCONSOLIDACFINANType) {
        this.entorno = eNTORNOCONSOLIDACFINANType;
    }

    public String getCODALFANUM2() {
        return this.codalfanum2;
    }

    public void setCODALFANUM2(String str) {
        this.codalfanum2 = str;
    }
}
