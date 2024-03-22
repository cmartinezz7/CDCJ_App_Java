package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIPO_MARCAJE_TTGG_Type", propOrder = {"idtipodedato", "codtipomarcaje"})
public class TIPOMARCAJETTGGType {
    @XmlElement(name = "COD_TIPO_MARCAJE", required = true)
    protected String codtipomarcaje;
    @XmlElement(name = "ID_TIPO_DE_DATO", required = true)
    protected String idtipodedato;

    public String getIDTIPODEDATO() {
        return this.idtipodedato;
    }

    public void setIDTIPODEDATO(String str) {
        this.idtipodedato = str;
    }

    public String getCODTIPOMARCAJE() {
        return this.codtipomarcaje;
    }

    public void setCODTIPOMARCAJE(String str) {
        this.codtipomarcaje = str;
    }
}
