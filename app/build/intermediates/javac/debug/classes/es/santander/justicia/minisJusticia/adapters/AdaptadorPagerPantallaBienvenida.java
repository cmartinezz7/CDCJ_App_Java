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
      Fragment fragment = null;
      switch(position) {
      case 0:
         fragment = BienvenidaInfoFragment.newInstance();
         break;
      case 1:
         fragment = BienvenidaSeleccionFragment.newInstance();
      }

      return (Fragment)fragment;
   }

   public int getCount() {
      return 2;
   }
}
