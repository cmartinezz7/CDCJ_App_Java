package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "com.isb.moemc2.contratos.la.f.cb.CB_ConexionSinCliente_LA_K_Type", namespace = "http://www.isban.es/webservices///F_moemc2_contratos_la/santander/internet/cbTypes/v1", propOrder = {"canalMarco", "empresa"})
public class ComIsbMoemc2ContratosLaFCbCBConexionSinClienteLAKType {
    protected String canalMarco;
    protected String empresa;

    public String getCanalMarco() {
        return this.canalMarco;
    }

    public void setCanalMarco(String str) {
        this.canalMarco = str;
    }

    public String getEmpresa() {
        return this.empresa;
    }

    public void setEmpresa(String str) {
        this.empresa = str;
    }
}
