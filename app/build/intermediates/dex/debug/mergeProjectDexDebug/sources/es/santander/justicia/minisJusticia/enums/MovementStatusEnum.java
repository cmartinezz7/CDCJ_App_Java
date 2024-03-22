package es.santander.justicia.minisJusticia.enums;

public enum MovementStatusEnum {
    EXECUTED("Ejecutado"),
    PENDING("Pendiente"),
    EXPIRED("Caducado");
    
    private String name;

    private MovementStatusEnum(String name2) {
        this.name = name2;
    }

    public String getName() {
        return this.name;
    }
}
