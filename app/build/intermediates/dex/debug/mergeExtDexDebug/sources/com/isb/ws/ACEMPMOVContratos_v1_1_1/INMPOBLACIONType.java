package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "INM_POBLACION_Type", propOrder = {"inmprovincia", "indpoblacion"})
public class INMPOBLACIONType {
    @XmlElement(name = "IND_POBLACION", required = true)
    protected String indpoblacion;
    @XmlElement(name = "INM_PROVINCIA", required = true)
    protected INMPROVINCIAType inmprovincia;

    public INMPROVINCIAType getINMPROVINCIA() {
        return this.inmprovincia;
    }

    public void setINMPROVINCIA(INMPROVINCIAType iNMPROVINCIAType) {
        this.inmprovincia = iNMPROVINCIAType;
    }

    public String getINDPOBLACION() {
        return this.indpoblacion;
    }

    public void setINDPOBLACION(String str) {
        this.indpoblacion = str;
    }
}
