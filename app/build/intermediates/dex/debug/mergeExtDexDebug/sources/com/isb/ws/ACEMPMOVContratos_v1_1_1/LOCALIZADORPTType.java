package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LOCALIZADOR_PT_Type", propOrder = {"centro", "numcontratolocal"})
public class LOCALIZADORPTType {
    @XmlElement(name = "CENTRO", required = true)
    protected CENTROType centro;
    @XmlElement(name = "NUM_CONTRATO_LOCAL", required = true)
    protected String numcontratolocal;

    public CENTROType getCENTRO() {
        return this.centro;
    }

    public void setCENTRO(CENTROType cENTROType) {
        this.centro = cENTROType;
    }

    public String getNUMCONTRATOLOCAL() {
        return this.numcontratolocal;
    }

    public void setNUMCONTRATOLOCAL(String str) {
        this.numcontratolocal = str;
    }
}
