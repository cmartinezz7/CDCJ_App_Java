package es.santander.justicia.minisJusticia.interfaces;

import es.santander.justicia.minisJusticia.dto.MovementItemDTO;
import es.santander.justicia.minisJusticia.dto.totalMovementsDTO;
import java.util.ArrayList;

public interface MovementQueryCallback {
   void onFinishGetMovements(ArrayList<MovementItemDTO> var1, ArrayList<totalMovementsDTO> var2, boolean var3, String var4);
}
