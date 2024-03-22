package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "com.isb.moemc2.contratos.la.f.cb.CB_Cabecera_LA_K_Type", namespace = "http://www.isban.es/webservices///F_moemc2_contratos_la/santander/internet/cbTypes/v1", propOrder = {"idioma"})
public class ComIsbMoemc2ContratosLaFCbCBCabeceraLAKType {
    protected IDIOMACORPORATIVOType idioma;

    public IDIOMACORPORATIVOType getIdioma() {
        return this.idioma;
    }

    public void setIdioma(IDIOMACORPORATIVOType iDIOMACORPORATIVOType) {
        this.idioma = iDIOMACORPORATIVOType;
    }
}
