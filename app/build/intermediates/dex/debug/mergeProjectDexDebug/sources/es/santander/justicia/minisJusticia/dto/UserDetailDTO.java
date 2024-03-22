package es.santander.justicia.minisJusticia.dto;

public class UserDetailDTO {
    private String groupID;
    private String name;
    private String surname;
    private String surname2;

    public String getGroupID() {
        return this.groupID;
    }

    public void setGroupID(String groupID2) {
        this.groupID = groupID2;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname3) {
        this.surname = surname3;
    }

    public String getSurname2() {
        return this.surname2;
    }

    public void setSurname2(String surname22) {
        this.surname2 = surname22;
    }
}
