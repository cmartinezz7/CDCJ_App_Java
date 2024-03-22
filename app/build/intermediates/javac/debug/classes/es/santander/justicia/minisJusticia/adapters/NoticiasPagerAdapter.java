package es.santander.justicia.minisJusticia.adapters;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import es.santander.justicia.minisJusticia.fragments.EnciclopediaFragment;
import es.santander.justicia.minisJusticia.fragments.NoticiasActualidadFragment;
import es.santander.justicia.minisJusticia.fragments.SentenciaFragment;

public class NoticiasPagerAdapter extends FragmentStatePagerAdapter {
   private int mNumOfTabs;
   private NoticiasActualidadFragment noticiasFragment;
   private SentenciaFragment sentenciaFragment;
   private EnciclopediaFragment enciclopediaFragment;

   public NoticiasPagerAdapter(FragmentManager fm, int NumOfTabs) {
      super(fm);
      this.mNumOfTabs = NumOfTabs;
      this.noticiasFragment = NoticiasActualidadFragment.getInstance((Bundle)null);
      this.sentenciaFragment = new SentenciaFragment();
      this.enciclopediaFragment = new EnciclopediaFragment();
   }

   public Fragment getItem(int position) {
      switch(position) {
      case 0:
         return this.noticiasFragment;
      case 1:
         return this.sentenciaFragment;
      case 2:
         return this.enciclopediaFragment;
      default:
         return null;
      }
   }

   public int getCount() {
      return this.mNumOfTabs;
   }
}
