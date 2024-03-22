package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MIF_COD_EXPEDIENTE_Type", propOrder = {"miftipoexpediente", "cexpedtesecuencialmedio"})
public class MIFCODEXPEDIENTEType {
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "CEXPEDTE_SECUENCIAL_MEDIO")
    protected long cexpedtesecuencialmedio;
    @XmlElement(name = "MIF_TIPO_EXPEDIENTE", required = true)
    protected MIFTIPOEXPEDIENTEType miftipoexpediente;

    public MIFTIPOEXPEDIENTEType getMIFTIPOEXPEDIENTE() {
        return this.miftipoexpediente;
    }

    public void setMIFTIPOEXPEDIENTE(MIFTIPOEXPEDIENTEType mIFTIPOEXPEDIENTEType) {
        this.miftipoexpediente = mIFTIPOEXPEDIENTEType;
    }

    public long getCEXPEDTESECUENCIALMEDIO() {
        return this.cexpedtesecuencialmedio;
    }

    public void setCEXPEDTESECUENCIALMEDIO(long j) {
        this.cexpedtesecuencialmedio = j;
    }
}
