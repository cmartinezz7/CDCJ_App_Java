package es.santander.justicia.minisJusticia.common.dto;

import es.santander.justicia.utils.Constants;

public class ResponseServiceDTO {
    private String mensajse;
    private Constants.ResultResponse resultResponse;

    public Constants.ResultResponse getResultResponse() {
        return this.resultResponse;
    }

    public void setResultResponse(Constants.ResultResponse resultResponse2) {
        this.resultResponse = resultResponse2;
    }

    public String getMensajse() {
        return this.mensajse;
    }

    public void setMensajse(String mensajse2) {
        this.mensajse = mensajse2;
    }
}
