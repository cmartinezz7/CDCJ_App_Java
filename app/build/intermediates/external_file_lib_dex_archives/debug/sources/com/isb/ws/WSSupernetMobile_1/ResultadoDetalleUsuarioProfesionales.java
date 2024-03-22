package com.isb.ws.WSSupernetMobile_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "resultadoDetalleUsuarioProfesionales", propOrder = {"groupId", "name", "surname", "surname2"})
public class ResultadoDetalleUsuarioProfesionales {
    protected String groupId;
    protected String name;
    protected String surname;
    protected String surname2;

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String str) {
        this.surname = str;
    }

    public String getSurname2() {
        return this.surname2;
    }

    public void setSurname2(String str) {
        this.surname2 = str;
    }
}
