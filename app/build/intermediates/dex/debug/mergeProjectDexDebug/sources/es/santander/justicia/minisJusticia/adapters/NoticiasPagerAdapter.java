package es.santander.justicia.minisJusticia.adapters;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import es.santander.justicia.minisJusticia.fragments.EnciclopediaFragment;
import es.santander.justicia.minisJusticia.fragments.NoticiasActualidadFragment;
import es.santander.justicia.minisJusticia.fragments.SentenciaFragment;

public class NoticiasPagerAdapter extends FragmentStatePagerAdapter {
    private EnciclopediaFragment enciclopediaFragment = new EnciclopediaFragment();
    private int mNumOfTabs;
    private NoticiasActualidadFragment noticiasFragment = NoticiasActualidadFragment.getInstance((Bundle) null);
    private SentenciaFragment sentenciaFragment = new SentenciaFragment();

    public NoticiasPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    public Fragment getItem(int position) {
        if (position == 0) {
            return this.noticiasFragment;
        }
        if (position == 1) {
            return this.sentenciaFragment;
        }
        if (position != 2) {
            return null;
        }
        return this.enciclopediaFragment;
    }

    public int getCount() {
        return this.mNumOfTabs;
    }
}
