package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ZIP_CODE_Type", propOrder = {"zipcode", "codigocondado"})
public class ZIPCODEType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "CODIGO_CONDADO")
    protected int codigocondado;
    @XmlElement(name = "ZIPCODE", required = true)
    protected String zipcode;

    public String getZIPCODE() {
        return this.zipcode;
    }

    public void setZIPCODE(String str) {
        this.zipcode = str;
    }

    public int getCODIGOCONDADO() {
        return this.codigocondado;
    }

    public void setCODIGOCONDADO(int i) {
        this.codigocondado = i;
    }
}
