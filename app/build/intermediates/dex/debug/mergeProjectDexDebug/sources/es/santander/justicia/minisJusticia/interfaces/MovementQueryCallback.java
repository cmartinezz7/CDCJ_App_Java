package es.santander.justicia.minisJusticia.interfaces;

import es.santander.justicia.minisJusticia.dto.MovementItemDTO;
import es.santander.justicia.minisJusticia.dto.totalMovementsDTO;
import java.util.ArrayList;

public interface MovementQueryCallback {
    void onFinishGetMovements(ArrayList<MovementItemDTO> arrayList, ArrayList<totalMovementsDTO> arrayList2, boolean z, String str);
}
