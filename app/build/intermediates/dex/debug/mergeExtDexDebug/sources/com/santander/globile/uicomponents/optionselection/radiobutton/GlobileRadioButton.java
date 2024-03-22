package com.santander.globile.uicomponents.optionselection.radiobutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatRadioButton;
import com.santander.globile.uicomponents.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000e\u001a\u00020\u000fH\u0007J\b\u0010\u0010\u001a\u00020\u000fH\u0007J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0003R\u001a\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/santander/globile/uicomponents/optionselection/radiobutton/GlobileRadioButton;", "Landroidx/appcompat/widget/AppCompatRadioButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "radioColor", "getRadioColor", "()I", "setRadioColor", "(I)V", "changeToNormalColor", "", "changeToSelectedColor", "checkSelected", "checked", "", "createCustomLayout", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileRadioButton.kt */
public final class GlobileRadioButton extends AppCompatRadioButton {
    private HashMap _$_findViewCache;
    private int radioColor;

    public GlobileRadioButton(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public GlobileRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [android.view.View, com.santander.globile.uicomponents.optionselection.radiobutton.GlobileRadioButton] */
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
    public GlobileRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkParameterIsNotNull(context, "context");
        createCustomLayout(attrs);
        checkSelected(isChecked());
        setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) {
            final /* synthetic */ GlobileRadioButton this$0;

            {
                this.this$0 = r1;
            }

            public final void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                this.this$0.checkSelected(isChecked);
            }
        });
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobileRadioButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final int getRadioColor() {
        return this.radioColor;
    }

    public final void setRadioColor(int i) {
        this.radioColor = i;
    }

    private final void createCustomLayout(AttributeSet attrs) {
        TypedArray attributes = getContext().obtainStyledAttributes(attrs, R.styleable.GlobileRadioButton, 0, 0);
        this.radioColor = attributes.getInt(R.styleable.GlobileRadioButton_default_color, 0);
        attributes.recycle();
    }

    public final void changeToSelectedColor() {
        setSupportButtonTintList(new ColorStateList(new int[][]{new int[]{16842910}, new int[]{-16842910}, new int[]{-16842912}, new int[]{16842912}, new int[]{16842919}}, this.radioColor == 0 ? new int[]{getResources().getColor(R.color.santander_red), getResources().getColor(R.color.santander_red), getResources().getColor(R.color.santander_red), getResources().getColor(R.color.santander_red), getResources().getColor(R.color.santander_red)} : new int[]{getResources().getColor(R.color.turquoise), getResources().getColor(R.color.turquoise), getResources().getColor(R.color.turquoise), getResources().getColor(R.color.turquoise), getResources().getColor(R.color.turquoise)}));
    }

    public final void changeToNormalColor() {
        setSupportButtonTintList(new ColorStateList(new int[][]{new int[]{16842910}, new int[]{-16842910}, new int[]{-16842912}, new int[]{16842912}, new int[]{16842919}}, new int[]{getResources().getColor(R.color.medium_grey), getResources().getColor(R.color.medium_grey), getResources().getColor(R.color.medium_grey), getResources().getColor(R.color.medium_grey), getResources().getColor(R.color.medium_grey)}));
    }

    /* access modifiers changed from: private */
    public final void checkSelected(boolean checked) {
        if (checked) {
            changeToSelectedColor();
        } else {
            changeToNormalColor();
        }
    }
}
