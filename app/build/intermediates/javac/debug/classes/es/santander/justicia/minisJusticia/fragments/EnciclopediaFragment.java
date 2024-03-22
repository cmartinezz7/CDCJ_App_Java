package es.santander.justicia.minisJusticia.fragments;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import es.santander.justicia.minisJusticia.NewsActivity;
import es.santander.justicia.minisJusticia.dto.EnciclopediaItemDTO;
import es.santander.justicia.minisJusticia.dto.EnciclopediaParentItemDTO;
import es.santander.justicia.minisJusticia.fragments.EnciclopediaFragment.1;
import es.santander.justicia.minisJusticia.fragments.EnciclopediaFragment.2;
import es.santander.justicia.minisJusticia.fragments.EnciclopediaFragment.3;
import es.santander.justicia.minisJusticia.fragments.EnciclopediaFragment.4;
import es.santander.justicia.minisJusticia.fragments.EnciclopediaFragment.5;
import es.santander.justicia.minisJusticia.fragments.EnciclopediaFragment.6;
import java.util.ArrayList;
import java.util.Iterator;

public class EnciclopediaFragment extends Fragment implements OnClickListener {
   private TextView tvDescription;
   private TextView tvTitle;
   private View rootview;
   private View mProgressView;
   private LinearLayout rlEnciclopedia;
   private Activity activity;
   private ViewGroup mContainer;
   private Typeface tfMedium;
   private Typeface tfRegular;
   private ArrayList<EnciclopediaItemDTO> enciclopediaItemsList = new ArrayList();
   private ArrayList<EnciclopediaParentItemDTO> enciclopediaParentsList = new ArrayList();
   private OnClickListener collapseRow = new 3(this);
   private OnClickListener expandRow = new 4(this);
   private OnClickListener openEncyclopediaLink = new 5(this);

   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.activity = this.getActivity();
      this.tfMedium = Typeface.createFromAsset(this.activity.getAssets(), "FiraSans-Medium.ttf");
      this.tfRegular = Typeface.createFromAsset(this.activity.getAssets(), "FiraSans-Regular.ttf");
   }

   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      this.mContainer = container;
      this.rootview = inflater.inflate(2131558579, container, false);
      this.mProgressView = this.rootview.findViewById(2131362448);
      this.rlEnciclopedia = (LinearLayout)this.rootview.findViewById(2131362639);
      this.enciclopediaItemsList = NewsActivity.getEncyclopediaItemsList();
      this.enciclopediaParentsList = NewsActivity.getEncyclopediaGroupList();
      es.santander.justicia.minisJusticia.fragments.EnciclopediaFragment.RetrieveEncyclopedia getEnc = new es.santander.justicia.minisJusticia.fragments.EnciclopediaFragment.RetrieveEncyclopedia(this);
      getEnc.execute(new Object[0]);
      return this.rootview;
   }

   public void onClick(View v) {
   }

   public static void expand(View v) {
      v.measure(-1, -2);
      int targetHeight = v.getMeasuredHeight();
      v.getLayoutParams().height = 1;
      v.setVisibility(0);
      Animation a = new 1(v, targetHeight);
      a.setDuration((long)((int)((float)targetHeight / v.getContext().getResources().getDisplayMetrics().density)));
      v.startAnimation(a);
   }

   public static void collapse(View v) {
      int initialHeight = v.getMeasuredHeight();
      Animation a = new 2(v, initialHeight);
      a.setDuration((long)((int)((float)initialHeight / v.getContext().getResources().getDisplayMetrics().density)));
      v.startAnimation(a);
   }

   public View prepareView() {
      LayoutInflater layoutInflater1 = (LayoutInflater)this.activity.getSystemService("layout_inflater");
      LayoutInflater layoutInflater = (LayoutInflater)this.activity.getSystemService("layout_inflater");
      View llLevel1 = layoutInflater.inflate(2131558727, this.mContainer, false);
      llLevel1.setOnClickListener(this.collapseRow);
      Iterator var4 = this.enciclopediaParentsList.iterator();

      while(var4.hasNext()) {
         EnciclopediaParentItemDTO enParent = (EnciclopediaParentItemDTO)var4.next();
         if (enParent.getLevel().equals("1")) {
            TextView tv = (TextView)llLevel1.findViewById(2131362988);
            llLevel1.setTag("level1 - " + enParent.getIde());
            tv.setTypeface(this.tfMedium);
            tv.setText(enParent.getTitle());
         } else if (enParent.getLevel().equals("2")) {
            View llLevel2 = layoutInflater.inflate(2131558728, this.mContainer, false);
            llLevel2.setOnClickListener(this.collapseRow);
            llLevel2.setTag("level2 - " + enParent.getIde());
            TextView tv = (TextView)llLevel2.findViewById(2131362988);
            tv.setTypeface(this.tfRegular);
            tv.setText(enParent.getTitle());
            ((LinearLayout)llLevel1).addView(llLevel2);
         }
      }

      return llLevel1;
   }

   public void firstCollapse(View v) {
      int childcount = ((LinearLayout)v).getChildCount();
      ImageView imgView;
      if (v.getTag().toString().contains("level1")) {
         for(int i = 2; i < childcount; ++i) {
            View childView = ((LinearLayout)v).getChildAt(i);
            int childDivider = childView.getId();
            if (childView.getTag().toString().contains("level2")) {
               int childcount2 = ((LinearLayout)childView).getChildCount();

               for(int j = 2; j < childcount2; ++j) {
                  View childView2 = ((LinearLayout)childView).getChildAt(j);
                  if (childView2.getVisibility() == 0 && childDivider != 2131362098 && (childView2.getTag().toString().contains("level3") || childView2.getTag().toString().contains("item"))) {
                     collapse(childView2);
                  }
               }
            }

            imgView = (ImageView)((LinearLayout)childView).getChildAt(0).findViewById(2131362333);
            imgView.setImageResource(2131231019);
            childView.setOnClickListener(this.expandRow);
         }
      }

      imgView = (ImageView)((LinearLayout)v).getChildAt(0).findViewById(2131362333);
      imgView.setImageResource(2131231025);
   }

   public void expandLevel(View v, int level) {
      String ide = v.getTag().toString();
      ide = ide.replace("level2 - ", "");
      String tagLevel = "";
      int resourcetoInflate = 0;
      switch(level) {
      case 0:
         ide = ide.replace("level4 - ", "");
         resourcetoInflate = 2131558730;
         break;
      case 1:
         tagLevel = "level2 - ";
         ide = ide.replace("level1 - ", "");
         resourcetoInflate = 2131558727;
         break;
      case 2:
         tagLevel = "level3 - ";
         ide = ide.replace("level2 - ", "");
         resourcetoInflate = 2131558728;
         break;
      case 3:
         tagLevel = "level4 - ";
         ide = ide.replace("level3 - ", "");
         resourcetoInflate = 2131558729;
         break;
      case 4:
         tagLevel = "level5 - ";
         ide = ide.replace("level4 - ", "");
         resourcetoInflate = 2131558729;
      }

      LayoutInflater layoutInflater = (LayoutInflater)this.activity.getSystemService("layout_inflater");
      Iterator var7 = this.enciclopediaParentsList.iterator();

      View itemLevel2;
      TextView tvIde;
      while(var7.hasNext()) {
         EnciclopediaParentItemDTO child = (EnciclopediaParentItemDTO)var7.next();
         if (child.getParentIDE().equals(ide)) {
            itemLevel2 = layoutInflater.inflate(resourcetoInflate, this.mContainer, false);
            itemLevel2.setOnClickListener(this.expandRow);
            itemLevel2.setTag(tagLevel + child.getIde());
            tvIde = (TextView)itemLevel2.findViewById(2131362988);
            tvIde.setTypeface(this.tfRegular);
            tvIde.setText(child.getTitle());
            ((LinearLayout)v).addView(itemLevel2);
         }
      }

      var7 = this.enciclopediaItemsList.iterator();

      while(var7.hasNext()) {
         EnciclopediaItemDTO enItem = (EnciclopediaItemDTO)var7.next();
         if (enItem.getParentIde().equals(ide)) {
            itemLevel2 = layoutInflater.inflate(2131558730, this.mContainer, false);
            itemLevel2.setOnClickListener(this.openEncyclopediaLink);
            tvIde = (TextView)itemLevel2.findViewById(2131362984);
            tvIde.setText(enItem.getLink());
            TextView tvEnItem = (TextView)itemLevel2.findViewById(2131362988);
            tvEnItem.setTypeface(this.tfRegular);
            tvEnItem.setText(enItem.getDescription());
            ((LinearLayout)v).addView(itemLevel2);
         }
      }

   }

   @TargetApi(13)
   private void showProgress(boolean show) {
      try {
         if (VERSION.SDK_INT >= 13) {
            int shortAnimTime = this.getResources().getInteger(17694720);
            this.rlEnciclopedia.setVisibility(show ? 8 : 0);
            this.mProgressView.setVisibility(show ? 0 : 8);
            this.mProgressView.animate().setDuration((long)shortAnimTime).alpha(show ? 1.0F : 0.0F).setListener(new 6(this, show));
         } else {
            this.rlEnciclopedia.setVisibility(show ? 8 : 0);
            this.mProgressView.setVisibility(show ? 0 : 8);
         }
      } catch (Exception var3) {
         Log.i("CargaEnciclopedia", "Contexto Perdido", var3);
      }

   }

   // $FF: synthetic method
   static void access$000(EnciclopediaFragment x0, boolean x1) {
      x0.showProgress(x1);
   }

   // $FF: synthetic method
   static ArrayList access$100(EnciclopediaFragment x0) {
      return x0.enciclopediaItemsList;
   }

   // $FF: synthetic method
   static ArrayList access$200(EnciclopediaFragment x0) {
      return x0.enciclopediaParentsList;
   }

   // $FF: synthetic method
   static ArrayList access$202(EnciclopediaFragment x0, ArrayList x1) {
      return x0.enciclopediaParentsList = x1;
   }

   // $FF: synthetic method
   static ArrayList access$102(EnciclopediaFragment x0, ArrayList x1) {
      return x0.enciclopediaItemsList = x1;
   }

   // $FF: synthetic method
   static View access$300(EnciclopediaFragment x0) {
      return x0.rootview;
   }

   // $FF: synthetic method
   static OnClickListener access$400(EnciclopediaFragment x0) {
      return x0.expandRow;
   }

   // $FF: synthetic method
   static OnClickListener access$500(EnciclopediaFragment x0) {
      return x0.collapseRow;
   }

   // $FF: synthetic method
   static View access$600(EnciclopediaFragment x0) {
      return x0.mProgressView;
   }
}
