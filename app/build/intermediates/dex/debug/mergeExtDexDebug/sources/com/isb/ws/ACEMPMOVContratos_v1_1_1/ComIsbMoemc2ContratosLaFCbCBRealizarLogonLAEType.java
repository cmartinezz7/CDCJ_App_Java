package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "com.isb.moemc2.contratos.la.f.cb.CB_RealizarLogon_LA_E_Type", namespace = "http://www.isban.es/webservices///F_moemc2_contratos_la/santander/internet/cbTypes/v1", propOrder = {"alias", "password", "servicioComerciable", "documentoPersona"})
public class ComIsbMoemc2ContratosLaFCbCBRealizarLogonLAEType {
    protected String alias;
    protected IDENTOFICIALPERSONAType documentoPersona;
    protected String password;
    protected String servicioComerciable;

    public String getAlias() {
        return this.alias;
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public String getServicioComerciable() {
        return this.servicioComerciable;
    }

    public void setServicioComerciable(String str) {
        this.servicioComerciable = str;
    }

    public IDENTOFICIALPERSONAType getDocumentoPersona() {
        return this.documentoPersona;
    }

    public void setDocumentoPersona(IDENTOFICIALPERSONAType iDENTOFICIALPERSONAType) {
        this.documentoPersona = iDENTOFICIALPERSONAType;
    }
}
