package es.santander.justicia.minisJusticia.models;

import com.bignerdranch.expandablerecyclerview.model.Parent;
import java.util.List;

public class Seizures implements Parent<SeizuresDetail> {
    private List<SeizuresDetail> mListDetail;

    public Seizures(List<SeizuresDetail> mListDetail2) {
        this.mListDetail = mListDetail2;
    }

    public List<SeizuresDetail> getmListDetail() {
        return this.mListDetail;
    }

    public void setmListDetail(List<SeizuresDetail> mListDetail2) {
        this.mListDetail = mListDetail2;
    }

    public List<SeizuresDetail> getChildList() {
        return this.mListDetail;
    }

    public boolean isInitiallyExpanded() {
        return false;
    }
}
