package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CONCEPTO_MULTIIDIOMA_Type", propOrder = {"codigotipodedato", "codalfanum3"})
public class CONCEPTOMULTIIDIOMAType {
    @XmlElement(name = "COD_ALFANUM_3", required = true)
    protected String codalfanum3;
    @XmlElement(name = "CODIGO_TIPO_DE_DATO", required = true)
    protected String codigotipodedato;

    public String getCODIGOTIPODEDATO() {
        return this.codigotipodedato;
    }

    public void setCODIGOTIPODEDATO(String str) {
        this.codigotipodedato = str;
    }

    public String getCODALFANUM3() {
        return this.codalfanum3;
    }

    public void setCODALFANUM3(String str) {
        this.codalfanum3 = str;
    }
}
