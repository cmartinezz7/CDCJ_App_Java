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
      switch(position) {
      case 0:
         return FragmentDetailMovTimeline.newInstance();
      case 1:
         return FragmentDetailMovData.newInstance();
      default:
         return null;
      }
   }

   public int getCount() {
      return 2;
   }
}
