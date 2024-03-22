package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BMG_NUMERO_GRUPO_Type", propOrder = {"bmgtipogrupo", "bmgcodigogrupo"})
public class BMGNUMEROGRUPOType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "BMG_CODIGO_GRUPO")
    protected int bmgcodigogrupo;
    @XmlElement(name = "BMG_TIPO_GRUPO", required = true)
    protected String bmgtipogrupo;

    public String getBMGTIPOGRUPO() {
        return this.bmgtipogrupo;
    }

    public void setBMGTIPOGRUPO(String str) {
        this.bmgtipogrupo = str;
    }

    public int getBMGCODIGOGRUPO() {
        return this.bmgcodigogrupo;
    }

    public void setBMGCODIGOGRUPO(int i) {
        this.bmgcodigogrupo = i;
    }
}
