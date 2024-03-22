package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PRODUCTO_TECNICO_SEGUROS_Type", propOrder = {"codcompaniaseg", "codproductotecnico"})
public class PRODUCTOTECNICOSEGUROSType {
    @XmlElement(name = "COD_COMPANIA_SEG", required = true)
    protected String codcompaniaseg;
    @XmlElement(name = "COD_PRODUCTO_TECNICO", required = true)
    protected String codproductotecnico;

    public String getCODCOMPANIASEG() {
        return this.codcompaniaseg;
    }

    public void setCODCOMPANIASEG(String str) {
        this.codcompaniaseg = str;
    }

    public String getCODPRODUCTOTECNICO() {
        return this.codproductotecnico;
    }

    public void setCODPRODUCTOTECNICO(String str) {
        this.codproductotecnico = str;
    }
}
