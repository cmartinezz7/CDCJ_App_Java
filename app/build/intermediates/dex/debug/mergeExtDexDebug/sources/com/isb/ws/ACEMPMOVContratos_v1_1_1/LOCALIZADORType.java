package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LOCALIZADOR_Type", propOrder = {"componente1", "componente2"})
public class LOCALIZADORType {
    @XmlElement(name = "COMPONENTE_1", required = true)
    protected String componente1;
    @XmlElement(name = "COMPONENTE_2", required = true)
    protected String componente2;

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
}
