package es.santander.justicia.minisJusticia.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import es.santander.justicia.minisJusticia.dto.MovementItemDTO;
import es.santander.justicia.minisJusticia.fragments.DetalleDeMovimientoTimeLineDetailFragment;
import es.santander.justicia.minisJusticia.fragments.DetalleMovimientoTimeLineFragment;

public class ViewPagerDetalleMovimientoAdapter extends FragmentPagerAdapter {
    private MovementItemDTO movementItemDTO;

    public ViewPagerDetalleMovimientoAdapter(FragmentManager fm, MovementItemDTO movementItemDTO2) {
        super(fm);
        this.movementItemDTO = movementItemDTO2;
    }

    public Fragment getItem(int position) {
        if (position == 0) {
            return DetalleDeMovimientoTimeLineDetailFragment.newInstance(this.movementItemDTO);
        }
        if (position != 1) {
            return null;
        }
        return DetalleMovimientoTimeLineFragment.newInstance(this.movementItemDTO);
    }

    public int getCount() {
        return 2;
    }
}
