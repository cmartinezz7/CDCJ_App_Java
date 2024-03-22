package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PT_BIEN_Type", propOrder = {"ptoficina", "ptnumerodebien"})
public class PTBIENType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "PT_NUMERO_DE_BIEN")
    protected long ptnumerodebien;
    @XmlElement(name = "PT_OFICINA", required = true)
    protected String ptoficina;

    public String getPTOFICINA() {
        return this.ptoficina;
    }

    public void setPTOFICINA(String str) {
        this.ptoficina = str;
    }

    public long getPTNUMERODEBIEN() {
        return this.ptnumerodebien;
    }

    public void setPTNUMERODEBIEN(long j) {
        this.ptnumerodebien = j;
    }
}
