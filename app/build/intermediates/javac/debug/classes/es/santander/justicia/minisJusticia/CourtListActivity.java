package es.santander.justicia.minisJusticia;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import es.santander.justicia.minisJusticia.CourtListActivity.1;
import es.santander.justicia.minisJusticia.CourtListActivity.2;
import es.santander.justicia.minisJusticia.adapters.CourtListAdapter;
import es.santander.justicia.minisJusticia.common.activity.MainActivity;
import es.santander.justicia.minisJusticia.controllers.CourtSearcherController;
import es.santander.justicia.minisJusticia.dto.CourtDataDto;
import es.santander.justicia.minisJusticia.interfaces.CourtSearcherCallback;
import es.santander.justicia.minisJusticia.views.QFontTextView;
import java.util.ArrayList;

public class CourtListActivity extends MainActivity implements CourtSearcherCallback {
   private Context context;
   private ListView courtListView;
   private ProgressDialog dialog;
   private CourtListAdapter courtListAdapter;

   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.context = this.getBaseContext();
      this.setTealiumName("/lista_juzgados");
      this.setContentView(2131558625);
      Bundle extra = this.getIntent().getExtras();
      String province = "";
      String judicialEnvironment = "";
      if (extra != null) {
         province = extra.getString("province");
         judicialEnvironment = extra.getString("judicialEnvironment");
      }

      ImageButton btnBack = (ImageButton)this.findViewById(2131361967);
      TextView toolBarTitle = (QFontTextView)this.findViewById(2131363082);
      toolBarTitle.setText(2131886759);
      btnBack.setOnClickListener(new 1(this));
      this.courtListView = (ListView)this.findViewById(2131362452);
      this.dialog = new ProgressDialog(this);
      this.dialog.setCancelable(false);
      this.dialog.setMessage(this.getResources().getString(2131886515));
      this.dialog.show();
      CourtSearcherController courtController = new CourtSearcherController(this);
      courtController.searchCourts(province, judicialEnvironment);
   }

   public void onFinishSearch(ArrayList<CourtDataDto> courtList, boolean success) {
      if (this.dialog != null && this.dialog.isShowing()) {
         this.dialog.dismiss();
      }

      if (success && !courtList.isEmpty()) {
         this.courtListAdapter = new CourtListAdapter(this.context, courtList);
         this.courtListView.setAdapter(this.courtListAdapter);
         this.courtListView.setOnItemClickListener(new 2(this));
      } else {
         Intent intent = new Intent(this, NoResultsActivity.class);
         intent.putExtra("screenDestination", "searcherCourtScreen");
         this.startActivity(intent);
         this.finish();
      }

   }

   // $FF: synthetic method
   static CourtListAdapter access$000(CourtListActivity x0) {
      return x0.courtListAdapter;
   }
}
