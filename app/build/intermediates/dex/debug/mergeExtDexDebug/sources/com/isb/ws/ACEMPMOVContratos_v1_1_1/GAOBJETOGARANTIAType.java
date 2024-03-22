package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GA_OBJETO_GARANTIA_Type", propOrder = {"gatipoobjeto", "valorobjeto"})
public class GAOBJETOGARANTIAType {
    @XmlElement(name = "GA_TIPO_OBJETO", required = true)
    protected GATIPOOBJETOType gatipoobjeto;
    @XmlElement(name = "VALOR_OBJETO", required = true)
    protected String valorobjeto;

    public GATIPOOBJETOType getGATIPOOBJETO() {
        return this.gatipoobjeto;
    }

    public void setGATIPOOBJETO(GATIPOOBJETOType gATIPOOBJETOType) {
        this.gatipoobjeto = gATIPOOBJETOType;
    }

    public String getVALOROBJETO() {
        return this.valorobjeto;
    }

    public void setVALOROBJETO(String str) {
        this.valorobjeto = str;
    }
}
