package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IDIOMA_CORPORATIVO_Type", propOrder = {"idiomaiso", "dialectoiso"})
public class IDIOMACORPORATIVOType {
    @XmlElement(name = "DIALECTO_ISO", required = true)
    protected String dialectoiso;
    @XmlElement(name = "IDIOMA_ISO", required = true)
    protected String idiomaiso;

    public String getIDIOMAISO() {
        return this.idiomaiso;
    }

    public void setIDIOMAISO(String str) {
        this.idiomaiso = str;
    }

    public String getDIALECTOISO() {
        return this.dialectoiso;
    }

    public void setDIALECTOISO(String str) {
        this.dialectoiso = str;
    }
}
