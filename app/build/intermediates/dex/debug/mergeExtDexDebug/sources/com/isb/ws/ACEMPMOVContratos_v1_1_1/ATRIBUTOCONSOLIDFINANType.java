package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ATRIBUTO_CONSOLID_FINAN_Type", propOrder = {"entorno", "codalfanum5"})
public class ATRIBUTOCONSOLIDFINANType {
    @XmlElement(name = "COD_ALFANUM_5", required = true)
    protected String codalfanum5;
    @XmlElement(name = "ENTORNO", required = true)
    protected ENTORNOCONSOLIDACFINANType entorno;

    public ENTORNOCONSOLIDACFINANType getENTORNO() {
        return this.entorno;
    }

    public void setENTORNO(ENTORNOCONSOLIDACFINANType eNTORNOCONSOLIDACFINANType) {
        this.entorno = eNTORNOCONSOLIDACFINANType;
    }

    public String getCODALFANUM5() {
        return this.codalfanum5;
    }

    public void setCODALFANUM5(String str) {
        this.codalfanum5 = str;
    }
}
