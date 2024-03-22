package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TELEFONO_INTER_REGULADO_Type", propOrder = {"prefijointernacional", "prefijonacional", "numeroabonado"})
public class TELEFONOINTERREGULADOType {
    @XmlElement(name = "NUMERO_ABONADO", required = true)
    protected String numeroabonado;
    @XmlElement(name = "PREFIJO_INTERNACIONAL", required = true)
    protected String prefijointernacional;
    @XmlElement(name = "PREFIJO_NACIONAL", required = true)
    protected String prefijonacional;

    public String getPREFIJOINTERNACIONAL() {
        return this.prefijointernacional;
    }

    public void setPREFIJOINTERNACIONAL(String str) {
        this.prefijointernacional = str;
    }

    public String getPREFIJONACIONAL() {
        return this.prefijonacional;
    }

    public void setPREFIJONACIONAL(String str) {
        this.prefijonacional = str;
    }

    public String getNUMEROABONADO() {
        return this.numeroabonado;
    }

    public void setNUMEROABONADO(String str) {
        this.numeroabonado = str;
    }
}
