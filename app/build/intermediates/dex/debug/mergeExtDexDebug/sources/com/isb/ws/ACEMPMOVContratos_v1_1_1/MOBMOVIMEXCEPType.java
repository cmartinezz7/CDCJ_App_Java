package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MOB_MOVIM_EXCEP_Type", propOrder = {"obb", "tipcontabilidadmvto", "nromovimiento", "mobexcepcion"})
public class MOBMOVIMEXCEPType {
    @XmlElement(name = "MOB_EXCEPCION", required = true)
    protected String mobexcepcion;
    @XmlSchemaType(name = "integer")
    @XmlElement(name = "NRO_MOVIMIENTO")
    protected int nromovimiento;
    @XmlElement(name = "OBB", required = true)
    protected MOBOBBType obb;
    @XmlElement(name = "TIP_CONTABILIDAD_MVTO", required = true)
    protected String tipcontabilidadmvto;

    public MOBOBBType getOBB() {
        return this.obb;
    }

    public void setOBB(MOBOBBType mOBOBBType) {
        this.obb = mOBOBBType;
    }

    public String getTIPCONTABILIDADMVTO() {
        return this.tipcontabilidadmvto;
    }

    public void setTIPCONTABILIDADMVTO(String str) {
        this.tipcontabilidadmvto = str;
    }

    public int getNROMOVIMIENTO() {
        return this.nromovimiento;
    }

    public void setNROMOVIMIENTO(int i) {
        this.nromovimiento = i;
    }

    public String getMOBEXCEPCION() {
        return this.mobexcepcion;
    }

    public void setMOBEXCEPCION(String str) {
        this.mobexcepcion = str;
    }
}
