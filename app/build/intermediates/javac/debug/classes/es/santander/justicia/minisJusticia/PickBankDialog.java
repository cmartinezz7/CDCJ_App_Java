package es.santander.justicia.minisJusticia;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import es.santander.justicia.minisJusticia.common.MainApplication;

public class PickBankDialog extends Dialog implements OnClickListener {
   public Activity mActivity;
   public Dialog d;
   public LinearLayout buttonProfesional;
   public LinearLayout buttonEmpresas;
   public ImageView closeDialog;

   public PickBankDialog(Activity a) {
      super(a);
      this.mActivity = a;
   }

   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.requestWindowFeature(1);
      this.setContentView(2131558557);
      this.buttonProfesional = (LinearLayout)this.findViewById(2131361974);
      this.buttonEmpresas = (LinearLayout)this.findViewById(2131361969);
      this.closeDialog = (ImageView)this.findViewById(2131362345);
      this.buttonProfesional.setOnClickListener(this);
      this.buttonEmpresas.setOnClickListener(this);
      this.closeDialog.setOnClickListener(this);
      Typeface tf = Typeface.createFromAsset(this.mActivity.getAssets(), "FiraSans-Medium.ttf");
      ((TextView)this.findViewById(2131363035)).setTypeface(tf);
      tf = Typeface.createFromAsset(this.mActivity.getAssets(), "FiraSans-Regular.ttf");
      ((TextView)this.findViewById(2131362985)).setTypeface(tf);
      ((TextView)this.findViewById(2131362983)).setTypeface(tf);
   }

   public void onClick(View v) {
      switch(v.getId()) {
      case 2131361969:
         try {
            this.mActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + MainApplication.getInfo("WpfrVFv/3blDuOOefCmz3fdsCFxrb05/scNk5XnCD5c="))));
         } catch (ActivityNotFoundException var3) {
            this.mActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + MainApplication.getInfo("WpfrVFv/3blDuOOefCmz3fdsCFxrb05/scNk5XnCD5c="))));
         }

         this.dismiss();
         break;
      case 2131361974:
         try {
            this.mActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + MainApplication.getInfo("WpfrVFv/3blDuOOefCmz3ULKXjrg0Yf2YEluVZ7OTAU="))));
         } catch (ActivityNotFoundException var4) {
            this.mActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + MainApplication.getInfo("WpfrVFv/3blDuOOefCmz3ULKXjrg0Yf2YEluVZ7OTAU="))));
         }

         this.dismiss();
         break;
      case 2131362345:
         this.dismiss();
      }

      this.dismiss();
   }
}
