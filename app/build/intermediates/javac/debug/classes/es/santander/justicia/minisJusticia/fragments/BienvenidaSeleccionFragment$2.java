package es.santander.justicia.minisJusticia.fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import es.santander.justicia.minisJusticia.NewsActivity;
import es.santander.justicia.minisJusticia.models.KeyValueModel;

class BienvenidaSeleccionFragment$2 implements OnClickListener {
   // $FF: synthetic field
   final BienvenidaSeleccionFragment this$0;

   BienvenidaSeleccionFragment$2(BienvenidaSeleccionFragment this$0) {
      this.this$0 = this$0;
   }

   public void onClick(View v) {
      ProgressDialog progressDialog = new ProgressDialog(this.this$0.getActivity());
      progressDialog.setCancelable(false);
      progressDialog.setMessage(this.this$0.getString(2131886514));
      progressDialog.show();
      KeyValueModel.getInstancePermanent().insertValue("pls", "", "L");
      Intent intent = new Intent(this.this$0.getActivity().getBaseContext(), NewsActivity.class);
      this.this$0.startActivity(intent);
      this.this$0.getActivity().finish();
   }
}
