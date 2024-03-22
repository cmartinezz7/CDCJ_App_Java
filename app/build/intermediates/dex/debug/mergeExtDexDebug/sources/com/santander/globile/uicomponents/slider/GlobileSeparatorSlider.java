package com.santander.globile.uicomponents.slider;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.santander.globile.uicomponents.R;
import com.santander.globile.uicomponents.common.UIComponentConstants;
import com.santander.globile.uicomponents.common.exceptions.InvalidIntervalException;
import com.santander.globile.uicomponents.text.SantanderTextView;
import io.apptik.widget.MultiSlider;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0007H\u0002J\b\u00108\u001a\u000206H\u0002J\u0010\u00109\u001a\u0002062\u0006\u0010:\u001a\u00020\u0007H\u0002J\u0018\u0010;\u001a\u0002062\u0006\u00107\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u0007H\u0002J\u0018\u0010<\u001a\u0002062\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0007H\u0002J\u0012\u0010@\u001a\u0002062\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010A\u001a\u0002062\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010B\u001a\u00020>H\u0002J\u0012\u0010C\u001a\u0004\u0018\u00010 2\u0006\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010D\u001a\u00020\u0007H\u0002J&\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J\n\u0010H\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010I\u001a\u00020\u0007H\u0002J\u0006\u0010J\u001a\u00020KJ\u0015\u0010L\u001a\u0004\u0018\u00010\u00072\u0006\u0010M\u001a\u00020\u0007¢\u0006\u0002\u0010NJ\u0018\u0010O\u001a\u00020\u001a2\u0006\u0010G\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J0\u0010P\u001a\u0002062\u0006\u0010Q\u001a\u00020\u001a2\u0006\u0010R\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\u00072\u0006\u0010U\u001a\u00020\u0007H\u0014J\u0018\u0010V\u001a\u0002062\u0006\u0010W\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\u0007H\u0014J\u0010\u0010Y\u001a\u0002062\u0006\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010Z\u001a\u000206H\u0002J\u001e\u0010[\u001a\u0002062\u0006\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007J\u0016\u0010\\\u001a\u0002062\u0006\u0010]\u001a\u00020\u00072\u0006\u0010^\u001a\u00020\u0007J\u000e\u0010_\u001a\u0002062\u0006\u0010\u000f\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\u000eR(\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R(\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u000f\u001a\u0004\u0018\u00010 @FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R(\u0010'\u001a\u0004\u0018\u00010 2\b\u0010\u000f\u001a\u0004\u0018\u00010 @FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R\u000e\u0010*\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u0012\u00104\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006`"}, d2 = {"Lcom/santander/globile/uicomponents/slider/GlobileSeparatorSlider;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "HeightMeasureSpec", "WidthMeasureSpec", "data", "", "defaultColor", "Ljava/lang/Integer;", "value", "Lcom/santander/globile/uicomponents/slider/GlobileSliderListener;", "globileSliderListener", "getGlobileSliderListener", "()Lcom/santander/globile/uicomponents/slider/GlobileSliderListener;", "setGlobileSliderListener", "(Lcom/santander/globile/uicomponents/slider/GlobileSliderListener;)V", "interval", "intervals", "Landroid/widget/RelativeLayout;", "isAlignmentResetOnLayoutChange", "", "isCurrency", "()Z", "setCurrency", "(Z)V", "listener", "", "maxText", "getMaxText", "()Ljava/lang/String;", "setMaxText", "(Ljava/lang/String;)V", "max_number", "minText", "getMinText", "setMinText", "min_number", "relativeLayout", "sNextGeneratedId", "Ljava/util/concurrent/atomic/AtomicInteger;", "seekbarCountEnd", "Lcom/santander/globile/uicomponents/text/SantanderTextView;", "seekbarCountInit", "seekbar_range", "Lio/apptik/widget/MultiSlider;", "showSeparator", "type", "alignFirstInterval", "", "offset", "alignIntervals", "alignIntervalsInBetween", "maximumWidthOfEachInterval", "alignLastInterval", "alignTextViewToRightOfPreviousInterval", "textView", "Landroid/widget/TextView;", "idOfPreviousInterval", "createCustomLayout", "createInitAttributes", "createInterval", "formatAsCurrency", "generateViewIdentifier", "getIntervals", "min", "max", "getRelativeLayout", "getSeekbarThumbWidth", "getSliderValues", "Lcom/santander/globile/uicomponents/slider/SliderData;", "getValue", "index", "(I)Ljava/lang/Integer;", "isDivisible", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "readMessageToAccessibility", "setAlignmentResetOnLayoutChange", "setData", "setRangeValue", "valueMin", "valueMax", "setValue", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileSeparatorSlider.kt */
public final class GlobileSeparatorSlider extends LinearLayout {
    private int HeightMeasureSpec;
    private int WidthMeasureSpec;
    private HashMap _$_findViewCache;
    private List<Integer> data;
    private Integer defaultColor;
    private GlobileSliderListener globileSliderListener;
    /* access modifiers changed from: private */
    public int interval;
    private RelativeLayout intervals;
    private boolean isAlignmentResetOnLayoutChange;
    private boolean isCurrency;
    /* access modifiers changed from: private */
    public GlobileSliderListener listener;
    private String maxText;
    private int max_number;
    private String minText;
    private int min_number;
    private RelativeLayout relativeLayout;
    private final AtomicInteger sNextGeneratedId;
    private SantanderTextView seekbarCountEnd;
    private SantanderTextView seekbarCountInit;
    private MultiSlider seekbar_range;
    private boolean showSeparator;
    private Integer type;

    public GlobileSeparatorSlider(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public GlobileSeparatorSlider(Context context, AttributeSet attributeSet) {
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
    public GlobileSeparatorSlider(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.interval = 1;
        createInitAttributes(attrs);
        Object systemService = context.getSystemService("layout_inflater");
        if (systemService != null) {
            LayoutInflater inflater = (LayoutInflater) systemService;
            Integer num = this.defaultColor;
            if (num != null && num.intValue() == 0) {
                Integer num2 = this.type;
                if (num2 != null && num2.intValue() == 0) {
                    inflater.inflate(R.layout.seekbar_with_intervals_red, this);
                } else {
                    inflater.inflate(R.layout.seekbar_range_with_intervals_red, this);
                }
            } else {
                Integer num3 = this.type;
                if (num3 != null && num3.intValue() == 0) {
                    inflater.inflate(R.layout.seekbar_with_intervals_turquose, this);
                } else {
                    inflater.inflate(R.layout.seekbar_range_with_intervals_turquose, this);
                }
            }
            MultiSlider _seekbar_range = (MultiSlider) findViewById(R.id.seekbar_range);
            _seekbar_range.setOnThumbValueChangeListener(new MultiSlider.OnThumbValueChangeListener(this) {
                final /* synthetic */ GlobileSeparatorSlider this$0;

                {
                    this.this$0 = r1;
                }

                public final void onValueChanged(MultiSlider $noName_0, MultiSlider.Thumb $noName_1, int thumbIndex, int value) {
                    Integer value2 = this.this$0.getValue(value);
                    if (value2 != null) {
                        int it = value2.intValue();
                        GlobileSeparatorSlider globileSeparatorSlider = this.this$0;
                        globileSeparatorSlider.readMessageToAccessibility(globileSeparatorSlider.interval * (value + 1));
                        GlobileSliderListener access$getListener$p = this.this$0.listener;
                        if (access$getListener$p != null) {
                            access$getListener$p.onSelectionListener(thumbIndex, it);
                        }
                    }
                }
            });
            this.seekbar_range = _seekbar_range;
            this.intervals = (RelativeLayout) findViewById(R.id.intervals);
            this.seekbarCountInit = (SantanderTextView) findViewById(R.id.seekbarCountInit);
            this.seekbarCountEnd = (SantanderTextView) findViewById(R.id.seekbarCountEnd);
            createCustomLayout(attrs);
            this.sNextGeneratedId = new AtomicInteger(1);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.LayoutInflater");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlobileSeparatorSlider(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final GlobileSliderListener getGlobileSliderListener() {
        return this.globileSliderListener;
    }

    public final void setGlobileSliderListener(GlobileSliderListener value) {
        this.listener = value;
    }

    public final String getMinText() {
        return this.minText;
    }

    public final void setMinText(String value) {
        SantanderTextView santanderTextView = this.seekbarCountInit;
        if (santanderTextView != null) {
            santanderTextView.setText(value);
        }
    }

    public final String getMaxText() {
        return this.maxText;
    }

    public final void setMaxText(String value) {
        SantanderTextView santanderTextView = this.seekbarCountEnd;
        if (santanderTextView != null) {
            santanderTextView.setText(value);
        }
    }

    public final boolean isCurrency() {
        return this.isCurrency;
    }

    public final void setCurrency(boolean z) {
        this.isCurrency = z;
    }

    private final void createCustomLayout(AttributeSet attrs) {
        TypedArray attributes = getContext().obtainStyledAttributes(attrs, R.styleable.GlobileSeparatorSlider, 0, 0);
        this.min_number = attributes.getInt(R.styleable.GlobileSeparatorSlider_min_number, 0);
        this.max_number = attributes.getInt(R.styleable.GlobileSeparatorSlider_max_number, 0);
        this.interval = attributes.getInt(R.styleable.GlobileSeparatorSlider_interval, 1);
        setMinText(attributes.getString(R.styleable.GlobileSeparatorSlider_min_text));
        setMaxText(attributes.getString(R.styleable.GlobileSeparatorSlider_max_text));
        this.isCurrency = attributes.getBoolean(R.styleable.GlobileSeparatorSlider_is_currency, false);
        if (isDivisible(this.max_number, this.interval)) {
            setData(this.min_number, this.max_number, this.interval);
            attributes.recycle();
            return;
        }
        throw new Exception(UIComponentConstants.INTERVAL_EXCEPTION_MESSAGE);
    }

    private final void createInitAttributes(AttributeSet attrs) {
        TypedArray attributes = getContext().obtainStyledAttributes(attrs, R.styleable.GlobileSeparatorSlider, 0, 0);
        this.defaultColor = Integer.valueOf(attributes.getInt(R.styleable.GlobileSeparatorSlider_default_color, 0));
        this.type = Integer.valueOf(attributes.getInt(R.styleable.GlobileSeparatorSlider_slider_type, 0));
        attributes.recycle();
    }

    /* access modifiers changed from: private */
    public final void readMessageToAccessibility(int value) {
        String formatMessage = formatAsCurrency(value);
        if (formatMessage == null) {
            formatMessage = getResources().getString(R.string.slider_selected_description, new Object[]{String.valueOf(value)});
        }
        Toast toast = Toast.makeText(getContext(), formatMessage, 0);
        Intrinsics.checkExpressionValueIsNotNull(toast, "toast");
        View view = toast.getView();
        Intrinsics.checkExpressionValueIsNotNull(view, "toast.view");
        view.setVisibility(8);
        toast.show();
    }

    private final String formatAsCurrency(int value) {
        String result = null;
        if (!this.isCurrency) {
            return result;
        }
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        Intrinsics.checkExpressionValueIsNotNull(formatter, "formatter");
        formatter.setMaximumFractionDigits(2);
        formatter.setCurrency(Currency.getInstance("EUR"));
        return getResources().getString(R.string.slider_selected_description, new Object[]{formatter.format(Integer.valueOf(value))});
    }

    public final SliderData getSliderValues() {
        HashMap map = new HashMap();
        MultiSlider it = this.seekbar_range;
        if (it != null) {
            MultiSlider.Thumb thumb = it.getThumb(0);
            Intrinsics.checkExpressionValueIsNotNull(thumb, "it.getThumb(0)");
            map.put(0, getValue(thumb.getValue()));
            Integer num = this.type;
            if (num == null || num.intValue() != 0) {
                MultiSlider.Thumb thumb2 = it.getThumb(1);
                Intrinsics.checkExpressionValueIsNotNull(thumb2, "it.getThumb(1)");
                map.put(1, getValue(thumb2.getValue()));
            }
        }
        return new SliderData(map);
    }

    public final Integer getValue(int index) {
        List it = this.data;
        if (it != null) {
            return Integer.valueOf(it.get(index).intValue());
        }
        return null;
    }

    public final void setData(int min, int max, int interval2) {
        List data2 = getIntervals(min, max, interval2);
        this.data = data2;
        MultiSlider multiSlider = this.seekbar_range;
        if (multiSlider != null) {
            multiSlider.setMax(data2.size() - 1);
        }
    }

    public final void setValue(int value) {
        MultiSlider.Thumb thumb;
        List it = this.data;
        if (it != null) {
            int indexValue = it.indexOf(Integer.valueOf(value));
            if (value < it.get(0).intValue()) {
                indexValue = it.get(0).intValue();
            } else if (value > it.get(it.size() - 1).intValue()) {
                indexValue = it.get(it.size() - 1).intValue();
            } else if (it.indexOf(Integer.valueOf(value)) == -1) {
                throw new InvalidIntervalException(UIComponentConstants.INVALID_INTERVAL_SELECTED);
            }
            MultiSlider multiSlider = this.seekbar_range;
            if (multiSlider != null && (thumb = multiSlider.getThumb(0)) != null) {
                thumb.setValue(indexValue);
            }
        }
    }

    public final void setRangeValue(int valueMin, int valueMax) {
        MultiSlider.Thumb thumb;
        MultiSlider.Thumb thumb2;
        List it = this.data;
        if (it != null) {
            int indexValue1 = it.indexOf(Integer.valueOf(valueMin));
            int indexValue2 = it.indexOf(Integer.valueOf(valueMax));
            if (valueMin < it.get(0).intValue()) {
                indexValue1 = it.get(0).intValue();
            } else if (valueMax > it.get(it.size() - 1).intValue()) {
                indexValue2 = it.get(it.size() - 1).intValue();
            } else if (valueMax < valueMin) {
                throw new InvalidIntervalException(UIComponentConstants.INVALID_INTERVAL_END_VALUE_LESSER);
            } else if (it.indexOf(Integer.valueOf(valueMin)) == -1) {
                throw new InvalidIntervalException(UIComponentConstants.INVALID_INTERVAL_SELECTED);
            } else if (it.indexOf(Integer.valueOf(valueMax)) == -1) {
                throw new InvalidIntervalException(UIComponentConstants.INVALID_INTERVAL_SELECTED);
            }
            MultiSlider multiSlider = this.seekbar_range;
            if (!(multiSlider == null || (thumb2 = multiSlider.getThumb(0)) == null)) {
                thumb2.setValue(indexValue1);
            }
            MultiSlider multiSlider2 = this.seekbar_range;
            if (multiSlider2 != null && (thumb = multiSlider2.getThumb(1)) != null) {
                thumb.setValue(indexValue2);
            }
        }
    }

    private final boolean isDivisible(int max, int interval2) {
        return max % interval2 == 0;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (changed && this.showSeparator && !this.isAlignmentResetOnLayoutChange) {
            alignIntervals();
            RelativeLayout it = this.relativeLayout;
            if (it != null) {
                it.measure(this.WidthMeasureSpec, this.HeightMeasureSpec);
                it.layout(it.getLeft(), it.getTop(), it.getRight(), it.getBottom());
            }
        }
    }

    private final void alignIntervals() {
        Integer num;
        View childAt;
        if (this.seekbar_range != null) {
            int widthOfSeekbarThumb = getSeekbarThumbWidth();
            int thumbOffset = widthOfSeekbarThumb / 2;
            MultiSlider multiSlider = this.seekbar_range;
            Integer maximumWidthOfEachInterval = null;
            Integer widthOfSeekbar = multiSlider != null ? Integer.valueOf(multiSlider.getWidth()) : null;
            RelativeLayout relativeLayout2 = getRelativeLayout();
            Integer firstIntervalWidth = (relativeLayout2 == null || (childAt = relativeLayout2.getChildAt(0)) == null) ? null : Integer.valueOf(childAt.getWidth());
            if (firstIntervalWidth != null) {
                int intValue = firstIntervalWidth.intValue();
                if (widthOfSeekbar != null) {
                    int intValue2 = widthOfSeekbar.intValue();
                    num = Integer.valueOf((widthOfSeekbar.intValue() - firstIntervalWidth.intValue()) - widthOfSeekbarThumb);
                } else {
                    num = null;
                }
            } else {
                num = null;
            }
            Integer remainingPaddableWidth = num;
            MultiSlider multiSlider2 = this.seekbar_range;
            Integer numberOfIntervals = multiSlider2 != null ? Integer.valueOf(multiSlider2.getMax()) : null;
            if (numberOfIntervals != null) {
                int it = numberOfIntervals.intValue();
                if (remainingPaddableWidth != null) {
                    maximumWidthOfEachInterval = Integer.valueOf(remainingPaddableWidth.intValue() / it);
                }
            }
            alignFirstInterval(thumbOffset);
            if (maximumWidthOfEachInterval != null) {
                int intValue3 = maximumWidthOfEachInterval.intValue();
                alignIntervalsInBetween(maximumWidthOfEachInterval.intValue());
                alignLastInterval(thumbOffset, maximumWidthOfEachInterval.intValue());
            }
            this.isAlignmentResetOnLayoutChange = true;
        }
    }

    private final int getSeekbarThumbWidth() {
        return getResources().getDimensionPixelOffset(R.dimen.seekbar_thumb_width);
    }

    private final void alignFirstInterval(int offset) {
        RelativeLayout relativeLayout2 = getRelativeLayout();
        View childAt = relativeLayout2 != null ? relativeLayout2.getChildAt(0) : null;
        if (childAt != null) {
            ((TextView) childAt).setPadding(offset, 0, 0, 0);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
    }

    private final void alignIntervalsInBetween(int maximumWidthOfEachInterval) {
        int widthOfPreviousIntervalsText = 0;
        RelativeLayout relativeLayout2 = getRelativeLayout();
        Integer childCount = relativeLayout2 != null ? Integer.valueOf(relativeLayout2.getChildCount()) : null;
        if (childCount != null) {
            int intValue = childCount.intValue() - 1;
            int index = 1;
            while (index < intValue) {
                RelativeLayout relativeLayout3 = getRelativeLayout();
                View childAt = relativeLayout3 != null ? relativeLayout3.getChildAt(index) : null;
                if (childAt != null) {
                    SantanderTextView textViewInterval = (SantanderTextView) childAt;
                    int widthOfText = textViewInterval.getWidth();
                    textViewInterval.setPadding(MathKt.roundToInt((float) ((maximumWidthOfEachInterval - (widthOfText / 2)) - (widthOfPreviousIntervalsText / 2))), 0, 0, 0);
                    widthOfPreviousIntervalsText = widthOfText;
                    index++;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type com.santander.globile.uicomponents.text.SantanderTextView");
                }
            }
        }
    }

    private final void alignLastInterval(int offset, int maximumWidthOfEachInterval) {
        RelativeLayout relativeLayout2 = getRelativeLayout();
        View view = null;
        Integer valueOf = relativeLayout2 != null ? Integer.valueOf(relativeLayout2.getChildCount()) : null;
        if (valueOf == null) {
            Intrinsics.throwNpe();
        }
        int lastIndex = valueOf.intValue() - 1;
        RelativeLayout relativeLayout3 = getRelativeLayout();
        if (relativeLayout3 != null) {
            view = relativeLayout3.getChildAt(lastIndex);
        }
        if (view != null) {
            SantanderTextView lastInterval = (SantanderTextView) view;
            lastInterval.setPadding(MathKt.roundToInt((float) (maximumWidthOfEachInterval - lastInterval.getWidth())), 0, 0, 0);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.santander.globile.uicomponents.text.SantanderTextView");
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        this.WidthMeasureSpec = widthMeasureSpec;
        this.HeightMeasureSpec = heightMeasureSpec;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private final TextView createInterval() {
        View textBoxView = LayoutInflater.from(getContext()).inflate(R.layout.seekbar_with_intervals_labels, (ViewGroup) null);
        if (textBoxView != null) {
            View findViewById = textBoxView.findViewById(R.id.textViewInterval);
            if (findViewById != null) {
                textBoxView.setId(LinearLayout.generateViewId());
                return (TextView) ((SantanderTextView) findViewById);
            }
            throw new TypeCastException("null cannot be cast to non-null type com.santander.globile.uicomponents.text.SantanderTextView");
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.View");
    }

    private final int generateViewIdentifier() {
        int result;
        int newValue;
        do {
            result = this.sNextGeneratedId.get();
            newValue = result + 1;
            if (newValue > 16777215) {
                newValue = 1;
            }
        } while (!this.sNextGeneratedId.compareAndSet(result, newValue));
        return result;
    }

    private final void setAlignmentResetOnLayoutChange() {
        alignIntervals();
        RelativeLayout it = this.relativeLayout;
        if (it != null) {
            it.measure(this.WidthMeasureSpec, this.HeightMeasureSpec);
            it.layout(it.getLeft(), it.getTop(), it.getRight(), it.getBottom());
        }
    }

    private final void alignTextViewToRightOfPreviousInterval(TextView textView, int idOfPreviousInterval) {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(-2, -2);
        if (idOfPreviousInterval > 0) {
            params.addRule(1, idOfPreviousInterval);
        }
        textView.setLayoutParams(params);
    }

    private final List<Integer> getIntervals(int min, int max, int interval2) {
        return new GlobileSeparatorSlider$getIntervals$1(min, max, interval2);
    }

    private final RelativeLayout getRelativeLayout() {
        if (this.relativeLayout == null) {
            this.relativeLayout = (RelativeLayout) findViewById(R.id.intervals);
        }
        return this.relativeLayout;
    }
}
