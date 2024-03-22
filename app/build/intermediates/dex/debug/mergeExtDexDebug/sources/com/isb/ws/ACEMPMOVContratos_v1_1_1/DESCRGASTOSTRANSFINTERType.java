package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DESCR_GASTOS_TRANSF_INTER_Type", propOrder = {"indicadorgastos", "indicadorgastosporcta"})
public class DESCRGASTOSTRANSFINTERType {
    @XmlElement(name = "INDICADOR_GASTOS", required = true)
    protected String indicadorgastos;
    @XmlElement(name = "INDICADOR_GASTOS_POR_CTA", required = true)
    protected String indicadorgastosporcta;

    public String getINDICADORGASTOS() {
        return this.indicadorgastos;
    }

    public void setINDICADORGASTOS(String str) {
        this.indicadorgastos = str;
    }

    public String getINDICADORGASTOSPORCTA() {
        return this.indicadorgastosporcta;
    }

    public void setINDICADORGASTOSPORCTA(String str) {
        this.indicadorgastosporcta = str;
    }
}
