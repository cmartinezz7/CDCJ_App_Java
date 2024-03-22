package es.santander.justicia.minisJusticia.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

public class sucursales_santander extends Fragment {
   private static final String ARG_PARAM1 = "param1";
   private static final String ARG_PARAM2 = "param2";
   private String mParam1;
   private String mParam2;
   private es.santander.justicia.minisJusticia.fragments.sucursales_santander.OnFragmentInteractionListener mListener;

   public static sucursales_santander newInstance(String param1, String param2) {
      sucursales_santander fragment = new sucursales_santander();
      Bundle args = new Bundle();
      args.putString("param1", param1);
      args.putString("param2", param2);
      fragment.setArguments(args);
      return fragment;
   }

   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      if (this.getArguments() != null) {
         this.mParam1 = this.getArguments().getString("param1");
         this.mParam2 = this.getArguments().getString("param2");
      }

   }

   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      return inflater.inflate(2131558578, container, false);
   }

   public void onButtonPressed(Uri uri) {
      if (this.mListener != null) {
         this.mListener.onFragmentInteraction(uri);
      }

   }

   public void onAttach(Context context) {
      super.onAttach(context);
      if (context instanceof es.santander.justicia.minisJusticia.fragments.sucursales_santander.OnFragmentInteractionListener) {
         this.mListener = (es.santander.justicia.minisJusticia.fragments.sucursales_santander.OnFragmentInteractionListener)context;
      } else {
         throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
      }
   }

   public void onDetach() {
      super.onDetach();
      this.mListener = null;
   }
}
