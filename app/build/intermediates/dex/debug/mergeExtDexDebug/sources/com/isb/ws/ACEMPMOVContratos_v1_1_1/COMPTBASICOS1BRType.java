package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COMPT_BASICOS_1_BR_Type", propOrder = {"pesucadm", "peestciv", "pesexper", "petipper"})
public class COMPTBASICOS1BRType {
    @XmlElement(name = "PEESTCIV", required = true)
    protected String peestciv;
    @XmlElement(name = "PESEXPER", required = true)
    protected String pesexper;
    @XmlElement(name = "PESUCADM", required = true)
    protected String pesucadm;
    @XmlElement(name = "PETIPPER", required = true)
    protected String petipper;

    public String getPESUCADM() {
        return this.pesucadm;
    }

    public void setPESUCADM(String str) {
        this.pesucadm = str;
    }

    public String getPEESTCIV() {
        return this.peestciv;
    }

    public void setPEESTCIV(String str) {
        this.peestciv = str;
    }

    public String getPESEXPER() {
        return this.pesexper;
    }

    public void setPESEXPER(String str) {
        this.pesexper = str;
    }

    public String getPETIPPER() {
        return this.petipper;
    }

    public void setPETIPPER(String str) {
        this.petipper = str;
    }
}
