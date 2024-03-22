package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CONCEPTO_ORDEN_HCE_Type", propOrder = {"codigoalfanum1", "codordenhce"})
public class CONCEPTOORDENHCEType {
    @XmlElement(name = "CODIGO_ALFANUM_1", required = true)
    protected String codigoalfanum1;
    @XmlElement(name = "COD_ORDEN_HCE", required = true)
    protected String codordenhce;

    public String getCODIGOALFANUM1() {
        return this.codigoalfanum1;
    }

    public void setCODIGOALFANUM1(String str) {
        this.codigoalfanum1 = str;
    }

    public String getCODORDENHCE() {
        return this.codordenhce;
    }

    public void setCODORDENHCE(String str) {
        this.codordenhce = str;
    }
}
