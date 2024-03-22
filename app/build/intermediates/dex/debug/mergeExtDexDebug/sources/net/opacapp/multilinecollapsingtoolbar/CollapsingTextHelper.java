package net.opacapp.multilinecollapsingtoolbar;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.appcompat.R;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import kotlin.KotlinVersion;
import org.kxml2.wap.Wbxml;

final class CollapsingTextHelper {
    private static final boolean DEBUG_DRAW = false;
    private static final Paint DEBUG_DRAW_PAINT;
    private static final boolean USE_SCALING_TEXTURE = (Build.VERSION.SDK_INT < 18);
    private boolean mBoundsChanged;
    private final Rect mCollapsedBounds;
    private float mCollapsedDrawX;
    private float mCollapsedDrawY;
    private int mCollapsedShadowColor;
    private float mCollapsedShadowDx;
    private float mCollapsedShadowDy;
    private float mCollapsedShadowRadius;
    private float mCollapsedTextBlend;
    private int mCollapsedTextColor;
    private int mCollapsedTextGravity = 16;
    private float mCollapsedTextSize = 15.0f;
    private Bitmap mCollapsedTitleTexture;
    private Typeface mCollapsedTypeface;
    private Bitmap mCrossSectionTitleTexture;
    private final RectF mCurrentBounds;
    private float mCurrentDrawX;
    private float mCurrentDrawY;
    private float mCurrentTextSize;
    private Typeface mCurrentTypeface;
    private boolean mDrawTitle;
    private final Rect mExpandedBounds;
    private float mExpandedDrawX;
    private float mExpandedDrawY;
    private float mExpandedFirstLineDrawX;
    private float mExpandedFraction;
    private int mExpandedShadowColor;
    private float mExpandedShadowDx;
    private float mExpandedShadowDy;
    private float mExpandedShadowRadius;
    private float mExpandedTextBlend;
    private int mExpandedTextColor;
    private int mExpandedTextGravity = 16;
    private float mExpandedTextSize = 15.0f;
    private Bitmap mExpandedTitleTexture;
    private Typeface mExpandedTypeface;
    private boolean mIsRtl;
    private Interpolator mPositionInterpolator;
    private float mScale;
    private CharSequence mText;
    private StaticLayout mTextLayout;
    private final TextPaint mTextPaint;
    private Interpolator mTextSizeInterpolator;
    private CharSequence mTextToDraw;
    private CharSequence mTextToDrawCollapsed;
    private Paint mTexturePaint;
    private boolean mUseTexture;
    private final View mView;
    private int maxLines = 3;

    static {
        Paint paint = null;
        DEBUG_DRAW_PAINT = paint;
        if (paint != null) {
            paint.setAntiAlias(true);
            paint.setColor(-65281);
        }
    }

    public CollapsingTextHelper(View view) {
        this.mView = view;
        this.mTextPaint = new TextPaint(Wbxml.EXT_T_1);
        this.mCollapsedBounds = new Rect();
        this.mExpandedBounds = new Rect();
        this.mCurrentBounds = new RectF();
    }

    /* access modifiers changed from: package-private */
    public void setTextSizeInterpolator(Interpolator interpolator) {
        this.mTextSizeInterpolator = interpolator;
        recalculate();
    }

    /* access modifiers changed from: package-private */
    public void setPositionInterpolator(Interpolator interpolator) {
        this.mPositionInterpolator = interpolator;
        recalculate();
    }

    /* access modifiers changed from: package-private */
    public void setExpandedTextSize(float textSize) {
        if (this.mExpandedTextSize != textSize) {
            this.mExpandedTextSize = textSize;
            recalculate();
        }
    }

    /* access modifiers changed from: package-private */
    public void setCollapsedTextSize(float textSize) {
        if (this.mCollapsedTextSize != textSize) {
            this.mCollapsedTextSize = textSize;
            recalculate();
        }
    }

    /* access modifiers changed from: package-private */
    public void setCollapsedTextColor(int textColor) {
        if (this.mCollapsedTextColor != textColor) {
            this.mCollapsedTextColor = textColor;
            recalculate();
        }
    }

    /* access modifiers changed from: package-private */
    public void setExpandedTextColor(int textColor) {
        if (this.mExpandedTextColor != textColor) {
            this.mExpandedTextColor = textColor;
            recalculate();
        }
    }

    /* access modifiers changed from: package-private */
    public void setExpandedBounds(int left, int top, int right, int bottom) {
        if (!rectEquals(this.mExpandedBounds, left, top, right, bottom)) {
            this.mExpandedBounds.set(left, top, right, bottom);
            this.mBoundsChanged = true;
            onBoundsChanged();
        }
    }

    /* access modifiers changed from: package-private */
    public void setCollapsedBounds(int left, int top, int right, int bottom) {
        if (!rectEquals(this.mCollapsedBounds, left, top, right, bottom)) {
            this.mCollapsedBounds.set(left, top, right, bottom);
            this.mBoundsChanged = true;
            onBoundsChanged();
        }
    }

    /* access modifiers changed from: package-private */
    public void onBoundsChanged() {
        this.mDrawTitle = this.mCollapsedBounds.width() > 0 && this.mCollapsedBounds.height() > 0 && this.mExpandedBounds.width() > 0 && this.mExpandedBounds.height() > 0;
    }

    /* access modifiers changed from: package-private */
    public void setExpandedTextGravity(int gravity) {
        if (this.mExpandedTextGravity != gravity) {
            this.mExpandedTextGravity = gravity;
            recalculate();
        }
    }

    /* access modifiers changed from: package-private */
    public int getExpandedTextGravity() {
        return this.mExpandedTextGravity;
    }

    /* access modifiers changed from: package-private */
    public void setCollapsedTextGravity(int gravity) {
        if (this.mCollapsedTextGravity != gravity) {
            this.mCollapsedTextGravity = gravity;
            recalculate();
        }
    }

    /* access modifiers changed from: package-private */
    public int getCollapsedTextGravity() {
        return this.mCollapsedTextGravity;
    }

    /* access modifiers changed from: package-private */
    public void setCollapsedTextAppearance(int resId) {
        TypedArray a = this.mView.getContext().obtainStyledAttributes(resId, R.styleable.TextAppearance);
        if (a.hasValue(3)) {
            this.mCollapsedTextColor = a.getColor(3, this.mCollapsedTextColor);
        }
        if (a.hasValue(0)) {
            this.mCollapsedTextSize = (float) a.getDimensionPixelSize(0, (int) this.mCollapsedTextSize);
        }
        this.mCollapsedShadowColor = a.getInt(4, 0);
        this.mCollapsedShadowDx = a.getFloat(5, 0.0f);
        this.mCollapsedShadowDy = a.getFloat(6, 0.0f);
        this.mCollapsedShadowRadius = a.getFloat(7, 0.0f);
        a.recycle();
        if (Build.VERSION.SDK_INT >= 16) {
            this.mCollapsedTypeface = readFontFamilyTypeface(resId);
        }
        recalculate();
    }

    /* access modifiers changed from: package-private */
    public void setExpandedTextAppearance(int resId) {
        TypedArray a = this.mView.getContext().obtainStyledAttributes(resId, R.styleable.TextAppearance);
        if (a.hasValue(3)) {
            this.mExpandedTextColor = a.getColor(3, this.mExpandedTextColor);
        }
        if (a.hasValue(0)) {
            this.mExpandedTextSize = (float) a.getDimensionPixelSize(0, (int) this.mExpandedTextSize);
        }
        this.mExpandedShadowColor = a.getInt(4, 0);
        this.mExpandedShadowDx = a.getFloat(5, 0.0f);
        this.mExpandedShadowDy = a.getFloat(6, 0.0f);
        this.mExpandedShadowRadius = a.getFloat(7, 0.0f);
        a.recycle();
        if (Build.VERSION.SDK_INT >= 16) {
            this.mExpandedTypeface = readFontFamilyTypeface(resId);
        }
        recalculate();
    }

    /* access modifiers changed from: package-private */
    public void setMaxLines(int maxLines2) {
        if (maxLines2 != this.maxLines) {
            this.maxLines = maxLines2;
            clearTexture();
            recalculate();
        }
    }

    /* access modifiers changed from: package-private */
    public int getMaxLines() {
        return this.maxLines;
    }

    private Typeface readFontFamilyTypeface(int resId) {
        TypedArray a = this.mView.getContext().obtainStyledAttributes(resId, new int[]{16843692});
        try {
            String family = a.getString(0);
            if (family != null) {
                return Typeface.create(family, 0);
            }
            a.recycle();
            return null;
        } finally {
            a.recycle();
        }
    }

    /* access modifiers changed from: package-private */
    public void setCollapsedTypeface(Typeface typeface) {
        if (this.mCollapsedTypeface != typeface) {
            this.mCollapsedTypeface = typeface;
            recalculate();
        }
    }

    /* access modifiers changed from: package-private */
    public void setExpandedTypeface(Typeface typeface) {
        if (this.mExpandedTypeface != typeface) {
            this.mExpandedTypeface = typeface;
            recalculate();
        }
    }

    /* access modifiers changed from: package-private */
    public void setTypefaces(Typeface typeface) {
        this.mExpandedTypeface = typeface;
        this.mCollapsedTypeface = typeface;
        recalculate();
    }

    /* access modifiers changed from: package-private */
    public Typeface getCollapsedTypeface() {
        Typeface typeface = this.mCollapsedTypeface;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    /* access modifiers changed from: package-private */
    public Typeface getExpandedTypeface() {
        Typeface typeface = this.mExpandedTypeface;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    /* access modifiers changed from: package-private */
    public void setExpansionFraction(float fraction) {
        float fraction2 = MathUtils.constrain(fraction, 0.0f, 1.0f);
        if (fraction2 != this.mExpandedFraction) {
            this.mExpandedFraction = fraction2;
            calculateCurrentOffsets();
        }
    }

    /* access modifiers changed from: package-private */
    public float getExpansionFraction() {
        return this.mExpandedFraction;
    }

    /* access modifiers changed from: package-private */
    public float getCollapsedTextSize() {
        return this.mCollapsedTextSize;
    }

    /* access modifiers changed from: package-private */
    public float getExpandedTextSize() {
        return this.mExpandedTextSize;
    }

    private void calculateCurrentOffsets() {
        calculateOffsets(this.mExpandedFraction);
    }

    private void calculateOffsets(float fraction) {
        interpolateBounds(fraction);
        this.mCurrentDrawX = lerp(this.mExpandedDrawX, this.mCollapsedDrawX, fraction, this.mPositionInterpolator);
        this.mCurrentDrawY = lerp(this.mExpandedDrawY, this.mCollapsedDrawY, fraction, this.mPositionInterpolator);
        setInterpolatedTextSize(lerp(this.mExpandedTextSize, this.mCollapsedTextSize, fraction, this.mTextSizeInterpolator));
        setCollapsedTextBlend(1.0f - lerp(0.0f, 1.0f, 1.0f - fraction, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        setExpandedTextBlend(lerp(1.0f, 0.0f, fraction, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        int i = this.mCollapsedTextColor;
        int i2 = this.mExpandedTextColor;
        if (i != i2) {
            this.mTextPaint.setColor(blendColors(i2, i, fraction));
        } else {
            this.mTextPaint.setColor(i);
        }
        this.mTextPaint.setShadowLayer(lerp(this.mExpandedShadowRadius, this.mCollapsedShadowRadius, fraction, (Interpolator) null), lerp(this.mExpandedShadowDx, this.mCollapsedShadowDx, fraction, (Interpolator) null), lerp(this.mExpandedShadowDy, this.mCollapsedShadowDy, fraction, (Interpolator) null), blendColors(this.mExpandedShadowColor, this.mCollapsedShadowColor, fraction));
        ViewCompat.postInvalidateOnAnimation(this.mView);
    }

    private void calculateBaseOffsets() {
        float currentTextSize = this.mCurrentTextSize;
        calculateUsingTextSize(this.mCollapsedTextSize);
        CharSequence charSequence = this.mTextToDraw;
        this.mTextToDrawCollapsed = charSequence;
        float textHeight = 0.0f;
        float width = charSequence != null ? this.mTextPaint.measureText(charSequence, 0, charSequence.length()) : 0.0f;
        int collapsedAbsGravity = GravityCompat.getAbsoluteGravity(this.mCollapsedTextGravity, this.mIsRtl ? 1 : 0);
        StaticLayout staticLayout = this.mTextLayout;
        float textHeight2 = staticLayout != null ? (float) staticLayout.getHeight() : 0.0f;
        int i = collapsedAbsGravity & 112;
        if (i == 48) {
            this.mCollapsedDrawY = (float) this.mCollapsedBounds.top;
        } else if (i != 80) {
            this.mCollapsedDrawY = ((float) this.mCollapsedBounds.centerY()) - (textHeight2 / 2.0f);
        } else {
            this.mCollapsedDrawY = ((float) this.mCollapsedBounds.bottom) - textHeight2;
        }
        int i2 = collapsedAbsGravity & 8388615;
        if (i2 == 1) {
            this.mCollapsedDrawX = ((float) this.mCollapsedBounds.centerX()) - (width / 2.0f);
        } else if (i2 != 5) {
            this.mCollapsedDrawX = (float) this.mCollapsedBounds.left;
        } else {
            this.mCollapsedDrawX = ((float) this.mCollapsedBounds.right) - width;
        }
        calculateUsingTextSize(this.mExpandedTextSize);
        StaticLayout staticLayout2 = this.mTextLayout;
        float width2 = staticLayout2 != null ? staticLayout2.getLineWidth(0) : 0.0f;
        StaticLayout staticLayout3 = this.mTextLayout;
        this.mExpandedFirstLineDrawX = staticLayout3 != null ? staticLayout3.getLineLeft(0) : 0.0f;
        int expandedAbsGravity = GravityCompat.getAbsoluteGravity(this.mExpandedTextGravity, this.mIsRtl ? 1 : 0);
        StaticLayout staticLayout4 = this.mTextLayout;
        if (staticLayout4 != null) {
            textHeight = (float) staticLayout4.getHeight();
        }
        int i3 = expandedAbsGravity & 112;
        if (i3 == 48) {
            this.mExpandedDrawY = (float) this.mExpandedBounds.top;
        } else if (i3 != 80) {
            this.mExpandedDrawY = ((float) this.mExpandedBounds.centerY()) - (textHeight / 2.0f);
        } else {
            this.mExpandedDrawY = ((float) this.mExpandedBounds.bottom) - textHeight;
        }
        int i4 = expandedAbsGravity & 8388615;
        if (i4 == 1) {
            this.mExpandedDrawX = ((float) this.mExpandedBounds.centerX()) - (width2 / 2.0f);
        } else if (i4 != 5) {
            this.mExpandedDrawX = (float) this.mExpandedBounds.left;
        } else {
            this.mExpandedDrawX = ((float) this.mExpandedBounds.right) - width2;
        }
        clearTexture();
        setInterpolatedTextSize(currentTextSize);
    }

    private void interpolateBounds(float fraction) {
        this.mCurrentBounds.left = lerp((float) this.mExpandedBounds.left, (float) this.mCollapsedBounds.left, fraction, this.mPositionInterpolator);
        this.mCurrentBounds.top = lerp(this.mExpandedDrawY, this.mCollapsedDrawY, fraction, this.mPositionInterpolator);
        this.mCurrentBounds.right = lerp((float) this.mExpandedBounds.right, (float) this.mCollapsedBounds.right, fraction, this.mPositionInterpolator);
        this.mCurrentBounds.bottom = lerp((float) this.mExpandedBounds.bottom, (float) this.mCollapsedBounds.bottom, fraction, this.mPositionInterpolator);
    }

    public void draw(Canvas canvas) {
        float ascent;
        Canvas canvas2 = canvas;
        int saveCount = canvas.save();
        if (this.mTextToDraw != null && this.mDrawTitle) {
            float x = this.mCurrentDrawX;
            float y = this.mCurrentDrawY;
            boolean drawTexture = this.mUseTexture && this.mExpandedTitleTexture != null;
            this.mTextPaint.setTextSize(this.mCurrentTextSize);
            if (drawTexture) {
                ascent = 0.0f;
            } else {
                ascent = this.mTextPaint.ascent() * this.mScale;
            }
            float f = this.mScale;
            if (f != 1.0f) {
                canvas2.scale(f, f, x, y);
            }
            float currentExpandedX = (this.mCurrentDrawX + this.mTextLayout.getLineLeft(0)) - (this.mExpandedFirstLineDrawX * 2.0f);
            if (drawTexture) {
                this.mTexturePaint.setAlpha((int) (this.mExpandedTextBlend * 255.0f));
                canvas2.drawBitmap(this.mExpandedTitleTexture, currentExpandedX, y, this.mTexturePaint);
                this.mTexturePaint.setAlpha((int) (this.mCollapsedTextBlend * 255.0f));
                canvas2.drawBitmap(this.mCollapsedTitleTexture, x, y, this.mTexturePaint);
                this.mTexturePaint.setAlpha(KotlinVersion.MAX_COMPONENT_VALUE);
                canvas2.drawBitmap(this.mCrossSectionTitleTexture, x, y, this.mTexturePaint);
            } else {
                canvas2.translate(currentExpandedX, y);
                this.mTextPaint.setAlpha((int) (this.mExpandedTextBlend * 255.0f));
                this.mTextLayout.draw(canvas2);
                canvas2.translate(x - currentExpandedX, 0.0f);
                this.mTextPaint.setAlpha((int) (this.mCollapsedTextBlend * 255.0f));
                CharSequence charSequence = this.mTextToDrawCollapsed;
                canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, (-ascent) / this.mScale, this.mTextPaint);
                this.mTextPaint.setAlpha(KotlinVersion.MAX_COMPONENT_VALUE);
                canvas.drawText(this.mTextToDraw, this.mTextLayout.getLineStart(0), this.mTextLayout.getLineEnd(0), 0.0f, (-ascent) / this.mScale, this.mTextPaint);
            }
        }
        canvas2.restoreToCount(saveCount);
    }

    private boolean calculateIsRtl(CharSequence text) {
        boolean defaultIsRtl = true;
        if (ViewCompat.getLayoutDirection(this.mView) != 1) {
            defaultIsRtl = false;
        }
        return (defaultIsRtl ? TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL : TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR).isRtl(text, 0, text.length());
    }

    private void setInterpolatedTextSize(float textSize) {
        calculateUsingTextSize(textSize);
        boolean z = USE_SCALING_TEXTURE && this.mScale != 1.0f;
        this.mUseTexture = z;
        if (z) {
            ensureExpandedTexture();
            ensureCollapsedTexture();
            ensureCrossSectionTexture();
        }
        ViewCompat.postInvalidateOnAnimation(this.mView);
    }

    private void setCollapsedTextBlend(float blend) {
        this.mCollapsedTextBlend = blend;
        ViewCompat.postInvalidateOnAnimation(this.mView);
    }

    private void setExpandedTextBlend(float blend) {
        this.mExpandedTextBlend = blend;
        ViewCompat.postInvalidateOnAnimation(this.mView);
    }

    private void calculateUsingTextSize(float textSize) {
        float newTextSize;
        int maxLines2;
        float availableWidth;
        CharSequence truncatedText;
        Layout.Alignment alignment;
        float f = textSize;
        if (this.mText != null) {
            boolean updateDrawText = false;
            if (isClose(f, this.mCollapsedTextSize)) {
                availableWidth = (float) this.mCollapsedBounds.width();
                newTextSize = this.mCollapsedTextSize;
                this.mScale = 1.0f;
                Typeface typeface = this.mCurrentTypeface;
                Typeface typeface2 = this.mCollapsedTypeface;
                if (typeface != typeface2) {
                    this.mCurrentTypeface = typeface2;
                    updateDrawText = true;
                }
                maxLines2 = 1;
            } else {
                availableWidth = (float) this.mExpandedBounds.width();
                newTextSize = this.mExpandedTextSize;
                Typeface typeface3 = this.mCurrentTypeface;
                Typeface typeface4 = this.mExpandedTypeface;
                if (typeface3 != typeface4) {
                    this.mCurrentTypeface = typeface4;
                    updateDrawText = true;
                }
                if (isClose(f, this.mExpandedTextSize)) {
                    this.mScale = 1.0f;
                } else {
                    this.mScale = f / this.mExpandedTextSize;
                }
                maxLines2 = this.maxLines;
            }
            if (availableWidth > 0.0f) {
                updateDrawText = this.mCurrentTextSize != newTextSize || this.mBoundsChanged || updateDrawText;
                this.mCurrentTextSize = newTextSize;
                this.mBoundsChanged = false;
            }
            if (this.mTextToDraw == null || updateDrawText) {
                this.mTextPaint.setTextSize(this.mCurrentTextSize);
                this.mTextPaint.setTypeface(this.mCurrentTypeface);
                StaticLayout staticLayout = new StaticLayout(this.mText, this.mTextPaint, (int) availableWidth, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
                if (staticLayout.getLineCount() > maxLines2) {
                    int lastLine = maxLines2 - 1;
                    String textBefore = lastLine > 0 ? this.mText.subSequence(0, staticLayout.getLineEnd(lastLine - 1)) : "";
                    CharSequence lineText = this.mText.subSequence(staticLayout.getLineStart(lastLine), staticLayout.getLineEnd(lastLine));
                    CharSequence lineEnd = "";
                    if (lineText.charAt(lineText.length() - 1) == ' ') {
                        lineEnd = lineText.subSequence(lineText.length() - 1, lineText.length());
                        lineText = lineText.subSequence(0, lineText.length() - 1);
                    }
                    truncatedText = TextUtils.concat(new CharSequence[]{textBefore, TextUtils.ellipsize(TextUtils.concat(new CharSequence[]{lineText, "…", lineEnd}), this.mTextPaint, availableWidth, TextUtils.TruncateAt.END)});
                } else {
                    truncatedText = this.mText;
                }
                if (!TextUtils.equals(truncatedText, this.mTextToDraw)) {
                    this.mTextToDraw = truncatedText;
                    this.mIsRtl = calculateIsRtl(truncatedText);
                }
                int i = this.mExpandedTextGravity & 8388615;
                if (i == 1) {
                    alignment = Layout.Alignment.ALIGN_CENTER;
                } else if (i == 5 || i == 8388613) {
                    alignment = Layout.Alignment.ALIGN_OPPOSITE;
                } else {
                    alignment = Layout.Alignment.ALIGN_NORMAL;
                }
                StaticLayout staticLayout2 = r9;
                StaticLayout staticLayout3 = new StaticLayout(this.mTextToDraw, this.mTextPaint, (int) availableWidth, alignment, 1.0f, 0.0f, false);
                this.mTextLayout = staticLayout2;
            }
        }
    }

    private void ensureExpandedTexture() {
        if (this.mExpandedTitleTexture == null && !this.mExpandedBounds.isEmpty() && !TextUtils.isEmpty(this.mTextToDraw)) {
            calculateOffsets(0.0f);
            int w = this.mTextLayout.getWidth();
            int h = this.mTextLayout.getHeight();
            if (w > 0 && h > 0) {
                this.mExpandedTitleTexture = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
                this.mTextLayout.draw(new Canvas(this.mExpandedTitleTexture));
                if (this.mTexturePaint == null) {
                    this.mTexturePaint = new Paint(3);
                }
            }
        }
    }

    private void ensureCollapsedTexture() {
        if (this.mCollapsedTitleTexture == null && !this.mCollapsedBounds.isEmpty() && !TextUtils.isEmpty(this.mTextToDraw)) {
            calculateOffsets(0.0f);
            TextPaint textPaint = this.mTextPaint;
            CharSequence charSequence = this.mTextToDraw;
            int w = Math.round(textPaint.measureText(charSequence, 0, charSequence.length()));
            int h = Math.round(this.mTextPaint.descent() - this.mTextPaint.ascent());
            if (w > 0 || h > 0) {
                this.mCollapsedTitleTexture = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
                Canvas c = new Canvas(this.mCollapsedTitleTexture);
                CharSequence charSequence2 = this.mTextToDrawCollapsed;
                c.drawText(charSequence2, 0, charSequence2.length(), 0.0f, (-this.mTextPaint.ascent()) / this.mScale, this.mTextPaint);
                if (this.mTexturePaint == null) {
                    this.mTexturePaint = new Paint(3);
                }
            }
        }
    }

    private void ensureCrossSectionTexture() {
        if (this.mCrossSectionTitleTexture == null && !this.mCollapsedBounds.isEmpty() && !TextUtils.isEmpty(this.mTextToDraw)) {
            calculateOffsets(0.0f);
            int w = Math.round(this.mTextPaint.measureText(this.mTextToDraw, this.mTextLayout.getLineStart(0), this.mTextLayout.getLineEnd(0)));
            int h = Math.round(this.mTextPaint.descent() - this.mTextPaint.ascent());
            if (w > 0 || h > 0) {
                this.mCrossSectionTitleTexture = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
                new Canvas(this.mCrossSectionTitleTexture).drawText(this.mTextToDraw, this.mTextLayout.getLineStart(0), this.mTextLayout.getLineEnd(0), 0.0f, (-this.mTextPaint.ascent()) / this.mScale, this.mTextPaint);
                if (this.mTexturePaint == null) {
                    this.mTexturePaint = new Paint(3);
                }
            }
        }
    }

    public void recalculate() {
        if (this.mView.getHeight() > 0 && this.mView.getWidth() > 0) {
            calculateBaseOffsets();
            calculateCurrentOffsets();
        }
    }

    /* access modifiers changed from: package-private */
    public void setText(CharSequence text) {
        if (text == null || !text.equals(this.mText)) {
            this.mText = text;
            this.mTextToDraw = null;
            clearTexture();
            recalculate();
        }
    }

    /* access modifiers changed from: package-private */
    public CharSequence getText() {
        return this.mText;
    }

    private void clearTexture() {
        Bitmap bitmap = this.mExpandedTitleTexture;
        if (bitmap != null) {
            bitmap.recycle();
            this.mExpandedTitleTexture = null;
        }
        Bitmap bitmap2 = this.mCollapsedTitleTexture;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.mCollapsedTitleTexture = null;
        }
        Bitmap bitmap3 = this.mCrossSectionTitleTexture;
        if (bitmap3 != null) {
            bitmap3.recycle();
            this.mCrossSectionTitleTexture = null;
        }
    }

    private static boolean isClose(float value, float targetValue) {
        return Math.abs(value - targetValue) < 0.001f;
    }

    /* access modifiers changed from: package-private */
    public int getExpandedTextColor() {
        return this.mExpandedTextColor;
    }

    /* access modifiers changed from: package-private */
    public int getCollapsedTextColor() {
        return this.mCollapsedTextColor;
    }

    private static int blendColors(int color1, int color2, float ratio) {
        float inverseRatio = 1.0f - ratio;
        return Color.argb((int) ((((float) Color.alpha(color1)) * inverseRatio) + (((float) Color.alpha(color2)) * ratio)), (int) ((((float) Color.red(color1)) * inverseRatio) + (((float) Color.red(color2)) * ratio)), (int) ((((float) Color.green(color1)) * inverseRatio) + (((float) Color.green(color2)) * ratio)), (int) ((((float) Color.blue(color1)) * inverseRatio) + (((float) Color.blue(color2)) * ratio)));
    }

    private static float lerp(float startValue, float endValue, float fraction, Interpolator interpolator) {
        if (interpolator != null) {
            fraction = interpolator.getInterpolation(fraction);
        }
        return AnimationUtils.lerp(startValue, endValue, fraction);
    }

    private static boolean rectEquals(Rect r, int left, int top, int right, int bottom) {
        return r.left == left && r.top == top && r.right == right && r.bottom == bottom;
    }
}
