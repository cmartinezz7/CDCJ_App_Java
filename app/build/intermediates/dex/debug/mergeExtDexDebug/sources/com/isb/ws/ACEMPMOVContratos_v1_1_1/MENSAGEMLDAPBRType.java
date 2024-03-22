package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MENSAGEM_LDAP_BR_Type", propOrder = {"acao", "status"})
public class MENSAGEMLDAPBRType {
    @XmlElement(name = "ACAO", required = true)
    protected String acao;
    @XmlElement(name = "STATUS", required = true)
    protected String status;

    public String getACAO() {
        return this.acao;
    }

    public void setACAO(String str) {
        this.acao = str;
    }

    public String getSTATUS() {
        return this.status;
    }

    public void setSTATUS(String str) {
        this.status = str;
    }
}
