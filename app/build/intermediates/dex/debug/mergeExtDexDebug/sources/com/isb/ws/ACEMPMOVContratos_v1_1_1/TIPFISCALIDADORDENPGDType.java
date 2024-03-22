package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TIP_FISCALIDAD_ORDEN_PGD_Type", propOrder = {"empresaconcodalfanum2", "codigoalfanum"})
public class TIPFISCALIDADORDENPGDType {
    @XmlElement(name = "CODIGO_ALFANUM", required = true)
    protected String codigoalfanum;
    @XmlElement(name = "EMPRESA_CON_COD_ALFANUM2", required = true)
    protected TIPREFORDENPGDType empresaconcodalfanum2;

    public TIPREFORDENPGDType getEMPRESACONCODALFANUM2() {
        return this.empresaconcodalfanum2;
    }

    public void setEMPRESACONCODALFANUM2(TIPREFORDENPGDType tIPREFORDENPGDType) {
        this.empresaconcodalfanum2 = tIPREFORDENPGDType;
    }

    public String getCODIGOALFANUM() {
        return this.codigoalfanum;
    }

    public void setCODIGOALFANUM(String str) {
        this.codigoalfanum = str;
    }
}
