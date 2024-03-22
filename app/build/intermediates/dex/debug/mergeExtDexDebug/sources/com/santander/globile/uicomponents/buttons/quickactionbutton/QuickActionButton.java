package com.santander.globile.uicomponents.buttons.quickactionbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.santander.globile.uicomponents.R;
import com.santander.globile.uicomponents.image.icon.IconColor;
import com.santander.globile.uicomponents.image.icon.IconSize;
import com.santander.globile.uicomponents.text.SantanderTextView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001\u001dB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nJ\u0012\u0010\u0015\u001a\u00020\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0010J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0007J\u000e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u000eJ\b\u0010\u001b\u001a\u00020\u0013H\u0002J\u0012\u0010\u001c\u001a\u00020\u00132\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/santander/globile/uicomponents/buttons/quickactionbutton/QuickActionButton;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mButtonDisable", "", "mButtonDrawable", "Ljava/lang/Integer;", "mButtonText", "", "mButtonTint", "Lcom/santander/globile/uicomponents/buttons/quickactionbutton/QuickActionButton$ButtonTint;", "mContext", "setDisabled", "", "disabled", "setDrawableColor", "color", "setIcon", "drawable", "setText", "text", "setTextAppareance", "setViews", "ButtonTint", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: QuickActionButton.kt */
public final class QuickActionButton extends FrameLayout {
    private HashMap _$_findViewCache;
    private boolean mButtonDisable;
    private Integer mButtonDrawable;
    private String mButtonText;
    private ButtonTint mButtonTint;
    private final Context mContext;

    public QuickActionButton(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public QuickActionButton(Context context, AttributeSet attributeSet) {
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
    public QuickActionButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.mContext = context;
        this.mButtonTint = ButtonTint.WHITE;
        this.mButtonText = "";
        LayoutInflater.from(context).inflate(R.layout.quick_button, this, true);
        setViews(attrs);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QuickActionButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void setViews(AttributeSet attrs) {
        TypedArray attributes = getContext().obtainStyledAttributes(attrs, R.styleable.QuickActionButton, 0, 0);
        this.mButtonTint = ButtonTint.Companion.tintFromInt(Integer.valueOf(attributes.getInt(R.styleable.QuickActionButton_buttonColor, 0)));
        this.mButtonText = attributes.getString(R.styleable.QuickActionButton_quickActionbuttonText);
        this.mButtonDisable = attributes.getBoolean(R.styleable.QuickActionButton_disabled, false);
        setTextAppareance();
        setDrawableColor$default(this, (ButtonTint) null, 1, (Object) null);
        setDisabled(this.mButtonDisable);
        SantanderTextView santanderTextView = (SantanderTextView) _$_findCachedViewById(R.id.text_quick_button);
        Intrinsics.checkExpressionValueIsNotNull(santanderTextView, "text_quick_button");
        santanderTextView.setText(this.mButtonText);
    }

    private final void setTextAppareance() {
        if (!this.mButtonDisable) {
            if (Build.VERSION.SDK_INT < 23) {
                ((SantanderTextView) _$_findCachedViewById(R.id.text_quick_button)).setTextAppearance(getContext(), R.style.GlobileQuickActionButtonStyleTextAppearance);
            } else {
                ((SantanderTextView) _$_findCachedViewById(R.id.text_quick_button)).setTextAppearance(R.style.GlobileQuickActionButtonStyleTextAppearance);
            }
        } else if (Build.VERSION.SDK_INT < 23) {
            ((SantanderTextView) _$_findCachedViewById(R.id.text_quick_button)).setTextAppearance(getContext(), R.style.GlobileQuickActionButtonStyleTextAppearanceDisable);
        } else {
            ((SantanderTextView) _$_findCachedViewById(R.id.text_quick_button)).setTextAppearance(R.style.GlobileQuickActionButtonStyleTextAppearanceDisable);
        }
    }

    public final void setIcon(int drawable) {
        this.mButtonDrawable = Integer.valueOf(drawable);
        if (this.mButtonDisable) {
            ((QuickIconGlobile) _$_findCachedViewById(R.id.icon_quick_button)).setDisabledIcon(drawable, IconColorDisabled.DISABLED, IconSize.SMALL);
        } else if (this.mButtonTint.getTint() == 0) {
            ((QuickIconGlobile) _$_findCachedViewById(R.id.icon_quick_button)).setIcon(drawable, IconColor.GREY, IconSize.SMALL);
        } else {
            ((QuickIconGlobile) _$_findCachedViewById(R.id.icon_quick_button)).setIcon(drawable, IconColor.WHITE, IconSize.SMALL);
        }
    }

    public final void setText(String text) {
        Intrinsics.checkParameterIsNotNull(text, "text");
        SantanderTextView santanderTextView = (SantanderTextView) _$_findCachedViewById(R.id.text_quick_button);
        Intrinsics.checkExpressionValueIsNotNull(santanderTextView, "text_quick_button");
        santanderTextView.setText(text);
    }

    public static /* synthetic */ void setDrawableColor$default(QuickActionButton quickActionButton, ButtonTint buttonTint, int i, Object obj) {
        if ((i & 1) != 0) {
            buttonTint = null;
        }
        quickActionButton.setDrawableColor(buttonTint);
    }

    public final void setDrawableColor(ButtonTint color) {
        if (!this.mButtonDisable) {
            if (color != null) {
                this.mButtonTint = color;
            }
            ButtonTint buttonTint = this.mButtonTint;
            if (buttonTint != null) {
                int tint = buttonTint.getTint();
                if (tint == 0) {
                    _$_findCachedViewById(R.id.background_icon_quick_button).setBackgroundResource(R.drawable.quick_action_button_white);
                } else if (tint == 1) {
                    _$_findCachedViewById(R.id.background_icon_quick_button).setBackgroundResource(R.drawable.quick_action_button_boston_red);
                } else if (tint == 2) {
                    _$_findCachedViewById(R.id.background_icon_quick_button).setBackgroundResource(R.drawable.quick_action_button_dark_sky);
                } else if (tint == 3) {
                    _$_findCachedViewById(R.id.background_icon_quick_button).setBackgroundResource(R.drawable.quick_action_button_accesible_sky);
                } else if (tint == 4) {
                    _$_findCachedViewById(R.id.background_icon_quick_button).setBackgroundResource(R.drawable.quick_action_button_dark_grey);
                }
            }
        } else {
            _$_findCachedViewById(R.id.background_icon_quick_button).setBackgroundResource(R.drawable.quick_action_button_white);
        }
    }

    public final void setDisabled(boolean disabled) {
        this.mButtonDisable = disabled;
        if (disabled) {
            setClickable(false);
            setEnabled(false);
            setDrawableColor((ButtonTint) null);
            setTextAppareance();
            Integer num = this.mButtonDrawable;
            if (num != null) {
                setIcon(num.intValue());
                return;
            }
            return;
        }
        setClickable(true);
        setEnabled(true);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0001\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/santander/globile/uicomponents/buttons/quickactionbutton/QuickActionButton$ButtonTint;", "", "tint", "", "(Ljava/lang/String;II)V", "getTint", "()I", "setTint", "(I)V", "WHITE", "RED", "DARK_SKY", "ACCESSIBLE_SKY", "GREY", "Companion", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
    /* compiled from: QuickActionButton.kt */
    public enum ButtonTint {
        WHITE(0),
        RED(1),
        DARK_SKY(2),
        ACCESSIBLE_SKY(3),
        GREY(4);
        
        public static final Companion Companion = null;
        private int tint;

        private ButtonTint(int tint2) {
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

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/santander/globile/uicomponents/buttons/quickactionbutton/QuickActionButton$ButtonTint$Companion;", "", "()V", "tintFromInt", "Lcom/santander/globile/uicomponents/buttons/quickactionbutton/QuickActionButton$ButtonTint;", "tint", "", "(Ljava/lang/Integer;)Lcom/santander/globile/uicomponents/buttons/quickactionbutton/QuickActionButton$ButtonTint;", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
        /* compiled from: QuickActionButton.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
                this();
            }

            public final ButtonTint tintFromInt(Integer tint) {
                ButtonTint it;
                ButtonTint[] values = ButtonTint.values();
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
                return it != null ? it : ButtonTint.WHITE;
            }
        }
    }
}
