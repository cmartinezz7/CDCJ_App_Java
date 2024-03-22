package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FORMANSWER_REMUOP_Type", propOrder = {"formquestidremuop", "codanswer"})
public class FORMANSWERREMUOPType {
    @XmlElement(name = "COD_ANSWER", required = true)
    protected String codanswer;
    @XmlElement(name = "FORMQUESTID_REMUOP", required = true)
    protected String formquestidremuop;

    public String getFORMQUESTIDREMUOP() {
        return this.formquestidremuop;
    }

    public void setFORMQUESTIDREMUOP(String str) {
        this.formquestidremuop = str;
    }

    public String getCODANSWER() {
        return this.codanswer;
    }

    public void setCODANSWER(String str) {
        this.codanswer = str;
    }
}
