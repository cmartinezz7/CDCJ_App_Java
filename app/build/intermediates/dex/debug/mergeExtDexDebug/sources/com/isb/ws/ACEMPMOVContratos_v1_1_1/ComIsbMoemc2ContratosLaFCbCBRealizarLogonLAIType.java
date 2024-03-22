package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "com.isb.moemc2.contratos.la.f.cb.CB_RealizarLogon_LA_I_Type", namespace = "http://www.isban.es/webservices///F_moemc2_contratos_la/santander/internet/cbTypes/v1", propOrder = {"servicioComerciable"})
public class ComIsbMoemc2ContratosLaFCbCBRealizarLogonLAIType {
    @XmlElement(nillable = true)
    protected List<String> servicioComerciable;

    public List<String> getServicioComerciable() {
        if (this.servicioComerciable == null) {
            this.servicioComerciable = new ArrayList();
        }
        return this.servicioComerciable;
    }
}
