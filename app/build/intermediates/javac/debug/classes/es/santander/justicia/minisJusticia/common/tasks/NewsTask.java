package es.santander.justicia.minisJusticia.common.tasks;

import android.os.AsyncTask;
import android.util.Log;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.dto.NoticiaActualidadDTO;
import es.santander.justicia.minisJusticia.login.manager.LoginManager;
import es.santander.justicia.utils.XMLParser;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class NewsTask extends AsyncTask<Object, Object, Object> {
   private ActivityCallBack activityCallBack;
   public static final String TASK_ID = "NEWS";
   private URL url;

   public NewsTask(ActivityCallBack activity) {
      this.activityCallBack = activity;
   }

   protected Object doInBackground(Object[] objects) {
      String text = null;
      InputStream is = null;

      try {
         this.url = new URL(MainApplication.getInfo("DLULAZoaAELsD6ewvCTOad+izzZOSAtVspwrYrjYTc03LIx0pJXRKsJhGdYZJACpS0aIphezhn5IQESTwNZpyA=="));
         is = this.getInputStream(this.url);
         if (is != null) {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(false);
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(is, "UTF_8");
            boolean insideItem = false;
            boolean insideSentenciaItem = false;
            XMLParser parser = new XMLParser();
            int eventType = xpp.getEventType();
            NoticiaActualidadDTO news = new NoticiaActualidadDTO();
            LoginManager.getInstance().setNewsList(new ArrayList());

            for(; eventType != 1; eventType = xpp.next()) {
               String name = xpp.getName();
               switch(eventType) {
               case 2:
                  if (name.equals("item") && xpp.getAttributeValue(0).equals("true")) {
                     if (xpp.getAttributeCount() > 1 && xpp.getAttributeValue(1).equals("SDD")) {
                        insideSentenciaItem = true;
                     }

                     insideItem = true;
                  }
                  break;
               case 3:
                  if (name.equals("item") && insideSentenciaItem) {
                     LoginManager.getInstance().setSsdNews(news);
                     insideSentenciaItem = false;
                  } else {
                     if (name.equals("item") && insideItem) {
                        LoginManager.getInstance().getNewsList().add(news);
                        news = new NoticiaActualidadDTO();
                        insideItem = false;
                     }

                     if (insideItem) {
                        if (name.equals("title")) {
                           news.setTituloNoticia(text);
                        } else if (name.equals("link")) {
                           news.setLink(text);
                        } else if (name.equals("description") && text != null) {
                           news.setDescription(parser.cleanXml(text));
                        }
                     }
                  }
                  break;
               case 4:
                  text = xpp.getText();
               }
            }

            insideItem = false;
         }
      } catch (MalformedURLException var26) {
         Log.e("JusticiaSoapService", "MalformedURLException", var26);
      } catch (XmlPullParserException var27) {
         Log.e("JusticiaSoapService", "XmlPullParserException", var27);
      } catch (IOException var28) {
         Log.e("JusticiaSoapService", "IOException", var28);
      } catch (Exception var29) {
         Log.e("JusticiaSoapService", "Exception", var29);
      } finally {
         try {
            if (is != null) {
               is.close();
            }
         } catch (IOException var25) {
            Log.e("JusticiaSoapService", "is.close() - IOException", var25);
         }

      }

      return "";
   }

   public InputStream getInputStream(URL url) {
      try {
         return url.openConnection().getInputStream();
      } catch (IOException var3) {
         return null;
      }
   }

   protected void onPostExecute(Object response) {
      if (this.activityCallBack != null) {
         this.activityCallBack.onTaskFinished("NEWS", this);
      }

   }

   public ActivityCallBack getActivityCallBack() {
      return this.activityCallBack;
   }

   public void setActivityCallBack(ActivityCallBack activityCallBack) {
      this.activityCallBack = activityCallBack;
   }
}
