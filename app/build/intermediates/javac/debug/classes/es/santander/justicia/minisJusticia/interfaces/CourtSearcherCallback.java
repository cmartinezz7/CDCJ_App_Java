package es.santander.justicia.minisJusticia.interfaces;

import es.santander.justicia.minisJusticia.dto.CourtDataDto;
import java.util.ArrayList;

public interface CourtSearcherCallback {
   void onFinishSearch(ArrayList<CourtDataDto> var1, boolean var2);
}
