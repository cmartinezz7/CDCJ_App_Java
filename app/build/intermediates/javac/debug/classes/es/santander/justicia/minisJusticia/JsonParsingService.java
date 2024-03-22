package es.santander.justicia.minisJusticia;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class JsonParsingService extends Service {
   public static final String LOGTAG = JsonParsingService.class.getSimpleName();
   public final IBinder binder = new es.santander.justicia.minisJusticia.JsonParsingService.ParsingBinder(this);

   public void onCreate() {
      Log.i(LOGTAG, "Tracking Service Running...");
   }

   public void onDestroy() {
      Log.i(LOGTAG, "Tracking Service Stopped...");
   }

   public IBinder onBind(Intent intent) {
      return this.binder;
   }
}
