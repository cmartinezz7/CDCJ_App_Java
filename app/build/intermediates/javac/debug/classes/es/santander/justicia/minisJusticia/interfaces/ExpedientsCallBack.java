package es.santander.justicia.minisJusticia.interfaces;

import es.santander.justicia.minisJusticia.dto.ExpedienteDTO;
import java.util.ArrayList;

public interface ExpedientsCallBack {
   void onFinishGetExpedients(ArrayList<ExpedienteDTO> var1, boolean var2, String var3);

   void onFinishGetExpedientDetail(ExpedienteDTO var1, boolean var2, String var3);
}
