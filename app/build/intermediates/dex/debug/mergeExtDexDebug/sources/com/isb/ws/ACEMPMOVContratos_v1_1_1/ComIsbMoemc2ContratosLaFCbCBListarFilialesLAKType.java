package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "com.isb.moemc2.contratos.la.f.cb.CB_ListarFiliales_LA_K_Type", namespace = "http://www.isban.es/webservices///F_moemc2_contratos_la/santander/internet/cbTypes/v1", propOrder = {"documento", "nombreFilial"})
public class ComIsbMoemc2ContratosLaFCbCBListarFilialesLAKType {
    protected IDENTOFICIALPERSONAType documento;
    protected String nombreFilial;

    public IDENTOFICIALPERSONAType getDocumento() {
        return this.documento;
    }

    public void setDocumento(IDENTOFICIALPERSONAType iDENTOFICIALPERSONAType) {
        this.documento = iDENTOFICIALPERSONAType;
    }

    public String getNombreFilial() {
        return this.nombreFilial;
    }

    public void setNombreFilial(String str) {
        this.nombreFilial = str;
    }
}
