package es.santander.justicia.minisJusticia.dto;

import android.util.Log;
import es.santander.justicia.utils.DateUtils;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PeticionDTO implements Serializable, Comparable<PeticionDTO> {
    private String codExpediente;
    private String fecacept;
    private String fecpetic;
    private String jestactu;

    public PeticionDTO() {
    }

    public PeticionDTO(String codExpediente2, String fecacept2, String fecpetic2, String jestactu2) {
        this.codExpediente = codExpediente2;
        this.fecacept = fecacept2;
        this.fecpetic = fecpetic2;
        this.jestactu = jestactu2;
    }

    public void setCodExpediente(String codExpediente2) {
        this.codExpediente = codExpediente2;
    }

    public void setFecacept(String fecacept2) {
        this.fecacept = fecacept2;
    }

    public void setFecpetic(String fecpetic2) {
        this.fecpetic = fecpetic2;
    }

    public void setJestactu(String jestactu2) {
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

    public int compareTo(PeticionDTO petition) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return sdf.parse(DateUtils.formatDate(petition.getFecpetic())).compareTo(sdf.parse(DateUtils.formatDate(this.fecpetic)));
        } catch (ParseException e) {
            Log.e("PeticionDTO", "ParseException", e);
            return 0;
        }
    }
}
