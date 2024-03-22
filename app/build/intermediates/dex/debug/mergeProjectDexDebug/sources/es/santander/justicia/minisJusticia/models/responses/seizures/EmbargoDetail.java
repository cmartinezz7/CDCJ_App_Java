package es.santander.justicia.minisJusticia.models.responses.seizures;

public class EmbargoDetail {
    private String document;
    private String importe;
    private String nombre;

    public EmbargoDetail(String nombre2, String importe2, String document2) {
        this.nombre = nombre2;
        this.importe = importe2;
        this.document = document2;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getImporte() {
        return this.importe;
    }

    public String getDocument() {
        return this.document;
    }
}
