package com.santander.globile.uicomponents.optionselection.buttonselector;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.santander.globile.uicomponents.R;
import com.santander.globile.uicomponents.buttons.GlobileButton;
import com.santander.globile.uicomponents.common.GlobileButtonSelectorPosition;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001)B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010&\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0012\u0010'\u001a\u00020\"2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010(\u001a\u00020\"H\u0002R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006*"}, d2 = {"Lcom/santander/globile/uicomponents/optionselection/buttonselector/GlobileButtonSpreadSelector;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "buttonCenter", "Lcom/santander/globile/uicomponents/buttons/GlobileButton;", "getButtonCenter", "()Lcom/santander/globile/uicomponents/buttons/GlobileButton;", "setButtonCenter", "(Lcom/santander/globile/uicomponents/buttons/GlobileButton;)V", "buttonCenterText", "", "buttonLeft", "getButtonLeft", "setButtonLeft", "buttonLeftText", "buttonRight", "getButtonRight", "setButtonRight", "buttonRightText", "buttonType", "defaultSelection", "globileButtonSelectorListener", "Lcom/santander/globile/uicomponents/optionselection/buttonselector/GlobileButtonSpreadSelector$GlobileButtonSelectorListener;", "getGlobileButtonSelectorListener", "()Lcom/santander/globile/uicomponents/optionselection/buttonselector/GlobileButtonSpreadSelector$GlobileButtonSelectorListener;", "setGlobileButtonSelectorListener", "(Lcom/santander/globile/uicomponents/optionselection/buttonselector/GlobileButtonSpreadSelector$GlobileButtonSelectorListener;)V", "buttonCenterClick", "", "v", "Landroid/view/View;", "buttonLeftClick", "buttonRightClick", "createCustomLayout", "noSelection", "GlobileButtonSelectorListener", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileButtonSpreadSelector.kt */
public final class GlobileButtonSpreadSelector extends LinearLayout {
    private HashMap _$_findViewCache;
    private GlobileButton buttonCenter;
    private String buttonCenterText;
    private GlobileButton buttonLeft;
    private String buttonLeftText;
    private GlobileButton buttonRight;
    private String buttonRightText;
    private int buttonType;
    private int defaultSelection;
    private GlobileButtonSelectorListener globileButtonSelectorListener;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/santander/globile/uicomponents/optionselection/buttonselector/GlobileButtonSpreadSelector$GlobileButtonSelectorListener;", "", "onSelection", "", "code", "Lcom/santander/globile/uicomponents/common/GlobileButtonSelectorPosition;", "appCompatButton", "Landroid/view/View;", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
    /* compiled from: GlobileButtonSpreadSelector.kt */
    public interface GlobileButtonSelectorListener {
        void onSelection(GlobileButtonSelectorPosition globileButtonSelectorPosition, View view);
    }

    public GlobileButtonSpreadSelector(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public GlobileButtonSpreadSelector(Context context, AttributeSet attributeSet) {
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
    public GlobileButtonSpreadSelector(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.defaultSelection = -1;
        LayoutInflater.from(context).inflate(R.layout.globile_button_selector_spread, this, true);
        GlobileButton globileButton = (GlobileButton) _$_findCachedViewById(R.id.globile_button_selector_left);
        Intrinsics.checkExpressionValueIsNotNull(globileButton, "globile_button_selector_left");
        this.buttonLeft = globileButton;
        GlobileButton globileButton2 = (GlobileButton) _$_findCachedViewById(R.id.globile_button_selector_center);
        Intrinsics.checkExpressionValueIsNotNull(globileButton2, "globile_button_selector_center");
        this.buttonCenter = globileButton2;
        GlobileButton globileButton3 = (GlobileButton) _$_findCachedViewById(R.id.globile_button_selector_right);
        Intrinsics.checkExpressionValueIsNotNull(globileButton3, "globile_button_selector_right");
        this.buttonRight = globileButton3;
        createCustomLayout(attrs);
        this.buttonLeft.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ GlobileButtonSpreadSelector this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                GlobileButtonSpreadSelector globileButtonSpreadSelector = this.this$0;
                Intrinsics.checkExpressionValueIsNotNull(view, "view");
                globileButtonSpreadSelector.buttonLeftClick(view);
            }
        });
        this.buttonCenter.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ GlobileButtonSpreadSelector this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                GlobileButtonSpreadSelector globileButtonSpreadSelector = this.this$0;
                Intrinsics.checkExpressionValueIsNotNull(view, "view");
                globileButtonSpreadSelector.buttonCenterClick(view);
            }
        });
        this.buttonRight.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ GlobileButtonSpreadSelector this$0;

            {
                this.this$0 = r1;
            }

            public final void onClick(View view) {
                GlobileButtonSpreadSelector globileButtonSpreadSelector = this.this$0;
                Intrinsics.checkExpressionValueIsNotNull(view, "view");
                globileButtonSpreadSelector.buttonRightClick(view);
            }
        });
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobileButtonSpreadSelector(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final GlobileButton getButtonLeft() {
        return this.buttonLeft;
    }

    public final void setButtonLeft(GlobileButton globileButton) {
        Intrinsics.checkParameterIsNotNull(globileButton, "<set-?>");
        this.buttonLeft = globileButton;
    }

    public final GlobileButton getButtonCenter() {
        return this.buttonCenter;
    }

    public final void setButtonCenter(GlobileButton globileButton) {
        Intrinsics.checkParameterIsNotNull(globileButton, "<set-?>");
        this.buttonCenter = globileButton;
    }

    public final GlobileButton getButtonRight() {
        return this.buttonRight;
    }

    public final void setButtonRight(GlobileButton globileButton) {
        Intrinsics.checkParameterIsNotNull(globileButton, "<set-?>");
        this.buttonRight = globileButton;
    }

    public final GlobileButtonSelectorListener getGlobileButtonSelectorListener() {
        return this.globileButtonSelectorListener;
    }

    public final void setGlobileButtonSelectorListener(GlobileButtonSelectorListener globileButtonSelectorListener2) {
        this.globileButtonSelectorListener = globileButtonSelectorListener2;
    }

    private final void createCustomLayout(AttributeSet attrs) {
        TypedArray attributes = getContext().obtainStyledAttributes(attrs, R.styleable.GlobileButtonSelector, 0, 0);
        this.buttonType = attributes.getInt(R.styleable.GlobileButtonSelector_optionsCount, 0);
        this.defaultSelection = attributes.getInt(R.styleable.GlobileButtonSelector_defaultSelector, -1);
        this.buttonRightText = attributes.getString(R.styleable.GlobileButtonSelector_buttonRightText);
        this.buttonCenterText = attributes.getString(R.styleable.GlobileButtonSelector_buttonCenterText);
        this.buttonLeftText = attributes.getString(R.styleable.GlobileButtonSelector_buttonLeftText);
        String it = this.buttonRightText;
        if (it != null) {
            this.buttonRight.setText(it);
        }
        String it2 = this.buttonCenterText;
        if (it2 != null) {
            this.buttonCenter.setText(it2);
        }
        String it3 = this.buttonLeftText;
        if (it3 != null) {
            this.buttonLeft.setText(it3);
        }
        if (this.buttonType > 0) {
            this.buttonCenter.setVisibility(0);
        } else {
            this.buttonCenter.setVisibility(8);
        }
        int i = this.defaultSelection;
        if (i == -1) {
            noSelection();
        } else if (i == 0) {
            buttonLeftClick((View) this.buttonLeft);
        } else if (i == 1) {
            buttonCenterClick((View) this.buttonCenter);
        } else if (i == 2) {
            buttonRightClick((View) this.buttonRight);
        }
        attributes.recycle();
    }

    private final void noSelection() {
        this.buttonLeft.setSelected(false);
        this.buttonCenter.setSelected(false);
        this.buttonRight.setSelected(false);
        this.buttonLeft.setTypeface(Typeface.DEFAULT);
        this.buttonCenter.setTypeface(Typeface.DEFAULT);
        this.buttonRight.setTypeface(Typeface.DEFAULT);
    }

    /* access modifiers changed from: private */
    public final void buttonLeftClick(View v) {
        this.buttonLeft.setSelected(true);
        this.buttonCenter.setSelected(false);
        this.buttonRight.setSelected(false);
        this.buttonLeft.setTypeface(Typeface.DEFAULT_BOLD);
        this.buttonCenter.setTypeface(Typeface.DEFAULT);
        this.buttonRight.setTypeface(Typeface.DEFAULT);
        GlobileButtonSelectorListener globileButtonSelectorListener2 = this.globileButtonSelectorListener;
        if (globileButtonSelectorListener2 != null) {
            globileButtonSelectorListener2.onSelection(GlobileButtonSelectorPosition.LEFT, v);
        }
    }

    /* access modifiers changed from: private */
    public final void buttonCenterClick(View v) {
        this.buttonLeft.setSelected(false);
        this.buttonCenter.setSelected(true);
        this.buttonRight.setSelected(false);
        GlobileButtonSelectorListener globileButtonSelectorListener2 = this.globileButtonSelectorListener;
        if (globileButtonSelectorListener2 != null) {
            globileButtonSelectorListener2.onSelection(GlobileButtonSelectorPosition.CENTER, v);
        }
        this.buttonLeft.setTypeface(Typeface.DEFAULT);
        this.buttonCenter.setTypeface(Typeface.DEFAULT_BOLD);
        this.buttonRight.setTypeface(Typeface.DEFAULT);
    }

    /* access modifiers changed from: private */
    public final void buttonRightClick(View v) {
        this.buttonCenter.setSelected(this.buttonType <= 0);
        this.buttonRight.setSelected(true);
        this.buttonLeft.setSelected(false);
        GlobileButtonSelectorListener globileButtonSelectorListener2 = this.globileButtonSelectorListener;
        if (globileButtonSelectorListener2 != null) {
            globileButtonSelectorListener2.onSelection(GlobileButtonSelectorPosition.RIGHT, v);
        }
        this.buttonLeft.setTypeface(Typeface.DEFAULT);
        this.buttonCenter.setTypeface(Typeface.DEFAULT);
        this.buttonRight.setTypeface(Typeface.DEFAULT_BOLD);
    }
}
