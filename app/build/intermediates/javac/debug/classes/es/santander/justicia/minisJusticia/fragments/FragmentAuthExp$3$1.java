package es.santander.justicia.minisJusticia.fragments;

import es.santander.justicia.minisJusticia.fragments.FragmentAuthExp.3;
import es.santander.justicia.minisJusticia.models.responses.buscPetAcceso.BuscarPeticionesAcceso;
import java.util.Comparator;

class FragmentAuthExp$3$1 implements Comparator<BuscarPeticionesAcceso> {
   // $FF: synthetic field
   final 3 this$1;

   FragmentAuthExp$3$1(3 this$1) {
      this.this$1 = this$1;
   }

   public int compare(BuscarPeticionesAcceso o1, BuscarPeticionesAcceso o2) {
      return o2.getFecModificacionPeticion().compareTo(o1.getFecModificacionPeticion());
   }
}
