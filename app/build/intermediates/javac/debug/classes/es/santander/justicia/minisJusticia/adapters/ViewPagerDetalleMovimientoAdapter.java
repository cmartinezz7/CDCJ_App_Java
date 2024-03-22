package es.santander.justicia.minisJusticia.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import es.santander.justicia.minisJusticia.dto.MovementItemDTO;
import es.santander.justicia.minisJusticia.fragments.DetalleDeMovimientoTimeLineDetailFragment;
import es.santander.justicia.minisJusticia.fragments.DetalleMovimientoTimeLineFragment;

public class ViewPagerDetalleMovimientoAdapter extends FragmentPagerAdapter {
   private MovementItemDTO movementItemDTO;

   public ViewPagerDetalleMovimientoAdapter(FragmentManager fm, MovementItemDTO movementItemDTO) {
      super(fm);
      this.movementItemDTO = movementItemDTO;
   }

   public Fragment getItem(int position) {
      Fragment fragment = null;
      switch(position) {
      case 0:
         fragment = DetalleDeMovimientoTimeLineDetailFragment.newInstance(this.movementItemDTO);
         break;
      case 1:
         fragment = DetalleMovimientoTimeLineFragment.newInstance(this.movementItemDTO);
      }

      return (Fragment)fragment;
   }

   public int getCount() {
      return 2;
   }
}
