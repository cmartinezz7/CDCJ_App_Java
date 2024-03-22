package com.santander.globile.uicomponents.textfield;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.google.android.material.textfield.TextInputLayout;
import com.santander.globile.uicomponents.R;
import com.santander.globile.uicomponents.edittext.SantanderAppCompatEditText;
import com.santander.globile.uicomponents.utils.IntExtensionsKt;
import java.lang.reflect.Field;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.io.ConstantsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.kxml2.wap.Wbxml;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0003vwxB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ&\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020>2\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010W\u001a\u0004\u0018\u00010\u0017J\u0006\u0010X\u001a\u00020TJ\u0010\u0010Y\u001a\u00020\u00072\u0006\u0010Z\u001a\u00020\u0007H\u0002J\u0012\u0010[\u001a\u00020T2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010\\\u001a\u00020T2\u0006\u0010]\u001a\u00020C2\u0006\u0010^\u001a\u00020\u000eH\u0002J\u000e\u0010_\u001a\u00020T2\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010`\u001a\u00020T2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0010\u0010a\u001a\u00020T2\u0006\u0010b\u001a\u00020\u0017H\u0002J\u0012\u0010c\u001a\u00020T2\b\u0010D\u001a\u0004\u0018\u00010\u0017H\u0002J\u000e\u0010d\u001a\u00020T2\u0006\u0010e\u001a\u00020fJ\u0017\u0010g\u001a\u00020T2\b\u0010:\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010\fJ\u0017\u0010h\u001a\u00020T2\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010\fJ\"\u0010i\u001a\u00020T2\u0006\u0010Z\u001a\u00020j2\b\u0010k\u001a\u0004\u0018\u00010l2\b\u0010m\u001a\u0004\u0018\u00010%J\u0017\u0010n\u001a\u00020T2\b\u0010J\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010\fJ\u0017\u0010o\u001a\u00020T2\b\u0010M\u001a\u0004\u0018\u00010LH\u0002¢\u0006\u0002\u0010QJ\u0012\u0010p\u001a\u00020T2\b\b\u0001\u0010q\u001a\u00020\u0007H\u0002J\u0012\u0010r\u001a\u00020T2\b\u0010?\u001a\u0004\u0018\u00010\u0017H\u0002J\u000e\u0010s\u001a\u00020T2\u0006\u0010e\u001a\u00020fJ\u0010\u0010t\u001a\u00020T2\u0006\u0010u\u001a\u00020\u000eH\u0002R$\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007@BX\u000e¢\u0006\n\n\u0002\u0010\r\"\u0004\b\u000b\u0010\fR$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000e8B@BX\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR&\u0010 \u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00078F@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010&\u001a\u00020%2\u0006\u0010\t\u001a\u00020%@BX\u000e¢\u0006\b\n\u0000\"\u0004\b'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\"\u0010*\u001a\u0004\u0018\u00010\u00172\b\u0010\t\u001a\u0004\u0018\u00010\u0017@BX\u000e¢\u0006\b\n\u0000\"\u0004\b+\u0010,R,\u0010-\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00078F@FX\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b.\u0010/\"\u0004\b0\u0010\fR\u001e\u00101\u001a\u00020%2\u0006\u0010\t\u001a\u00020%@BX\u000e¢\u0006\b\n\u0000\"\u0004\b2\u0010(R\u0010\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u0012\u00108\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u00109\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R$\u0010:\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007@BX\u000e¢\u0006\n\n\u0002\u0010\r\"\u0004\b;\u0010\fR\u000e\u0010<\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u000e¢\u0006\u0002\n\u0000R(\u0010D\u001a\u0004\u0018\u00010\u00172\b\u0010\t\u001a\u0004\u0018\u00010\u00178F@FX\u000e¢\u0006\f\u001a\u0004\bE\u0010F\"\u0004\bG\u0010,R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u000e¢\u0006\u0002\n\u0000R$\u0010J\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007@BX\u000e¢\u0006\n\n\u0002\u0010\r\"\u0004\bK\u0010\fR*\u0010M\u001a\u0004\u0018\u00010L2\b\u0010\t\u001a\u0004\u0018\u00010L@FX\u000e¢\u0006\u0010\n\u0002\u0010R\u001a\u0004\bN\u0010O\"\u0004\bP\u0010Q¨\u0006y"}, d2 = {"Lcom/santander/globile/uicomponents/textfield/GlobileTextField;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "backgroundColor", "setBackgroundColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "", "enable", "getEnable", "()Z", "setEnable", "(Z)V", "endIconDrawableView", "Landroid/widget/ImageView;", "errorText", "", "globileBottomTextView", "Landroid/widget/TextView;", "globileEditTextView", "Lcom/santander/globile/uicomponents/edittext/SantanderAppCompatEditText;", "getGlobileEditTextView", "()Lcom/santander/globile/uicomponents/edittext/SantanderAppCompatEditText;", "setGlobileEditTextView", "(Lcom/santander/globile/uicomponents/edittext/SantanderAppCompatEditText;)V", "globileEndIconBackground", "getGlobileEndIconBackground", "()I", "setGlobileEndIconBackground", "(I)V", "Lcom/santander/globile/uicomponents/textfield/GlobileTextField$ImageTint;", "globileEndIconBackgroundTint", "setGlobileEndIconBackgroundTint", "(Lcom/santander/globile/uicomponents/textfield/GlobileTextField$ImageTint;)V", "globileEndIconContentDescription", "globilePlaceholder", "setGlobilePlaceholder", "(Ljava/lang/String;)V", "globileRightIconBackground", "getGlobileRightIconBackground", "()Ljava/lang/Integer;", "setGlobileRightIconBackground", "globileRightIconBackgroundTint", "setGlobileRightIconBackgroundTint", "groupEndView", "Landroidx/constraintlayout/widget/Group;", "helpText", "iconEndDrawable", "iconEndDrawableTint", "iconRightDrawable", "iconRightDrawableTint", "inputType", "setInputType", "isErrorMode", "oldState", "Lcom/santander/globile/uicomponents/textfield/GlobileTextField$GlobileEditTextState;", "placeholder", "rightIconContentDescription", "rightIconDrawableView", "spaceBarIndicatorView", "Landroid/view/View;", "text", "getText", "()Ljava/lang/String;", "setText", "textInputLayout", "Lcom/google/android/material/textfield/TextInputLayout;", "textLength", "setTextLength", "", "textSize", "getTextSize", "()Ljava/lang/Float;", "setTextSize", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "changeState", "", "globileEditTextState", "accessibilityFieldName", "bottomMessage", "clear", "convertInputType", "type", "createCustomLayout", "enableContent", "view", "enabled", "enableEndIcon", "enableRightIcon", "readMessageToAccessibility", "message", "setBottomText", "setEndIconClickListener", "listener", "Landroid/view/View$OnClickListener;", "setGlobileInputType", "setGlobileTextFieldBackgroundColor", "setGlobileTextFieldIcon", "Lcom/santander/globile/uicomponents/textfield/GlobileTextField$GlobileEditIconType;", "drawable", "Landroid/graphics/drawable/Drawable;", "tintColor", "setGlobileTextLength", "setGlobileTextSize", "setHintColor", "color", "setPlaceHolder", "setRightIconClickListener", "showFocusLine", "hasFocus", "GlobileEditIconType", "GlobileEditTextState", "ImageTint", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileTextField.kt */
public final class GlobileTextField extends LinearLayout {
    private HashMap _$_findViewCache;
    private Integer backgroundColor;
    /* access modifiers changed from: private */
    public ImageView endIconDrawableView;
    private String errorText;
    private TextView globileBottomTextView;
    private SantanderAppCompatEditText globileEditTextView;
    private int globileEndIconBackground;
    private ImageTint globileEndIconBackgroundTint;
    private String globileEndIconContentDescription;
    private String globilePlaceholder;
    private Integer globileRightIconBackground;
    private ImageTint globileRightIconBackgroundTint;
    private Group groupEndView;
    private String helpText;
    private int iconEndDrawable;
    private ImageTint iconEndDrawableTint;
    private Integer iconRightDrawable;
    private ImageTint iconRightDrawableTint;
    private Integer inputType;
    private boolean isErrorMode;
    private GlobileEditTextState oldState;
    private String placeholder;
    private String rightIconContentDescription;
    private ImageView rightIconDrawableView;
    private View spaceBarIndicatorView;
    private TextInputLayout textInputLayout;
    private Integer textLength;
    private Float textSize;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/santander/globile/uicomponents/textfield/GlobileTextField$GlobileEditIconType;", "", "(Ljava/lang/String;I)V", "END", "RIGHT", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
    /* compiled from: GlobileTextField.kt */
    public enum GlobileEditIconType {
        END,
        RIGHT
    }

    public GlobileTextField(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public GlobileTextField(Context context, AttributeSet attributeSet) {
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
    public GlobileTextField(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.globileEndIconContentDescription = "";
        this.rightIconContentDescription = "";
        this.iconRightDrawableTint = ImageTint.RED;
        this.iconEndDrawableTint = ImageTint.RED;
        this.oldState = GlobileEditTextState.NORMAL;
        this.globileRightIconBackgroundTint = ImageTint.RED;
        this.globileEndIconBackgroundTint = ImageTint.RED;
        LayoutInflater.from(context).inflate(R.layout.globile_text_input_layout, this, true);
        setOrientation(1);
        this.globileEditTextView = (SantanderAppCompatEditText) findViewById(R.id.santander_globile_edit_text);
        this.textInputLayout = (TextInputLayout) findViewById(R.id.santander_globile_text_input_layout);
        this.globileBottomTextView = (TextView) findViewById(R.id.bottom_text);
        this.groupEndView = findViewById(R.id.groupEnd);
        this.spaceBarIndicatorView = findViewById(R.id.edit_text_spacer_indicator);
        this.endIconDrawableView = (ImageView) findViewById(R.id.globile_input_text_end_icon);
        this.rightIconDrawableView = (ImageView) findViewById(R.id.globile_input_text_right_icon);
        ((SantanderAppCompatEditText) _$_findCachedViewById(R.id.santander_globile_edit_text)).setOnFocusChangeListener(new View.OnFocusChangeListener(this) {
            final /* synthetic */ GlobileTextField this$0;

            {
                this.this$0 = r1;
            }

            public final void onFocusChange(View $noName_0, boolean hasFocus) {
                this.this$0.showFocusLine(hasFocus);
            }
        });
        createCustomLayout(attrs);
        changeState$default(this, GlobileEditTextState.NORMAL, (String) null, (String) null, 6, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobileTextField(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final SantanderAppCompatEditText getGlobileEditTextView() {
        return this.globileEditTextView;
    }

    public final void setGlobileEditTextView(SantanderAppCompatEditText santanderAppCompatEditText) {
        this.globileEditTextView = santanderAppCompatEditText;
    }

    private final void setGlobilePlaceholder(String value) {
        this.placeholder = value;
        setPlaceHolder(value);
    }

    public final String getText() {
        SantanderAppCompatEditText santanderAppCompatEditText = this.globileEditTextView;
        return String.valueOf(santanderAppCompatEditText != null ? santanderAppCompatEditText.getText() : null);
    }

    public final void setText(String value) {
        SantanderAppCompatEditText santanderAppCompatEditText = this.globileEditTextView;
        if (santanderAppCompatEditText != null) {
            santanderAppCompatEditText.setText(value);
        }
    }

    private final void setGlobileRightIconBackgroundTint(ImageTint value) {
        Drawable drawable;
        this.iconRightDrawableTint = value;
        GlobileEditIconType globileEditIconType = GlobileEditIconType.RIGHT;
        Integer num = this.iconRightDrawable;
        if (num != null) {
            int intValue = num.intValue();
            Context context = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            drawable = IntExtensionsKt.toDrawable(intValue, context);
        } else {
            drawable = null;
        }
        setGlobileTextFieldIcon(globileEditIconType, drawable, value);
    }

    public final void setGlobileRightIconBackground(Integer value) {
        this.iconRightDrawable = value;
        if (value == null || value.intValue() <= 0) {
            enableRightIcon(false);
        } else {
            GlobileEditIconType globileEditIconType = GlobileEditIconType.RIGHT;
            int intValue = value.intValue();
            Context context = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            setGlobileTextFieldIcon(globileEditIconType, IntExtensionsKt.toDrawable(intValue, context), this.iconRightDrawableTint);
        }
        this.globileRightIconBackground = value;
    }

    public final Integer getGlobileRightIconBackground() {
        return this.iconRightDrawable;
    }

    private final void setGlobileEndIconBackgroundTint(ImageTint value) {
        this.iconEndDrawableTint = value;
        GlobileEditIconType globileEditIconType = GlobileEditIconType.END;
        int i = this.iconEndDrawable;
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        setGlobileTextFieldIcon(globileEditIconType, IntExtensionsKt.toDrawable(i, context), value);
    }

    public final void setGlobileEndIconBackground(int value) {
        this.iconEndDrawable = value;
        if (value > 0) {
            GlobileEditIconType globileEditIconType = GlobileEditIconType.END;
            Context context = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            setGlobileTextFieldIcon(globileEditIconType, IntExtensionsKt.toDrawable(value, context), this.iconEndDrawableTint);
        } else {
            enableEndIcon(false);
        }
        this.globileEndIconBackground = value;
    }

    public final int getGlobileEndIconBackground() {
        return this.iconEndDrawable;
    }

    private final void setInputType(Integer value) {
        setGlobileInputType(value);
    }

    public final Float getTextSize() {
        return this.textSize;
    }

    public final void setTextSize(Float value) {
        setGlobileTextSize(value);
    }

    private final void setTextLength(Integer value) {
        setGlobileTextLength(value);
    }

    private final void setBackgroundColor(Integer value) {
        setGlobileTextFieldBackgroundColor(value);
    }

    private final boolean getEnable() {
        return isEnabled();
    }

    private final void setEnable(boolean value) {
        enableContent(this, value);
    }

    private final void createCustomLayout(AttributeSet attrs) {
        TypedArray attributes = getContext().obtainStyledAttributes(attrs, R.styleable.GlobileTextField, 0, 0);
        setGlobilePlaceholder(attributes.getString(R.styleable.GlobileTextField_placeholder));
        this.helpText = attributes.getString(R.styleable.GlobileTextField_helpText);
        this.errorText = attributes.getString(R.styleable.GlobileTextField_errorText);
        setGlobileRightIconBackground(Integer.valueOf(attributes.getResourceId(R.styleable.GlobileTextField_rightIconBackground, 0)));
        this.rightIconContentDescription = attributes.getString(R.styleable.GlobileTextField_rightIconContentDescription);
        setGlobileRightIconBackgroundTint(ImageTint.Companion.tintFromInt(Integer.valueOf(attributes.getInt(R.styleable.GlobileTextField_rightIconBackgroundTint, 1))));
        setGlobileEndIconBackground(attributes.getResourceId(R.styleable.GlobileTextField_endIconBackground, 0));
        this.globileEndIconContentDescription = attributes.getString(R.styleable.GlobileTextField_globileEndIconContentDescription);
        setGlobileEndIconBackgroundTint(ImageTint.Companion.tintFromInt(Integer.valueOf(attributes.getInt(R.styleable.GlobileTextField_endIconBackgroundTint, 1))));
        setInputType(Integer.valueOf(convertInputType(attributes.getInt(R.styleable.GlobileTextField_inputType, 0))));
        setTextSize(Float.valueOf(attributes.getFloat(R.styleable.GlobileTextField_textSizeInput, 0.0f)));
        setTextLength(Integer.valueOf(attributes.getInt(R.styleable.GlobileTextField_textLength, 0)));
        setBackgroundColor(Integer.valueOf(attributes.getResourceId(R.styleable.GlobileTextField_backgroundColor, 0)));
        setEnable(attributes.getBoolean(R.styleable.GlobileTextField_enabled, true));
        TypedArray styledAttributes = getContext().obtainStyledAttributes(attrs, new int[]{16843087});
        CharSequence text = styledAttributes.getText(0);
        setText(text != null ? text.toString() : null);
        setBottomText(this.helpText);
        styledAttributes.recycle();
        attributes.recycle();
    }

    private final void enableContent(View view, boolean enabled) {
        view.setEnabled(enabled);
        if (view instanceof ViewGroup) {
            int childCount = ((ViewGroup) view).getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = ((ViewGroup) view).getChildAt(i);
                Intrinsics.checkExpressionValueIsNotNull(child, "child");
                enableContent(child, enabled);
            }
        }
    }

    private final void readMessageToAccessibility(String message) {
        Toast toast = Toast.makeText(getContext(), message, 0);
        Intrinsics.checkExpressionValueIsNotNull(toast, "toast");
        View view = toast.getView();
        Intrinsics.checkExpressionValueIsNotNull(view, "toast.view");
        view.setVisibility(8);
        toast.show();
    }

    private final void setGlobileTextFieldBackgroundColor(Integer value) {
        int color;
        if (value != null) {
            int it = value.intValue();
            if (value.intValue() == 0) {
                color = -1;
            } else if (Build.VERSION.SDK_INT >= 23) {
                color = getResources().getColor(it, (Resources.Theme) null);
            } else {
                color = getResources().getColor(it);
            }
            TextInputLayout textInputLayout2 = (TextInputLayout) _$_findCachedViewById(R.id.santander_globile_text_input_layout);
            if (textInputLayout2 != null) {
                textInputLayout2.setBackgroundColor(color);
            }
            ConstraintLayout _$_findCachedViewById = _$_findCachedViewById(R.id.right_containter);
            if (_$_findCachedViewById != null) {
                _$_findCachedViewById.setBackgroundColor(color);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void showFocusLine(boolean hasFocus) {
        View _$_findCachedViewById = _$_findCachedViewById(R.id.edit_text_spacer_indicator);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "edit_text_spacer_indicator");
        ViewGroup.LayoutParams params = _$_findCachedViewById.getLayoutParams();
        params.height = IntExtensionsKt.getToDP(hasFocus ? 2 : 1);
        View _$_findCachedViewById2 = _$_findCachedViewById(R.id.edit_text_spacer_indicator);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById2, "edit_text_spacer_indicator");
        _$_findCachedViewById2.setLayoutParams(params);
    }

    public final void setEndIconClickListener(View.OnClickListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        ImageView imageView = this.endIconDrawableView;
        if (imageView != null) {
            imageView.setOnClickListener(new GlobileTextField$setEndIconClickListener$1(this, listener));
        }
    }

    public final void setRightIconClickListener(View.OnClickListener listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        ImageView imageView = this.rightIconDrawableView;
        if (imageView != null) {
            imageView.setOnClickListener(new GlobileTextField$setRightIconClickListener$1(this, listener));
        }
    }

    public final void clear() {
        Editable text;
        SantanderAppCompatEditText santanderAppCompatEditText = this.globileEditTextView;
        if (santanderAppCompatEditText != null && (text = santanderAppCompatEditText.getText()) != null) {
            text.clear();
        }
    }

    private final void setHintColor(int color) {
        TextInputLayout til = (TextInputLayout) findViewById(R.id.santander_globile_text_input_layout);
        try {
            Field fDefaultTextColor = TextInputLayout.class.getDeclaredField("defaultHintTextColor");
            Intrinsics.checkExpressionValueIsNotNull(fDefaultTextColor, "fDefaultTextColor");
            fDefaultTextColor.setAccessible(true);
            fDefaultTextColor.set(til, new ColorStateList(new int[][]{new int[]{0}}, new int[]{color}));
            Field fFocusedTextColor = TextInputLayout.class.getDeclaredField("focusedTextColor");
            Intrinsics.checkExpressionValueIsNotNull(fFocusedTextColor, "fFocusedTextColor");
            fFocusedTextColor.setAccessible(true);
            fFocusedTextColor.set(til, new ColorStateList(new int[][]{new int[]{0}}, new int[]{color}));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static /* synthetic */ void changeState$default(GlobileTextField globileTextField, GlobileEditTextState globileEditTextState, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "text field";
        }
        if ((i & 4) != 0) {
            str2 = "";
        }
        globileTextField.changeState(globileEditTextState, str, str2);
    }

    public final void changeState(GlobileEditTextState globileEditTextState, String accessibilityFieldName, String bottomMessage) {
        Intrinsics.checkParameterIsNotNull(globileEditTextState, "globileEditTextState");
        int state = globileEditTextState.getState();
        if (state == 0) {
            this.isErrorMode = false;
            if (Build.VERSION.SDK_INT >= 23) {
                View view = this.spaceBarIndicatorView;
                if (view != null) {
                    view.setBackgroundColor(getResources().getColor(R.color.dark_sky, (Resources.Theme) null));
                }
                TextView textView = this.globileBottomTextView;
                if (textView != null) {
                    textView.setTextColor(getResources().getColor(R.color.grey, (Resources.Theme) null));
                }
                setHintColor(getResources().getColor(R.color.medium_grey, (Resources.Theme) null));
            } else {
                View view2 = this.spaceBarIndicatorView;
                if (view2 != null) {
                    view2.setBackgroundColor(getResources().getColor(R.color.dark_sky));
                }
                TextView textView2 = this.globileBottomTextView;
                if (textView2 != null) {
                    textView2.setTextColor(getResources().getColor(R.color.grey));
                }
                setHintColor(getResources().getColor(R.color.medium_grey));
            }
            if (this.oldState == GlobileEditTextState.ERROR) {
                String string = getResources().getString(R.string.text_error_clear, new Object[]{accessibilityFieldName});
                Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(\n   …, accessibilityFieldName)");
                readMessageToAccessibility(string);
            }
            if (!Intrinsics.areEqual((Object) bottomMessage, (Object) "")) {
                setBottomText(bottomMessage);
            } else {
                setBottomText(this.helpText);
            }
        } else if (state == 1) {
            this.isErrorMode = true;
            if (Build.VERSION.SDK_INT >= 23) {
                View view3 = this.spaceBarIndicatorView;
                if (view3 != null) {
                    view3.setBackgroundColor(getResources().getColor(R.color.santander_red, (Resources.Theme) null));
                }
                TextView textView3 = this.globileBottomTextView;
                if (textView3 != null) {
                    textView3.setTextColor(getResources().getColor(R.color.santander_red, (Resources.Theme) null));
                }
                setHintColor(getResources().getColor(R.color.santander_red, (Resources.Theme) null));
            } else {
                View view4 = this.spaceBarIndicatorView;
                if (view4 != null) {
                    view4.setBackgroundColor(getResources().getColor(R.color.santander_red));
                }
                TextView textView4 = this.globileBottomTextView;
                if (textView4 != null) {
                    textView4.setTextColor(getResources().getColor(R.color.santander_red));
                }
                setHintColor(getResources().getColor(R.color.santander_red));
            }
            Resources resources = getResources();
            int i = R.string.text_error_appeared;
            Object[] objArr = new Object[2];
            objArr[0] = accessibilityFieldName;
            if (bottomMessage == null) {
                Intrinsics.throwNpe();
            }
            objArr[1] = bottomMessage;
            String string2 = resources.getString(i, objArr);
            Intrinsics.checkExpressionValueIsNotNull(string2, "resources.getString(\n   …eldName, bottomMessage!!)");
            readMessageToAccessibility(string2);
            if (!Intrinsics.areEqual((Object) bottomMessage, (Object) "")) {
                setBottomText(bottomMessage);
            } else {
                setBottomText(this.errorText);
            }
        }
        this.oldState = globileEditTextState;
    }

    private final void setPlaceHolder(String placeholder2) {
        if (placeholder2 != null) {
            String it = placeholder2;
            TextInputLayout textInputLayout2 = this.textInputLayout;
            if (textInputLayout2 != null) {
                textInputLayout2.setHint((CharSequence) it);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0023, code lost:
        r4 = r4.newDrawable();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setGlobileTextFieldIcon(com.santander.globile.uicomponents.textfield.GlobileTextField.GlobileEditIconType r12, android.graphics.drawable.Drawable r13, com.santander.globile.uicomponents.textfield.GlobileTextField.ImageTint r14) {
        /*
            r11 = this;
            java.lang.String r0 = "type"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r12, r0)
            if (r13 == 0) goto L_0x012e
            r0 = r13
            r1 = 0
            r2 = 0
            r3 = 1
            if (r14 == 0) goto L_0x00f8
            int r4 = r14.getTint()
            if (r4 == 0) goto L_0x00f8
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 23
            r6 = 4
            r7 = 3
            r8 = 2
            r9 = 0
            if (r4 < r5) goto L_0x008c
            android.graphics.drawable.Drawable$ConstantState r4 = r13.getConstantState()
            if (r4 == 0) goto L_0x002e
            android.graphics.drawable.Drawable r4 = r4.newDrawable()
            if (r4 == 0) goto L_0x002e
            android.graphics.drawable.Drawable r4 = r4.mutate()
            goto L_0x002f
        L_0x002e:
            r4 = r9
        L_0x002f:
            r2 = r4
            if (r2 == 0) goto L_0x00f9
            r4 = r2
            r5 = 0
            int r10 = r14.getTint()
            if (r10 == 0) goto L_0x007b
            if (r10 == r3) goto L_0x006d
            if (r10 == r8) goto L_0x005f
            if (r10 == r7) goto L_0x0051
            if (r10 == r6) goto L_0x0043
            goto L_0x0088
        L_0x0043:
            android.content.res.Resources r6 = r11.getResources()
            int r7 = com.santander.globile.uicomponents.R.color.grey
            int r6 = r6.getColor(r7, r9)
            r4.setTint(r6)
            goto L_0x0088
        L_0x0051:
            android.content.res.Resources r6 = r11.getResources()
            int r7 = com.santander.globile.uicomponents.R.color.accessible_sky
            int r6 = r6.getColor(r7, r9)
            r4.setTint(r6)
            goto L_0x0088
        L_0x005f:
            android.content.res.Resources r6 = r11.getResources()
            int r7 = com.santander.globile.uicomponents.R.color.dark_sky
            int r6 = r6.getColor(r7, r9)
            r4.setTint(r6)
            goto L_0x0088
        L_0x006d:
            android.content.res.Resources r6 = r11.getResources()
            int r7 = com.santander.globile.uicomponents.R.color.boston_red
            int r6 = r6.getColor(r7, r9)
            r4.setTint(r6)
            goto L_0x0088
        L_0x007b:
            android.content.res.Resources r6 = r11.getResources()
            int r7 = com.santander.globile.uicomponents.R.color.white
            int r6 = r6.getColor(r7, r9)
            r4.setTint(r6)
        L_0x0088:
            goto L_0x00f9
        L_0x008c:
            android.graphics.drawable.Drawable$ConstantState r4 = r13.getConstantState()
            if (r4 == 0) goto L_0x009c
            android.graphics.drawable.Drawable r4 = r4.newDrawable()
            if (r4 == 0) goto L_0x009c
            android.graphics.drawable.Drawable r9 = r4.mutate()
        L_0x009c:
            r2 = r9
            if (r2 == 0) goto L_0x00f7
            r4 = r2
            r5 = 0
            int r9 = r14.getTint()
            if (r9 == 0) goto L_0x00e8
            if (r9 == r3) goto L_0x00da
            if (r9 == r8) goto L_0x00cc
            if (r9 == r7) goto L_0x00be
            if (r9 == r6) goto L_0x00b0
            goto L_0x00f5
        L_0x00b0:
            android.content.res.Resources r6 = r11.getResources()
            int r7 = com.santander.globile.uicomponents.R.color.grey
            int r6 = r6.getColor(r7)
            androidx.core.graphics.drawable.DrawableCompat.setTint(r4, r6)
            goto L_0x00f5
        L_0x00be:
            android.content.res.Resources r6 = r11.getResources()
            int r7 = com.santander.globile.uicomponents.R.color.accessible_sky
            int r6 = r6.getColor(r7)
            androidx.core.graphics.drawable.DrawableCompat.setTint(r4, r6)
            goto L_0x00f5
        L_0x00cc:
            android.content.res.Resources r6 = r11.getResources()
            int r7 = com.santander.globile.uicomponents.R.color.dark_sky
            int r6 = r6.getColor(r7)
            androidx.core.graphics.drawable.DrawableCompat.setTint(r4, r6)
            goto L_0x00f5
        L_0x00da:
            android.content.res.Resources r6 = r11.getResources()
            int r7 = com.santander.globile.uicomponents.R.color.boston_red
            int r6 = r6.getColor(r7)
            androidx.core.graphics.drawable.DrawableCompat.setTint(r4, r6)
            goto L_0x00f5
        L_0x00e8:
            android.content.res.Resources r6 = r11.getResources()
            int r7 = com.santander.globile.uicomponents.R.color.white
            int r6 = r6.getColor(r7)
            androidx.core.graphics.drawable.DrawableCompat.setTint(r4, r6)
        L_0x00f5:
        L_0x00f7:
            goto L_0x00f9
        L_0x00f8:
            r2 = r13
        L_0x00f9:
            com.santander.globile.uicomponents.textfield.GlobileTextField$GlobileEditIconType r4 = com.santander.globile.uicomponents.textfield.GlobileTextField.GlobileEditIconType.END
            if (r12 != r4) goto L_0x0115
            r11.enableEndIcon(r3)
            android.widget.ImageView r3 = r11.endIconDrawableView
            if (r3 == 0) goto L_0x0108
            r3.setImageDrawable(r2)
        L_0x0108:
            android.widget.ImageView r3 = r11.endIconDrawableView
            if (r3 == 0) goto L_0x012b
            java.lang.String r4 = r11.globileEndIconContentDescription
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.setContentDescription(r4)
            goto L_0x012b
        L_0x0115:
            r11.enableRightIcon(r3)
            android.widget.ImageView r3 = r11.rightIconDrawableView
            if (r3 == 0) goto L_0x011f
            r3.setImageDrawable(r2)
        L_0x011f:
            android.widget.ImageView r3 = r11.rightIconDrawableView
            if (r3 == 0) goto L_0x012b
            java.lang.String r4 = r11.rightIconContentDescription
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.setContentDescription(r4)
        L_0x012b:
        L_0x012e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.santander.globile.uicomponents.textfield.GlobileTextField.setGlobileTextFieldIcon(com.santander.globile.uicomponents.textfield.GlobileTextField$GlobileEditIconType, android.graphics.drawable.Drawable, com.santander.globile.uicomponents.textfield.GlobileTextField$ImageTint):void");
    }

    private final void setBottomText(String text) {
        TextView textView;
        if (text != null) {
            String it = text;
            TextView textView2 = this.globileBottomTextView;
            if (textView2 != null) {
                textView2.setText(it);
            }
            SantanderAppCompatEditText santanderAppCompatEditText = this.globileEditTextView;
            if (santanderAppCompatEditText != null && (textView = this.globileBottomTextView) != null) {
                if (santanderAppCompatEditText == null) {
                    Intrinsics.throwNpe();
                }
                textView.setLabelFor(santanderAppCompatEditText.getId());
            }
        }
    }

    private final int convertInputType(int type) {
        switch (type) {
            case 2:
                return 4;
            case 3:
                return 20;
            case 4:
                return 2;
            case 5:
                return ConstantsKt.DEFAULT_BUFFER_SIZE;
            case 6:
                return 18;
            case 7:
                return 3;
            case 8:
                return 33;
            case 9:
                return Wbxml.EXT_T_1;
            case 10:
                return 16;
            default:
                return 1;
        }
    }

    private final void setGlobileTextSize(Float textSize2) {
        SantanderAppCompatEditText santanderAppCompatEditText;
        if (textSize2 != null) {
            float it = textSize2.floatValue();
            if ((!Intrinsics.areEqual(textSize2, 0.0f)) && (santanderAppCompatEditText = this.globileEditTextView) != null) {
                santanderAppCompatEditText.setTextSize(2, it);
            }
        }
    }

    private final void setGlobileTextLength(Integer textLength2) {
        if (textLength2 != null) {
            int intValue = textLength2.intValue();
            if (textLength2.intValue() != 0) {
                InputFilter[] fArray = {new InputFilter.LengthFilter(textLength2.intValue())};
                SantanderAppCompatEditText santanderAppCompatEditText = this.globileEditTextView;
                if (santanderAppCompatEditText != null) {
                    santanderAppCompatEditText.setFilters(fArray);
                }
            }
        }
    }

    private final void setGlobileInputType(Integer inputType2) {
        SantanderAppCompatEditText santanderAppCompatEditText;
        if (inputType2 != null && inputType2.intValue() != 0 && (santanderAppCompatEditText = this.globileEditTextView) != null) {
            santanderAppCompatEditText.setInputType(inputType2.intValue());
        }
    }

    public final void enableEndIcon(boolean enable) {
        if (enable) {
            Group group = this.groupEndView;
            if (group != null) {
                group.setVisibility(0);
                return;
            }
            return;
        }
        Group group2 = this.groupEndView;
        if (group2 != null) {
            group2.setVisibility(8);
        }
    }

    public final void enableRightIcon(boolean enable) {
        if (enable) {
            ImageView imageView = this.rightIconDrawableView;
            if (imageView != null) {
                imageView.setVisibility(0);
                return;
            }
            return;
        }
        ImageView imageView2 = this.rightIconDrawableView;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/santander/globile/uicomponents/textfield/GlobileTextField$GlobileEditTextState;", "", "state", "", "(Ljava/lang/String;II)V", "getState", "()I", "NORMAL", "ERROR", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
    /* compiled from: GlobileTextField.kt */
    public enum GlobileEditTextState {
        NORMAL(0),
        ERROR(1);
        
        private final int state;

        private GlobileEditTextState(int state2) {
            this.state = state2;
        }

        public final int getState() {
            return this.state;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/santander/globile/uicomponents/textfield/GlobileTextField$ImageTint;", "", "tint", "", "(Ljava/lang/String;II)V", "getTint", "()I", "WHITE", "RED", "DARK_SKY", "ACCESSIBLE_SKY", "GREY", "Companion", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
    /* compiled from: GlobileTextField.kt */
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

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/santander/globile/uicomponents/textfield/GlobileTextField$ImageTint$Companion;", "", "()V", "tintFromInt", "Lcom/santander/globile/uicomponents/textfield/GlobileTextField$ImageTint;", "tint", "", "(Ljava/lang/Integer;)Lcom/santander/globile/uicomponents/textfield/GlobileTextField$ImageTint;", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
        /* compiled from: GlobileTextField.kt */
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
