package es.santander.justicia.minisJusticia;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import es.santander.justicia.minisJusticia.dto.CourtDataDto;

class CourtListActivity$2 implements OnItemClickListener {
   // $FF: synthetic field
   final CourtListActivity this$0;

   CourtListActivity$2(CourtListActivity this$0) {
      this.this$0 = this$0;
   }

   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
      CourtDataDto courtData = CourtListActivity.access$000(this.this$0).getItem(position);
      String courtCode = courtData.getCourtCode();
      Intent intent = new Intent(this.this$0, MapsActivity.class);
      intent.putExtra("courtCode", courtCode);
      this.this$0.startActivity(intent);
   }
}
