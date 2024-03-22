package com.santander.globile.uicomponents.optionselection.dropdown;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.santander.globile.uicomponents.R;
import com.santander.globile.uicomponents.optionselection.dropdown.adapter.GlobileDropdownAdapter;
import com.santander.globile.uicomponents.optionselection.dropdown.data.DropDownData;
import com.santander.globile.uicomponents.optionselection.dropdown.listener.OnItemSelectedListener;
import com.santander.globile.uicomponents.optionselection.dropdown.spinner.GlobileSpinner;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u0007H\u0002J\u0012\u0010:\u001a\u0002082\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010;\u001a\u0004\u0018\u00010<J\u0006\u0010=\u001a\u000208J\u0006\u0010>\u001a\u000208J\u0018\u0010?\u001a\u0002082\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020AH\u0002J8\u0010C\u001a\u000208\"\u0004\b\u0000\u0010D2\u0012\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002HD0G0F2\b\b\u0002\u0010H\u001a\u00020\u00072\f\u0010I\u001a\b\u0012\u0004\u0012\u0002HD0JJ\u0018\u0010K\u001a\u0002082\u0006\u0010L\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\u0007H\u0002J\u000e\u0010N\u001a\u0002082\u0006\u0010O\u001a\u00020\u0007J\u0006\u0010P\u001a\u000208J\u0006\u0010Q\u001a\u000208R$\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\t\u001a\u0004\u0018\u00010\u000f@FX\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0016\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R(\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\t\u001a\u0004\u0018\u00010\u0017@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR(\u0010\u001d\u001a\u0004\u0018\u00010\u00172\b\u0010\t\u001a\u0004\u0018\u00010\u0017@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR(\u0010 \u001a\u0004\u0018\u00010\u00172\b\u0010\t\u001a\u0004\u0018\u00010\u0017@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\u001c\u0010#\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001cR\u000e\u0010&\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u0002\n\u0000R\u0012\u00105\u001a\u0006\u0012\u0002\b\u000306X.¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/santander/globile/uicomponents/optionselection/dropdown/GlobileDropdown;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "dropDownBackroundColor", "getDropDownBackroundColor", "()I", "setDropDownBackroundColor", "(I)V", "", "dropDownItemColor", "getDropDownItemColor", "()Ljava/lang/Boolean;", "setDropDownItemColor", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "dropdownVisibleItemsCount", "", "errorText", "getErrorText", "()Ljava/lang/String;", "setErrorText", "(Ljava/lang/String;)V", "floatingLabelText", "getFloatingLabelText", "setFloatingLabelText", "helperText", "getHelperText", "setHelperText", "hintText", "getHintText", "setHintText", "loading", "mDropdownArrow", "Landroid/widget/ImageView;", "mDropdownBackgroundColorInSelected", "mDropdownPrimaryColorInSelected", "mErrorMessageText", "mErrorMessageTextView", "Landroid/widget/TextView;", "mErrorText", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mFloatingLabelText", "mHelperMessageText", "mHelperMessageTextView", "mSpinner", "Lcom/santander/globile/uicomponents/optionselection/dropdown/spinner/GlobileSpinner;", "mSpinnerAdapter", "Lcom/santander/globile/uicomponents/optionselection/dropdown/adapter/GlobileDropdownAdapter;", "changeBackgroundColor", "", "condition", "createCustomLayout", "getSelectedItem", "", "hideError", "hideHelper", "rotateArrow", "from", "", "to", "setGlobileDropdown", "T", "itemsList", "", "Lcom/santander/globile/uicomponents/optionselection/dropdown/data/DropDownData;", "initialSelectedValue", "selectListener", "Lcom/santander/globile/uicomponents/optionselection/dropdown/listener/OnItemSelectedListener;", "setListViewHeightBasedOnChildren", "itemSize", "itemsToShow", "setSelection", "position", "showError", "showHelper", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileDropdown.kt */
public final class GlobileDropdown extends LinearLayout {
    private HashMap _$_findViewCache;
    private int dropDownBackroundColor;
    private Boolean dropDownItemColor;
    private int dropdownVisibleItemsCount;
    private String errorText;
    private String floatingLabelText;
    private String helperText;
    private String hintText;
    /* access modifiers changed from: private */
    public boolean loading;
    private ImageView mDropdownArrow;
    private int mDropdownBackgroundColorInSelected;
    private int mDropdownPrimaryColorInSelected;
    private String mErrorMessageText;
    private TextView mErrorMessageTextView;
    private ConstraintLayout mErrorText;
    private String mFloatingLabelText;
    private String mHelperMessageText;
    private TextView mHelperMessageTextView;
    private GlobileSpinner mSpinner;
    /* access modifiers changed from: private */
    public GlobileDropdownAdapter<?> mSpinnerAdapter;

    public GlobileDropdown(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public GlobileDropdown(Context context, AttributeSet attributeSet) {
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
    public GlobileDropdown(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.loading = true;
        this.dropdownVisibleItemsCount = 7;
        LayoutInflater.from(context).inflate(R.layout.globile_dropdown, this, true);
        this.mSpinner = (GlobileSpinner) findViewById(R.id.component_spinner);
        this.mDropdownArrow = (ImageView) findViewById(R.id.dropdown_arrow_image);
        ConstraintLayout findViewById = findViewById(R.id.error_layout);
        if (findViewById != null) {
            this.mErrorText = findViewById;
            View findViewById2 = findViewById(R.id.error_text);
            if (findViewById2 != null) {
                this.mErrorMessageTextView = (TextView) findViewById2;
                View findViewById3 = findViewById(R.id.dropdown_helper_text);
                if (findViewById3 != null) {
                    this.mHelperMessageTextView = (TextView) findViewById3;
                    createCustomLayout(attrs);
                    this.dropDownItemColor = true;
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    }

    public static final /* synthetic */ GlobileDropdownAdapter access$getMSpinnerAdapter$p(GlobileDropdown $this) {
        GlobileDropdownAdapter<?> globileDropdownAdapter = $this.mSpinnerAdapter;
        if (globileDropdownAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpinnerAdapter");
        }
        return globileDropdownAdapter;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobileDropdown(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static /* synthetic */ void setGlobileDropdown$default(GlobileDropdown globileDropdown, List list, int i, OnItemSelectedListener onItemSelectedListener, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        globileDropdown.setGlobileDropdown(list, i, onItemSelectedListener);
    }

    public final <T> void setGlobileDropdown(List<DropDownData<T>> itemsList, int initialSelectedValue, OnItemSelectedListener<T> selectListener) {
        Intrinsics.checkParameterIsNotNull(itemsList, "itemsList");
        Intrinsics.checkParameterIsNotNull(selectListener, "selectListener");
        List list = CollectionsKt.toMutableList(itemsList);
        String it = this.hintText;
        if (it != null) {
            list.add(0, new DropDownData(it, (Object) null, 2, (DefaultConstructorMarker) null));
        }
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        this.mSpinnerAdapter = new GlobileDropdown$setGlobileDropdown$2(this, list, context, list);
        GlobileDropdown$setGlobileDropdown$onItemSelectedListener$1 onItemSelectedListener = new GlobileDropdown$setGlobileDropdown$onItemSelectedListener$1(this, initialSelectedValue, itemsList, selectListener, list);
        GlobileSpinner $this$with = (GlobileSpinner) _$_findCachedViewById(R.id.component_spinner);
        GlobileDropdownAdapter<?> globileDropdownAdapter = this.mSpinnerAdapter;
        if (globileDropdownAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpinnerAdapter");
        }
        $this$with.setAdapter(globileDropdownAdapter);
        ((GlobileSpinner) $this$with._$_findCachedViewById(R.id.component_spinner)).setCustomItemSelectedLister(onItemSelectedListener);
        ((GlobileSpinner) $this$with._$_findCachedViewById(R.id.component_spinner)).setDataList(itemsList);
        $this$with.setSpinnerEventsListener(new GlobileDropdown$setGlobileDropdown$$inlined$with$lambda$1(this, onItemSelectedListener, itemsList, initialSelectedValue));
        GlobileDropdownAdapter<?> globileDropdownAdapter2 = this.mSpinnerAdapter;
        if (globileDropdownAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpinnerAdapter");
        }
        globileDropdownAdapter2.setInitialValue(initialSelectedValue);
        GlobileDropdownAdapter<?> globileDropdownAdapter3 = this.mSpinnerAdapter;
        if (globileDropdownAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpinnerAdapter");
        }
        globileDropdownAdapter3.setPrimaryColorInSelected(this.mDropdownPrimaryColorInSelected);
        GlobileDropdownAdapter<?> globileDropdownAdapter4 = this.mSpinnerAdapter;
        if (globileDropdownAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpinnerAdapter");
        }
        globileDropdownAdapter4.setSelected(initialSelectedValue);
        GlobileDropdownAdapter<?> globileDropdownAdapter5 = this.mSpinnerAdapter;
        if (globileDropdownAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpinnerAdapter");
        }
        globileDropdownAdapter5.setFloatingText(this.mFloatingLabelText);
        $this$with.setFloatingText(this.mFloatingLabelText);
        $this$with.setSelection(initialSelectedValue);
        setListViewHeightBasedOnChildren(list.size(), this.dropdownVisibleItemsCount);
    }

    public final void setSelection(int position) {
        GlobileSpinner $this$with = (GlobileSpinner) _$_findCachedViewById(R.id.component_spinner);
        this.loading = false;
        GlobileDropdownAdapter<?> globileDropdownAdapter = this.mSpinnerAdapter;
        if (globileDropdownAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSpinnerAdapter");
        }
        globileDropdownAdapter.setLoading(false);
        $this$with.setSelection(position);
    }

    public final Object getSelectedItem() {
        GlobileSpinner globileSpinner = this.mSpinner;
        if (globileSpinner != null) {
            return globileSpinner.getSelectedItem();
        }
        return null;
    }

    private final void setListViewHeightBasedOnChildren(int itemSize, int itemsToShow) {
        Class spinnerClass;
        if (this.mSpinner instanceof AppCompatSpinner) {
            spinnerClass = AppCompatSpinner.class;
        } else {
            spinnerClass = Spinner.class;
        }
        Field popup = spinnerClass.getDeclaredField("mPopup");
        Intrinsics.checkExpressionValueIsNotNull(popup, "popup");
        popup.setAccessible(true);
        Object obj = popup.get(this.mSpinner);
        if (obj != null) {
            ListPopupWindow popupWindow = (ListPopupWindow) obj;
            int i = itemsToShow + 1;
            if (1 <= i && itemSize >= i) {
                float totalHeight = 0.0f;
                int i2 = (itemSize > itemsToShow ? itemsToShow : itemSize) + 1;
                for (int i3 = 0; i3 < i2; i3++) {
                    Context context = getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context, "context");
                    totalHeight += context.getResources().getDimension(R.dimen.dropdown_item_height);
                }
                popupWindow.setHeight((int) totalHeight);
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.appcompat.widget.ListPopupWindow");
    }

    private final void changeBackgroundColor(int condition) {
        Drawable drawable;
        GlobileSpinner globileSpinner = this.mSpinner;
        if (globileSpinner != null) {
            if (condition == 1) {
                if (Build.VERSION.SDK_INT >= 21) {
                    drawable = getResources().getDrawable(R.drawable.dropdown_background_top_rounded_sky, (Resources.Theme) null);
                } else {
                    drawable = getResources().getDrawable(R.drawable.dropdown_background_top_rounded_sky);
                }
            } else if (Build.VERSION.SDK_INT >= 21) {
                drawable = getResources().getDrawable(R.drawable.dropdown_background_top_rounded_white, (Resources.Theme) null);
            } else {
                drawable = getResources().getDrawable(R.drawable.dropdown_background_top_rounded_white);
            }
            globileSpinner.setBackground(drawable);
        }
    }

    private final void createCustomLayout(AttributeSet attrs) {
        boolean z = false;
        TypedArray attributes = getContext().obtainStyledAttributes(attrs, R.styleable.GlobileDropdown, 0, 0);
        setDropDownBackroundColor(attributes.getInt(R.styleable.GlobileDropdown_dropdownDefaultColor, 0));
        setDropDownItemColor(Boolean.valueOf(attributes.getInt(R.styleable.GlobileDropdown_dropdownItemColor, 0) == 0));
        this.hintText = attributes.getString(R.styleable.GlobileDropdown_dropdownHintText);
        setFloatingLabelText(attributes.getString(R.styleable.GlobileDropdown_dropdownFloatingLabelText));
        setErrorText(attributes.getString(R.styleable.GlobileDropdown_dropdownErrorMessageText));
        setHelperText(attributes.getString(R.styleable.GlobileDropdown_dropdownHelperMessageText));
        this.dropdownVisibleItemsCount = attributes.getInt(R.styleable.GlobileDropdown_dropdownVisibleItemsCount, 7);
        if (Build.VERSION.SDK_INT < 23) {
            TextView textView = this.mErrorMessageTextView;
            if (textView != null) {
                textView.setTextAppearance(getContext(), R.style.GlobileDropdownStyleTextAppearance);
            }
            TextView textView2 = this.mHelperMessageTextView;
            if (textView2 != null) {
                textView2.setTextAppearance(getContext(), R.style.GlobileDropdownStyleTextAppearance);
            }
        } else {
            TextView textView3 = this.mErrorMessageTextView;
            if (textView3 != null) {
                textView3.setTextAppearance(R.style.GlobileDropdownStyleTextAppearance);
            }
            TextView textView4 = this.mHelperMessageTextView;
            if (textView4 != null) {
                textView4.setTextAppearance(R.style.GlobileDropdownStyleTextAppearance);
            }
        }
        CharSequence charSequence = this.mHelperMessageText;
        if (charSequence == null || charSequence.length() == 0) {
            hideHelper();
        } else {
            showHelper();
        }
        CharSequence charSequence2 = this.hintText;
        if (charSequence2 == null || charSequence2.length() == 0) {
            z = true;
        }
        if (z) {
            this.hintText = getResources().getString(R.string.dropdown_default_placeholder);
        }
        attributes.recycle();
    }

    /* access modifiers changed from: private */
    public final void rotateArrow(float from, float to) {
        RotateAnimation animation = new RotateAnimation(from, to, 1, 0.5f, 1, 0.5f);
        animation.setDuration(200);
        animation.setFillAfter(true);
        ImageView imageView = this.mDropdownArrow;
        if (imageView != null) {
            imageView.startAnimation(animation);
        }
    }

    public final void showHelper() {
        ConstraintLayout constraintLayout = this.mErrorText;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(4);
        }
        TextView textView = this.mHelperMessageTextView;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }

    public final void hideHelper() {
        TextView textView = this.mHelperMessageTextView;
        if (textView != null) {
            textView.setVisibility(4);
        }
    }

    public final void showError() {
        TextView textView = this.mHelperMessageTextView;
        if (textView != null) {
            textView.setVisibility(4);
        }
        ConstraintLayout constraintLayout = this.mErrorText;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
    }

    public final void hideError() {
        ConstraintLayout constraintLayout = this.mErrorText;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(4);
        }
    }

    public final Boolean getDropDownItemColor() {
        return this.dropDownItemColor;
    }

    public final void setDropDownItemColor(Boolean value) {
        this.mDropdownPrimaryColorInSelected = (Intrinsics.areEqual((Object) value, (Object) false) ^ true) ^ true ? 1 : 0;
        GlobileSpinner globileSpinner = (GlobileSpinner) _$_findCachedViewById(R.id.component_spinner);
        Intrinsics.checkExpressionValueIsNotNull(globileSpinner, "component_spinner");
        SpinnerAdapter adapter = globileSpinner.getAdapter();
        if (!(adapter instanceof GlobileDropdownAdapter)) {
            adapter = null;
        }
        GlobileDropdownAdapter globileDropdownAdapter = (GlobileDropdownAdapter) adapter;
        if (globileDropdownAdapter != null) {
            globileDropdownAdapter.setPrimaryColorInSelected((Intrinsics.areEqual((Object) value, (Object) false) ^ true) ^ true ? 1 : 0);
        }
    }

    public final int getDropDownBackroundColor() {
        return this.dropDownBackroundColor;
    }

    public final void setDropDownBackroundColor(int value) {
        changeBackgroundColor(value);
    }

    public final String getHintText() {
        return this.hintText;
    }

    public final void setHintText(String str) {
        this.hintText = str;
    }

    public final String getFloatingLabelText() {
        return this.floatingLabelText;
    }

    public final void setFloatingLabelText(String value) {
        this.mFloatingLabelText = value;
        GlobileSpinner globileSpinner = (GlobileSpinner) _$_findCachedViewById(R.id.component_spinner);
        Intrinsics.checkExpressionValueIsNotNull(globileSpinner, "component_spinner");
        SpinnerAdapter adapter = globileSpinner.getAdapter();
        if (!(adapter instanceof GlobileDropdownAdapter)) {
            adapter = null;
        }
        GlobileDropdownAdapter globileDropdownAdapter = (GlobileDropdownAdapter) adapter;
        if (globileDropdownAdapter != null) {
            globileDropdownAdapter.setFloatingText(value);
        }
    }

    public final String getErrorText() {
        return this.errorText;
    }

    public final void setErrorText(String value) {
        this.mErrorMessageText = value;
        TextView textView = this.mErrorMessageTextView;
        if (textView != null) {
            textView.setText(getContext().getString(R.string.error_string) + value);
        }
    }

    public final String getHelperText() {
        return this.helperText;
    }

    public final void setHelperText(String value) {
        this.mHelperMessageText = value;
        TextView textView = this.mHelperMessageTextView;
        if (textView != null) {
            textView.setText(value);
        }
    }
}
