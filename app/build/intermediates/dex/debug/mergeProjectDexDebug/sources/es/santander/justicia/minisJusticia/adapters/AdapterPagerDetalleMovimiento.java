package es.santander.justicia.minisJusticia.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import es.santander.justicia.minisJusticia.fragments.FragmentDetailMovData;
import es.santander.justicia.minisJusticia.fragments.FragmentDetailMovTimeline;

public class AdapterPagerDetalleMovimiento extends FragmentStatePagerAdapter {
    private final int TOTAL_PAGES = 2;

    public AdapterPagerDetalleMovimiento(FragmentManager fm) {
        super(fm);
    }

    public Fragment getItem(int position) {
        if (position == 0) {
            return FragmentDetailMovTimeline.newInstance();
        }
        if (position != 1) {
            return null;
        }
        return FragmentDetailMovData.newInstance();
    }

    public int getCount() {
        return 2;
    }
}
