package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CONTRATO_PRESENTACION_1_Type", propOrder = {"componente1", "componente2", "componente3", "componente4"})
public class CONTRATOPRESENTACION1Type {
    @XmlElement(name = "COMPONENTE_1", required = true)
    protected String componente1;
    @XmlElement(name = "COMPONENTE_2", required = true)
    protected String componente2;
    @XmlElement(name = "COMPONENTE_3", required = true)
    protected String componente3;
    @XmlElement(name = "COMPONENTE_4", required = true)
    protected String componente4;

    public String getCOMPONENTE1() {
        return this.componente1;
    }

    public void setCOMPONENTE1(String str) {
        this.componente1 = str;
    }

    public String getCOMPONENTE2() {
        return this.componente2;
    }

    public void setCOMPONENTE2(String str) {
        this.componente2 = str;
    }

    public String getCOMPONENTE3() {
        return this.componente3;
    }

    public void setCOMPONENTE3(String str) {
        this.componente3 = str;
    }

    public String getCOMPONENTE4() {
        return this.componente4;
    }

    public void setCOMPONENTE4(String str) {
        this.componente4 = str;
    }
}
