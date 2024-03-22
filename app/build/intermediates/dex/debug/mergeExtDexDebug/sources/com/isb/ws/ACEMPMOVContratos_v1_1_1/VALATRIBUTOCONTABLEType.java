package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VAL_ATRIBUTO_CONTABLE_Type", propOrder = {"denatributocontable", "valoratributo"})
public class VALATRIBUTOCONTABLEType {
    @XmlElement(name = "DEN_ATRIBUTO_CONTABLE", required = true)
    protected DENATRIBUTOCONTABLEType denatributocontable;
    @XmlElement(name = "VALOR_ATRIBUTO", required = true)
    protected String valoratributo;

    public DENATRIBUTOCONTABLEType getDENATRIBUTOCONTABLE() {
        return this.denatributocontable;
    }

    public void setDENATRIBUTOCONTABLE(DENATRIBUTOCONTABLEType dENATRIBUTOCONTABLEType) {
        this.denatributocontable = dENATRIBUTOCONTABLEType;
    }

    public String getVALORATRIBUTO() {
        return this.valoratributo;
    }

    public void setVALORATRIBUTO(String str) {
        this.valoratributo = str;
    }
}
