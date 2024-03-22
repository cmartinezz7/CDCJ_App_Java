package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BMG_ID_EXTERNO_SECURITY_Type", propOrder = {"bmgtipoidsecurity", "bmgcodidextsecurity"})
public class BMGIDEXTERNOSECURITYType {
    @XmlElement(name = "BMG_COD_ID_EXT_SECURITY", required = true)
    protected String bmgcodidextsecurity;
    @XmlElement(name = "BMG_TIPO_ID_SECURITY", required = true)
    protected String bmgtipoidsecurity;

    public String getBMGTIPOIDSECURITY() {
        return this.bmgtipoidsecurity;
    }

    public void setBMGTIPOIDSECURITY(String str) {
        this.bmgtipoidsecurity = str;
    }

    public String getBMGCODIDEXTSECURITY() {
        return this.bmgcodidextsecurity;
    }

    public void setBMGCODIDEXTSECURITY(String str) {
        this.bmgcodidextsecurity = str;
    }
}
