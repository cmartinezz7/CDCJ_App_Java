package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BMG_AJUSTABILIDA_SECURITY_Type", propOrder = {"bmgajustabilidasecurity", "bmgtipoajusteindexacio"})
public class BMGAJUSTABILIDASECURITYType {
    @XmlElement(name = "BMG_AJUSTABILIDA_SECURITY", required = true)
    protected String bmgajustabilidasecurity;
    @XmlElement(name = "BMG_TIPO_AJUSTE_INDEXACIO", required = true)
    protected String bmgtipoajusteindexacio;

    public String getBMGAJUSTABILIDASECURITY() {
        return this.bmgajustabilidasecurity;
    }

    public void setBMGAJUSTABILIDASECURITY(String str) {
        this.bmgajustabilidasecurity = str;
    }

    public String getBMGTIPOAJUSTEINDEXACIO() {
        return this.bmgtipoajusteindexacio;
    }

    public void setBMGTIPOAJUSTEINDEXACIO(String str) {
        this.bmgtipoajusteindexacio = str;
    }
}
