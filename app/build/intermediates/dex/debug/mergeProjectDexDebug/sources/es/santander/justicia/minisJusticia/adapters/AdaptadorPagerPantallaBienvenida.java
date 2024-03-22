package es.santander.justicia.minisJusticia.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import es.santander.justicia.minisJusticia.fragments.BienvenidaInfoFragment;
import es.santander.justicia.minisJusticia.fragments.BienvenidaSeleccionFragment;

public class AdaptadorPagerPantallaBienvenida extends FragmentPagerAdapter {
    public AdaptadorPagerPantallaBienvenida(FragmentManager fm) {
        super(fm);
    }

    public Fragment getItem(int position) {
        if (position == 0) {
            return BienvenidaInfoFragment.newInstance();
        }
        if (position != 1) {
            return null;
        }
        return BienvenidaSeleccionFragment.newInstance();
    }

    public int getCount() {
        return 2;
    }
}
