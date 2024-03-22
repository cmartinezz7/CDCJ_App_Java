package es.santander.justicia.minisJusticia.fragments;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.NewsActivity;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.minisJusticia.dto.EnciclopediaItemDTO;
import es.santander.justicia.minisJusticia.dto.EnciclopediaParentItemDTO;
import es.santander.justicia.utils.Constants;
import es.santander.justicia.utils.InitConfigConstants;
import es.santander.justicia.utils.XMLParser;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class EnciclopediaFragment extends Fragment implements View.OnClickListener {
    private Activity activity;
    /* access modifiers changed from: private */
    public View.OnClickListener collapseRow = new View.OnClickListener() {
        public void onClick(View v) {
            int childcount = ((LinearLayout) v).getChildCount();
            if (v.getTag().toString().contains("level1")) {
                for (int i = 2; i < childcount; i++) {
                    View childView = ((LinearLayout) v).getChildAt(i);
                    int childDivider = childView.getId();
                    if (childView.getVisibility() == 0 && childDivider != 2131362098 && (childView.getTag().toString().contains("level2") || childView.getTag().toString().contains("item"))) {
                        EnciclopediaFragment.collapse(childView);
                    }
                }
                ((ImageView) ((LinearLayout) v).getChildAt(0).findViewById(R.id.ivCollapseExpand)).setImageResource(R.drawable.ic_arrow_down_blue);
            } else if (v.getTag().toString().contains("level2")) {
                for (int i2 = 2; i2 < childcount; i2++) {
                    View childView2 = ((LinearLayout) v).getChildAt(i2);
                    int childDivider2 = childView2.getId();
                    if (childView2.getVisibility() == 0 && childDivider2 != 2131362098 && (childView2.getTag().toString().contains("level3") || childView2.getTag().toString().contains("item"))) {
                        EnciclopediaFragment.collapse(childView2);
                    }
                }
                ((ImageView) ((LinearLayout) v).getChildAt(0).findViewById(R.id.ivCollapseExpand)).setImageResource(R.drawable.ic_arrow_down_darkgrey);
            } else if (v.getTag().toString().contains("level3")) {
                for (int i3 = 2; i3 < childcount; i3++) {
                    View childView3 = ((LinearLayout) v).getChildAt(i3);
                    int childDivider3 = childView3.getId();
                    if (childView3.getVisibility() == 0 && childDivider3 != 2131362098 && (childView3.getTag().toString().contains("level4") || childView3.getTag().toString().contains("item"))) {
                        EnciclopediaFragment.collapse(childView3);
                    }
                }
                ((ImageView) ((LinearLayout) v).getChildAt(0).findViewById(R.id.ivCollapseExpand)).setImageResource(R.drawable.ic_arrow_down_grey);
            } else if (v.getTag().toString().contains("level4")) {
                for (int i4 = 2; i4 < childcount; i4++) {
                    View childView4 = ((LinearLayout) v).getChildAt(i4);
                    int childDivider4 = childView4.getId();
                    if (childView4.getVisibility() == 0 && childDivider4 != 2131362098 && (childView4.getTag().toString().contains("level4") || childView4.getTag().toString().contains("item"))) {
                        EnciclopediaFragment.collapse(childView4);
                    }
                }
                ((ImageView) ((LinearLayout) v).getChildAt(0).findViewById(R.id.ivCollapseExpand)).setImageResource(R.drawable.ic_arrow_down_grey);
            }
            v.setOnClickListener(EnciclopediaFragment.this.expandRow);
        }
    };
    /* access modifiers changed from: private */
    public ArrayList<EnciclopediaItemDTO> enciclopediaItemsList = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<EnciclopediaParentItemDTO> enciclopediaParentsList = new ArrayList<>();
    /* access modifiers changed from: private */
    public View.OnClickListener expandRow = new View.OnClickListener() {
        public void onClick(View v) {
            int childcount = ((LinearLayout) v).getChildCount();
            if (v.getTag().toString().contains("level1")) {
                for (int i = 2; i < childcount; i++) {
                    View childView = ((LinearLayout) v).getChildAt(i);
                    int childDivider = childView.getId();
                    if (childView.getVisibility() == 8 && childDivider != 2131362098 && (childView.getTag().toString().contains("level2") || childView.getTag().toString().contains("item"))) {
                        EnciclopediaFragment.expand(childView);
                    }
                }
                ((ImageView) ((LinearLayout) v).getChildAt(0).findViewById(R.id.ivCollapseExpand)).setImageResource(R.drawable.ic_arrow_up_blue);
            } else if (v.getTag().toString().contains("level2")) {
                EnciclopediaFragment.this.expandLevel(v, 2);
                for (int i2 = 2; i2 < childcount; i2++) {
                    View childView2 = ((LinearLayout) v).getChildAt(i2);
                    int childDivider2 = childView2.getId();
                    if (childView2.getVisibility() == 8 && childDivider2 != 2131362098 && (v.getTag().toString().contains("level3") || v.getTag().toString().contains("item"))) {
                        EnciclopediaFragment.expand(childView2);
                    }
                }
                ((ImageView) ((LinearLayout) v).getChildAt(0).findViewById(R.id.ivCollapseExpand)).setImageResource(R.drawable.ic_arrow_up_darkgrey);
            } else if (v.getTag().toString().contains("level3")) {
                EnciclopediaFragment.this.expandLevel(v, 3);
                for (int i3 = 2; i3 < childcount; i3++) {
                    View childView3 = ((LinearLayout) v).getChildAt(i3);
                    int childDivider3 = childView3.getId();
                    if (childView3.getVisibility() == 8 && childDivider3 != 2131362098 && (v.getTag().toString().contains("level4") || v.getTag().toString().contains("item"))) {
                        EnciclopediaFragment.expand(childView3);
                    }
                }
                ((ImageView) ((LinearLayout) v).getChildAt(0).findViewById(R.id.ivCollapseExpand)).setImageResource(R.drawable.ic_arrow_up_grey);
            } else if (v.getTag().toString().contains("level4")) {
                EnciclopediaFragment.this.expandLevel(v, 4);
                for (int i4 = 2; i4 < childcount; i4++) {
                    View childView4 = ((LinearLayout) v).getChildAt(i4);
                    int childDivider4 = childView4.getId();
                    if (childView4.getVisibility() == 8 && childDivider4 != 2131362098 && (v.getTag().toString().contains("level5") || v.getTag().toString().contains("item"))) {
                        EnciclopediaFragment.expand(childView4);
                    }
                }
                ((ImageView) ((LinearLayout) v).getChildAt(0).findViewById(R.id.ivCollapseExpand)).setImageResource(R.drawable.ic_arrow_up_grey);
            }
            v.setOnClickListener(EnciclopediaFragment.this.collapseRow);
        }
    };
    private ViewGroup mContainer;
    /* access modifiers changed from: private */
    public View mProgressView;
    private View.OnClickListener openEncyclopediaLink = new View.OnClickListener() {
        public void onClick(View v) {
            int childcount = ((LinearLayout) v).getChildCount();
            String url = "";
            for (int i = 0; i < childcount; i++) {
                url = ((TextView) ((LinearLayout) v).getChildAt(i)).getText().toString();
            }
            if (!url.startsWith("https://") && !url.startsWith("http://")) {
                url = "http://" + url;
            }
            Intent toEnc = new Intent("android.intent.action.VIEW");
            toEnc.setData(Uri.parse(url));
            EnciclopediaFragment.this.startActivity(toEnc);
        }
    };
    private LinearLayout rlEnciclopedia;
    /* access modifiers changed from: private */
    public View rootview;
    private Typeface tfMedium;
    private Typeface tfRegular;
    private TextView tvDescription;
    private TextView tvTitle;

    public void onCreate(Bundle savedInstanceState) {
        EnciclopediaFragment.super.onCreate(savedInstanceState);
        FragmentActivity activity2 = getActivity();
        this.activity = activity2;
        this.tfMedium = Typeface.createFromAsset(activity2.getAssets(), Constants.FIRASANS_MEDIUM);
        this.tfRegular = Typeface.createFromAsset(this.activity.getAssets(), Constants.FIRASANS_REGULAR);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.mContainer = container;
        View inflate = inflater.inflate(R.layout.fragment_tab_enciclopedia, container, false);
        this.rootview = inflate;
        this.mProgressView = inflate.findViewById(R.id.login_progress);
        this.rlEnciclopedia = (LinearLayout) this.rootview.findViewById(R.id.rlEnciclopedia);
        this.enciclopediaItemsList = NewsActivity.getEncyclopediaItemsList();
        this.enciclopediaParentsList = NewsActivity.getEncyclopediaGroupList();
        new RetrieveEncyclopedia().execute(new Object[0]);
        return this.rootview;
    }

    public void onClick(View v) {
    }

    public class RetrieveEncyclopedia extends AsyncTask {
        public RetrieveEncyclopedia() {
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            EnciclopediaFragment.this.showProgress(true);
        }

        /* access modifiers changed from: protected */
        public Object doInBackground(Object[] objects) {
            DocumentBuilderFactory dbf;
            NodeList nodeList;
            try {
                if (EnciclopediaFragment.this.enciclopediaItemsList != null) {
                    if (EnciclopediaFragment.this.enciclopediaParentsList != null) {
                        return EnciclopediaFragment.this.prepareView();
                    }
                }
                ArrayList unused = EnciclopediaFragment.this.enciclopediaParentsList = new ArrayList();
                ArrayList unused2 = EnciclopediaFragment.this.enciclopediaItemsList = new ArrayList();
                XMLParser parser = new XMLParser();
                URL url = new URL(MainApplication.getInfo(MainApplication.URL_ECYCLOPEDIAe));
                DocumentBuilderFactory dbf2 = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf2.newDocumentBuilder();
                Document doc = db.parse(new InputSource(url.openStream()));
                doc.getDocumentElement().normalize();
                NodeList nodeList2 = doc.getElementsByTagName("text");
                NodeList nodeItemList = doc.getElementsByTagName("element");
                int i = 0;
                while (i < nodeList2.getLength()) {
                    EnciclopediaParentItemDTO parentItemDTO = new EnciclopediaParentItemDTO();
                    NodeList childs = ((Element) nodeList2.item(i)).getElementsByTagName("section");
                    URL url2 = url;
                    int j = 0;
                    while (true) {
                        dbf = dbf2;
                        if (j >= childs.getLength()) {
                            break;
                        }
                        Node child = childs.item(j);
                        Node node = child;
                        Element elementChild = (Element) child;
                        DocumentBuilder db2 = db;
                        Document doc2 = doc;
                        if (elementChild.getAttribute("level").equals("1")) {
                            parentItemDTO = new EnciclopediaParentItemDTO();
                            parentItemDTO.setLevel(elementChild.getAttribute("level"));
                            parentItemDTO.setIde(elementChild.getAttribute("ide"));
                            nodeList = nodeList2;
                            parentItemDTO.setTitle(parser.cleanXml(elementChild.getElementsByTagName("title").item(0).getTextContent()));
                            parentItemDTO.setParentIDE("0");
                        } else {
                            nodeList = nodeList2;
                        }
                        if (elementChild.getAttribute("level").equals("2")) {
                            parentItemDTO = new EnciclopediaParentItemDTO();
                            parentItemDTO.setLevel(elementChild.getAttribute("level"));
                            parentItemDTO.setIde(elementChild.getAttribute("ide"));
                            parentItemDTO.setTitle(parser.cleanXml(elementChild.getElementsByTagName("title").item(0).getTextContent()));
                            parentItemDTO.setParentIDE(((Element) elementChild.getParentNode()).getAttribute("ide"));
                        }
                        if (elementChild.getAttribute("level").equals("3")) {
                            parentItemDTO = new EnciclopediaParentItemDTO();
                            parentItemDTO.setLevel(elementChild.getAttribute("level"));
                            parentItemDTO.setIde(elementChild.getAttribute("ide"));
                            parentItemDTO.setTitle(parser.cleanXml(elementChild.getElementsByTagName("title").item(0).getTextContent()));
                            parentItemDTO.setParentIDE(((Element) elementChild.getParentNode()).getAttribute("ide"));
                        }
                        if (elementChild.getAttribute("level").equals("4")) {
                            EnciclopediaParentItemDTO parentItemDTO2 = new EnciclopediaParentItemDTO();
                            parentItemDTO2.setLevel(elementChild.getAttribute("level"));
                            parentItemDTO2.setIde(elementChild.getAttribute("ide"));
                            parentItemDTO2.setTitle(parser.cleanXml(elementChild.getElementsByTagName("title").item(0).getTextContent()));
                            parentItemDTO2.setParentIDE(((Element) elementChild.getParentNode()).getAttribute("ide"));
                            parentItemDTO = parentItemDTO2;
                        }
                        EnciclopediaFragment.this.enciclopediaParentsList.add(parentItemDTO);
                        j++;
                        dbf2 = dbf;
                        db = db2;
                        doc = doc2;
                        nodeList2 = nodeList;
                    }
                    Document document = doc;
                    NodeList nodeList3 = nodeList2;
                    i++;
                    url = url2;
                    dbf2 = dbf;
                }
                DocumentBuilderFactory documentBuilderFactory = dbf2;
                DocumentBuilder documentBuilder = db;
                Document document2 = doc;
                NodeList nodeList4 = nodeList2;
                for (int i2 = 0; i2 < nodeItemList.getLength(); i2++) {
                    EnciclopediaItemDTO encyclopediaItem = new EnciclopediaItemDTO();
                    Element element = (Element) nodeItemList.item(i2);
                    encyclopediaItem.setLevel(element.getAttribute("level"));
                    encyclopediaItem.setIde(element.getAttribute("ide"));
                    encyclopediaItem.setIdd(element.getAttribute("idd"));
                    encyclopediaItem.setVersion(element.getAttribute(InitConfigConstants.NODE_VERSION));
                    encyclopediaItem.setLink(element.getAttribute("href"));
                    encyclopediaItem.setDescription(element.getTextContent());
                    encyclopediaItem.setParentIde(((Element) element.getParentNode()).getAttribute("ide"));
                    EnciclopediaFragment.this.enciclopediaItemsList.add(encyclopediaItem);
                }
            } catch (MalformedURLException e) {
                Log.e("EnciclopediaFragment", "MalformedURLException", e);
            } catch (IOException e2) {
                Log.e("EnciclopediaFragment", "IOException", e2);
            } catch (Exception e3) {
                Log.e("EnciclopediaFragment", "Exception", e3);
            }
            NewsActivity.setEncyclopediaItemsList(EnciclopediaFragment.this.enciclopediaItemsList);
            NewsActivity.setEncyclopediaGroupList(EnciclopediaFragment.this.enciclopediaParentsList);
            return EnciclopediaFragment.this.prepareView();
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Object o) {
            super.onPostExecute(o);
            ArrayList unused = EnciclopediaFragment.this.enciclopediaParentsList = NewsActivity.getEncyclopediaGroupList();
            ArrayList unused2 = EnciclopediaFragment.this.enciclopediaItemsList = NewsActivity.getEncyclopediaItemsList();
            ((LinearLayout) EnciclopediaFragment.this.rootview.findViewById(R.id.rlEnciclopedia)).addView((View) o);
            EnciclopediaFragment.this.firstCollapse((View) o);
            EnciclopediaFragment.this.showProgress(false);
        }

        public InputStream getInputStream(URL url) {
            try {
                return url.openConnection().getInputStream();
            } catch (IOException e) {
                return null;
            }
        }

        public ArrayList<EnciclopediaItemDTO> enciclopediaItemsList() {
            return EnciclopediaFragment.this.enciclopediaItemsList;
        }
    }

    public static void expand(final View v) {
        v.measure(-1, -2);
        final int targetHeight = v.getMeasuredHeight();
        v.getLayoutParams().height = 1;
        v.setVisibility(0);
        Animation a = new Animation() {
            /* access modifiers changed from: protected */
            public void applyTransformation(float interpolatedTime, Transformation t) {
                int i;
                ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
                if (interpolatedTime == 1.0f) {
                    i = -2;
                } else {
                    i = (int) (((float) targetHeight) * interpolatedTime);
                }
                layoutParams.height = i;
                v.requestLayout();
            }

            public boolean willChangeBounds() {
                return true;
            }
        };
        a.setDuration((long) ((int) (((float) targetHeight) / v.getContext().getResources().getDisplayMetrics().density)));
        v.startAnimation(a);
    }

    public static void collapse(final View v) {
        final int initialHeight = v.getMeasuredHeight();
        Animation a = new Animation() {
            /* access modifiers changed from: protected */
            public void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1.0f) {
                    v.setVisibility(8);
                    return;
                }
                ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
                int i = initialHeight;
                layoutParams.height = i - ((int) (((float) i) * interpolatedTime));
                v.requestLayout();
            }

            public boolean willChangeBounds() {
                return true;
            }
        };
        a.setDuration((long) ((int) (((float) initialHeight) / v.getContext().getResources().getDisplayMetrics().density)));
        v.startAnimation(a);
    }

    public View prepareView() {
        LayoutInflater layoutInflater = (LayoutInflater) this.activity.getSystemService("layout_inflater");
        LayoutInflater layoutInflater2 = (LayoutInflater) this.activity.getSystemService("layout_inflater");
        View llLevel1 = layoutInflater2.inflate(R.layout.row_encyclopedia_group_level1, this.mContainer, false);
        llLevel1.setOnClickListener(this.collapseRow);
        Iterator<EnciclopediaParentItemDTO> it = this.enciclopediaParentsList.iterator();
        while (it.hasNext()) {
            EnciclopediaParentItemDTO enParent = it.next();
            if (enParent.getLevel().equals("1")) {
                TextView tv = (TextView) llLevel1.findViewById(2131362988);
                llLevel1.setTag("level1 - " + enParent.getIde());
                tv.setTypeface(this.tfMedium);
                tv.setText(enParent.getTitle());
            } else if (enParent.getLevel().equals("2")) {
                View llLevel2 = layoutInflater2.inflate(R.layout.row_encyclopedia_group_level2, this.mContainer, false);
                llLevel2.setOnClickListener(this.collapseRow);
                llLevel2.setTag("level2 - " + enParent.getIde());
                TextView tv2 = (TextView) llLevel2.findViewById(2131362988);
                tv2.setTypeface(this.tfRegular);
                tv2.setText(enParent.getTitle());
                ((LinearLayout) llLevel1).addView(llLevel2);
            }
        }
        return llLevel1;
    }

    public void firstCollapse(View v) {
        int childcount = ((LinearLayout) v).getChildCount();
        if (v.getTag().toString().contains("level1")) {
            for (int i = 2; i < childcount; i++) {
                View childView = ((LinearLayout) v).getChildAt(i);
                int childDivider = childView.getId();
                if (childView.getTag().toString().contains("level2")) {
                    int childcount2 = ((LinearLayout) childView).getChildCount();
                    for (int j = 2; j < childcount2; j++) {
                        View childView2 = ((LinearLayout) childView).getChildAt(j);
                        if (childView2.getVisibility() == 0 && childDivider != 2131362098 && (childView2.getTag().toString().contains("level3") || childView2.getTag().toString().contains("item"))) {
                            collapse(childView2);
                        }
                    }
                }
                ((ImageView) ((LinearLayout) childView).getChildAt(0).findViewById(R.id.ivCollapseExpand)).setImageResource(R.drawable.ic_arrow_down_darkgrey);
                childView.setOnClickListener(this.expandRow);
            }
        }
        ((ImageView) ((LinearLayout) v).getChildAt(0).findViewById(R.id.ivCollapseExpand)).setImageResource(R.drawable.ic_arrow_up_blue);
    }

    public void expandLevel(View v, int level) {
        String ide = v.getTag().toString().replace("level2 - ", "");
        String tagLevel = "";
        int resourcetoInflate = 0;
        if (level == 0) {
            ide = ide.replace("level4 - ", "");
            resourcetoInflate = R.layout.row_encyclopedia_item;
        } else if (level == 1) {
            tagLevel = "level2 - ";
            ide = ide.replace("level1 - ", "");
            resourcetoInflate = R.layout.row_encyclopedia_group_level1;
        } else if (level == 2) {
            tagLevel = "level3 - ";
            ide = ide.replace("level2 - ", "");
            resourcetoInflate = R.layout.row_encyclopedia_group_level2;
        } else if (level == 3) {
            tagLevel = "level4 - ";
            ide = ide.replace("level3 - ", "");
            resourcetoInflate = R.layout.row_encyclopedia_group_level3;
        } else if (level == 4) {
            tagLevel = "level5 - ";
            ide = ide.replace("level4 - ", "");
            resourcetoInflate = R.layout.row_encyclopedia_group_level3;
        }
        LayoutInflater layoutInflater = (LayoutInflater) this.activity.getSystemService("layout_inflater");
        Iterator<EnciclopediaParentItemDTO> it = this.enciclopediaParentsList.iterator();
        while (it.hasNext()) {
            EnciclopediaParentItemDTO child = it.next();
            if (child.getParentIDE().equals(ide)) {
                View llLevel = layoutInflater.inflate(resourcetoInflate, this.mContainer, false);
                llLevel.setOnClickListener(this.expandRow);
                llLevel.setTag(tagLevel + child.getIde());
                TextView tvEnThirdLevelParent = (TextView) llLevel.findViewById(2131362988);
                tvEnThirdLevelParent.setTypeface(this.tfRegular);
                tvEnThirdLevelParent.setText(child.getTitle());
                ((LinearLayout) v).addView(llLevel);
            }
        }
        Iterator<EnciclopediaItemDTO> it2 = this.enciclopediaItemsList.iterator();
        while (it2.hasNext()) {
            EnciclopediaItemDTO enItem = it2.next();
            if (enItem.getParentIde().equals(ide)) {
                View itemLevel2 = layoutInflater.inflate(R.layout.row_encyclopedia_item, this.mContainer, false);
                itemLevel2.setOnClickListener(this.openEncyclopediaLink);
                ((TextView) itemLevel2.findViewById(R.id.tvIde)).setText(enItem.getLink());
                TextView tvEnItem = (TextView) itemLevel2.findViewById(2131362988);
                tvEnItem.setTypeface(this.tfRegular);
                tvEnItem.setText(enItem.getDescription());
                ((LinearLayout) v).addView(itemLevel2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void showProgress(final boolean show) {
        try {
            int i = 8;
            if (Build.VERSION.SDK_INT >= 13) {
                int shortAnimTime = getResources().getInteger(17694720);
                this.rlEnciclopedia.setVisibility(show ? 8 : 0);
                View view = this.mProgressView;
                if (show) {
                    i = 0;
                }
                view.setVisibility(i);
                this.mProgressView.animate().setDuration((long) shortAnimTime).alpha(show ? 1.0f : 0.0f).setListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animation) {
                        EnciclopediaFragment.this.mProgressView.setVisibility(show ? 0 : 8);
                    }
                });
                return;
            }
            this.rlEnciclopedia.setVisibility(show ? 8 : 0);
            View view2 = this.mProgressView;
            if (show) {
                i = 0;
            }
            view2.setVisibility(i);
        } catch (Exception e) {
            Log.i("CargaEnciclopedia", "Contexto Perdido", e);
        }
    }
}
