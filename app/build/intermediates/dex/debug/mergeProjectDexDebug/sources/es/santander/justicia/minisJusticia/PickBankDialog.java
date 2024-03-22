package es.santander.justicia.minisJusticia;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.common.MainApplication;
import es.santander.justicia.utils.Constants;

public class PickBankDialog extends Dialog implements View.OnClickListener {
    public LinearLayout buttonEmpresas;
    public LinearLayout buttonProfesional;
    public ImageView closeDialog;
    public Dialog d;
    public Activity mActivity;

    public PickBankDialog(Activity a) {
        super(a);
        this.mActivity = a;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        setContentView(R.layout.dialog_ir_a_tu_banco);
        this.buttonProfesional = (LinearLayout) findViewById(R.id.buttonProfesional);
        this.buttonEmpresas = (LinearLayout) findViewById(R.id.buttonEmpresas);
        this.closeDialog = (ImageView) findViewById(R.id.iv_close_dialog);
        this.buttonProfesional.setOnClickListener(this);
        this.buttonEmpresas.setOnClickListener(this);
        this.closeDialog.setOnClickListener(this);
        ((TextView) findViewById(R.id.tv_pick_type_of_bank)).setTypeface(Typeface.createFromAsset(this.mActivity.getAssets(), Constants.FIRASANS_MEDIUM));
        Typeface tf = Typeface.createFromAsset(this.mActivity.getAssets(), Constants.FIRASANS_REGULAR);
        ((TextView) findViewById(R.id.tvProfesional)).setTypeface(tf);
        ((TextView) findViewById(R.id.tvEmpresas)).setTypeface(tf);
    }

    public void onClick(View v) {
        int id = v.getId();
        if (id == 2131361969) {
            try {
                this.mActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + MainApplication.getInfo(MainApplication.PACKAGE_APP_EMPRESASe))));
            } catch (ActivityNotFoundException e) {
                this.mActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + MainApplication.getInfo(MainApplication.PACKAGE_APP_EMPRESASe))));
            }
            dismiss();
        } else if (id == 2131361974) {
            try {
                this.mActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + MainApplication.getInfo(MainApplication.PACKAGE_APP_PARTICULARe))));
            } catch (ActivityNotFoundException e2) {
                this.mActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + MainApplication.getInfo(MainApplication.PACKAGE_APP_PARTICULARe))));
            }
            dismiss();
        } else if (id == 2131362345) {
            dismiss();
        }
        dismiss();
    }
}
