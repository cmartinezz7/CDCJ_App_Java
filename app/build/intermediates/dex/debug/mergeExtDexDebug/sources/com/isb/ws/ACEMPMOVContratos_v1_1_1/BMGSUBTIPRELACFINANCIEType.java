package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BMG_SUBTIP_RELAC_FINANCIE_Type", propOrder = {"bmgidrolrelacfinancie", "codsubtiprelacfinancie"})
public class BMGSUBTIPRELACFINANCIEType {
    @XmlElement(name = "BMG_ID_ROL_RELAC_FINANCIE", required = true)
    protected String bmgidrolrelacfinancie;
    @XmlElement(name = "COD_SUBTIP_RELAC_FINANCIE", required = true)
    protected String codsubtiprelacfinancie;

    public String getBMGIDROLRELACFINANCIE() {
        return this.bmgidrolrelacfinancie;
    }

    public void setBMGIDROLRELACFINANCIE(String str) {
        this.bmgidrolrelacfinancie = str;
    }

    public String getCODSUBTIPRELACFINANCIE() {
        return this.codsubtiprelacfinancie;
    }

    public void setCODSUBTIPRELACFINANCIE(String str) {
        this.codsubtiprelacfinancie = str;
    }
}
