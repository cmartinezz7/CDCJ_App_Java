package com.santander.globile.uicomponents.optionselection.checkbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.santander.globile.uicomponents.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u001a\u001a\u00020\u001bH\u0007J\b\u0010\u001c\u001a\u00020\u001bH\u0007J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\nH\u0002J\u0012\u0010\u001f\u001a\u00020\u001b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0003J\u000e\u0010 \u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\nR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006!"}, d2 = {"Lcom/santander/globile/uicomponents/optionselection/checkbox/GlobileCheckbox;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "radioColor", "getRadioColor", "()I", "setRadioColor", "(I)V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "changeToNormalColor", "", "changeToSelectedColor", "checkSelected", "checked", "createCustomLayout", "enabled", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileCheckbox.kt */
public final class GlobileCheckbox extends LinearLayout {
    private HashMap _$_findViewCache;
    private boolean enable;
    private int radioColor;
    private String text;

    public GlobileCheckbox(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public GlobileCheckbox(Context context, AttributeSet attributeSet) {
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
    public GlobileCheckbox(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.text = "";
        this.enable = true;
        LayoutInflater.from(context).inflate(R.layout.globile_check_box, this, true);
        if (Build.VERSION.SDK_INT < 23) {
            ((TextView) _$_findCachedViewById(R.id.text_globile_check_box)).setTextAppearance(context, R.style.SantanderTextViewAppearance);
        } else {
            ((TextView) _$_findCachedViewById(R.id.text_globile_check_box)).setTextAppearance(R.style.SantanderTextViewAppearance);
        }
        createCustomLayout(attrs);
        _$_findCachedViewById(R.id.check_globile_check_box).setButtonDrawable(R.drawable.check_selection_background);
        _$_findCachedViewById(R.id.check_globile_check_box).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) {
            final /* synthetic */ GlobileCheckbox this$0;

            {
                this.this$0 = r1;
            }

            public final void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                this.this$0.checkSelected(isChecked);
            }
        });
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobileCheckbox(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final int getRadioColor() {
        return this.radioColor;
    }

    public final void setRadioColor(int i) {
        this.radioColor = i;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final void setEnable(boolean z) {
        this.enable = z;
    }

    private final void createCustomLayout(AttributeSet attrs) {
        TypedArray attributes = getContext().obtainStyledAttributes(attrs, R.styleable.GlobileCheckbox, 0, 0);
        this.enable = attributes.getBoolean(R.styleable.GlobileCheckbox_enabled_checkbox, true);
        this.radioColor = attributes.getInt(R.styleable.GlobileCheckbox_default_color, 0);
        this.text = attributes.getString(R.styleable.GlobileCheckbox_textCheckBox);
        TextView textView = (TextView) _$_findCachedViewById(R.id.text_globile_check_box);
        Intrinsics.checkExpressionValueIsNotNull(textView, "text_globile_check_box");
        textView.setText(this.text);
        enabled(this.enable);
        attributes.recycle();
    }

    public final void changeToSelectedColor() {
        ColorStateList myList = new ColorStateList(new int[][]{new int[]{16842910}, new int[]{-16842910}, new int[]{-16842912}, new int[]{16842912}, new int[]{16842919}}, this.radioColor == 0 ? new int[]{getResources().getColor(R.color.santander_red), getResources().getColor(R.color.santander_red), getResources().getColor(R.color.santander_red), getResources().getColor(R.color.santander_red), getResources().getColor(R.color.santander_red)} : new int[]{getResources().getColor(R.color.turquoise), getResources().getColor(R.color.turquoise), getResources().getColor(R.color.turquoise), getResources().getColor(R.color.turquoise), getResources().getColor(R.color.turquoise)});
        AppCompatCheckBox _$_findCachedViewById = _$_findCachedViewById(R.id.check_globile_check_box);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "check_globile_check_box");
        _$_findCachedViewById.setSupportButtonTintList(myList);
    }

    public final void changeToNormalColor() {
        ColorStateList myList = new ColorStateList(new int[][]{new int[]{16842910}, new int[]{-16842910}, new int[]{-16842912}, new int[]{16842912}, new int[]{16842919}}, new int[]{getResources().getColor(R.color.medium_grey), getResources().getColor(R.color.medium_grey), getResources().getColor(R.color.medium_grey), getResources().getColor(R.color.medium_grey), getResources().getColor(R.color.medium_grey)});
        AppCompatCheckBox _$_findCachedViewById = _$_findCachedViewById(R.id.check_globile_check_box);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "check_globile_check_box");
        _$_findCachedViewById.setSupportButtonTintList(myList);
    }

    /* access modifiers changed from: private */
    public final void checkSelected(boolean checked) {
        if (checked) {
            changeToSelectedColor();
            ((TextView) _$_findCachedViewById(R.id.text_globile_check_box)).setTextColor(getResources().getColor(R.color.grey));
            return;
        }
        changeToNormalColor();
        ((TextView) _$_findCachedViewById(R.id.text_globile_check_box)).setTextColor(getResources().getColor(R.color.medium_grey));
    }

    public final void enabled(boolean enabled) {
        AppCompatCheckBox _$_findCachedViewById = _$_findCachedViewById(R.id.check_globile_check_box);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "check_globile_check_box");
        _$_findCachedViewById.setEnabled(enabled);
        if (!enabled) {
            ((TextView) _$_findCachedViewById(R.id.text_globile_check_box)).setTextColor(getResources().getColor(R.color.light_grey));
        }
    }
}
