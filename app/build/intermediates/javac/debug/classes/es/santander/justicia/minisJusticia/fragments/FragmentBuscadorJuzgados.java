package es.santander.justicia.minisJusticia.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.annotation.Nullable;
import es.santander.justicia.minisJusticia.ActivityHomeLetrados.PlaceholderFragment;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;
import es.santander.justicia.minisJusticia.fragments.FragmentBuscadorJuzgados.1;
import es.santander.justicia.minisJusticia.fragments.FragmentBuscadorJuzgados.2;
import es.santander.justicia.minisJusticia.fragments.FragmentBuscadorJuzgados.3;
import es.santander.justicia.minisJusticia.models.SpinnerContentModel;
import es.santander.justicia.minisJusticia.views.QFontButton;
import java.util.ArrayList;

public class FragmentBuscadorJuzgados extends PlaceholderFragment {
   private Spinner mSpinnerProvices;
   private Spinner mSpinnerEnvironment;
   private QFontButton mTextSearch;
   private String mCodProvincia;
   private String mCodEnvironment;

   public void onStart() {
      super.onStart();
      TealiumHelper.trackView("/busqueda_juzgado");
   }

   @Nullable
   public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      ViewGroup viewGroup = (ViewGroup)inflater.inflate(2131558569, container, false);
      this.mSpinnerProvices = (Spinner)viewGroup.findViewById(2131362725);
      this.mSpinnerEnvironment = (Spinner)viewGroup.findViewById(2131362723);
      this.mTextSearch = (QFontButton)viewGroup.findViewById(2131362870);
      this.initUi();
      return viewGroup;
   }

   private void initUi() {
      ArrayList<SpinnerValuesDTO> spinnerProvinces = SpinnerContentModel.getSpinnerValues("spnProvinces");
      ArrayAdapter<SpinnerValuesDTO> arrayProvinces = new ArrayAdapter(this.getActivity(), 2131558752, 2131362922, spinnerProvinces);
      arrayProvinces.setDropDownViewResource(2131558753);
      this.mSpinnerProvices.setAdapter(arrayProvinces);
      this.mSpinnerProvices.setOnItemSelectedListener(new 1(this, spinnerProvinces));
      ArrayList<SpinnerValuesDTO> spinerEnvironment = SpinnerContentModel.getSpinnerValues("spnJudicialEnv");
      ArrayAdapter<SpinnerValuesDTO> arrayEnvironment = new ArrayAdapter(this.getActivity(), 2131558752, 2131362922, spinerEnvironment);
      arrayEnvironment.setDropDownViewResource(2131558753);
      this.mSpinnerEnvironment.setAdapter(arrayEnvironment);
      this.mSpinnerEnvironment.setOnItemSelectedListener(new 2(this, spinerEnvironment));
      this.mTextSearch.setOnClickListener(new 3(this));
   }

   // $FF: synthetic method
   static String access$002(FragmentBuscadorJuzgados x0, String x1) {
      return x0.mCodProvincia = x1;
   }

   // $FF: synthetic method
   static String access$102(FragmentBuscadorJuzgados x0, String x1) {
      return x0.mCodEnvironment = x1;
   }

   // $FF: synthetic method
   static String access$000(FragmentBuscadorJuzgados x0) {
      return x0.mCodProvincia;
   }

   // $FF: synthetic method
   static String access$100(FragmentBuscadorJuzgados x0) {
      return x0.mCodEnvironment;
   }
}
