package com.santander.globile.uicomponents.image.badgeview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.content.res.ResourcesCompat;
import com.santander.globile.uicomponents.R;
import java.util.HashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u0000 G2\u00020\u0001:\u0001GB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\u0010\u0010 \u001a\u00020\u00002\b\u0010!\u001a\u0004\u0018\u00010\u0001J\u0018\u0010\"\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\tH\u0002J\u0006\u0010$\u001a\u00020\u001cJ\u0010\u0010%\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)H\u0014J\u000e\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\tJ\u000e\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\tJ\u000e\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u001cJ\u000e\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\tJ\u000e\u00100\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\tJ\u000e\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u00020\tJ(\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\t2\u0006\u00106\u001a\u00020\t2\u0006\u00107\u001a\u00020\tH\u0007J\u000e\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020\tJ\u0016\u0010:\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020\tJ\u000e\u0010=\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\tJ\u000e\u0010>\u001a\u00020\u00002\u0006\u00102\u001a\u00020\tJ\u000e\u0010?\u001a\u00020\u00002\u0006\u00102\u001a\u00020\tJ\u0016\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\t2\u0006\u0010B\u001a\u00020\tJ\u0018\u0010C\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010D\u001a\u00020EH\u0002J\u0006\u0010F\u001a\u00020\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/santander/globile/uicomponents/image/badgeview/GlobileBadgeNumber;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "backgroundPaint", "Landroid/graphics/Paint;", "badgeGravity", "bottomMargin", "currentShape", "defaultBackgroundColor", "defaultTextColor", "defaultTextSize", "hasBind", "", "horiontalSpace", "leftMargin", "numberPaint", "rightMargin", "showText", "", "strokePaint", "topMargin", "verticalSpace", "bind", "view", "dip2px", "dip", "getBadgeCount", "init", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setBadgeBackground", "color", "setBadgeCount", "count", "setBadgeGravity", "gravity", "setBadgeStroke", "setHeight", "sp", "setMargin", "left", "top", "right", "bottom", "setShape", "shape", "setSpace", "horitontal", "vertical", "setTextColor", "setTextSize", "setWidth", "setWidthAndHeight", "w", "h", "sp2px", "spValue", "", "unbind", "Companion", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: GlobileBadgeNumber.kt */
public final class GlobileBadgeNumber extends View {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int SHAPE_CIRCLE = 1;
    public static final int SHAPE_OVAL = 3;
    public static final int SHAPE_RECTANGLE = 2;
    public static final int SHAPE_ROUND_RECTANGLE = 4;
    public static final int SHAPE_SQUARE = 5;
    private HashMap _$_findViewCache;
    private Paint backgroundPaint = new Paint(1);
    private int badgeGravity = 8388661;
    private int bottomMargin;
    private int currentShape = 1;
    private int defaultBackgroundColor = -65536;
    private int defaultTextColor = -1;
    private int defaultTextSize;
    private boolean hasBind;
    private int horiontalSpace;
    private int leftMargin;
    private Paint numberPaint = new Paint(1);
    private int rightMargin;
    private String showText = "";
    private Paint strokePaint = new Paint(1);
    private int topMargin;
    private int verticalSpace;

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
    public GlobileBadgeNumber(Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
        init(context);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobileBadgeNumber(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attrs, "attrs");
        init(context);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobileBadgeNumber(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attrs, "attrs");
        init(context);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlobileBadgeNumber(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attrs, "attrs");
        init(context);
    }

    private final void init(Context context) {
        this.defaultTextSize = dip2px(context, 1);
        this.numberPaint.setColor(this.defaultTextColor);
        this.numberPaint.setStyle(Paint.Style.FILL);
        this.numberPaint.setTextSize((float) this.defaultTextSize);
        this.numberPaint.setTextAlign(Paint.Align.CENTER);
        this.numberPaint.setTypeface(ResourcesCompat.getFont(context, R.font.santander_text_regular));
        this.backgroundPaint.setColor(this.defaultBackgroundColor);
        this.backgroundPaint.setStyle(Paint.Style.FILL);
        this.strokePaint.setColor(this.defaultBackgroundColor);
        this.strokePaint.setStyle(Paint.Style.STROKE);
        this.strokePaint.setStrokeCap(Paint.Cap.ROUND);
        this.strokePaint.setStrokeWidth(4.0f);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-2, -2);
        params.gravity = this.badgeGravity;
        setLayoutParams(params);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        super.onDraw(canvas);
        RectF rectF = new RectF(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight());
        Paint paint = this.numberPaint;
        if (paint == null) {
            Intrinsics.throwNpe();
        }
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float textH = fontMetrics.descent - fontMetrics.ascent;
        rectF.set(2.0f, 2.0f, ((float) getMeasuredWidth()) - 2.0f, ((float) getMeasuredHeight()) - 2.0f);
        int i = this.currentShape;
        if (i == 1) {
            canvas.drawCircle(((float) getMeasuredWidth()) / 2.0f, ((float) getMeasuredHeight()) / 2.0f, (float) (getMeasuredWidth() / 2), this.backgroundPaint);
            canvas.drawCircle(((float) getMeasuredWidth()) / 2.0f, ((float) getMeasuredHeight()) / 2.0f, ((float) (getMeasuredWidth() / 2)) - 1.5f, this.strokePaint);
            canvas.drawText(this.showText, ((float) getMeasuredWidth()) / 2.0f, (((float) getMeasuredHeight()) / 2.0f) + ((textH / 2.0f) - fontMetrics.descent), this.numberPaint);
        } else if (i == 2) {
            canvas.drawRect(rectF, this.backgroundPaint);
            canvas.drawRect(rectF, this.strokePaint);
            canvas.drawText(this.showText, ((float) getMeasuredWidth()) / 2.0f, (((float) getMeasuredHeight()) / 2.0f) + ((textH / 2.0f) - fontMetrics.descent), this.numberPaint);
        } else if (i == 3) {
            canvas.drawOval(rectF, this.backgroundPaint);
            canvas.drawOval(rectF, this.strokePaint);
            canvas.drawText(this.showText, ((float) getMeasuredWidth()) / 2.0f, (((float) getMeasuredHeight()) / 2.0f) + ((textH / 2.0f) - fontMetrics.descent), this.numberPaint);
        } else if (i == 4) {
            Context context = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            Context context2 = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context2, "context");
            canvas.drawRoundRect(rectF, (float) dip2px(context, 5), (float) dip2px(context2, 5), this.backgroundPaint);
            Context context3 = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context3, "context");
            Context context4 = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context4, "context");
            canvas.drawRoundRect(rectF, (float) dip2px(context3, 5), (float) dip2px(context4, 5), this.strokePaint);
            canvas.drawText(this.showText, ((float) getMeasuredWidth()) / 2.0f, (((float) getMeasuredHeight()) / 2.0f) + ((textH / 2.0f) - fontMetrics.descent), this.numberPaint);
        } else if (i == 5) {
            int sideLength = Math.min(getMeasuredHeight(), getMeasuredWidth());
            RectF squareF = new RectF(0.0f, 0.0f, (float) sideLength, (float) sideLength);
            canvas.drawRect(squareF, this.backgroundPaint);
            canvas.drawRect(squareF, this.strokePaint);
            canvas.drawText(this.showText, ((float) sideLength) / 2.0f, (((float) sideLength) / 2.0f) + ((textH / 2.0f) - fontMetrics.descent), this.numberPaint);
        }
    }

    private final int dip2px(Context context, int dip) {
        Context context2 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context2, "getContext()");
        Resources resources = context2.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "getContext().resources");
        return (int) ((((float) dip) * resources.getDisplayMetrics().density) + 0.5f);
    }

    private final int sp2px(Context context, float spValue) {
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "context.resources");
        return (int) ((spValue * resources.getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public final GlobileBadgeNumber setShape(int shape) {
        this.currentShape = shape;
        invalidate();
        return this;
    }

    public final GlobileBadgeNumber setWidthAndHeight(int w, int h) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) layoutParams;
            Context context = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            params.width = dip2px(context, w);
            Context context2 = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context2, "context");
            params.height = dip2px(context2, h);
            setLayoutParams(params);
            return this;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    public final GlobileBadgeNumber setWidth(int sp) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) layoutParams;
            Context context = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            params.width = dip2px(context, sp);
            setLayoutParams(params);
            return this;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    public final GlobileBadgeNumber setHeight(int sp) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) layoutParams;
            Context context = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            params.height = dip2px(context, sp);
            setLayoutParams(params);
            return this;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    @Deprecated(message = "")
    public final GlobileBadgeNumber setMargin(int left, int top, int right, int bottom) {
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        this.leftMargin = dip2px(context, left);
        Context context2 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context2, "context");
        this.bottomMargin = dip2px(context2, bottom);
        Context context3 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context3, "context");
        this.topMargin = dip2px(context3, top);
        Context context4 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context4, "context");
        this.rightMargin = dip2px(context4, right);
        invalidate();
        return this;
    }

    public final GlobileBadgeNumber setSpace(int horitontal, int vertical) {
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        this.horiontalSpace = dip2px(context, horitontal);
        Context context2 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context2, "context");
        this.verticalSpace = dip2px(context2, vertical);
        invalidate();
        return this;
    }

    public final GlobileBadgeNumber setTextSize(int sp) {
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        this.defaultTextSize = sp2px(context, (float) sp);
        Paint paint = this.numberPaint;
        Context context2 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context2, "context");
        paint.setTextSize((float) sp2px(context2, (float) sp));
        invalidate();
        return this;
    }

    public final GlobileBadgeNumber setTextColor(int color) {
        this.defaultTextColor = color;
        this.numberPaint.setColor(color);
        invalidate();
        return this;
    }

    public final GlobileBadgeNumber setBadgeStroke(int color) {
        this.strokePaint.setColor(color);
        invalidate();
        return this;
    }

    public final GlobileBadgeNumber setBadgeBackground(int color) {
        this.defaultBackgroundColor = color;
        this.backgroundPaint.setColor(color);
        invalidate();
        return this;
    }

    public final GlobileBadgeNumber setBadgeCount(int count) {
        this.showText = String.valueOf(count);
        invalidate();
        return this;
    }

    public final GlobileBadgeNumber setBadgeCount(String count) {
        Intrinsics.checkParameterIsNotNull(count, "count");
        this.showText = count;
        invalidate();
        return this;
    }

    public final GlobileBadgeNumber setBadgeGravity(int gravity) {
        this.badgeGravity = gravity;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) layoutParams;
            params.gravity = gravity;
            setLayoutParams(params);
            return this;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    public final GlobileBadgeNumber bind(View view) {
        View view2 = view;
        if (getParent() != null) {
            ViewParent parent = getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(this);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
            }
        }
        if (view2 == null) {
            return this;
        }
        if (!(view.getParent() instanceof FrameLayout) || !this.hasBind) {
            if (view.getParent() instanceof ViewGroup) {
                ViewParent parent2 = view.getParent();
                if (parent2 != null) {
                    ViewGroup parentContainer = (ViewGroup) parent2;
                    ViewParent parent3 = view.getParent();
                    if (parent3 != null) {
                        int viewIndex = ((ViewGroup) parent3).indexOfChild(view2);
                        ViewParent parent4 = view.getParent();
                        if (parent4 != null) {
                            ((ViewGroup) parent4).removeView(view2);
                            FrameLayout container = new FrameLayout(getContext());
                            ViewGroup.LayoutParams containerParams = view.getLayoutParams();
                            int origionHeight = containerParams.height;
                            int origionWidth = containerParams.width;
                            FrameLayout.LayoutParams viewLayoutParams = new FrameLayout.LayoutParams(origionWidth, origionHeight);
                            if (origionHeight == -2) {
                                containerParams.height = -2;
                                viewLayoutParams.topMargin = this.topMargin;
                                viewLayoutParams.bottomMargin = this.bottomMargin;
                            } else {
                                containerParams.height = this.topMargin + origionHeight + this.bottomMargin + this.verticalSpace;
                            }
                            if (origionWidth == -2) {
                                containerParams.width = -2;
                                viewLayoutParams.leftMargin = this.leftMargin;
                                viewLayoutParams.rightMargin = this.rightMargin;
                            } else {
                                containerParams.width = this.rightMargin + origionWidth + this.horiontalSpace + this.leftMargin;
                            }
                            container.setLayoutParams(containerParams);
                            ViewGroup.LayoutParams layoutParams = getLayoutParams();
                            if (layoutParams != null) {
                                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) layoutParams;
                                if (params.gravity == 8388661 || params.gravity == 8388613 || params.gravity == 48) {
                                    view2.setPadding(0, this.verticalSpace, this.horiontalSpace, 0);
                                    viewLayoutParams.gravity = 8388691;
                                } else if (params.gravity == 8388659 || params.gravity == 8388611 || params.gravity == 48) {
                                    view2.setPadding(this.horiontalSpace, this.verticalSpace, 0, 0);
                                    viewLayoutParams.gravity = 8388693;
                                } else if (params.gravity == 8388691) {
                                    view2.setPadding(this.horiontalSpace, 0, 0, this.verticalSpace);
                                    viewLayoutParams.gravity = 8388661;
                                } else if (params.gravity == 8388693) {
                                    view2.setPadding(0, 0, this.horiontalSpace, this.verticalSpace);
                                    viewLayoutParams.gravity = 8388659;
                                } else {
                                    view2.setPadding(0, this.verticalSpace, this.horiontalSpace, 0);
                                    viewLayoutParams.gravity = 8388691;
                                }
                                view2.setLayoutParams(viewLayoutParams);
                                container.setId(view.getId());
                                container.addView(view2);
                                container.addView(this);
                                parentContainer.addView(container, viewIndex);
                                this.hasBind = true;
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                            }
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
                }
            } else if (view.getParent() == null) {
                Log.e("badgeview", "View must have a parent");
            }
            return this;
        }
        ViewParent parent5 = view.getParent();
        if (parent5 != null) {
            ((FrameLayout) parent5).addView(this);
            return this;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout");
    }

    public final boolean unbind() {
        if (getParent() == null) {
            return false;
        }
        ViewParent parent = getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(this);
            return true;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final String getBadgeCount() {
        return this.showText;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/santander/globile/uicomponents/image/badgeview/GlobileBadgeNumber$Companion;", "", "()V", "SHAPE_CIRCLE", "", "SHAPE_OVAL", "SHAPE_RECTANGLE", "SHAPE_ROUND_RECTANGLE", "SHAPE_SQUARE", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
    /* compiled from: GlobileBadgeNumber.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }
    }
}
