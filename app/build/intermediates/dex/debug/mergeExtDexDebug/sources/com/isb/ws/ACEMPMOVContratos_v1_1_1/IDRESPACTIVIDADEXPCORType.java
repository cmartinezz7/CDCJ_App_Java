package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ID_RESP_ACTIVIDAD_EXPCOR_Type", propOrder = {"idactividadexpcor", "codigodecanal", "codresultadogestion"})
public class IDRESPACTIVIDADEXPCORType {
    @XmlElement(name = "CODIGO_DE_CANAL", required = true)
    protected String codigodecanal;
    @XmlElement(name = "COD_RESULTADO_GESTION", required = true)
    protected String codresultadogestion;
    @XmlElement(name = "ID_ACTIVIDAD_EXPCOR", required = true)
    protected IDACTIVIDADEXPCORType idactividadexpcor;

    public IDACTIVIDADEXPCORType getIDACTIVIDADEXPCOR() {
        return this.idactividadexpcor;
    }

    public void setIDACTIVIDADEXPCOR(IDACTIVIDADEXPCORType iDACTIVIDADEXPCORType) {
        this.idactividadexpcor = iDACTIVIDADEXPCORType;
    }

    public String getCODIGODECANAL() {
        return this.codigodecanal;
    }

    public void setCODIGODECANAL(String str) {
        this.codigodecanal = str;
    }

    public String getCODRESULTADOGESTION() {
        return this.codresultadogestion;
    }

    public void setCODRESULTADOGESTION(String str) {
        this.codresultadogestion = str;
    }
}
