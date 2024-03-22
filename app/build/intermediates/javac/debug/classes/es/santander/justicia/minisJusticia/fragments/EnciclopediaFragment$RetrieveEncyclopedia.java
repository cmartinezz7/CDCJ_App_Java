package es.santander.justicia.minisJusticia.fragments;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import es.santander.justicia.minisJusticia.NewsActivity;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.dto.EnciclopediaItemDTO;
import es.santander.justicia.minisJusticia.dto.EnciclopediaParentItemDTO;
import es.santander.justicia.utils.XMLParser;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class EnciclopediaFragment$RetrieveEncyclopedia extends AsyncTask {
   // $FF: synthetic field
   final EnciclopediaFragment this$0;

   public EnciclopediaFragment$RetrieveEncyclopedia(EnciclopediaFragment this$0) {
      this.this$0 = this$0;
   }

   protected void onPreExecute() {
      super.onPreExecute();
      EnciclopediaFragment.access$000(this.this$0, true);
   }

   protected Object doInBackground(Object[] objects) {
      try {
         if (EnciclopediaFragment.access$100(this.this$0) != null && EnciclopediaFragment.access$200(this.this$0) != null) {
            return this.this$0.prepareView();
         }

         EnciclopediaFragment.access$202(this.this$0, new ArrayList());
         EnciclopediaFragment.access$102(this.this$0, new ArrayList());
         XMLParser parser = new XMLParser();
         URL url = new URL(MainApplication.getInfo("TmFz7DplvKiFGGH0vDIwx0T8IgJULGZJF0UNDy40SLA7dgaFORVI/LGEWyBz+PNxMwgeN12fp3imUyqLASJUMQ=="));
         DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
         DocumentBuilder db = dbf.newDocumentBuilder();
         Document doc = db.parse(new InputSource(url.openStream()));
         doc.getDocumentElement().normalize();
         NodeList nodeList = doc.getElementsByTagName("text");
         NodeList nodeItemList = doc.getElementsByTagName("element");

         int i;
         Node node;
         Element element;
         for(i = 0; i < nodeList.getLength(); ++i) {
            EnciclopediaParentItemDTO parentItemDTO = new EnciclopediaParentItemDTO();
            node = nodeList.item(i);
            element = (Element)node;
            NodeList childs = element.getElementsByTagName("section");

            for(int j = 0; j < childs.getLength(); ++j) {
               Node child = childs.item(j);
               Element elementChild = (Element)child;
               Node nodeTitle;
               if (elementChild.getAttribute("level").equals("1")) {
                  parentItemDTO = new EnciclopediaParentItemDTO();
                  parentItemDTO.setLevel(elementChild.getAttribute("level"));
                  parentItemDTO.setIde(elementChild.getAttribute("ide"));
                  nodeTitle = elementChild.getElementsByTagName("title").item(0);
                  parentItemDTO.setTitle(parser.cleanXml(nodeTitle.getTextContent()));
                  parentItemDTO.setParentIDE("0");
               }

               if (elementChild.getAttribute("level").equals("2")) {
                  parentItemDTO = new EnciclopediaParentItemDTO();
                  parentItemDTO.setLevel(elementChild.getAttribute("level"));
                  parentItemDTO.setIde(elementChild.getAttribute("ide"));
                  nodeTitle = elementChild.getElementsByTagName("title").item(0);
                  parentItemDTO.setTitle(parser.cleanXml(nodeTitle.getTextContent()));
                  parentItemDTO.setParentIDE(((Element)elementChild.getParentNode()).getAttribute("ide"));
               }

               if (elementChild.getAttribute("level").equals("3")) {
                  parentItemDTO = new EnciclopediaParentItemDTO();
                  parentItemDTO.setLevel(elementChild.getAttribute("level"));
                  parentItemDTO.setIde(elementChild.getAttribute("ide"));
                  nodeTitle = elementChild.getElementsByTagName("title").item(0);
                  parentItemDTO.setTitle(parser.cleanXml(nodeTitle.getTextContent()));
                  parentItemDTO.setParentIDE(((Element)elementChild.getParentNode()).getAttribute("ide"));
               }

               if (elementChild.getAttribute("level").equals("4")) {
                  parentItemDTO = new EnciclopediaParentItemDTO();
                  parentItemDTO.setLevel(elementChild.getAttribute("level"));
                  parentItemDTO.setIde(elementChild.getAttribute("ide"));
                  nodeTitle = elementChild.getElementsByTagName("title").item(0);
                  parentItemDTO.setTitle(parser.cleanXml(nodeTitle.getTextContent()));
                  parentItemDTO.setParentIDE(((Element)elementChild.getParentNode()).getAttribute("ide"));
               }

               EnciclopediaFragment.access$200(this.this$0).add(parentItemDTO);
            }
         }

         for(i = 0; i < nodeItemList.getLength(); ++i) {
            EnciclopediaItemDTO encyclopediaItem = new EnciclopediaItemDTO();
            node = nodeItemList.item(i);
            element = (Element)node;
            encyclopediaItem.setLevel(element.getAttribute("level"));
            encyclopediaItem.setIde(element.getAttribute("ide"));
            encyclopediaItem.setIdd(element.getAttribute("idd"));
            encyclopediaItem.setVersion(element.getAttribute("version"));
            encyclopediaItem.setLink(element.getAttribute("href"));
            encyclopediaItem.setDescription(element.getTextContent());
            encyclopediaItem.setParentIde(((Element)element.getParentNode()).getAttribute("ide"));
            EnciclopediaFragment.access$100(this.this$0).add(encyclopediaItem);
         }
      } catch (MalformedURLException var18) {
         Log.e("EnciclopediaFragment", "MalformedURLException", var18);
      } catch (IOException var19) {
         Log.e("EnciclopediaFragment", "IOException", var19);
      } catch (Exception var20) {
         Log.e("EnciclopediaFragment", "Exception", var20);
      }

      NewsActivity.setEncyclopediaItemsList(EnciclopediaFragment.access$100(this.this$0));
      NewsActivity.setEncyclopediaGroupList(EnciclopediaFragment.access$200(this.this$0));
      return this.this$0.prepareView();
   }

   protected void onPostExecute(Object o) {
      super.onPostExecute(o);
      EnciclopediaFragment.access$202(this.this$0, NewsActivity.getEncyclopediaGroupList());
      EnciclopediaFragment.access$102(this.this$0, NewsActivity.getEncyclopediaItemsList());
      LinearLayout rl = (LinearLayout)EnciclopediaFragment.access$300(this.this$0).findViewById(2131362639);
      rl.addView((View)o);
      this.this$0.firstCollapse((View)o);
      EnciclopediaFragment.access$000(this.this$0, false);
   }

   public InputStream getInputStream(URL url) {
      try {
         return url.openConnection().getInputStream();
      } catch (IOException var3) {
         return null;
      }
   }

   public ArrayList<EnciclopediaItemDTO> enciclopediaItemsList() {
      return EnciclopediaFragment.access$100(this.this$0);
   }
}
