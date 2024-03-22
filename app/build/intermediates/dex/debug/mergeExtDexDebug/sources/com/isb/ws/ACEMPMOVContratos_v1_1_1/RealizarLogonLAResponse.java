package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "realizarLogon_LAResponse", namespace = "http://www.isban.es/webservices///F_moemc2_contratos_la/internet/ACEMPMOVContratos/v1")
@XmlType(name = "", propOrder = {"methodResult"})
public class RealizarLogonLAResponse {
    @XmlElement(required = true)
    protected ComIsbMoemc2ContratosLaFCbCBRealizarLogonLASType methodResult;

    public ComIsbMoemc2ContratosLaFCbCBRealizarLogonLASType getMethodResult() {
        return this.methodResult;
    }

    public void setMethodResult(ComIsbMoemc2ContratosLaFCbCBRealizarLogonLASType comIsbMoemc2ContratosLaFCbCBRealizarLogonLASType) {
        this.methodResult = comIsbMoemc2ContratosLaFCbCBRealizarLogonLASType;
    }
}
