package es.santander.justicia.minisJusticia.models;

import com.bignerdranch.expandablerecyclerview.model.Parent;
import java.util.List;

public class ExpedienteAuthLetrados implements Parent<ExpedienteDetailLetrados> {
    private List<ExpedienteDetailLetrados> mListDetail;

    public ExpedienteAuthLetrados(List<ExpedienteDetailLetrados> mListDetail2) {
        this.mListDetail = mListDetail2;
    }

    public List<ExpedienteDetailLetrados> getmListDetail() {
        return this.mListDetail;
    }

    public void setmListDetail(List<ExpedienteDetailLetrados> mListDetail2) {
        this.mListDetail = mListDetail2;
    }

    public List<ExpedienteDetailLetrados> getChildList() {
        return this.mListDetail;
    }

    public boolean isInitiallyExpanded() {
        return false;
    }
}
