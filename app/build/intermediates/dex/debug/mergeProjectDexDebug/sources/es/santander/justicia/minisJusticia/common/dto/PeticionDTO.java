package es.santander.justicia.minisJusticia.common.dto;

import java.io.Serializable;

public class PeticionDTO implements Serializable {
    private String codExpediente;
    private String fecacept;
    private String fecpetic;
    private String jestactu;

    public PeticionDTO(String codExpediente2, String fecacept2, String fecpetic2, String jestactu2) {
        this.codExpediente = codExpediente2;
        this.fecacept = fecacept2;
        this.fecpetic = fecpetic2;
        this.jestactu = jestactu2;
    }

    public String getCodExpediente() {
        return this.codExpediente;
    }

    public String getFecacept() {
        return this.fecacept;
    }

    public String getFecpetic() {
        return this.fecpetic;
    }

    public String getJestactu() {
        return this.jestactu;
    }
}
