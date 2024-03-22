package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CASO_GESREG_GRH_Type", propOrder = {"centro", "cdgesreg"})
public class CASOGESREGGRHType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "CDGESREG")
    protected long cdgesreg;
    @XmlElement(name = "CENTRO", required = true)
    protected CENTROType centro;

    public CENTROType getCENTRO() {
        return this.centro;
    }

    public void setCENTRO(CENTROType cENTROType) {
        this.centro = cENTROType;
    }

    public long getCDGESREG() {
        return this.cdgesreg;
    }

    public void setCDGESREG(long j) {
        this.cdgesreg = j;
    }
}
