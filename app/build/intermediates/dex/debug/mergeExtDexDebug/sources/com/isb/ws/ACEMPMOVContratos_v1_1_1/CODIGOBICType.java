package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CODIGO_BIC_Type", propOrder = {"entidadbic", "paisbic", "locatorbic", "branch"})
public class CODIGOBICType {
    @XmlElement(name = "BRANCH", required = true)
    protected String branch;
    @XmlElement(name = "ENTIDAD_BIC", required = true)
    protected String entidadbic;
    @XmlElement(name = "LOCATOR_BIC", required = true)
    protected String locatorbic;
    @XmlElement(name = "PAIS_BIC", required = true)
    protected String paisbic;

    public String getENTIDADBIC() {
        return this.entidadbic;
    }

    public void setENTIDADBIC(String str) {
        this.entidadbic = str;
    }

    public String getPAISBIC() {
        return this.paisbic;
    }

    public void setPAISBIC(String str) {
        this.paisbic = str;
    }

    public String getLOCATORBIC() {
        return this.locatorbic;
    }

    public void setLOCATORBIC(String str) {
        this.locatorbic = str;
    }

    public String getBRANCH() {
        return this.branch;
    }

    public void setBRANCH(String str) {
        this.branch = str;
    }
}
