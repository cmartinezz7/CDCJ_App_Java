package es.santander.justicia.minisJusticia.interfaces;

import es.santander.justicia.minisJusticia.dto.ExpedienteDTO;
import java.util.ArrayList;

public interface ExpedientsCallBack {
    void onFinishGetExpedientDetail(ExpedienteDTO expedienteDTO, boolean z, String str);

    void onFinishGetExpedients(ArrayList<ExpedienteDTO> arrayList, boolean z, String str);
}
