package com.isb.ws.ACEMPMOVContratos_v1_1_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GCPB_QUEST_Type", propOrder = {"gcpbxped", "timesinipbc"})
public class GCPBQUESTType {
    @XmlElement(name = "GCPB_XPED", required = true)
    protected GCPBEXPEDType gcpbxped;
    @XmlSchemaType(name = "dateTime")
    @XmlElement(name = "TIMESINI_PBC", required = true)
    protected XMLGregorianCalendar timesinipbc;

    public GCPBEXPEDType getGCPBXPED() {
        return this.gcpbxped;
    }

    public void setGCPBXPED(GCPBEXPEDType gCPBEXPEDType) {
        this.gcpbxped = gCPBEXPEDType;
    }

    public XMLGregorianCalendar getTIMESINIPBC() {
        return this.timesinipbc;
    }

    public void setTIMESINIPBC(XMLGregorianCalendar xMLGregorianCalendar) {
        this.timesinipbc = xMLGregorianCalendar;
    }
}
