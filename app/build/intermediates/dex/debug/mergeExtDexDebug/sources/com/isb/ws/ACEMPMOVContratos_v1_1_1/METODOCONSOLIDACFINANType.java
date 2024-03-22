package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "METODO_CONSOLIDAC_FINAN_Type", propOrder = {"entornoconsolidacfinan", "codalfanum2"})
public class METODOCONSOLIDACFINANType {
    @XmlElement(name = "COD_ALFANUM_2", required = true)
    protected String codalfanum2;
    @XmlElement(name = "ENTORNO_CONSOLIDAC_FINAN", required = true)
    protected ENTORNOCONSOLIDACFINANType entornoconsolidacfinan;

    public ENTORNOCONSOLIDACFINANType getENTORNOCONSOLIDACFINAN() {
        return this.entornoconsolidacfinan;
    }

    public void setENTORNOCONSOLIDACFINAN(ENTORNOCONSOLIDACFINANType eNTORNOCONSOLIDACFINANType) {
        this.entornoconsolidacfinan = eNTORNOCONSOLIDACFINANType;
    }

    public String getCODALFANUM2() {
        return this.codalfanum2;
    }

    public void setCODALFANUM2(String str) {
        this.codalfanum2 = str;
    }
}
