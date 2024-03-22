package es.santander.justicia.minisJusticia.interfaces;

import es.santander.justicia.minisJusticia.dto.PeticionDTO;
import java.util.ArrayList;

public interface PetitionsCallback {
   void onFinishGetPetitions(ArrayList<PeticionDTO> var1, boolean var2, String var3);
}
