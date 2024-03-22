package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.ws.WebFault;

@WebFault(name = "com.isb.moemc2.contratos.la.f.exc.General_Contratos_LA", targetNamespace = "http://www.isban.es/webservices///F_moemc2_contratos_la/santander/internet/functionalFaults/v1")
public class RealizarLogonLAComIsbMoemc2ContratosLaFExcGeneralContratosLAFault extends Exception {
    private ComIsbMoemc2ContratosLaFExcGeneralContratosLA faultInfo;

    public RealizarLogonLAComIsbMoemc2ContratosLaFExcGeneralContratosLAFault(String str, ComIsbMoemc2ContratosLaFExcGeneralContratosLA comIsbMoemc2ContratosLaFExcGeneralContratosLA) {
        super(str);
        this.faultInfo = comIsbMoemc2ContratosLaFExcGeneralContratosLA;
    }

    public RealizarLogonLAComIsbMoemc2ContratosLaFExcGeneralContratosLAFault(String str, ComIsbMoemc2ContratosLaFExcGeneralContratosLA comIsbMoemc2ContratosLaFExcGeneralContratosLA, Throwable th) {
        super(str, th);
        this.faultInfo = comIsbMoemc2ContratosLaFExcGeneralContratosLA;
    }

    public ComIsbMoemc2ContratosLaFExcGeneralContratosLA getFaultInfo() {
        return this.faultInfo;
    }
}
