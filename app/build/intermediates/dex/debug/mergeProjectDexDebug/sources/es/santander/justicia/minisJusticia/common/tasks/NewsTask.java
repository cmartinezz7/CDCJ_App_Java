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
    public static final String TASK_ID = "NEWS";
    private ActivityCallBack activityCallBack;
    private URL url;

    public NewsTask(ActivityCallBack activity) {
        this.activityCallBack = activity;
    }

    /* access modifiers changed from: protected */
    public Object doInBackground(Object[] objects) {
        String text = null;
        InputStream is = null;
        try {
            URL url2 = new URL(MainApplication.getInfo(MainApplication.URL_NEWSe));
            this.url = url2;
            is = getInputStream(url2);
            if (is != null) {
                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                factory.setNamespaceAware(false);
                XmlPullParser xpp = factory.newPullParser();
                xpp.setInput(is, "UTF_8");
                boolean insideItem = false;
                boolean insideSentenciaItem = false;
                XMLParser parser = new XMLParser();
                NoticiaActualidadDTO news = new NoticiaActualidadDTO();
                LoginManager.getInstance().setNewsList(new ArrayList());
                for (int eventType = xpp.getEventType(); eventType != 1; eventType = xpp.next()) {
                    String name = xpp.getName();
                    if (eventType != 2) {
                        if (eventType != 3) {
                            if (eventType == 4) {
                                text = xpp.getText();
                            }
                        } else if (!name.equals("item") || !insideSentenciaItem) {
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
                        } else {
                            LoginManager.getInstance().setSsdNews(news);
                            insideSentenciaItem = false;
                        }
                    } else if (name.equals("item") && xpp.getAttributeValue(0).equals("true")) {
                        if (xpp.getAttributeCount() > 1 && xpp.getAttributeValue(1).equals("SDD")) {
                            insideSentenciaItem = true;
                        }
                        insideItem = true;
                    }
                }
            }
            if (is == null) {
                return "";
            }
            try {
                is.close();
                return "";
            } catch (IOException e) {
                Log.e("JusticiaSoapService", "is.close() - IOException", e);
                return "";
            }
        } catch (MalformedURLException e2) {
            Log.e("JusticiaSoapService", "MalformedURLException", e2);
            if (is == null) {
                return "";
            }
            is.close();
            return "";
        } catch (XmlPullParserException e3) {
            Log.e("JusticiaSoapService", "XmlPullParserException", e3);
            if (is == null) {
                return "";
            }
            is.close();
            return "";
        } catch (IOException e4) {
            Log.e("JusticiaSoapService", "IOException", e4);
            if (is == null) {
                return "";
            }
            is.close();
            return "";
        } catch (Exception e5) {
            Log.e("JusticiaSoapService", "Exception", e5);
            if (is == null) {
                return "";
            }
            is.close();
            return "";
        } catch (Throwable th) {
            Throwable th2 = th;
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e6) {
                    Log.e("JusticiaSoapService", "is.close() - IOException", e6);
                }
            }
            throw th2;
        }
    }

    public InputStream getInputStream(URL url2) {
        try {
            return url2.openConnection().getInputStream();
        } catch (IOException e) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Object response) {
        ActivityCallBack activityCallBack2 = this.activityCallBack;
        if (activityCallBack2 != null) {
            activityCallBack2.onTaskFinished(TASK_ID, this);
        }
    }

    public ActivityCallBack getActivityCallBack() {
        return this.activityCallBack;
    }

    public void setActivityCallBack(ActivityCallBack activityCallBack2) {
        this.activityCallBack = activityCallBack2;
    }
}
