package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FUNCION_CHARGEBACK_DISP_Type", propOrder = {"tipofranquiciadisp", "codfuncionfranq"})
public class FUNCIONCHARGEBACKDISPType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "COD_FUNCION_FRANQ")
    protected int codfuncionfranq;
    @XmlElement(name = "TIPO_FRANQUICIA_DISP", required = true)
    protected TIPOFRANQUICIADISPType tipofranquiciadisp;

    public TIPOFRANQUICIADISPType getTIPOFRANQUICIADISP() {
        return this.tipofranquiciadisp;
    }

    public void setTIPOFRANQUICIADISP(TIPOFRANQUICIADISPType tIPOFRANQUICIADISPType) {
        this.tipofranquiciadisp = tIPOFRANQUICIADISPType;
    }

    public int getCODFUNCIONFRANQ() {
        return this.codfuncionfranq;
    }

    public void setCODFUNCIONFRANQ(int i) {
        this.codfuncionfranq = i;
    }
}
