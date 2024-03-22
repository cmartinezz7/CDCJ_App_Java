package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COD_POSTAL_NACIONAL_Type", propOrder = {"provincia", "indcapitaldeprovincia", "distritopostal"})
public class CODPOSTALNACIONALType {
    @XmlElement(name = "DISTRITO_POSTAL", required = true)
    protected String distritopostal;
    @XmlElement(name = "IND_CAPITAL_DE_PROVINCIA", required = true)
    protected String indcapitaldeprovincia;
    @XmlElement(name = "PROVINCIA", required = true)
    protected String provincia;

    public String getPROVINCIA() {
        return this.provincia;
    }

    public void setPROVINCIA(String str) {
        this.provincia = str;
    }

    public String getINDCAPITALDEPROVINCIA() {
        return this.indcapitaldeprovincia;
    }

    public void setINDCAPITALDEPROVINCIA(String str) {
        this.indcapitaldeprovincia = str;
    }

    public String getDISTRITOPOSTAL() {
        return this.distritopostal;
    }

    public void setDISTRITOPOSTAL(String str) {
        this.distritopostal = str;
    }
}
