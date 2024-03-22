package com.santander.globile.uicomponents.text;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.santander.globile.uicomponents.R;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 32\u00020\u0001:\u000234B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ,\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u001d2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010 \u001a\u00020\nH\u0002J\u0010\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\nH\u0002J\u0010\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\nH\u0002J\u0006\u0010'\u001a\u00020\nJ\b\u0010(\u001a\u00020\"H\u0002J\b\u0010)\u001a\u00020\"H\u0002J\u0012\u0010*\u001a\u00020\"2\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\u0018\u0010-\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007H\u0014J\u000e\u0010.\u001a\u00020\"2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010/\u001a\u00020\"2\u0006\u0010\u000b\u001a\u00020\u0007J\u000e\u00100\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u000fJ\u000e\u00101\u001a\u00020\"2\u0006\u00102\u001a\u00020\nR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00060\rR\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00060\rR\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00060\rR\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/santander/globile/uicomponents/text/QuantityTextView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "amount", "", "color", "decimalPartText", "Lcom/santander/globile/uicomponents/text/QuantityTextView$Text;", "font", "", "integerPartText", "integerSize", "mHeight", "mWidth", "symbol", "symbolAtEnd", "", "symbolText", "symbolsAndDecimalSize", "textMargins", "textPaint", "Landroid/text/TextPaint;", "calculateBounds", "Lkotlin/Pair;", "widthMeasureSpec", "heightMeasureSpec", "offset", "calculatePositions", "", "calculateX", "fromX", "calculateY", "fromY", "getAmount", "initQuantityTexts", "initTextPaint", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "setAmount", "setColor", "setCurrency", "setSize", "size", "Companion", "Text", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: QuantityTextView.kt */
public final class QuantityTextView extends View {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String defaultFont = "SantanderText-Regular.ttf";
    private static final String fontSuffix = ".ttf";
    private HashMap _$_findViewCache;
    private float amount;
    private int color;
    private final Text decimalPartText;
    private String font;
    private final Text integerPartText;
    private float integerSize;
    private int mHeight;
    private int mWidth;
    private String symbol;
    private boolean symbolAtEnd;
    private final Text symbolText;
    private float symbolsAndDecimalSize;
    private final float textMargins;
    /* access modifiers changed from: private */
    public final TextPaint textPaint;

    public QuantityTextView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public QuantityTextView(Context context, AttributeSet attributeSet) {
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
    public QuantityTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.textPaint = new TextPaint(1);
        this.symbolText = new Text();
        this.integerPartText = new Text();
        this.decimalPartText = new Text();
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.QuantityTextView, 0, R.style.QuantityDefaultStyle);
        try {
            this.amount = typedArray.getFloat(R.styleable.QuantityTextView_amount, 0.0f);
            this.symbolAtEnd = typedArray.getBoolean(R.styleable.QuantityTextView_currencyAtEnd, false);
            this.textMargins = typedArray.getDimension(R.styleable.QuantityTextView_textMargins, 0.0f);
            float dimension = typedArray.getDimension(R.styleable.QuantityTextView_baseTextSize, 18.0f);
            this.integerSize = dimension;
            this.symbolsAndDecimalSize = dimension * 0.75f;
            String string = typedArray.getString(R.styleable.QuantityTextView_currency);
            if (string == null) {
                string = "";
            }
            this.symbol = string;
            this.color = typedArray.getColor(R.styleable.QuantityTextView_textColor, -16777216);
            this.font = typedArray.getString(R.styleable.QuantityTextView_quantityTextFont);
        } finally {
            typedArray.recycle();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QuantityTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void setAmount(float amount2) {
        this.amount = amount2;
        requestLayout();
    }

    public final float getAmount() {
        return this.amount;
    }

    public final void setCurrency(String symbol2) {
        Intrinsics.checkParameterIsNotNull(symbol2, "symbol");
        this.symbol = symbol2;
        requestLayout();
    }

    public final void setColor(int color2) {
        this.color = color2;
        requestLayout();
    }

    public final void setSize(float size) {
        this.integerSize = size;
        this.symbolsAndDecimalSize = 0.75f * size;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        initQuantityTexts();
        initTextPaint();
        this.textPaint.setTextSize(this.integerPartText.getSize());
        int offset = (int) this.textPaint.getFontMetrics().bottom;
        Pair<Integer, Integer> calculateBounds = calculateBounds(widthMeasureSpec, heightMeasureSpec, offset);
        int width = calculateBounds.component1().intValue();
        int height = calculateBounds.component2().intValue();
        calculatePositions((float) offset);
        setMeasuredDimension(width, height);
    }

    private final void initQuantityTexts() {
        String currencySymbol;
        String str;
        float tmp = this.amount;
        int integerPart = (int) tmp;
        float f = (float) 0;
        if (tmp < f) {
            tmp *= (float) -1;
        }
        int decimals = (int) ((tmp - ((float) Math.floor((double) tmp))) * ((float) 100));
        if (this.symbolAtEnd || this.amount >= f) {
            currencySymbol = this.symbol;
        } else {
            integerPart *= -1;
            currencySymbol = '-' + this.symbol;
        }
        this.symbolText.setText(currencySymbol);
        this.symbolText.setSize(this.symbolsAndDecimalSize);
        Text text = this.integerPartText;
        if (integerPart != 0 || this.amount >= f || !this.symbolAtEnd) {
            str = NumberFormat.getNumberInstance(Locale.getDefault()).format(Integer.valueOf(integerPart)).toString();
        } else {
            str = new StringBuilder().append('-').append(integerPart).toString();
        }
        text.setText(str);
        this.integerPartText.setSize(this.integerSize);
        this.decimalPartText.setText(new DecimalFormatSymbols(Locale.getDefault()).getDecimalSeparator() + (decimals < 10 ? new StringBuilder().append('0').append(decimals).toString() : String.valueOf(decimals)));
        this.decimalPartText.setSize(this.symbolsAndDecimalSize);
    }

    private final void initTextPaint() {
        Typeface typeface;
        this.textPaint.setStyle(Paint.Style.FILL);
        this.textPaint.setColor(this.color);
        TextPaint textPaint2 = this.textPaint;
        try {
            Context context = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            AssetManager assets = context.getAssets();
            StringBuilder append = new StringBuilder().append("fonts/");
            String $this$run = this.font;
            if ($this$run != null) {
                if (!StringsKt.endsWith$default($this$run, fontSuffix, false, 2, (Object) null)) {
                    $this$run = $this$run + fontSuffix;
                }
                if ($this$run != null) {
                    typeface = Typeface.createFromAsset(assets, append.append($this$run).toString());
                    textPaint2.setTypeface(typeface);
                }
            }
            $this$run = defaultFont;
            typeface = Typeface.createFromAsset(assets, append.append($this$run).toString());
        } catch (Exception e) {
            Context context2 = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context2, "context");
            typeface = Typeface.createFromAsset(context2.getAssets(), "fonts/SantanderText-Regular.ttf");
        }
        textPaint2.setTypeface(typeface);
    }

    private final Pair<Integer, Integer> calculateBounds(int widthMeasureSpec, int heightMeasureSpec, int offset) {
        int i;
        int i2;
        this.symbolText.calculateBounds();
        this.integerPartText.calculateBounds();
        this.decimalPartText.calculateBounds();
        int widthSize = View.MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int heightSize = View.MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        if (widthMode == Integer.MIN_VALUE || widthMode == 0) {
            i = (((int) this.textMargins) * 2) + this.symbolText.getW() + this.integerPartText.getW() + this.decimalPartText.getW() + getPaddingBottom() + getPaddingTop() + offset;
        } else if (widthMode == 1073741824) {
            i = widthSize;
        } else {
            throw new IllegalArgumentException("Invalid provided width");
        }
        this.mWidth = i;
        if (heightMode == Integer.MIN_VALUE || heightMode == 0) {
            i2 = this.integerPartText.getH() + getPaddingTop() + getPaddingBottom() + offset;
        } else if (heightMode == 1073741824) {
            i2 = heightSize;
        } else {
            throw new IllegalArgumentException("Invalid provided height");
        }
        this.mHeight = i2;
        return new Pair<>(Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight));
    }

    private final void calculatePositions(float offset) {
        calculateX(((float) getPaddingStart()) + (offset / 2.0f));
        calculateY((float) (getPaddingTop() + this.integerPartText.getH()));
    }

    private final void calculateX(float fromX) {
        if (!this.symbolAtEnd) {
            this.symbolText.setX(fromX);
        }
        this.integerPartText.setX(this.symbolAtEnd ? fromX : this.symbolText.getX() + ((float) this.symbolText.getW()) + this.textMargins);
        Text text = this.decimalPartText;
        float f = this.textMargins;
        float f2 = f;
        boolean z = this.symbolAtEnd;
        text.setX(f + this.integerPartText.getX() + ((float) this.integerPartText.getW()));
        if (this.symbolAtEnd) {
            this.symbolText.setX(this.decimalPartText.getX() + this.textMargins + ((float) this.decimalPartText.getW()));
        }
    }

    private final void calculateY(float fromY) {
        if (!this.symbolAtEnd) {
            this.symbolText.setY(fromY - ((float) ((this.integerPartText.getH() - this.symbolText.getH()) + this.symbolText.getBounds().bottom)));
        }
        this.integerPartText.setY(fromY);
        this.decimalPartText.setY(fromY);
        if (this.symbolAtEnd) {
            this.symbolText.setY(fromY);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.symbolText.draw(canvas);
        this.integerPartText.draw(canvas);
        this.decimalPartText.draw(canvas);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010$\u001a\u00020%J\u0010\u0010&\u001a\u00020%2\b\u0010'\u001a\u0004\u0018\u00010(R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001a\u0010\u001e\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001a\u0010!\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0014¨\u0006)"}, d2 = {"Lcom/santander/globile/uicomponents/text/QuantityTextView$Text;", "", "(Lcom/santander/globile/uicomponents/text/QuantityTextView;)V", "bounds", "Landroid/graphics/Rect;", "getBounds", "()Landroid/graphics/Rect;", "setBounds", "(Landroid/graphics/Rect;)V", "h", "", "getH", "()I", "setH", "(I)V", "size", "", "getSize", "()F", "setSize", "(F)V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "w", "getW", "setW", "x", "getX", "setX", "y", "getY", "setY", "calculateBounds", "", "draw", "canvas", "Landroid/graphics/Canvas;", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
    /* compiled from: QuantityTextView.kt */
    public final class Text {
        private Rect bounds = new Rect();
        private int h;
        private float size;
        private String text = "";
        private int w;
        private float x;
        private float y;

        public Text() {
        }

        public final String getText() {
            return this.text;
        }

        public final void setText(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.text = str;
        }

        public final float getX() {
            return this.x;
        }

        public final void setX(float f) {
            this.x = f;
        }

        public final float getY() {
            return this.y;
        }

        public final void setY(float f) {
            this.y = f;
        }

        public final int getW() {
            return this.w;
        }

        public final void setW(int i) {
            this.w = i;
        }

        public final int getH() {
            return this.h;
        }

        public final void setH(int i) {
            this.h = i;
        }

        public final float getSize() {
            return this.size;
        }

        public final void setSize(float f) {
            this.size = f;
        }

        public final Rect getBounds() {
            return this.bounds;
        }

        public final void setBounds(Rect rect) {
            Intrinsics.checkParameterIsNotNull(rect, "<set-?>");
            this.bounds = rect;
        }

        public final void calculateBounds() {
            QuantityTextView.this.textPaint.setTextSize(this.size);
            TextPaint access$getTextPaint$p = QuantityTextView.this.textPaint;
            String str = this.text;
            access$getTextPaint$p.getTextBounds(str, 0, str.length(), this.bounds);
            this.w = this.bounds.width();
            this.h = this.bounds.height();
        }

        public final void draw(Canvas canvas) {
            QuantityTextView.this.textPaint.setTextSize(this.size);
            if (canvas != null) {
                canvas.drawText(this.text, this.x, this.y, QuantityTextView.this.textPaint);
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/santander/globile/uicomponents/text/QuantityTextView$Companion;", "", "()V", "defaultFont", "", "fontSuffix", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
    /* compiled from: QuantityTextView.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}
