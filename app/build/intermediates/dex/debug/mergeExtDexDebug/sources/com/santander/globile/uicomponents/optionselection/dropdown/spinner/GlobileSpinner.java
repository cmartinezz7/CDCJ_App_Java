package com.santander.globile.uicomponents.optionselection.dropdown.spinner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatSpinner;
import com.santander.globile.uicomponents.R;
import com.santander.globile.uicomponents.optionselection.dropdown.data.DropDownData;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001/B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\"\u001a\u00020!J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020!H\u0016J\b\u0010&\u001a\u00020!H\u0016J\u0006\u0010'\u001a\u00020$J\u000e\u0010(\u001a\u00020$2\u0006\u0010\u0018\u001a\u00020\u0019J \u0010)\u001a\u00020$\"\u0004\b\u0000\u0010*2\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H*0\u00110\u0010J\u0010\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020\u0007H\u0016J\u000e\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020\u001fR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0011\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/santander/globile/uicomponents/optionselection/dropdown/spinner/GlobileSpinner;", "Landroidx/appcompat/widget/AppCompatSpinner;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "floatingText", "", "getFloatingText", "()Ljava/lang/String;", "setFloatingText", "(Ljava/lang/String;)V", "itemsList", "", "Lcom/santander/globile/uicomponents/optionselection/dropdown/data/DropDownData;", "lastId", "", "lastParent", "Landroid/widget/AdapterView;", "lastView", "Landroid/view/View;", "listener", "Landroid/widget/AdapterView$OnItemSelectedListener;", "getListener", "()Landroid/widget/AdapterView$OnItemSelectedListener;", "setListener", "(Landroid/widget/AdapterView$OnItemSelectedListener;)V", "mListener", "Lcom/santander/globile/uicomponents/optionselection/dropdown/spinner/GlobileSpinner$OnSpinnerEventsListener;", "mOpenInitiated", "", "hasBeenOpened", "onWindowFocusChanged", "", "hasWindowFocus", "performClick", "performClosedEvent", "setCustomItemSelectedLister", "setDataList", "T", "setSelection", "position", "setSpinnerEventsListener", "onSpinnerEventsListener", "OnSpinnerEventsListener", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileSpinner.kt */
public final class GlobileSpinner extends AppCompatSpinner {
    private HashMap _$_findViewCache;
    private String floatingText;
    private List<? extends DropDownData<?>> itemsList;
    /* access modifiers changed from: private */
    public long lastId;
    /* access modifiers changed from: private */
    public AdapterView<?> lastParent;
    /* access modifiers changed from: private */
    public View lastView;
    private AdapterView.OnItemSelectedListener listener;
    private OnSpinnerEventsListener mListener;
    private boolean mOpenInitiated;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/santander/globile/uicomponents/optionselection/dropdown/spinner/GlobileSpinner$OnSpinnerEventsListener;", "", "onSpinnerClosed", "", "onSpinnerOpened", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
    /* compiled from: GlobileSpinner.kt */
    public interface OnSpinnerEventsListener {
        void onSpinnerClosed();

        void onSpinnerOpened();
    }

    public GlobileSpinner(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public GlobileSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.santander.globile.uicomponents.optionselection.dropdown.spinner.GlobileSpinner, android.view.View] */
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
    public GlobileSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.floatingText = "";
        GlobileSpinner.super.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(this) {
            final /* synthetic */ GlobileSpinner this$0;

            {
                this.this$0 = $outer;
            }

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Intrinsics.checkParameterIsNotNull(parent, "parent");
                this.this$0.lastParent = parent;
                this.this$0.lastView = view;
                this.this$0.lastId = id;
                AdapterView.OnItemSelectedListener listener = this.this$0.getListener();
                if (listener != null) {
                    listener.onItemSelected(parent, view, position, id);
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
                Intrinsics.checkParameterIsNotNull(parent, "parent");
                AdapterView.OnItemSelectedListener listener = this.this$0.getListener();
                if (listener != null) {
                    listener.onNothingSelected(parent);
                }
            }
        });
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobileSpinner(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final AdapterView.OnItemSelectedListener getListener() {
        return this.listener;
    }

    public final void setListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.listener = onItemSelectedListener;
    }

    public final String getFloatingText() {
        return this.floatingText;
    }

    public final void setFloatingText(String str) {
        this.floatingText = str;
    }

    public void setSelection(int position) {
        String str;
        DropDownData dropDownData;
        if (position == getSelectedItemPosition()) {
            View view = this.lastView;
            View view2 = null;
            TextView floatingLabel = (TextView) (view != null ? view.findViewById(R.id.floating_label) : null);
            View view3 = this.lastView;
            if (view3 != null) {
                view2 = view3.findViewById(R.id.selected_text);
            }
            TextView selectText = (TextView) view2;
            if (floatingLabel != null) {
                floatingLabel.setText(this.floatingText);
            }
            if (floatingLabel != null) {
                floatingLabel.setVisibility(0);
            }
            if (selectText != null) {
                List<? extends DropDownData<?>> list = this.itemsList;
                if (list == null || (dropDownData = (DropDownData) list.get(position)) == null || (str = dropDownData.getKey()) == null) {
                    str = "";
                }
                selectText.setText(str);
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.listener;
            if (onItemSelectedListener != null) {
                onItemSelectedListener.onItemSelected(this.lastParent, this.lastView, position, this.lastId);
            }
        }
        GlobileSpinner.super.setSelection(position);
    }

    public final <T> void setDataList(List<DropDownData<T>> itemsList2) {
        Intrinsics.checkParameterIsNotNull(itemsList2, "itemsList");
        this.itemsList = itemsList2;
    }

    public boolean performClick() {
        this.mOpenInitiated = true;
        OnSpinnerEventsListener onSpinnerEventsListener = this.mListener;
        if (onSpinnerEventsListener != null) {
            if (onSpinnerEventsListener == null) {
                Intrinsics.throwNpe();
            }
            onSpinnerEventsListener.onSpinnerOpened();
        }
        return GlobileSpinner.super.performClick();
    }

    public final void setSpinnerEventsListener(OnSpinnerEventsListener onSpinnerEventsListener) {
        Intrinsics.checkParameterIsNotNull(onSpinnerEventsListener, "onSpinnerEventsListener");
        this.mListener = onSpinnerEventsListener;
    }

    public final void setCustomItemSelectedLister(AdapterView.OnItemSelectedListener listener2) {
        Intrinsics.checkParameterIsNotNull(listener2, "listener");
        this.listener = listener2;
    }

    public final void performClosedEvent() {
        this.mOpenInitiated = false;
        OnSpinnerEventsListener onSpinnerEventsListener = this.mListener;
        if (onSpinnerEventsListener != null) {
            if (onSpinnerEventsListener == null) {
                Intrinsics.throwNpe();
            }
            onSpinnerEventsListener.onSpinnerClosed();
        }
    }

    public final boolean hasBeenOpened() {
        return this.mOpenInitiated;
    }

    public void onWindowFocusChanged(boolean hasWindowFocus) {
        GlobileSpinner.super.onWindowFocusChanged(hasWindowFocus);
        if (hasBeenOpened() && hasWindowFocus) {
            performClosedEvent();
        }
    }
}
