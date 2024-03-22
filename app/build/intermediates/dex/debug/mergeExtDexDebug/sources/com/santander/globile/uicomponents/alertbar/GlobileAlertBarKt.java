package com.santander.globile.uicomponents.alertbar;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import com.androidadvance.topsnackbar.TSnackbar;
import com.santander.globile.uicomponents.R;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a(\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0002\u001a*\u0010\u000e\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r\u001a\"\u0010\u000e\u001a\u00020\u0001*\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r\u001a\"\u0010\u000e\u001a\u00020\u0001*\u00020\u00132\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r¨\u0006\u0014"}, d2 = {"addTopMargin", "", "snackbar", "Lcom/androidadvance/topsnackbar/TSnackbar;", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "setSnackBarView", "view", "Landroid/view/View;", "messageHTMLText", "", "labelText", "alertBarListener", "Lcom/santander/globile/uicomponents/alertbar/GlobileAlertBarListener;", "showGlobileAlertBar", "Landroid/app/Activity;", "toolbarId", "", "actionText", "Landroidx/fragment/app/Fragment;", "uicomponentslib_debug"}, k = 2, mv = {1, 1, 15})
/* compiled from: GlobileAlertBar.kt */
public final class GlobileAlertBarKt {
    public static final void showGlobileAlertBar(Fragment $this$showGlobileAlertBar, String messageHTMLText, String actionText, GlobileAlertBarListener alertBarListener) {
        Intrinsics.checkParameterIsNotNull($this$showGlobileAlertBar, "$this$showGlobileAlertBar");
        Intrinsics.checkParameterIsNotNull(messageHTMLText, "messageHTMLText");
        Intrinsics.checkParameterIsNotNull(actionText, "actionText");
        Intrinsics.checkParameterIsNotNull(alertBarListener, "alertBarListener");
        ViewParent viewParent = null;
        View view = $this$showGlobileAlertBar.getLayoutInflater().inflate(R.layout.globile_alertbar_layout, (ViewGroup) null);
        View view2 = $this$showGlobileAlertBar.getView();
        if (view2 != null) {
            viewParent = view2.getParent();
        }
        if (viewParent != null) {
            ((ViewGroup) viewParent).addView(view);
            Intrinsics.checkExpressionValueIsNotNull(view, "view");
            setSnackBarView(view, messageHTMLText, actionText, new GlobileAlertBarKt$showGlobileAlertBar$snackbar$1(alertBarListener)).show();
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public static final void showGlobileAlertBar(Activity $this$showGlobileAlertBar, String messageHTMLText, String actionText, GlobileAlertBarListener alertBarListener) {
        Intrinsics.checkParameterIsNotNull($this$showGlobileAlertBar, "$this$showGlobileAlertBar");
        Intrinsics.checkParameterIsNotNull(messageHTMLText, "messageHTMLText");
        Intrinsics.checkParameterIsNotNull(actionText, "actionText");
        Intrinsics.checkParameterIsNotNull(alertBarListener, "alertBarListener");
        View view = $this$showGlobileAlertBar.getLayoutInflater().inflate(R.layout.globile_alertbar_layout, (ViewGroup) null);
        Intrinsics.checkExpressionValueIsNotNull(view, "view");
        TSnackbar snackbar = setSnackBarView(view, messageHTMLText, actionText, new GlobileAlertBarKt$showGlobileAlertBar$snackbar$2(alertBarListener));
        ((FrameLayout) $this$showGlobileAlertBar.findViewById(16908290)).addView(view);
        snackbar.show();
    }

    public static final void showGlobileAlertBar(Activity $this$showGlobileAlertBar, int toolbarId, String messageHTMLText, String actionText, GlobileAlertBarListener alertBarListener) {
        Intrinsics.checkParameterIsNotNull($this$showGlobileAlertBar, "$this$showGlobileAlertBar");
        Intrinsics.checkParameterIsNotNull(messageHTMLText, "messageHTMLText");
        Intrinsics.checkParameterIsNotNull(actionText, "actionText");
        Intrinsics.checkParameterIsNotNull(alertBarListener, "alertBarListener");
        FrameLayout rootLayout = (FrameLayout) $this$showGlobileAlertBar.findViewById(16908290);
        LayoutInflater layoutInflater = $this$showGlobileAlertBar.getLayoutInflater();
        int i = R.layout.globile_alertbar_layout;
        View findViewById = rootLayout.findViewById(toolbarId);
        if (findViewById != null) {
            ViewParent parent = ((ViewGroup) findViewById).getParent();
            if (parent != null) {
                View view = layoutInflater.inflate(i, (ViewGroup) parent);
                Toolbar toolbar = rootLayout.findViewById(toolbarId);
                Intrinsics.checkExpressionValueIsNotNull(view, "view");
                TSnackbar snackbar = setSnackBarView(view, messageHTMLText, actionText, new GlobileAlertBarKt$showGlobileAlertBar$snackbar$3(alertBarListener));
                if (toolbar != null) {
                    addTopMargin(snackbar, toolbar);
                    toolbar.bringToFront();
                } else {
                    rootLayout.addView(view);
                }
                snackbar.show();
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    private static final TSnackbar setSnackBarView(View view, String messageHTMLText, String labelText, GlobileAlertBarListener alertBarListener) {
        Drawable drawable;
        GlobileAlertBarListener globileAlertBarListener = alertBarListener;
        TSnackbar snackbar = TSnackbar.make(view.findViewById(R.id.coordinator_layout), "", 0);
        Intrinsics.checkExpressionValueIsNotNull(snackbar, "TSnackbar.make(\n        …nackbar.LENGTH_LONG\n    )");
        View snackbarView = snackbar.getView();
        Intrinsics.checkExpressionValueIsNotNull(snackbarView, "snackbar.view");
        if (Build.VERSION.SDK_INT >= 21) {
            Context context = view.getContext();
            if (context == null) {
                Intrinsics.throwNpe();
            }
            drawable = context.getDrawable(R.drawable.alertbar_background);
        } else {
            Context context2 = view.getContext();
            if (context2 == null) {
                Intrinsics.throwNpe();
            }
            drawable = context2.getResources().getDrawable(R.drawable.alertbar_background);
        }
        snackbarView.setBackground(drawable);
        View findViewById = snackbarView.findViewById(com.androidadvance.topsnackbar.R.id.snackbar_text);
        if (findViewById != null) {
            TextView textView = (TextView) findViewById;
            if (Build.VERSION.SDK_INT >= 23) {
                Context context3 = view.getContext();
                if (context3 == null) {
                    Intrinsics.throwNpe();
                }
                textView.setTextColor(context3.getResources().getColor(R.color.alertbar_text, (Resources.Theme) null));
            } else {
                Context context4 = view.getContext();
                if (context4 == null) {
                    Intrinsics.throwNpe();
                }
                textView.setTextColor(context4.getResources().getColor(R.color.alertbar_text));
            }
            int it = R.font.santander_text_regular;
            Context context5 = view.getContext();
            if (context5 == null) {
                Intrinsics.throwNpe();
            }
            Typeface typeface = ResourcesCompat.getFont(context5, it);
            if (typeface == null) {
                Context context6 = view.getContext();
                if (context6 == null) {
                    Intrinsics.throwNpe();
                }
                typeface = ResourcesCompat.getFont(context6, R.font.santander_text_regular);
            }
            textView.setTypeface(typeface, 0);
            textView.setTextSize(2, 14.0f);
            textView.setMaxLines(2);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            if (Build.VERSION.SDK_INT >= 24) {
                textView.setText(Html.fromHtml(messageHTMLText, 0), TextView.BufferType.SPANNABLE);
            } else {
                String str = messageHTMLText;
                textView.setText(Html.fromHtml(messageHTMLText), TextView.BufferType.SPANNABLE);
            }
            Context context7 = view.getContext();
            Intrinsics.checkExpressionValueIsNotNull(context7, "view.context");
            Resources resources = context7.getResources();
            Intrinsics.checkExpressionValueIsNotNull(resources, "view.context.resources");
            float scale = resources.getDisplayMetrics().density;
            int iconPadding = (int) ((((float) 24) * scale) + 0.5f);
            snackbar.setIconLeft(R.drawable.alertbar_cancel, 18.0f);
            snackbar.setIconPadding(iconPadding);
            textView.setPadding((int) ((((float) 8) * scale) + 0.5f), 0, 0, 0);
            textView.setOnTouchListener(new GlobileAlertBarKt$setSnackBarView$1(textView, iconPadding, globileAlertBarListener, snackbar));
            View findViewById2 = snackbarView.findViewById(com.androidadvance.topsnackbar.R.id.snackbar_action);
            if (findViewById2 != null) {
                TextView snackBarActiontextView = (TextView) findViewById2;
                snackbar.setAction(labelText, new GlobileAlertBarKt$setSnackBarView$2(globileAlertBarListener));
                snackBarActiontextView.setTypeface(Typeface.DEFAULT_BOLD);
                snackBarActiontextView.setTextSize(2, 14.0f);
                if (Build.VERSION.SDK_INT >= 23) {
                    Context context8 = view.getContext();
                    if (context8 == null) {
                        Intrinsics.throwNpe();
                    }
                    snackbar.setActionTextColor(context8.getResources().getColor(R.color.alertbar_label, (Resources.Theme) null));
                } else {
                    Context context9 = view.getContext();
                    if (context9 == null) {
                        Intrinsics.throwNpe();
                    }
                    snackbar.setActionTextColor(context9.getResources().getColor(R.color.alertbar_label));
                }
                return snackbar;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
        }
        String str2 = messageHTMLText;
        throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
    }

    private static final void addTopMargin(TSnackbar snackbar, Toolbar toolbar) {
        View snackbarView = snackbar.getView();
        Intrinsics.checkExpressionValueIsNotNull(snackbarView, "snackbar.view");
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(-2, -2);
        params.topMargin = toolbar.getHeight();
        snackbarView.setLayoutParams(params);
    }
}
