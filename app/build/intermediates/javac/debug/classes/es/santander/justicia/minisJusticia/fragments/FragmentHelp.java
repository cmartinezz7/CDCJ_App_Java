package es.santander.justicia.minisJusticia.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import es.santander.justicia.minisJusticia.ActivityHomeLetrados.PlaceholderFragment;
import es.santander.justicia.minisJusticia.common.tealium.TealiumHelper;
import es.santander.justicia.minisJusticia.models.KeyValueModel;
import es.santander.justicia.minisJusticia.views.QTextView;
import es.santander.justicia.utils.CommonUtils;

public class FragmentHelp extends PlaceholderFragment {
   public void onStart() {
      super.onStart();
      TealiumHelper.trackView("/ayuda");
   }

   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      ViewGroup rootView = (ViewGroup)inflater.inflate(2131558574, container, false);
      this.initUi(rootView);
      return rootView;
   }

   private void initUi(ViewGroup rootView) {
      String value = KeyValueModel.getInstance().getValue("aInfo.", "letrados.superlinea1");
      if (CommonUtils.isNotNullNotBlack(value)) {
         ((QTextView)rootView.findViewById(2131361805)).setText(value);
      }

      String value2 = KeyValueModel.getInstance().getValue("aInfo.", "letrados.superlinea2");
      if (CommonUtils.isNotNullNotBlack(value)) {
         ((QTextView)rootView.findViewById(2131361806)).setText(value2);
      }

   }
}
