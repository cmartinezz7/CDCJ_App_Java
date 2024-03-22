package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KEY_SIGNATURE_Type", propOrder = {"positions", "positionvalues"})
public class KEYSIGNATUREType {
    @XmlElement(name = "POSITIONS", required = true)
    protected String positions;
    @XmlElement(name = "POSITION_VALUES", required = true)
    protected String positionvalues;

    public String getPOSITIONS() {
        return this.positions;
    }

    public void setPOSITIONS(String str) {
        this.positions = str;
    }

    public String getPOSITIONVALUES() {
        return this.positionvalues;
    }

    public void setPOSITIONVALUES(String str) {
        this.positionvalues = str;
    }
}
