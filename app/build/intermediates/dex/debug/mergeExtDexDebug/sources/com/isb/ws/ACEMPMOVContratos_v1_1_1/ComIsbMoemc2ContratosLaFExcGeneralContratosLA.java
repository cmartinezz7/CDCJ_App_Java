package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "com.isb.moemc2.contratos.la.f.exc.General_Contratos_LA", namespace = "http://www.isban.es/webservices///F_moemc2_contratos_la/santander/internet/functionalFaults/v1")
@XmlType(name = "", propOrder = {"error"})
public class ComIsbMoemc2ContratosLaFExcGeneralContratosLA {
    protected ComIsbMoemc2ContratosLaFCbCBDatosSalidaDescLAKType error;

    public ComIsbMoemc2ContratosLaFCbCBDatosSalidaDescLAKType getError() {
        return this.error;
    }

    public void setError(ComIsbMoemc2ContratosLaFCbCBDatosSalidaDescLAKType comIsbMoemc2ContratosLaFCbCBDatosSalidaDescLAKType) {
        this.error = comIsbMoemc2ContratosLaFCbCBDatosSalidaDescLAKType;
    }
}
