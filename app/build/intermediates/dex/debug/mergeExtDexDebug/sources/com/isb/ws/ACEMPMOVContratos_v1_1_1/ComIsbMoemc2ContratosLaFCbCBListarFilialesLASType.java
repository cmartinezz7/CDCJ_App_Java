package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "com.isb.moemc2.contratos.la.f.cb.CB_ListarFiliales_LA_S_Type", namespace = "http://www.isban.es/webservices///F_moemc2_contratos_la/santander/internet/cbTypes/v1", propOrder = {"info", "finLista", "repos", "lista"})
public class ComIsbMoemc2ContratosLaFCbCBListarFilialesLASType {
    protected String finLista;
    protected ComIsbMoemc2ContratosLaFCbCBDatosSalidaInfoLAKType info;
    protected ComIsbMoemc2ContratosLaFCbCBListarFilialesLAIType lista;
    protected ComIsbMoemc2ContratosLaFCbCBListarFilialesLARepoType repos;

    public ComIsbMoemc2ContratosLaFCbCBDatosSalidaInfoLAKType getInfo() {
        return this.info;
    }

    public void setInfo(ComIsbMoemc2ContratosLaFCbCBDatosSalidaInfoLAKType comIsbMoemc2ContratosLaFCbCBDatosSalidaInfoLAKType) {
        this.info = comIsbMoemc2ContratosLaFCbCBDatosSalidaInfoLAKType;
    }

    public String getFinLista() {
        return this.finLista;
    }

    public void setFinLista(String str) {
        this.finLista = str;
    }

    public ComIsbMoemc2ContratosLaFCbCBListarFilialesLARepoType getRepos() {
        return this.repos;
    }

    public void setRepos(ComIsbMoemc2ContratosLaFCbCBListarFilialesLARepoType comIsbMoemc2ContratosLaFCbCBListarFilialesLARepoType) {
        this.repos = comIsbMoemc2ContratosLaFCbCBListarFilialesLARepoType;
    }

    public ComIsbMoemc2ContratosLaFCbCBListarFilialesLAIType getLista() {
        return this.lista;
    }

    public void setLista(ComIsbMoemc2ContratosLaFCbCBListarFilialesLAIType comIsbMoemc2ContratosLaFCbCBListarFilialesLAIType) {
        this.lista = comIsbMoemc2ContratosLaFCbCBListarFilialesLAIType;
    }
}
