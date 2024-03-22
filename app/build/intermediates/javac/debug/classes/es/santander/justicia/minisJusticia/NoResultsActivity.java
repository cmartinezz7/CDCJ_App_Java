package es.santander.justicia.minisJusticia;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import es.santander.justicia.minisJusticia.NoResultsActivity.1;
import es.santander.justicia.minisJusticia.NoResultsActivity.2;
import es.santander.justicia.minisJusticia.common.activity.MainActivity;

public class NoResultsActivity extends MainActivity {
   private String screenDestination = "";
   private Button btnNewSearch;
   private Intent intent;

   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.setContentView(2131558724);
      Bundle extras = this.getIntent().getExtras();
      if (extras != null) {
         this.screenDestination = extras.getString("screenDestination");
      }

      ImageButton btnBack = (ImageButton)this.findViewById(2131361967);
      TextView toolBarTitle = (TextView)this.findViewById(2131363082);
      btnBack.setOnClickListener(new 1(this));
      this.btnNewSearch = (Button)this.findViewById(2131361955);
      String var5 = this.screenDestination;
      byte var6 = -1;
      switch(var5.hashCode()) {
      case 11410171:
         if (var5.equals("searchFilesScreen")) {
            var6 = 0;
         }
         break;
      case 1913147970:
         if (var5.equals("searcherCourtScreen")) {
            var6 = 1;
         }
      }

      switch(var6) {
      case 1:
         toolBarTitle.setText(2131886359);
         this.intent = new Intent(this, CourtSearcherActivityV2.class);
      case 0:
      default:
         this.btnNewSearch.setOnClickListener(new 2(this));
      }
   }

   // $FF: synthetic method
   static Intent access$000(NoResultsActivity x0) {
      return x0.intent;
   }
}
