package com.santander.globile.uicomponents.optionselection.dropdown.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.santander.globile.uicomponents.R;
import com.santander.globile.uicomponents.optionselection.dropdown.data.DropDownData;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0007¢\u0006\u0002\u0010\bJ\b\u0010%\u001a\u00020\u001bH\u0016J\"\u0010&\u001a\u00020$2\u0006\u0010'\u001a\u00020\u001b2\b\u0010(\u001a\u0004\u0018\u00010$2\u0006\u0010)\u001a\u00020*H\u0016J\u0006\u0010+\u001a\u00020\u001bJ\"\u0010,\u001a\u00020$2\u0006\u0010'\u001a\u00020\u001b2\b\u0010(\u001a\u0004\u0018\u00010$2\u0006\u0010)\u001a\u00020*H\u0016J\u001a\u0010-\u001a\u00020$2\u0006\u0010'\u001a\u00020\u001b2\b\u0010(\u001a\u0004\u0018\u00010$H\u0002J\u001a\u0010.\u001a\u00020$2\u0006\u0010'\u001a\u00020\u001b2\b\u0010(\u001a\u0004\u0018\u00010$H\u0002J\u0006\u0010/\u001a\u000200J\u000e\u00101\u001a\u0002002\u0006\u0010'\u001a\u00020\u001bJ\u000e\u00102\u001a\u0002002\u0006\u0010'\u001a\u00020\u001bR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/santander/globile/uicomponents/optionselection/dropdown/adapter/GlobileDropdownAdapter;", "T", "Landroid/widget/ArrayAdapter;", "Lcom/santander/globile/uicomponents/optionselection/dropdown/data/DropDownData;", "context", "Landroid/content/Context;", "itemsList", "", "(Landroid/content/Context;Ljava/util/List;)V", "adapterInitialized", "", "floatingLabel", "Landroid/widget/TextView;", "floatingText", "", "getFloatingText", "()Ljava/lang/String;", "setFloatingText", "(Ljava/lang/String;)V", "getItemsList", "()Ljava/util/List;", "loading", "getLoading", "()Z", "setLoading", "(Z)V", "mInitialValue", "", "mSelectedItem", "primaryColorInSelected", "getPrimaryColorInSelected", "()I", "setPrimaryColorInSelected", "(I)V", "selectText", "selectView", "Landroid/view/View;", "getCount", "getDropDownView", "position", "convertView", "parent", "Landroid/view/ViewGroup;", "getSelectedItem", "getView", "initDropdownView", "initSelectView", "setFloatingLabel", "", "setInitialValue", "setSelected", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileDropdownAdapter.kt */
public abstract class GlobileDropdownAdapter<T> extends ArrayAdapter<DropDownData<T>> {
    private boolean adapterInitialized;
    private TextView floatingLabel;
    private String floatingText;
    private final List<DropDownData<T>> itemsList;
    private boolean loading = true;
    private int mInitialValue;
    private int mSelectedItem;
    private int primaryColorInSelected;
    private TextView selectText;
    private View selectView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobileDropdownAdapter(Context context, List<DropDownData<T>> itemsList2) {
        super(context, R.layout.globile_dropdown_item, itemsList2);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(itemsList2, "itemsList");
        this.itemsList = itemsList2;
    }

    public final List<DropDownData<T>> getItemsList() {
        return this.itemsList;
    }

    public final boolean getLoading() {
        return this.loading;
    }

    public final void setLoading(boolean z) {
        this.loading = z;
    }

    public final int getPrimaryColorInSelected() {
        return this.primaryColorInSelected;
    }

    public final void setPrimaryColorInSelected(int i) {
        this.primaryColorInSelected = i;
    }

    public final String getFloatingText() {
        return this.floatingText;
    }

    public final void setFloatingText(String str) {
        this.floatingText = str;
    }

    public final void setSelected(int position) {
        if (this.adapterInitialized) {
            this.mSelectedItem = position;
            return;
        }
        this.mSelectedItem = this.mInitialValue;
        this.adapterInitialized = true;
    }

    public final int getSelectedItem() {
        return this.mSelectedItem;
    }

    public final void setInitialValue(int position) {
        this.mInitialValue = position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Intrinsics.checkParameterIsNotNull(parent, "parent");
        int index = position;
        if (!this.loading || this.mInitialValue > -1) {
            index++;
        }
        return initSelectView(index, convertView);
    }

    private final View initSelectView(int position, View convertView) {
        String str;
        if (this.adapterInitialized) {
            this.mSelectedItem = position;
        }
        this.selectView = convertView;
        View view = null;
        if (convertView == null) {
            this.selectView = View.inflate(getContext(), R.layout.globile_dropdown_selector, (ViewGroup) null);
        }
        View view2 = this.selectView;
        View findViewById = view2 != null ? view2.findViewById(R.id.floating_label) : null;
        if (findViewById != null) {
            this.floatingLabel = (TextView) findViewById;
            View view3 = this.selectView;
            if (view3 != null) {
                view = view3.findViewById(R.id.selected_text);
            }
            if (view != null) {
                this.selectText = (TextView) view;
                if (Build.VERSION.SDK_INT < 23) {
                    TextView textView = this.floatingLabel;
                    if (textView != null) {
                        textView.setTextAppearance(getContext(), R.style.GlobileDropdownStyleTextAppearance);
                    }
                    TextView textView2 = this.selectText;
                    if (textView2 != null) {
                        textView2.setTextAppearance(getContext(), R.style.GlobileDropdownStyleTextAppearance);
                    }
                } else {
                    TextView textView3 = this.floatingLabel;
                    if (textView3 != null) {
                        textView3.setTextAppearance(R.style.GlobileDropdownStyleTextAppearance);
                    }
                    TextView textView4 = this.selectText;
                    if (textView4 != null) {
                        textView4.setTextAppearance(R.style.GlobileDropdownStyleTextAppearance);
                    }
                }
                TextView textView5 = this.selectText;
                if (textView5 != null) {
                    Context context = getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context, "context");
                    textView5.setTextColor(context.getResources().getColor(R.color.grey));
                }
                TextView textView6 = this.selectText;
                if (textView6 != null) {
                    DropDownData dropDownData = (DropDownData) getItem(position);
                    if (dropDownData == null || (str = dropDownData.getKey()) == null) {
                        str = "";
                    }
                    textView6.setText(str);
                }
                setFloatingLabel();
                this.loading = false;
                View view4 = this.selectView;
                if (view4 == null) {
                    Intrinsics.throwNpe();
                }
                return view4;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
    }

    public int getCount() {
        int count = super.getCount();
        return count > 0 ? count - 1 : count;
    }

    public final void setFloatingLabel() {
        if (this.mSelectedItem == this.itemsList.size()) {
            TextView textView = this.floatingLabel;
            if (textView != null) {
                textView.setVisibility(8);
            }
            TextView textView2 = this.selectText;
            if (textView2 != null) {
                Context context = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "context");
                textView2.setTextColor(context.getResources().getColor(R.color.medium_grey));
                return;
            }
            return;
        }
        TextView textView3 = this.selectText;
        if (textView3 != null) {
            Context context2 = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context2, "context");
            textView3.setTextColor(context2.getResources().getColor(R.color.grey));
        }
        CharSequence charSequence = this.floatingText;
        if ((charSequence == null || charSequence.length() == 0) || (this.loading && this.mInitialValue <= -1)) {
            TextView textView4 = this.floatingLabel;
            if (textView4 != null) {
                textView4.setVisibility(8);
                return;
            }
            return;
        }
        TextView textView5 = this.floatingLabel;
        if (textView5 != null) {
            textView5.setText(this.floatingText);
        }
        TextView textView6 = this.floatingLabel;
        if (textView6 != null) {
            textView6.setVisibility(0);
        }
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        Intrinsics.checkParameterIsNotNull(parent, "parent");
        return initDropdownView(position + 1, convertView);
    }

    private final View initDropdownView(int position, View convertView) {
        String str;
        Drawable backgroundDrawable;
        View view = convertView;
        if (view == null) {
            view = View.inflate(getContext(), R.layout.globile_dropdown_item, (ViewGroup) null);
        }
        if (view == null) {
            Intrinsics.throwNpe();
        }
        View findViewById = view.findViewById(R.id.dropdown_item_text);
        if (findViewById != null) {
            TextView tvText1 = (TextView) findViewById;
            if (Build.VERSION.SDK_INT < 23) {
                tvText1.setTextAppearance(getContext(), R.style.GlobileDropdownStyleTextAppearance);
            } else {
                tvText1.setTextAppearance(R.style.GlobileDropdownStyleTextAppearance);
            }
            DropDownData dropDownData = (DropDownData) getItem(position);
            if (dropDownData == null || (str = dropDownData.getKey()) == null) {
                str = "";
            }
            tvText1.setText(str);
            if (position == this.itemsList.size()) {
                Context context = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "context");
                tvText1.setBackgroundColor(context.getResources().getColor(R.color.dropdown_list_item_background));
                Context context2 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context2, "context");
                tvText1.setTextColor(context2.getResources().getColor(R.color.medium_grey));
            } else if (position == this.mSelectedItem) {
                if (this.primaryColorInSelected == 0) {
                    Context context3 = getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context3, "context");
                    backgroundDrawable = context3.getResources().getDrawable(R.drawable.dropdown_item_red_background);
                } else {
                    Context context4 = getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context4, "context");
                    backgroundDrawable = context4.getResources().getDrawable(R.drawable.dropdown_item_turquoise_background);
                }
                tvText1.setBackground(backgroundDrawable);
                Context context5 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context5, "context");
                tvText1.setTextColor(context5.getResources().getColor(R.color.white));
            } else {
                Context context6 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context6, "context");
                tvText1.setBackgroundColor(context6.getResources().getColor(R.color.dropdown_list_item_background));
                Context context7 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context7, "context");
                tvText1.setTextColor(context7.getResources().getColor(R.color.grey));
            }
            return view;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
    }
}
