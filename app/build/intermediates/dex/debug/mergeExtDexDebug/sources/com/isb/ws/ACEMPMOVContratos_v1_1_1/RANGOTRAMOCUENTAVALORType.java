package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RANGO_TRAMO_CUENTA_VALOR_Type", propOrder = {"tramocuentadesde", "tramocuentahasta"})
public class RANGOTRAMOCUENTAVALORType {
    @XmlElement(name = "TRAMO_CUENTA_DESDE", required = true)
    protected String tramocuentadesde;
    @XmlElement(name = "TRAMO_CUENTA_HASTA", required = true)
    protected String tramocuentahasta;

    public String getTRAMOCUENTADESDE() {
        return this.tramocuentadesde;
    }

    public void setTRAMOCUENTADESDE(String str) {
        this.tramocuentadesde = str;
    }

    public String getTRAMOCUENTAHASTA() {
        return this.tramocuentahasta;
    }

    public void setTRAMOCUENTAHASTA(String str) {
        this.tramocuentahasta = str;
    }
}
