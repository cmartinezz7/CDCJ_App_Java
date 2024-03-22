package com.santander.globile.uicomponents.errorview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import com.santander.globile.uicomponents.R;
import com.santander.globile.uicomponents.buttons.endingbutton.GlobileEndingButton;
import com.santander.globile.uicomponents.text.SantanderTextView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010$\u001a\u0004\u0018\u00010\u00132\u0006\u0010%\u001a\u00020\u0007H\u0002R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001a\u0010!\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000e¨\u0006&"}, d2 = {"Lcom/santander/globile/uicomponents/errorview/GlobileSessionExpired;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "buttonTitle", "", "getButtonTitle", "()Ljava/lang/String;", "setButtonTitle", "(Ljava/lang/String;)V", "description", "getDescription", "setDescription", "drawableImage", "Landroid/graphics/drawable/Drawable;", "getDrawableImage", "()Landroid/graphics/drawable/Drawable;", "setDrawableImage", "(Landroid/graphics/drawable/Drawable;)V", "listener", "Landroid/view/View$OnClickListener;", "getListener", "()Landroid/view/View$OnClickListener;", "setListener", "(Landroid/view/View$OnClickListener;)V", "subtitle", "getSubtitle", "setSubtitle", "title", "getTitle", "setTitle", "getDrawable", "resId", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileSessionExpired.kt */
public final class GlobileSessionExpired extends ConstraintLayout {
    private HashMap _$_findViewCache;
    private String buttonTitle;
    private String description;
    private Drawable drawableImage;
    private View.OnClickListener listener;
    private String subtitle;
    private String title;

    public GlobileSessionExpired(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public GlobileSessionExpired(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.santander.globile.uicomponents.errorview.GlobileSessionExpired, android.view.View] */
    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobileSessionExpired(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkParameterIsNotNull(context, "context");
        String str = "";
        this.description = str;
        this.title = str;
        this.subtitle = str;
        this.buttonTitle = str;
        LayoutInflater.from(context).inflate(R.layout.error_session_expired, (ViewGroup) this, true);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.GlobileSessionExpired);
        int imageId = typedArray.getResourceId(R.styleable.GlobileSessionExpired_image, 0);
        String string = typedArray.getString(R.styleable.GlobileSessionExpired_description);
        this.description = string == null ? str : string;
        String string2 = typedArray.getString(R.styleable.GlobileSessionExpired_title);
        this.title = string2 == null ? str : string2;
        String string3 = typedArray.getString(R.styleable.GlobileSessionExpired_subtitle);
        this.subtitle = string3 == null ? str : string3;
        String string4 = typedArray.getString(R.styleable.GlobileSessionExpired_sessionButtonText);
        this.buttonTitle = string4 != null ? string4 : str;
        this.drawableImage = getDrawable(imageId);
        ((ImageView) _$_findCachedViewById(R.id.error_image)).setImageDrawable(this.drawableImage);
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.error_image);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "error_image");
        imageView.setContentDescription(this.description);
        SantanderTextView santanderTextView = (SantanderTextView) _$_findCachedViewById(R.id.error_title);
        Intrinsics.checkExpressionValueIsNotNull(santanderTextView, "error_title");
        santanderTextView.setText(this.title);
        SantanderTextView santanderTextView2 = (SantanderTextView) _$_findCachedViewById(R.id.error_subtitle);
        Intrinsics.checkExpressionValueIsNotNull(santanderTextView2, "error_subtitle");
        santanderTextView2.setText(this.subtitle);
        GlobileEndingButton globileEndingButton = (GlobileEndingButton) _$_findCachedViewById(R.id.loginButton);
        Intrinsics.checkExpressionValueIsNotNull(globileEndingButton, "loginButton");
        globileEndingButton.setText(this.buttonTitle);
        ((GlobileEndingButton) _$_findCachedViewById(R.id.loginButton)).setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ GlobileSessionExpired this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View it) {
                View.OnClickListener listener = this.this$0.getListener();
                if (listener != null) {
                    listener.onClick(it);
                }
            }
        });
        typedArray.recycle();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobileSessionExpired(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final Drawable getDrawableImage() {
        return this.drawableImage;
    }

    public final void setDrawableImage(Drawable drawable) {
        this.drawableImage = drawable;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.description = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.title = str;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final void setSubtitle(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.subtitle = str;
    }

    public final String getButtonTitle() {
        return this.buttonTitle;
    }

    public final void setButtonTitle(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.buttonTitle = str;
    }

    public final View.OnClickListener getListener() {
        return this.listener;
    }

    public final void setListener(View.OnClickListener onClickListener) {
        this.listener = onClickListener;
    }

    private final Drawable getDrawable(int resId) {
        if (Build.VERSION.SDK_INT >= 21) {
            return getResources().getDrawable(resId, (Resources.Theme) null);
        }
        Resources resources = getResources();
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        return ResourcesCompat.getDrawable(resources, resId, context.getTheme());
    }
}
