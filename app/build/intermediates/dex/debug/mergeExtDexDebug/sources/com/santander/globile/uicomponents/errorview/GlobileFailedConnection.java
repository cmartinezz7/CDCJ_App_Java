package com.santander.globile.uicomponents.errorview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.santander.globile.uicomponents.R;
import com.santander.globile.uicomponents.buttons.endingbutton.GlobileEndingButton;
import com.santander.globile.uicomponents.errorhandling.common.ConstantsKt;
import com.santander.globile.uicomponents.text.SantanderTextView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fJ\b\u0010\u0012\u001a\u00020\u0010H\u0002J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0007J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\fJ\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\fJ\u0012\u0010\u0019\u001a\u00020\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/santander/globile/uicomponents/errorview/GlobileFailedConnection;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mContext", "mImage", "mSubTitle", "", "mTextButton", "mTitle", "setButtonText", "", "buttonText", "setData", "setImage", "id", "setSubtitle", "subtitle", "setTitle", "title", "setViews", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileFailedConnection.kt */
public final class GlobileFailedConnection extends FrameLayout {
    private HashMap _$_findViewCache;
    private final Context mContext;
    private int mImage;
    private String mSubTitle;
    private String mTextButton;
    private String mTitle;

    public GlobileFailedConnection(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public GlobileFailedConnection(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

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
    public GlobileFailedConnection(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.globile_failed_connection, this, true);
        setViews(attrs);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobileFailedConnection(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void setViews(AttributeSet attrs) {
        TypedArray attributes = getContext().obtainStyledAttributes(attrs, R.styleable.GlobileFailedConnection, 0, 0);
        this.mImage = attributes.getResourceId(R.styleable.GlobileFailedConnection_failedConnectionImage, 0);
        String string = attributes.getString(R.styleable.GlobileFailedConnection_failedConnectionTitle);
        String str = "";
        if (string == null) {
            string = str;
        }
        this.mTitle = string;
        String string2 = attributes.getString(R.styleable.GlobileFailedConnection_failedConnectionSubTitle);
        if (string2 == null) {
            string2 = str;
        }
        this.mSubTitle = string2;
        String string3 = attributes.getString(R.styleable.GlobileFailedConnection_failedConnectionTextButton);
        if (string3 != null) {
            str = string3;
        }
        this.mTextButton = str;
        setData();
    }

    private final void setData() {
        String str = this.mTitle;
        SantanderTextView santanderTextView = (SantanderTextView) _$_findCachedViewById(R.id.failed_connection_title);
        Intrinsics.checkExpressionValueIsNotNull(santanderTextView, "failed_connection_title");
        santanderTextView.setText(this.mTitle);
        String it = this.mSubTitle;
        if (StringsKt.equals$default(this.mSubTitle, "", false, 2, (Object) null)) {
            SantanderTextView santanderTextView2 = (SantanderTextView) _$_findCachedViewById(R.id.failed_connection_subtitle);
            Intrinsics.checkExpressionValueIsNotNull(santanderTextView2, "failed_connection_subtitle");
            santanderTextView2.setVisibility(8);
        } else {
            SantanderTextView santanderTextView3 = (SantanderTextView) _$_findCachedViewById(R.id.failed_connection_subtitle);
            Intrinsics.checkExpressionValueIsNotNull(santanderTextView3, "failed_connection_subtitle");
            santanderTextView3.setText(this.mSubTitle);
        }
        String str2 = this.mTextButton;
        GlobileEndingButton globileEndingButton = (GlobileEndingButton) _$_findCachedViewById(R.id.failed_connection_button);
        Intrinsics.checkExpressionValueIsNotNull(globileEndingButton, "failed_connection_button");
        globileEndingButton.setText(this.mTextButton);
        int i = this.mImage;
        if (this.mImage == 0) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            AppCompatImageView _$_findCachedViewById = _$_findCachedViewById(R.id.failed_connection_image);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "failed_connection_image");
            _$_findCachedViewById.setBackground(getResources().getDrawable(this.mImage, (Resources.Theme) null));
            return;
        }
        AppCompatImageView _$_findCachedViewById2 = _$_findCachedViewById(R.id.failed_connection_image);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById2, "failed_connection_image");
        _$_findCachedViewById2.setBackground(getResources().getDrawable(this.mImage));
    }

    public final void setTitle(String title) {
        Intrinsics.checkParameterIsNotNull(title, ConstantsKt.TITLE_TEXT);
        SantanderTextView santanderTextView = (SantanderTextView) _$_findCachedViewById(R.id.failed_connection_title);
        Intrinsics.checkExpressionValueIsNotNull(santanderTextView, "failed_connection_title");
        santanderTextView.setText(title);
    }

    public final void setSubtitle(String subtitle) {
        Intrinsics.checkParameterIsNotNull(subtitle, ConstantsKt.SUBTITLE_TEXT);
        SantanderTextView santanderTextView = (SantanderTextView) _$_findCachedViewById(R.id.failed_connection_subtitle);
        Intrinsics.checkExpressionValueIsNotNull(santanderTextView, "failed_connection_subtitle");
        santanderTextView.setText(subtitle);
    }

    public final void setButtonText(String buttonText) {
        Intrinsics.checkParameterIsNotNull(buttonText, "buttonText");
        GlobileEndingButton globileEndingButton = (GlobileEndingButton) _$_findCachedViewById(R.id.failed_connection_button);
        Intrinsics.checkExpressionValueIsNotNull(globileEndingButton, "failed_connection_button");
        globileEndingButton.setText(buttonText);
    }

    public final void setImage(int id) {
        if (Build.VERSION.SDK_INT >= 21) {
            AppCompatImageView _$_findCachedViewById = _$_findCachedViewById(R.id.failed_connection_image);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "failed_connection_image");
            _$_findCachedViewById.setBackground(getResources().getDrawable(id, (Resources.Theme) null));
            return;
        }
        AppCompatImageView _$_findCachedViewById2 = _$_findCachedViewById(R.id.failed_connection_image);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById2, "failed_connection_image");
        _$_findCachedViewById2.setBackground(getResources().getDrawable(id));
    }
}
