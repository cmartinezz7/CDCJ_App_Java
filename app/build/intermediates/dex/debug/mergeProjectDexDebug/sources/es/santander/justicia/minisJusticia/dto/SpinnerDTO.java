package es.santander.justicia.minisJusticia.dto;

public class SpinnerDTO {
    private String _id;
    private String _name;

    public SpinnerDTO(String id, String name) {
        this._id = id;
        this._name = name;
    }

    public String getId() {
        return this._id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getName() {
        return this._name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public String toString() {
        return this._name;
    }
}
