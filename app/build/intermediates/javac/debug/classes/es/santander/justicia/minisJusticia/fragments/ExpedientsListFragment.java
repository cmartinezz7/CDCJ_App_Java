package es.santander.justicia.minisJusticia.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.ListFragment;

public class ExpedientsListFragment extends ListFragment {
   private Context context;

   public static ExpedientsListFragment newInstance(String param1, String param2) {
      ExpedientsListFragment fragment = new ExpedientsListFragment();
      return fragment;
   }

   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.context = this.getActivity().getBaseContext();
   }

   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      View view = inflater.inflate(2131558572, container, false);
      return view;
   }
}
