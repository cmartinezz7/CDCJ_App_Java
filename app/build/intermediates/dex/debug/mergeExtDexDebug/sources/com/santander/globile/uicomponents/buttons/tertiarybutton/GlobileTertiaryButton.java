package com.santander.globile.uicomponents.buttons.tertiarybutton;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.santander.globile.uicomponents.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001!B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020\u0007H\u0002J\b\u0010 \u001a\u00020\u001cH\u0002R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R*\u0010\u0010\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007@FX\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/santander/globile/uicomponents/buttons/tertiarybutton/GlobileTertiaryButton;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mButtonSecondText", "", "mButtonText", "mColor", "Lcom/santander/globile/uicomponents/buttons/tertiarybutton/GlobileTertiaryButton$TintColor;", "mContext", "value", "mImageResource", "getMImageResource", "()Ljava/lang/Integer;", "setMImageResource", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "mImageResourceInmutable", "mIsLink", "", "mShowArrow", "mShowSecondText", "setLinkOnClickListener", "", "listener", "Landroid/view/View$OnClickListener;", "setTintColor", "setViews", "TintColor", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileTertiaryButton.kt */
public final class GlobileTertiaryButton extends FrameLayout {
    private HashMap _$_findViewCache;
    private String mButtonSecondText;
    private String mButtonText;
    private TintColor mColor;
    private final Context mContext;
    private Integer mImageResource;
    private Integer mImageResourceInmutable;
    private boolean mIsLink;
    private boolean mShowArrow;
    private boolean mShowSecondText;

    public GlobileTertiaryButton(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public GlobileTertiaryButton(Context context, AttributeSet attributeSet) {
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
    public GlobileTertiaryButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.mContext = context;
        String str = "";
        this.mButtonText = str;
        this.mButtonSecondText = str;
        this.mColor = TintColor.RED;
        LayoutInflater.from(context).inflate(R.layout.tertiary_button, this, true);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.GlobileTertiaryButton);
        String string = typedArray.getString(R.styleable.GlobileTertiaryButton_tertiaryButtonText);
        this.mButtonText = string == null ? str : string;
        String string2 = typedArray.getString(R.styleable.GlobileTertiaryButton_tertiaryButtonSecondText);
        this.mButtonSecondText = string2 != null ? string2 : str;
        this.mColor = TintColor.Companion.tintFromInt(Integer.valueOf(typedArray.getInt(R.styleable.GlobileTertiaryButton_tertiaryColor, 0)));
        setMImageResource(Integer.valueOf(typedArray.getResourceId(R.styleable.GlobileTertiaryButton_tertiaryImageResource, 0)));
        this.mShowArrow = typedArray.getBoolean(R.styleable.GlobileTertiaryButton_tertiaryShowArrow, false);
        this.mIsLink = typedArray.getBoolean(R.styleable.GlobileTertiaryButton_tertiaryIsLink, false);
        setViews();
        typedArray.recycle();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobileTertiaryButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final Integer getMImageResource() {
        return this.mImageResource;
    }

    public final void setMImageResource(Integer value) {
        this.mImageResourceInmutable = value;
    }

    private final void setViews() {
        int i;
        int i2;
        Drawable img;
        Drawable img2;
        TextView textView = (TextView) _$_findCachedViewById(R.id.tertiary_button_second_textview);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tertiary_button_second_textview");
        int i3 = 0;
        textView.setVisibility(0);
        TextView $this$with = (TextView) _$_findCachedViewById(R.id.tertiary_button_textview);
        int i4 = R.color.tertiary_button_secondary;
        if (Build.VERSION.SDK_INT < 23) {
            $this$with.setTextAppearance($this$with.getContext(), R.style.GlobileTertiaryButtonStyleTextAppearance);
        } else {
            $this$with.setTextAppearance(R.style.GlobileTertiaryButtonStyleTextAppearance);
        }
        $this$with.setTextColor(setTintColor());
        if (this.mIsLink) {
            SpannableString mySpannableString = new SpannableString(this.mButtonText);
            mySpannableString.setSpan(new UnderlineSpan(), 0, mySpannableString.length(), 0);
            $this$with.setText(mySpannableString);
            this.mShowSecondText = !Intrinsics.areEqual((Object) this.mButtonSecondText, (Object) "");
        } else {
            $this$with.setText(this.mButtonText);
        }
        TextView $this$with2 = (TextView) _$_findCachedViewById(R.id.tertiary_button_second_textview);
        if (Build.VERSION.SDK_INT < 23) {
            $this$with2.setTextAppearance($this$with2.getContext(), R.style.GlobileTertiaryButtonStyleTextAppearance);
        } else {
            $this$with2.setTextAppearance(R.style.GlobileTertiaryButtonStyleTextAppearance);
        }
        $this$with2.setText(' ' + this.mButtonSecondText);
        if (this.mShowSecondText) {
            i = 0;
        } else {
            i = 8;
        }
        $this$with2.setVisibility(i);
        ImageView $this$with3 = (ImageView) _$_findCachedViewById(R.id.tertiary_button_letf_imageview);
        Integer num = this.mImageResourceInmutable;
        if (num == null || (num != null && num.intValue() == 0)) {
            i2 = 8;
        } else {
            if (Build.VERSION.SDK_INT >= 21) {
                Context context = $this$with3.getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "context");
                Resources resources = context.getResources();
                Integer num2 = this.mImageResourceInmutable;
                if (num2 == null) {
                    Intrinsics.throwNpe();
                }
                img2 = resources.getDrawable(num2.intValue(), (Resources.Theme) null);
            } else {
                Context context2 = $this$with3.getContext();
                Intrinsics.checkExpressionValueIsNotNull(context2, "context");
                Resources resources2 = context2.getResources();
                Integer num3 = this.mImageResourceInmutable;
                if (num3 == null) {
                    Intrinsics.throwNpe();
                }
                int intValue = num3.intValue();
                Context context3 = $this$with3.getContext();
                Intrinsics.checkExpressionValueIsNotNull(context3, "context");
                img2 = ResourcesCompat.getDrawable(resources2, intValue, context3.getTheme());
            }
            if (img2 != null) {
                Drawable it = img2;
                if (Build.VERSION.SDK_INT >= 23) {
                    img2.setTint(setTintColor());
                } else {
                    DrawableCompat.setTint(it, setTintColor());
                }
                $this$with3.setImageDrawable(it);
                Unit unit = Unit.INSTANCE;
            }
            i2 = 0;
        }
        $this$with3.setVisibility(i2);
        ImageView $this$with4 = (ImageView) _$_findCachedViewById(R.id.tertiary_button_right_imageview);
        if (this.mShowArrow) {
            if (Build.VERSION.SDK_INT >= 21) {
                Context context4 = $this$with4.getContext();
                Intrinsics.checkExpressionValueIsNotNull(context4, "context");
                Drawable drawable = context4.getResources().getDrawable(R.drawable.chevron_right_red, (Resources.Theme) null);
                Intrinsics.checkExpressionValueIsNotNull(drawable, "context.resources.getDra…hevron_right_red!!, null)");
                img = drawable.getConstantState().newDrawable().mutate();
            } else {
                Context context5 = $this$with4.getContext();
                Intrinsics.checkExpressionValueIsNotNull(context5, "context");
                Resources resources3 = context5.getResources();
                int i5 = R.drawable.chevron_right_red;
                Context context6 = $this$with4.getContext();
                Intrinsics.checkExpressionValueIsNotNull(context6, "context");
                Drawable drawable2 = ResourcesCompat.getDrawable(resources3, i5, context6.getTheme());
                if (drawable2 == null) {
                    Intrinsics.throwNpe();
                }
                Intrinsics.checkExpressionValueIsNotNull(drawable2, "ResourcesCompat.getDrawa…t_red!!, context.theme)!!");
                img = drawable2.getConstantState().newDrawable().mutate();
            }
            if (img != null) {
                Drawable it2 = img;
                if (Build.VERSION.SDK_INT >= 23) {
                    img.setTint(setTintColor());
                } else {
                    DrawableCompat.setTint(DrawableCompat.wrap(img), setTintColor());
                }
                $this$with4.setImageDrawable(it2);
                Unit unit2 = Unit.INSTANCE;
            }
        } else {
            i3 = 8;
        }
        $this$with4.setVisibility(i3);
    }

    public final void setLinkOnClickListener(View.OnClickListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        if (this.mIsLink) {
            ((TextView) _$_findCachedViewById(R.id.tertiary_button_textview)).setOnClickListener(new GlobileTertiaryButton$setLinkOnClickListener$1(this, listener));
        }
    }

    private final int setTintColor() {
        Integer colorTint;
        Integer num = null;
        if (Build.VERSION.SDK_INT >= 23) {
            colorTint = Integer.valueOf(getResources().getColor(R.color.boston_red, (Resources.Theme) null));
            int tint = this.mColor.getTint();
            if (tint == 0) {
                colorTint = Integer.valueOf(getResources().getColor(R.color.boston_red, (Resources.Theme) null));
            } else if (tint == 1) {
                colorTint = Integer.valueOf(getResources().getColor(R.color.yellow, (Resources.Theme) null));
            } else if (tint == 2) {
                colorTint = Integer.valueOf(getResources().getColor(R.color.lime_green, (Resources.Theme) null));
            } else if (tint == 3) {
                colorTint = Integer.valueOf(getResources().getColor(R.color.turquoise, (Resources.Theme) null));
            } else if (tint == 4) {
                colorTint = Integer.valueOf(getResources().getColor(R.color.blue, (Resources.Theme) null));
            } else if (tint == 5) {
                colorTint = Integer.valueOf(getResources().getColor(R.color.purple, (Resources.Theme) null));
            }
        } else {
            colorTint = Integer.valueOf(getResources().getColor(R.color.boston_red));
            int tint2 = this.mColor.getTint();
            if (tint2 == 0) {
                colorTint = Integer.valueOf(getResources().getColor(R.color.boston_red));
            } else if (tint2 == 1) {
                colorTint = Integer.valueOf(getResources().getColor(R.color.yellow));
            } else if (tint2 == 2) {
                colorTint = Integer.valueOf(getResources().getColor(R.color.lime_green));
            } else if (tint2 == 3) {
                colorTint = Integer.valueOf(getResources().getColor(R.color.turquoise));
            } else if (tint2 == 4) {
                colorTint = Integer.valueOf(getResources().getColor(R.color.blue));
            } else if (tint2 == 5) {
                colorTint = Integer.valueOf(getResources().getColor(R.color.purple));
            }
        }
        return colorTint.intValue();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/santander/globile/uicomponents/buttons/tertiarybutton/GlobileTertiaryButton$TintColor;", "", "tint", "", "(Ljava/lang/String;II)V", "getTint", "()I", "RED", "YELLOW", "LIME_GREEN", "TURQUOISE", "BLUE", "PURPLE", "Companion", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
    /* compiled from: GlobileTertiaryButton.kt */
    public enum TintColor {
        RED(0),
        YELLOW(1),
        LIME_GREEN(2),
        TURQUOISE(3),
        BLUE(4),
        PURPLE(5);
        
        public static final Companion Companion = null;
        private final int tint;

        private TintColor(int tint2) {
            this.tint = tint2;
        }

        public final int getTint() {
            return this.tint;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/santander/globile/uicomponents/buttons/tertiarybutton/GlobileTertiaryButton$TintColor$Companion;", "", "()V", "tintFromInt", "Lcom/santander/globile/uicomponents/buttons/tertiarybutton/GlobileTertiaryButton$TintColor;", "tint", "", "(Ljava/lang/Integer;)Lcom/santander/globile/uicomponents/buttons/tertiarybutton/GlobileTertiaryButton$TintColor;", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
        /* compiled from: GlobileTertiaryButton.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }

            public final TintColor tintFromInt(Integer tint) {
                TintColor it;
                TintColor[] values = TintColor.values();
                int length = values.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        it = null;
                        break;
                    }
                    it = values[i];
                    if (tint != null && it.getTint() == tint.intValue()) {
                        break;
                    }
                    i++;
                }
                return it != null ? it : TintColor.RED;
            }
        }
    }
}
