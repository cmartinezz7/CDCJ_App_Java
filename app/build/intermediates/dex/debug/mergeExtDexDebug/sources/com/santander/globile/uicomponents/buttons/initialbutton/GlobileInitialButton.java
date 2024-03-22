package com.santander.globile.uicomponents.buttons.initialbutton;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.drawable.DrawableCompat;
import com.santander.globile.uicomponents.R;
import com.santander.globile.uicomponents.text.SantanderTextView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002+,B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0007H\u0002J\u0010\u0010%\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010#J\u0010\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020!H\u0002R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/santander/globile/uicomponents/buttons/initialbutton/GlobileInitialButton;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "globileButton", "Landroidx/cardview/widget/CardView;", "getGlobileButton", "()Landroidx/cardview/widget/CardView;", "setGlobileButton", "(Landroidx/cardview/widget/CardView;)V", "globileInitialTextView", "Lcom/santander/globile/uicomponents/text/SantanderTextView;", "getGlobileInitialTextView", "()Lcom/santander/globile/uicomponents/text/SantanderTextView;", "setGlobileInitialTextView", "(Lcom/santander/globile/uicomponents/text/SantanderTextView;)V", "mButtonText", "", "mContext", "mImagePosition", "Lcom/santander/globile/uicomponents/buttons/initialbutton/GlobileInitialButton$ImagePosition;", "mImageResource", "Ljava/lang/Integer;", "mTextSize", "", "mTintColor", "Lcom/santander/globile/uicomponents/buttons/initialbutton/GlobileInitialButton$ImageTint;", "setDrawableIcon", "", "setDrawableWithColor", "Landroid/graphics/drawable/Drawable;", "drawableRes", "setInitialIcon", "icon", "setOnClickListener", "listener", "Landroid/view/View$OnClickListener;", "setViews", "ImagePosition", "ImageTint", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileInitialButton.kt */
public final class GlobileInitialButton extends LinearLayout {
    private HashMap _$_findViewCache;
    private CardView globileButton;
    private SantanderTextView globileInitialTextView;
    private String mButtonText;
    private final Context mContext;
    private ImagePosition mImagePosition;
    private Integer mImageResource;
    private float mTextSize;
    private ImageTint mTintColor;

    public GlobileInitialButton(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public GlobileInitialButton(Context context, AttributeSet attributeSet) {
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
    public GlobileInitialButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.mContext = context;
        this.mImagePosition = ImagePosition.LEFT;
        String str = "";
        this.mButtonText = str;
        this.mTextSize = 16.0f;
        this.mTintColor = ImageTint.RED;
        LinearLayout.inflate(context, R.layout.initial_button, this);
        setOrientation(1);
        this.globileInitialTextView = (SantanderTextView) findViewById(R.id.initial_button_text);
        this.globileButton = findViewById(R.id.wrapper_initial_button);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.GlobileInitialButton);
        this.mImagePosition = ImagePosition.Companion.positionFromInt(Integer.valueOf(typedArray.getInt(R.styleable.GlobileInitialButton_imagePosition, 0)));
        String string = typedArray.getString(R.styleable.GlobileInitialButton_buttonText);
        this.mButtonText = string != null ? string : str;
        this.mTextSize = typedArray.getFloat(R.styleable.GlobileInitialButton_textSizeInitialButton, 16.0f);
        this.mImageResource = Integer.valueOf(typedArray.getResourceId(R.styleable.GlobileInitialButton_imageResource, 0));
        this.mTintColor = ImageTint.Companion.tintFromInt(Integer.valueOf(typedArray.getInt(R.styleable.GlobileInitialButton_imageTint, 1)));
        setViews();
        typedArray.recycle();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobileInitialButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final SantanderTextView getGlobileInitialTextView() {
        return this.globileInitialTextView;
    }

    public final void setGlobileInitialTextView(SantanderTextView santanderTextView) {
        this.globileInitialTextView = santanderTextView;
    }

    public final CardView getGlobileButton() {
        return this.globileButton;
    }

    public final void setGlobileButton(CardView cardView) {
        this.globileButton = cardView;
    }

    public void setOnClickListener(View.OnClickListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        CardView cardView = this.globileButton;
        if (cardView != null) {
            cardView.setOnClickListener(listener);
        }
    }

    private final void setViews() {
        SantanderTextView it = this.globileInitialTextView;
        if (it != null) {
            SantanderTextView $this$apply = it;
            $this$apply.setTextSize(2, this.mTextSize);
            $this$apply.setText(this.mButtonText);
            if (Build.VERSION.SDK_INT < 23) {
                $this$apply.setTextAppearance($this$apply.getContext(), R.style.GlobileInitialButtonStyleTextAppearance);
            } else {
                $this$apply.setTextAppearance(R.style.GlobileInitialButtonStyleTextAppearance);
            }
        }
        setDrawableIcon();
    }

    private final Drawable setDrawableWithColor(int drawableRes) {
        Drawable img;
        if (Build.VERSION.SDK_INT >= 23) {
            Context context = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            Drawable drawable = context.getResources().getDrawable(drawableRes, (Resources.Theme) null);
            Intrinsics.checkExpressionValueIsNotNull(drawable, "(context.resources.getDrawable(drawableRes, null))");
            img = drawable.getConstantState().newDrawable().mutate();
            ImageTint imageTint = this.mTintColor;
            if (!(imageTint == null || img == null)) {
                Drawable it = img;
                int tint = imageTint.getTint();
                if (tint == 0) {
                    it.setTint(getResources().getColor(R.color.white, (Resources.Theme) null));
                } else if (tint == 1) {
                    it.setTint(getResources().getColor(R.color.boston_red, (Resources.Theme) null));
                } else if (tint == 2) {
                    it.setTint(getResources().getColor(R.color.dark_sky, (Resources.Theme) null));
                } else if (tint == 3) {
                    it.setTint(getResources().getColor(R.color.accessible_sky, (Resources.Theme) null));
                } else if (tint == 4) {
                    it.setTint(getResources().getColor(R.color.grey, (Resources.Theme) null));
                }
            }
        } else {
            Context context2 = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context2, "context");
            Drawable drawable2 = context2.getResources().getDrawable(drawableRes);
            Intrinsics.checkExpressionValueIsNotNull(drawable2, "(context.resources.getDrawable(drawableRes))");
            img = drawable2.getConstantState().newDrawable().mutate();
            ImageTint imageTint2 = this.mTintColor;
            if (!(imageTint2 == null || img == null)) {
                Drawable it2 = img;
                int tint2 = imageTint2.getTint();
                if (tint2 == 0) {
                    DrawableCompat.setTint(it2, getResources().getColor(R.color.white));
                } else if (tint2 == 1) {
                    DrawableCompat.setTint(it2, getResources().getColor(R.color.boston_red));
                } else if (tint2 == 2) {
                    DrawableCompat.setTint(it2, getResources().getColor(R.color.dark_sky));
                } else if (tint2 == 3) {
                    DrawableCompat.setTint(it2, getResources().getColor(R.color.accessible_sky));
                } else if (tint2 == 4) {
                    DrawableCompat.setTint(it2, getResources().getColor(R.color.grey));
                }
            }
        }
        Intrinsics.checkExpressionValueIsNotNull(img, "img");
        return img;
    }

    private final void setDrawableIcon() {
        int it;
        Integer num = this.mImageResource;
        if (num != null && (it = num.intValue()) != 0) {
            Drawable drawable = setDrawableWithColor(it);
            int position = this.mImagePosition.getPosition();
            if (position == 0) {
                SantanderTextView santanderTextView = this.globileInitialTextView;
                if (santanderTextView != null) {
                    santanderTextView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                }
            } else if (position == 1) {
                SantanderTextView santanderTextView2 = this.globileInitialTextView;
                if (santanderTextView2 != null) {
                    santanderTextView2.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, drawable, (Drawable) null, (Drawable) null);
                }
            } else if (position == 2) {
                SantanderTextView santanderTextView3 = this.globileInitialTextView;
                if (santanderTextView3 != null) {
                    santanderTextView3.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, drawable);
                }
            } else if (position != 3) {
                SantanderTextView santanderTextView4 = this.globileInitialTextView;
                if (santanderTextView4 != null) {
                    santanderTextView4.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
                }
            } else {
                SantanderTextView santanderTextView5 = this.globileInitialTextView;
                if (santanderTextView5 != null) {
                    santanderTextView5.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
                }
            }
        }
    }

    public final void setInitialIcon(Drawable icon) {
        if (icon != null) {
            Drawable drawable = icon;
            int position = this.mImagePosition.getPosition();
            if (position == 0) {
                SantanderTextView santanderTextView = this.globileInitialTextView;
                if (santanderTextView != null) {
                    santanderTextView.setCompoundDrawablesWithIntrinsicBounds(icon, (Drawable) null, (Drawable) null, (Drawable) null);
                }
            } else if (position == 1) {
                SantanderTextView santanderTextView2 = this.globileInitialTextView;
                if (santanderTextView2 != null) {
                    santanderTextView2.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, icon, (Drawable) null, (Drawable) null);
                }
            } else if (position == 2) {
                SantanderTextView santanderTextView3 = this.globileInitialTextView;
                if (santanderTextView3 != null) {
                    santanderTextView3.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, icon);
                }
            } else if (position != 3) {
                SantanderTextView santanderTextView4 = this.globileInitialTextView;
                if (santanderTextView4 != null) {
                    santanderTextView4.setCompoundDrawablesWithIntrinsicBounds(icon, (Drawable) null, (Drawable) null, (Drawable) null);
                }
            } else {
                SantanderTextView santanderTextView5 = this.globileInitialTextView;
                if (santanderTextView5 != null) {
                    santanderTextView5.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, icon, (Drawable) null);
                }
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/santander/globile/uicomponents/buttons/initialbutton/GlobileInitialButton$ImagePosition;", "", "position", "", "(Ljava/lang/String;II)V", "getPosition", "()I", "LEFT", "TOP", "BOTTOM", "RIGHT", "Companion", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
    /* compiled from: GlobileInitialButton.kt */
    public enum ImagePosition {
        LEFT(0),
        TOP(1),
        BOTTOM(2),
        RIGHT(3);
        
        public static final Companion Companion = null;
        private final int position;

        private ImagePosition(int position2) {
            this.position = position2;
        }

        public final int getPosition() {
            return this.position;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/santander/globile/uicomponents/buttons/initialbutton/GlobileInitialButton$ImagePosition$Companion;", "", "()V", "positionFromInt", "Lcom/santander/globile/uicomponents/buttons/initialbutton/GlobileInitialButton$ImagePosition;", "position", "", "(Ljava/lang/Integer;)Lcom/santander/globile/uicomponents/buttons/initialbutton/GlobileInitialButton$ImagePosition;", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
        /* compiled from: GlobileInitialButton.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }

            public final ImagePosition positionFromInt(Integer position) {
                ImagePosition it;
                ImagePosition[] values = ImagePosition.values();
                int length = values.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        it = null;
                        break;
                    }
                    it = values[i];
                    if (position != null && it.getPosition() == position.intValue()) {
                        break;
                    }
                    i++;
                }
                return it != null ? it : ImagePosition.LEFT;
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/santander/globile/uicomponents/buttons/initialbutton/GlobileInitialButton$ImageTint;", "", "tint", "", "(Ljava/lang/String;II)V", "getTint", "()I", "WHITE", "RED", "DARK_SKY", "ACCESSIBLE_SKY", "GREY", "Companion", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
    /* compiled from: GlobileInitialButton.kt */
    public enum ImageTint {
        WHITE(0),
        RED(1),
        DARK_SKY(2),
        ACCESSIBLE_SKY(3),
        GREY(4);
        
        public static final Companion Companion = null;
        private final int tint;

        private ImageTint(int tint2) {
            this.tint = tint2;
        }

        public final int getTint() {
            return this.tint;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/santander/globile/uicomponents/buttons/initialbutton/GlobileInitialButton$ImageTint$Companion;", "", "()V", "tintFromInt", "Lcom/santander/globile/uicomponents/buttons/initialbutton/GlobileInitialButton$ImageTint;", "tint", "", "(Ljava/lang/Integer;)Lcom/santander/globile/uicomponents/buttons/initialbutton/GlobileInitialButton$ImageTint;", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
        /* compiled from: GlobileInitialButton.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }

            public final ImageTint tintFromInt(Integer tint) {
                ImageTint it;
                ImageTint[] values = ImageTint.values();
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
                return it != null ? it : ImageTint.RED;
            }
        }
    }
}
