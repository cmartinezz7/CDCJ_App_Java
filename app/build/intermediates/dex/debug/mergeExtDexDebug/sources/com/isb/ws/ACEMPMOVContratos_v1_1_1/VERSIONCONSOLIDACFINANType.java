package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VERSION_CONSOLIDAC_FINAN_Type", propOrder = {"periodoconsolidac", "perimetro", "idversion"})
public class VERSIONCONSOLIDACFINANType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "ID_VERSION")
    protected int idversion;
    @XmlElement(name = "PERIMETRO", required = true)
    protected String perimetro;
    @XmlElement(name = "PERIODO_CONSOLIDAC", required = true)
    protected PERIODOCONSOLIDACFINANType periodoconsolidac;

    public PERIODOCONSOLIDACFINANType getPERIODOCONSOLIDAC() {
        return this.periodoconsolidac;
    }

    public void setPERIODOCONSOLIDAC(PERIODOCONSOLIDACFINANType pERIODOCONSOLIDACFINANType) {
        this.periodoconsolidac = pERIODOCONSOLIDACFINANType;
    }

    public String getPERIMETRO() {
        return this.perimetro;
    }

    public void setPERIMETRO(String str) {
        this.perimetro = str;
    }

    public int getIDVERSION() {
        return this.idversion;
    }

    public void setIDVERSION(int i) {
        this.idversion = i;
    }
}
