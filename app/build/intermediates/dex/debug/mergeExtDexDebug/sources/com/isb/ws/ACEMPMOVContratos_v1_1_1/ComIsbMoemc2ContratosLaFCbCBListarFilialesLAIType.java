package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "com.isb.moemc2.contratos.la.f.cb.CB_ListarFiliales_LA_I_Type", namespace = "http://www.isban.es/webservices///F_moemc2_contratos_la/santander/internet/cbTypes/v1", propOrder = {"dato"})
public class ComIsbMoemc2ContratosLaFCbCBListarFilialesLAIType {
    @XmlElement(nillable = true)
    protected List<ComIsbMoemc2ContratosLaFCbCBListarFilialesLAKType> dato;

    public List<ComIsbMoemc2ContratosLaFCbCBListarFilialesLAKType> getDato() {
        if (this.dato == null) {
            this.dato = new ArrayList();
        }
        return this.dato;
    }
}
