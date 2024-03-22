package es.santander.justicia.minisJusticia.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentDetailMovTimeline extends Fragment {
   public static FragmentDetailMovTimeline newInstance() {
      FragmentDetailMovTimeline retVal = new FragmentDetailMovTimeline();
      return retVal;
   }

   public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      ViewGroup rootView = (ViewGroup)inflater.inflate(2131558570, container, false);
      return rootView;
   }
}
