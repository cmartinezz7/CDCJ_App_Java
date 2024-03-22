package com.santander.globile.uicomponents.loader;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.santander.globile.uicomponents.R;
import com.santander.globile.uicomponents.errorhandling.common.ConstantsKt;
import com.santander.globile.uicomponents.text.SantanderTextView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001\u001cB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0007J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u000eJ\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u000bJ\b\u0010\u0018\u001a\u00020\u0010H\u0002J\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u000bJ\u0012\u0010\u001b\u001a\u00020\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/santander/globile/uicomponents/loader/GlobileLoader;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mContext", "mSubTitle", "", "mTitle", "mType", "Lcom/santander/globile/uicomponents/loader/GlobileLoader$LoaderType;", "primaryLoader", "", "secondaryLoader", "setCustomLoader", "id", "setGlobileLoaderType", "type", "setSubtitle", "subtitle", "setTexts", "setTitle", "title", "setViews", "LoaderType", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileLoader.kt */
public final class GlobileLoader extends FrameLayout {
    private HashMap _$_findViewCache;
    private final Context mContext;
    private String mSubTitle;
    private String mTitle;
    private LoaderType mType;

    public GlobileLoader(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public GlobileLoader(Context context, AttributeSet attributeSet) {
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
    public GlobileLoader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.mContext = context;
        this.mType = LoaderType.PRIMARY;
        LayoutInflater.from(context).inflate(R.layout.globile_loader, this, true);
        setViews(attrs);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobileLoader(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void setViews(AttributeSet attrs) {
        TypedArray attributes = getContext().obtainStyledAttributes(attrs, R.styleable.GlobileLoader, 0, 0);
        this.mType = LoaderType.Companion.typeFromInt(Integer.valueOf(attributes.getInt(R.styleable.GlobileLoader_loaderType, 0)));
        this.mTitle = attributes.getString(R.styleable.GlobileLoader_loaderTitle);
        this.mSubTitle = attributes.getString(R.styleable.GlobileLoader_loaderSubTitle);
        setGlobileLoaderType(this.mType);
        setTexts();
    }

    private final void setTexts() {
        if (this.mTitle != null) {
            SantanderTextView santanderTextView = (SantanderTextView) _$_findCachedViewById(R.id.title_globile_loader);
            Intrinsics.checkExpressionValueIsNotNull(santanderTextView, "title_globile_loader");
            santanderTextView.setText(this.mTitle);
        }
        if (this.mSubTitle != null) {
            SantanderTextView santanderTextView2 = (SantanderTextView) _$_findCachedViewById(R.id.subtitle_globile_loader);
            Intrinsics.checkExpressionValueIsNotNull(santanderTextView2, "subtitle_globile_loader");
            santanderTextView2.setText(this.mSubTitle);
        }
    }

    private final void primaryLoader() {
        Glide.with(this).load(Integer.valueOf(R.raw.main_loader2)).into((ImageView) _$_findCachedViewById(R.id.img_loader));
    }

    private final void secondaryLoader() {
        Glide.with(this).load(Integer.valueOf(R.raw.loader2)).into((ImageView) _$_findCachedViewById(R.id.img_loader));
    }

    public final void setTitle(String title) {
        Intrinsics.checkParameterIsNotNull(title, ConstantsKt.TITLE_TEXT);
        SantanderTextView santanderTextView = (SantanderTextView) _$_findCachedViewById(R.id.title_globile_loader);
        Intrinsics.checkExpressionValueIsNotNull(santanderTextView, "title_globile_loader");
        santanderTextView.setText(title);
    }

    public final void setSubtitle(String subtitle) {
        Intrinsics.checkParameterIsNotNull(subtitle, ConstantsKt.SUBTITLE_TEXT);
        SantanderTextView santanderTextView = (SantanderTextView) _$_findCachedViewById(R.id.subtitle_globile_loader);
        Intrinsics.checkExpressionValueIsNotNull(santanderTextView, "subtitle_globile_loader");
        santanderTextView.setText(subtitle);
    }

    public final void setCustomLoader(int id) {
        Glide.with(this).load(Integer.valueOf(id)).into((ImageView) _$_findCachedViewById(R.id.img_loader));
    }

    public final void setGlobileLoaderType(LoaderType type) {
        Intrinsics.checkParameterIsNotNull(type, "type");
        if (type == LoaderType.PRIMARY) {
            primaryLoader();
        } else {
            secondaryLoader();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/santander/globile/uicomponents/loader/GlobileLoader$LoaderType;", "", "tint", "", "(Ljava/lang/String;II)V", "getTint", "()I", "setTint", "(I)V", "PRIMARY", "SECONDARY", "Companion", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
    /* compiled from: GlobileLoader.kt */
    public enum LoaderType {
        PRIMARY(0),
        SECONDARY(1);
        
        public static final Companion Companion = null;
        private int tint;

        private LoaderType(int tint2) {
            this.tint = tint2;
        }

        public final int getTint() {
            return this.tint;
        }

        public final void setTint(int i) {
            this.tint = i;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/santander/globile/uicomponents/loader/GlobileLoader$LoaderType$Companion;", "", "()V", "typeFromInt", "Lcom/santander/globile/uicomponents/loader/GlobileLoader$LoaderType;", "type", "", "(Ljava/lang/Integer;)Lcom/santander/globile/uicomponents/loader/GlobileLoader$LoaderType;", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
        /* compiled from: GlobileLoader.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }

            public final LoaderType typeFromInt(Integer type) {
                LoaderType it;
                LoaderType[] values = LoaderType.values();
                int length = values.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        it = null;
                        break;
                    }
                    it = values[i];
                    if (type != null && it.getTint() == type.intValue()) {
                        break;
                    }
                    i++;
                }
                return it != null ? it : LoaderType.PRIMARY;
            }
        }
    }
}
