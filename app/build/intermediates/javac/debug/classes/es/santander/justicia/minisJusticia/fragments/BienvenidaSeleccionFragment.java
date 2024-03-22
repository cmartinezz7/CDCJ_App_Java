package es.santander.justicia.minisJusticia.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import es.santander.justicia.minisJusticia.fragments.BienvenidaSeleccionFragment.1;
import es.santander.justicia.minisJusticia.fragments.BienvenidaSeleccionFragment.2;
import es.santander.justicia.utils.FontsUtil;

public class BienvenidaSeleccionFragment extends Fragment {
   private Button profesionalPerfilButton;
   private Button letradoPerfilButton;
   private TextView tvContinuar;
   private Activity activity;

   public static BienvenidaSeleccionFragment newInstance() {
      BienvenidaSeleccionFragment fragment = new BienvenidaSeleccionFragment();
      return fragment;
   }

   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.activity = this.getActivity();
   }

   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      View view = inflater.inflate(2131558568, container, false);
      return view;
   }

   public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
      super.onViewCreated(view, savedInstanceState);
      this.profesionalPerfilButton = (Button)view.findViewById(2131361958);
      this.letradoPerfilButton = (Button)view.findViewById(2131361954);
      this.tvContinuar = (TextView)view.findViewById(2131362823);
      view.findViewById(2131363087).setVisibility(4);
      FontsUtil.changeFont(this.getContext(), this.tvContinuar, "FiraSans-Medium.ttf");
      this.profesionalPerfilButton.setOnClickListener(new 1(this));
      this.letradoPerfilButton.setOnClickListener(new 2(this));
   }
}
