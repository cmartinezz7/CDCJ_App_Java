package es.santander.justicia.minisJusticia;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import es.santander.justicia.minisJusticia.fragments.FragmentAdvices;
import es.santander.justicia.minisJusticia.fragments.FragmentAuhtJuzgados;
import es.santander.justicia.minisJusticia.fragments.FragmentAuthExp;
import es.santander.justicia.minisJusticia.fragments.FragmentBuscadorJuzgados;
import es.santander.justicia.minisJusticia.fragments.FragmentConsultaExpNew;
import es.santander.justicia.minisJusticia.fragments.FragmentHelp;
import es.santander.justicia.minisJusticia.fragments.FragmentOperations;

public abstract class ActivityHomeLetrados$PlaceholderFragment extends Fragment {
   public static final String ARG_SECTION_NUMBER = "section_number";

   public static ActivityHomeLetrados$PlaceholderFragment newInstance(int sectionNumber, Bundle args) {
      Object fragment;
      switch(sectionNumber) {
      case 2131886568:
         fragment = new FragmentAdvices();
         break;
      case 2131886569:
      case 2131886573:
      case 2131886575:
      case 2131886576:
      case 2131886577:
      case 2131886579:
      case 2131886580:
      case 2131886581:
      case 2131886582:
      case 2131886583:
      default:
         fragment = new FragmentAdvices();
         break;
      case 2131886570:
         fragment = new FragmentAuhtJuzgados();
         break;
      case 2131886571:
         fragment = new FragmentAuthExp();
         break;
      case 2131886572:
         fragment = new FragmentConsultaExpNew();
         break;
      case 2131886574:
         fragment = new FragmentBuscadorJuzgados();
         break;
      case 2131886578:
         fragment = new FragmentHelp();
         break;
      case 2131886584:
      case 2131886585:
         fragment = new FragmentOperations();
      }

      if (args == null) {
         args = new Bundle();
      }

      args.putInt("section_number", sectionNumber);
      ((ActivityHomeLetrados$PlaceholderFragment)fragment).setArguments(args);
      return (ActivityHomeLetrados$PlaceholderFragment)fragment;
   }

   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      View rootView = inflater.inflate(2131558575, container, false);
      return rootView;
   }

   public void onAttach(Context context) {
      super.onAttach(context);
      ((ActivityHomeLetrados)context).onSectionAttached(this.getArguments().getInt("section_number"));
   }
}
