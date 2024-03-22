package es.santander.justicia.minisJusticia.interfaces;

import es.santander.justicia.minisJusticia.dto.PeticionDTO;
import java.util.ArrayList;

public interface PetitionsCallback {
    void onFinishGetPetitions(ArrayList<PeticionDTO> arrayList, boolean z, String str);
}
