package es.santander.justicia.minisJusticia.models;

import com.bignerdranch.expandablerecyclerview.model.Parent;
import java.util.List;

public class ExpedienteConsultLetrados implements Parent<ExpedienteDetailLetrados> {
   private List<ExpedienteDetailLetrados> mListDetail;

   public ExpedienteConsultLetrados(List<ExpedienteDetailLetrados> mListDetail) {
      this.mListDetail = mListDetail;
   }

   public List<ExpedienteDetailLetrados> getmListDetail() {
      return this.mListDetail;
   }

   public void setmListDetail(List<ExpedienteDetailLetrados> mListDetail) {
      this.mListDetail = mListDetail;
   }

   public List<ExpedienteDetailLetrados> getChildList() {
      return this.mListDetail;
   }

   public boolean isInitiallyExpanded() {
      return false;
   }
}
