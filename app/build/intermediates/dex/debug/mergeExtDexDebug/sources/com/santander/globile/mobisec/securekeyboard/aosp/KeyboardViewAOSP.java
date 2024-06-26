package com.santander.globile.mobisec.securekeyboard.aosp;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.santander.globile.mobisec.securekeyboard.R;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.KotlinVersion;

public class KeyboardViewAOSP extends View implements View.OnClickListener {
    private static final int DEBOUNCE_TIME = 70;
    private static final boolean DEBUG = false;
    private static final int DELAY_AFTER_PREVIEW = 70;
    private static final int DELAY_BEFORE_PREVIEW = 0;
    private static final int[] KEY_DELETE = {-5};
    private static final int LONGPRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout();
    private static final int[] LONG_PRESSABLE_STATE_SET = {R.attr.state_long_pressable};
    private static int MAX_NEARBY_KEYS = 12;
    private static final int MSG_LONGPRESS = 4;
    private static final int MSG_REMOVE_PREVIEW = 2;
    private static final int MSG_REPEAT = 3;
    private static final int MSG_SHOW_PREVIEW = 1;
    private static final int MULTITAP_INTERVAL = 800;
    private static final int NOT_A_KEY = -1;
    private static final int REPEAT_INTERVAL = 50;
    private static final int REPEAT_START_DELAY = 400;
    private boolean mAbortKey;
    private AccessibilityManager mAccessibilityManager;
    private AudioManager mAudioManager;
    private float mBackgroundDimAmount;
    private Bitmap mBuffer;
    private Canvas mCanvas;
    private Rect mClipRegion;
    private final int[] mCoordinates;
    private int mCurrentKey;
    private int mCurrentKeyIndex;
    private long mCurrentKeyTime;
    private Rect mDirtyRect;
    /* access modifiers changed from: private */
    public boolean mDisambiguateSwipe;
    private int[] mDistances;
    /* access modifiers changed from: private */
    public int mDownKey;
    private long mDownTime;
    private boolean mDrawPending;
    private GestureDetector mGestureDetector;
    Handler mHandler;
    private boolean mHeadsetRequiredToHearPasswordsAnnounced;
    private boolean mInMultiTap;
    private KeyAOSP mInvalidatedKey;
    private Drawable mKeyBackground;
    private int[] mKeyIndices;
    private int mKeyTextColor;
    private int mKeyTextSize;
    private KeyboardAOSP mKeyboard;
    /* access modifiers changed from: private */
    public OnKeyboardActionListener mKeyboardActionListener;
    private boolean mKeyboardChanged;
    private KeyAOSP[] mKeys;
    private int mLabelTextSize;
    private int mLastCodeX;
    private int mLastCodeY;
    private int mLastKey;
    private long mLastKeyTime;
    private long mLastMoveTime;
    private int mLastSentIndex;
    private long mLastTapTime;
    private int mLastX;
    private int mLastY;
    private KeyboardViewAOSP mMiniKeyboard;
    private Map<KeyAOSP, View> mMiniKeyboardCache;
    private View mMiniKeyboardContainer;
    private int mMiniKeyboardOffsetX;
    private int mMiniKeyboardOffsetY;
    private boolean mMiniKeyboardOnScreen;
    private int mOldPointerCount;
    private float mOldPointerX;
    private float mOldPointerY;
    private Rect mPadding;
    private Paint mPaint;
    private PopupWindow mPopupKeyboard;
    private int mPopupLayout;
    private View mPopupParent;
    private int mPopupPreviewX;
    private int mPopupPreviewY;
    private int mPopupX;
    private int mPopupY;
    /* access modifiers changed from: private */
    public boolean mPossiblePoly;
    private boolean mPreviewCentered;
    private int mPreviewHeight;
    private StringBuilder mPreviewLabel;
    private int mPreviewOffset;
    private PopupWindow mPreviewPopup;
    /* access modifiers changed from: private */
    public TextView mPreviewText;
    private int mPreviewTextSizeLarge;
    private boolean mProximityCorrectOn;
    private int mProximityThreshold;
    private int mRepeatKeyIndex;
    private int mShadowColor;
    private float mShadowRadius;
    private boolean mShowPreview;
    private boolean mShowTouchPoints;
    /* access modifiers changed from: private */
    public int mStartX;
    /* access modifiers changed from: private */
    public int mStartY;
    /* access modifiers changed from: private */
    public int mSwipeThreshold;
    /* access modifiers changed from: private */
    public SwipeTracker mSwipeTracker;
    private int mTapCount;
    private int mVerticalCorrection;

    public interface OnKeyboardActionListener {
        void onKey(int i, int[] iArr);

        void onPress(int i);

        void onRelease(int i);

        void onText(CharSequence charSequence);

        void swipeDown();

        void swipeLeft();

        void swipeRight();

        void swipeUp();
    }

    public KeyboardViewAOSP(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.keyboardViewStyle);
    }

    public KeyboardViewAOSP(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mCurrentKeyIndex = -1;
        this.mCoordinates = new int[2];
        this.mPreviewCentered = false;
        this.mShowPreview = true;
        this.mShowTouchPoints = true;
        this.mCurrentKey = -1;
        this.mDownKey = -1;
        this.mKeyIndices = new int[12];
        this.mRepeatKeyIndex = -1;
        this.mClipRegion = new Rect(0, 0, 0, 0);
        this.mSwipeTracker = new SwipeTracker();
        this.mOldPointerCount = 1;
        this.mDistances = new int[MAX_NEARBY_KEYS];
        this.mPreviewLabel = new StringBuilder(1);
        this.mDirtyRect = new Rect();
        initView(context, attrs, defStyleAttr, 0);
    }

    public KeyboardViewAOSP(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
        this.mCurrentKeyIndex = -1;
        this.mCoordinates = new int[2];
        this.mPreviewCentered = false;
        this.mShowPreview = true;
        this.mShowTouchPoints = true;
        this.mCurrentKey = -1;
        this.mDownKey = -1;
        this.mKeyIndices = new int[12];
        this.mRepeatKeyIndex = -1;
        this.mClipRegion = new Rect(0, 0, 0, 0);
        this.mSwipeTracker = new SwipeTracker();
        this.mOldPointerCount = 1;
        this.mDistances = new int[MAX_NEARBY_KEYS];
        this.mPreviewLabel = new StringBuilder(1);
        this.mDirtyRect = new Rect();
        initView(context, attrs, defStyleAttr, 0);
    }

    private void initView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.KeyboardViewAOSP, defStyleAttr, defStyleRes);
        LayoutInflater inflate = (LayoutInflater) context.getSystemService("layout_inflater");
        int previewLayout = 0;
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            if (attr == R.styleable.KeyboardViewAOSP_keyBackground) {
                this.mKeyBackground = a.getDrawable(attr);
            } else if (attr == R.styleable.KeyboardViewAOSP_verticalCorrection) {
                this.mVerticalCorrection = a.getDimensionPixelOffset(attr, 0);
            } else if (attr == R.styleable.KeyboardViewAOSP_keyPreviewLayout) {
                previewLayout = a.getResourceId(attr, 0);
            } else if (attr == R.styleable.KeyboardViewAOSP_keyPreviewOffset) {
                this.mPreviewOffset = a.getDimensionPixelOffset(attr, 0);
            } else if (attr == R.styleable.KeyboardViewAOSP_keyPreviewHeight) {
                this.mPreviewHeight = a.getDimensionPixelSize(attr, 80);
            } else if (attr == R.styleable.KeyboardViewAOSP_keyTextSize) {
                this.mKeyTextSize = a.getDimensionPixelSize(attr, 18);
            } else if (attr == R.styleable.KeyboardViewAOSP_keyTextColor) {
                this.mKeyTextColor = a.getColor(attr, -16777216);
            } else if (attr == R.styleable.KeyboardViewAOSP_labelTextSize) {
                this.mLabelTextSize = a.getDimensionPixelSize(attr, 14);
            } else if (attr == R.styleable.KeyboardViewAOSP_popupLayout) {
                this.mPopupLayout = a.getResourceId(attr, 0);
            } else if (attr == R.styleable.KeyboardViewAOSP_shadowColor) {
                this.mShadowColor = a.getColor(attr, 0);
            } else if (attr == R.styleable.KeyboardViewAOSP_shadowRadius) {
                this.mShadowRadius = a.getFloat(attr, 0.0f);
            }
        }
        this.mBackgroundDimAmount = getContext().obtainStyledAttributes(R.styleable.Theme).getFloat(R.styleable.Theme_backgroundDimAmount, 0.5f);
        this.mPreviewPopup = new PopupWindow(context);
        if (previewLayout != 0) {
            TextView textView = (TextView) inflate.inflate(previewLayout, (ViewGroup) null);
            this.mPreviewText = textView;
            this.mPreviewTextSizeLarge = (int) textView.getTextSize();
            this.mPreviewPopup.setContentView(this.mPreviewText);
            this.mPreviewPopup.setBackgroundDrawable((Drawable) null);
        } else {
            this.mShowPreview = false;
        }
        this.mPreviewPopup.setTouchable(false);
        PopupWindow popupWindow = new PopupWindow(context);
        this.mPopupKeyboard = popupWindow;
        popupWindow.setBackgroundDrawable((Drawable) null);
        this.mPopupParent = this;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setTextSize((float) 0);
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        this.mPaint.setAlpha(KotlinVersion.MAX_COMPONENT_VALUE);
        this.mPadding = new Rect(0, 0, 0, 0);
        this.mMiniKeyboardCache = new HashMap();
        this.mKeyBackground.getPadding(this.mPadding);
        this.mSwipeThreshold = (int) (getResources().getDisplayMetrics().density * 500.0f);
        this.mDisambiguateSwipe = getResources().getBoolean(Resources.getSystem().getIdentifier("config_swipeDisambiguation", "bool", "android"));
        this.mAccessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        this.mAudioManager = (AudioManager) context.getSystemService("audio");
        resetMultiTap();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        initGestureDetector();
        if (this.mHandler == null) {
            this.mHandler = new Handler() {
                public void handleMessage(Message msg) {
                    int i = msg.what;
                    if (i == 1) {
                        KeyboardViewAOSP.this.showKey(msg.arg1);
                    } else if (i == 2) {
                        KeyboardViewAOSP.this.mPreviewText.setVisibility(4);
                    } else if (i != 3) {
                        if (i == 4) {
                            boolean unused = KeyboardViewAOSP.this.openPopupIfRequired((MotionEvent) msg.obj);
                        }
                    } else if (KeyboardViewAOSP.this.repeatKey()) {
                        sendMessageDelayed(Message.obtain(this, 3), 50);
                    }
                }
            };
        }
    }

    private void initGestureDetector() {
        if (this.mGestureDetector == null) {
            GestureDetector gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
                public boolean onFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY) {
                    if (KeyboardViewAOSP.this.mPossiblePoly) {
                        return false;
                    }
                    float absX = Math.abs(velocityX);
                    float absY = Math.abs(velocityY);
                    float deltaX = me2.getX() - me1.getX();
                    float deltaY = me2.getY() - me1.getY();
                    int travelX = KeyboardViewAOSP.this.getWidth() / 2;
                    int travelY = KeyboardViewAOSP.this.getHeight() / 2;
                    KeyboardViewAOSP.this.mSwipeTracker.computeCurrentVelocity(1000);
                    float endingVelocityX = KeyboardViewAOSP.this.mSwipeTracker.getXVelocity();
                    float endingVelocityY = KeyboardViewAOSP.this.mSwipeTracker.getYVelocity();
                    boolean sendDownKey = false;
                    if (velocityX <= ((float) KeyboardViewAOSP.this.mSwipeThreshold) || absY >= absX || deltaX <= ((float) travelX)) {
                        if (velocityX >= ((float) (-KeyboardViewAOSP.this.mSwipeThreshold)) || absY >= absX || deltaX >= ((float) (-travelX))) {
                            if (velocityY >= ((float) (-KeyboardViewAOSP.this.mSwipeThreshold)) || absX >= absY || deltaY >= ((float) (-travelY))) {
                                if (velocityY > ((float) KeyboardViewAOSP.this.mSwipeThreshold) && absX < absY / 2.0f && deltaY > ((float) travelY)) {
                                    if (!KeyboardViewAOSP.this.mDisambiguateSwipe || endingVelocityY >= velocityY / 4.0f) {
                                        KeyboardViewAOSP.this.swipeDown();
                                        return true;
                                    }
                                    sendDownKey = true;
                                }
                            } else if (!KeyboardViewAOSP.this.mDisambiguateSwipe || endingVelocityY <= velocityY / 4.0f) {
                                KeyboardViewAOSP.this.swipeUp();
                                return true;
                            } else {
                                sendDownKey = true;
                            }
                        } else if (!KeyboardViewAOSP.this.mDisambiguateSwipe || endingVelocityX <= velocityX / 4.0f) {
                            KeyboardViewAOSP.this.swipeLeft();
                            return true;
                        } else {
                            sendDownKey = true;
                        }
                    } else if (!KeyboardViewAOSP.this.mDisambiguateSwipe || endingVelocityX >= velocityX / 4.0f) {
                        KeyboardViewAOSP.this.swipeRight();
                        return true;
                    } else {
                        sendDownKey = true;
                    }
                    if (sendDownKey) {
                        KeyboardViewAOSP keyboardViewAOSP = KeyboardViewAOSP.this;
                        keyboardViewAOSP.detectAndSendKey(keyboardViewAOSP.mDownKey, KeyboardViewAOSP.this.mStartX, KeyboardViewAOSP.this.mStartY, me1.getEventTime());
                    }
                    return false;
                }
            });
            this.mGestureDetector = gestureDetector;
            gestureDetector.setIsLongpressEnabled(false);
        }
    }

    public void setOnKeyboardActionListener(OnKeyboardActionListener listener) {
        this.mKeyboardActionListener = listener;
    }

    /* access modifiers changed from: protected */
    public OnKeyboardActionListener getOnKeyboardActionListener() {
        return this.mKeyboardActionListener;
    }

    public void setKeyboard(KeyboardAOSP keyboard) {
        if (this.mKeyboard != null) {
            showPreview(-1);
        }
        removeMessages();
        this.mKeyboard = keyboard;
        List<KeyAOSP> keys = keyboard.getKeys();
        this.mKeys = (KeyAOSP[]) keys.toArray(new KeyAOSP[keys.size()]);
        requestLayout();
        this.mKeyboardChanged = true;
        invalidateAllKeys();
        computeProximityThreshold(keyboard);
        this.mMiniKeyboardCache.clear();
        this.mAbortKey = true;
    }

    public KeyboardAOSP getKeyboard() {
        return this.mKeyboard;
    }

    public boolean setShifted(boolean shifted) {
        KeyboardAOSP keyboardAOSP = this.mKeyboard;
        if (keyboardAOSP == null || !keyboardAOSP.setShifted(shifted)) {
            return false;
        }
        invalidateAllKeys();
        return true;
    }

    public boolean isShifted() {
        KeyboardAOSP keyboardAOSP = this.mKeyboard;
        if (keyboardAOSP != null) {
            return keyboardAOSP.isShifted();
        }
        return false;
    }

    public void setPreviewEnabled(boolean previewEnabled) {
        this.mShowPreview = previewEnabled;
    }

    public boolean isPreviewEnabled() {
        return this.mShowPreview;
    }

    public void setVerticalCorrection(int verticalOffset) {
    }

    public void setPopupParent(View v) {
        this.mPopupParent = v;
    }

    public void setPopupOffset(int x, int y) {
        this.mMiniKeyboardOffsetX = x;
        this.mMiniKeyboardOffsetY = y;
        if (this.mPreviewPopup.isShowing()) {
            this.mPreviewPopup.dismiss();
        }
    }

    public void setProximityCorrectionEnabled(boolean enabled) {
        this.mProximityCorrectOn = enabled;
    }

    public boolean isProximityCorrectionEnabled() {
        return this.mProximityCorrectOn;
    }

    public void onClick(View v) {
        dismissPopupKeyboard();
    }

    private CharSequence adjustCase(CharSequence label) {
        if (!this.mKeyboard.isShifted() || label == null || label.length() >= 3 || !Character.isLowerCase(label.charAt(0))) {
            return label;
        }
        return label.toString().toUpperCase();
    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        KeyboardAOSP keyboardAOSP = this.mKeyboard;
        if (keyboardAOSP == null) {
            setMeasuredDimension(getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
            return;
        }
        int width = keyboardAOSP.getMinWidth() + getPaddingLeft() + getPaddingRight();
        if (View.MeasureSpec.getSize(widthMeasureSpec) < width + 10) {
            width = View.MeasureSpec.getSize(widthMeasureSpec);
        }
        setMeasuredDimension(width, this.mKeyboard.getHeight() + getPaddingTop() + getPaddingBottom());
    }

    private void computeProximityThreshold(KeyboardAOSP keyboard) {
        KeyAOSP[] keys;
        if (keyboard != null && (keys = this.mKeys) != null) {
            int dimensionSum = 0;
            for (KeyAOSP key : keys) {
                dimensionSum += Math.min(key.width, key.height) + key.gap;
            }
            if (dimensionSum >= 0 && length != 0) {
                int i = (int) ((((float) dimensionSum) * 1.4f) / ((float) length));
                this.mProximityThreshold = i;
                this.mProximityThreshold = i * i;
            }
        }
    }

    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        KeyboardAOSP keyboardAOSP = this.mKeyboard;
        if (keyboardAOSP != null) {
            keyboardAOSP.resize(w, h);
        }
        this.mBuffer = null;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mDrawPending || this.mBuffer == null || this.mKeyboardChanged) {
            onBufferDraw();
        }
        canvas.drawBitmap(this.mBuffer, 0.0f, 0.0f, (Paint) null);
    }

    private void onBufferDraw() {
        boolean drawSingleKey;
        KeyAOSP[] keys;
        KeyAOSP invalidKey;
        int keyCount;
        Bitmap bitmap = this.mBuffer;
        if (bitmap == null || this.mKeyboardChanged) {
            if (bitmap == null || (this.mKeyboardChanged && !(bitmap.getWidth() == getWidth() && this.mBuffer.getHeight() == getHeight()))) {
                this.mBuffer = Bitmap.createBitmap(Math.max(1, getWidth()), Math.max(1, getHeight()), Bitmap.Config.ARGB_8888);
                this.mCanvas = new Canvas(this.mBuffer);
            }
            invalidateAllKeys();
            this.mKeyboardChanged = false;
        }
        if (this.mKeyboard != null) {
            this.mCanvas.save();
            Canvas canvas = this.mCanvas;
            canvas.clipRect(this.mDirtyRect);
            Paint paint = this.mPaint;
            Drawable keyBackground = this.mKeyBackground;
            Rect clipRegion = this.mClipRegion;
            Rect padding = this.mPadding;
            int kbdPaddingLeft = getPaddingLeft();
            int kbdPaddingTop = getPaddingTop();
            KeyAOSP[] keys2 = this.mKeys;
            KeyAOSP invalidKey2 = this.mInvalidatedKey;
            paint.setColor(this.mKeyTextColor);
            if (invalidKey2 == null || !canvas.getClipBounds(clipRegion) || (invalidKey2.x + kbdPaddingLeft) - 1 > clipRegion.left || (invalidKey2.y + kbdPaddingTop) - 1 > clipRegion.top || invalidKey2.x + invalidKey2.width + kbdPaddingLeft + 1 < clipRegion.right || invalidKey2.y + invalidKey2.height + kbdPaddingTop + 1 < clipRegion.bottom) {
                drawSingleKey = false;
            } else {
                drawSingleKey = true;
            }
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            int keyCount2 = keys2.length;
            int i = 0;
            while (i < keyCount2) {
                KeyAOSP key = keys2[i];
                if (!drawSingleKey || invalidKey2 == key) {
                    int[] drawableState = key.getCurrentDrawableState();
                    keyBackground.setState(drawableState);
                    String label = key.label == null ? null : adjustCase(key.label).toString();
                    Rect bounds = keyBackground.getBounds();
                    int[] iArr = drawableState;
                    keyCount = keyCount2;
                    if (key.width == bounds.right && key.height == bounds.bottom) {
                        Rect rect = bounds;
                    } else {
                        Rect rect2 = bounds;
                        keyBackground.setBounds(0, 0, key.width, key.height);
                    }
                    canvas.translate((float) (key.x + kbdPaddingLeft), (float) (key.y + kbdPaddingTop));
                    keyBackground.draw(canvas);
                    if (label != null) {
                        if (label.length() <= 1 || key.codes.length >= 2) {
                            paint.setTextSize((float) this.mKeyTextSize);
                            paint.setTypeface(Typeface.DEFAULT);
                        } else {
                            paint.setTextSize((float) this.mLabelTextSize);
                            paint.setTypeface(Typeface.DEFAULT_BOLD);
                        }
                        paint.setShadowLayer(this.mShadowRadius, 0.0f, 0.0f, this.mShadowColor);
                        canvas.drawText(label, (float) ((((key.width - padding.left) - padding.right) / 2) + padding.left), ((float) (((key.height - padding.top) - padding.bottom) / 2)) + ((paint.getTextSize() - paint.descent()) / 2.0f) + ((float) padding.top), paint);
                        paint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                        String str = label;
                        invalidKey = invalidKey2;
                        keys = keys2;
                    } else if (key.icon != null) {
                        int drawableX = ((((key.width - padding.left) - padding.right) - key.icon.getIntrinsicWidth()) / 2) + padding.left;
                        int drawableY = ((((key.height - padding.top) - padding.bottom) - key.icon.getIntrinsicHeight()) / 2) + padding.top;
                        String str2 = label;
                        canvas.translate((float) drawableX, (float) drawableY);
                        invalidKey = invalidKey2;
                        keys = keys2;
                        key.icon.setBounds(0, 0, key.icon.getIntrinsicWidth(), key.icon.getIntrinsicHeight());
                        key.icon.draw(canvas);
                        canvas.translate((float) (-drawableX), (float) (-drawableY));
                    } else {
                        invalidKey = invalidKey2;
                        keys = keys2;
                    }
                    canvas.translate((float) ((-key.x) - kbdPaddingLeft), (float) ((-key.y) - kbdPaddingTop));
                } else {
                    keyCount = keyCount2;
                    invalidKey = invalidKey2;
                    keys = keys2;
                }
                i++;
                keyCount2 = keyCount;
                invalidKey2 = invalidKey;
                keys2 = keys;
            }
            int keyCount3 = keyCount2;
            KeyAOSP invalidKey3 = invalidKey2;
            KeyAOSP[] keys3 = keys2;
            this.mInvalidatedKey = null;
            if (this.mMiniKeyboardOnScreen) {
                paint.setColor(((int) (this.mBackgroundDimAmount * 255.0f)) << 24);
                int i2 = keyCount3;
                KeyAOSP keyAOSP = invalidKey3;
                KeyAOSP[] keyAOSPArr = keys3;
                canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), paint);
            } else {
                KeyAOSP keyAOSP2 = invalidKey3;
                KeyAOSP[] keyAOSPArr2 = keys3;
            }
            this.mCanvas.restore();
            this.mDrawPending = false;
            this.mDirtyRect.setEmpty();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0045, code lost:
        if (r11.codes[0] <= 32) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0047, code lost:
        r14 = r11.codes.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004a, code lost:
        if (r12 >= r7) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004c, code lost:
        r7 = r12;
        r6 = r8[r10];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004f, code lost:
        if (r3 != null) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0051, code lost:
        r16 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0054, code lost:
        r15 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0055, code lost:
        r1 = r0.mDistances;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0058, code lost:
        if (r15 >= r1.length) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005c, code lost:
        if (r1[r15] <= r12) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005e, code lost:
        r16 = r4;
        java.lang.System.arraycopy(r1, r15, r1, r15 + r14, (r1.length - r15) - r14);
        java.lang.System.arraycopy(r3, r15, r3, r15 + r14, (r3.length - r15) - r14);
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0071, code lost:
        if (r1 >= r14) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0073, code lost:
        r3[r15 + r1] = r11.codes[r1];
        r0.mDistances[r15 + r1] = r12;
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0085, code lost:
        r16 = r4;
        r15 = r15 + 1;
        r1 = r18;
        r2 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008e, code lost:
        r16 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0091, code lost:
        r16 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0093, code lost:
        r10 = r10 + 1;
        r1 = r18;
        r2 = r19;
        r4 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003a, code lost:
        if (r14 >= r0.mProximityThreshold) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003c, code lost:
        if (r13 != false) goto L_0x003e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int getKeyIndices(int r18, int r19, int[] r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r20
            com.santander.globile.mobisec.securekeyboard.aosp.KeyAOSP[] r4 = r0.mKeys
            r5 = -1
            r6 = -1
            int r7 = r0.mProximityThreshold
            int r7 = r7 + 1
            int[] r8 = r0.mDistances
            r9 = 2147483647(0x7fffffff, float:NaN)
            java.util.Arrays.fill(r8, r9)
            com.santander.globile.mobisec.securekeyboard.aosp.KeyboardAOSP r8 = r0.mKeyboard
            int[] r8 = r8.getNearestKeys(r1, r2)
            int r9 = r8.length
            r10 = 0
        L_0x0020:
            if (r10 >= r9) goto L_0x009c
            r11 = r8[r10]
            r11 = r4[r11]
            r12 = 0
            boolean r13 = r11.isInside(r1, r2)
            if (r13 == 0) goto L_0x002f
            r5 = r8[r10]
        L_0x002f:
            boolean r14 = r0.mProximityCorrectOn
            if (r14 == 0) goto L_0x003c
            int r14 = r11.squaredDistanceFrom(r1, r2)
            r12 = r14
            int r15 = r0.mProximityThreshold
            if (r14 < r15) goto L_0x003e
        L_0x003c:
            if (r13 == 0) goto L_0x0091
        L_0x003e:
            int[] r14 = r11.codes
            r15 = 0
            r14 = r14[r15]
            r15 = 32
            if (r14 <= r15) goto L_0x0091
            int[] r14 = r11.codes
            int r14 = r14.length
            if (r12 >= r7) goto L_0x004f
            r7 = r12
            r6 = r8[r10]
        L_0x004f:
            if (r3 != 0) goto L_0x0054
            r16 = r4
            goto L_0x0093
        L_0x0054:
            r15 = 0
        L_0x0055:
            int[] r1 = r0.mDistances
            int r2 = r1.length
            if (r15 >= r2) goto L_0x008e
            r2 = r1[r15]
            if (r2 <= r12) goto L_0x0085
            int r2 = r15 + r14
            r16 = r4
            int r4 = r1.length
            int r4 = r4 - r15
            int r4 = r4 - r14
            java.lang.System.arraycopy(r1, r15, r1, r2, r4)
            int r1 = r15 + r14
            int r2 = r3.length
            int r2 = r2 - r15
            int r2 = r2 - r14
            java.lang.System.arraycopy(r3, r15, r3, r1, r2)
            r1 = 0
        L_0x0071:
            if (r1 >= r14) goto L_0x0084
            int r2 = r15 + r1
            int[] r4 = r11.codes
            r4 = r4[r1]
            r3[r2] = r4
            int[] r2 = r0.mDistances
            int r4 = r15 + r1
            r2[r4] = r12
            int r1 = r1 + 1
            goto L_0x0071
        L_0x0084:
            goto L_0x0093
        L_0x0085:
            r16 = r4
            int r15 = r15 + 1
            r1 = r18
            r2 = r19
            goto L_0x0055
        L_0x008e:
            r16 = r4
            goto L_0x0093
        L_0x0091:
            r16 = r4
        L_0x0093:
            int r10 = r10 + 1
            r1 = r18
            r2 = r19
            r4 = r16
            goto L_0x0020
        L_0x009c:
            r16 = r4
            r1 = -1
            if (r5 != r1) goto L_0x00a2
            r5 = r6
        L_0x00a2:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.santander.globile.mobisec.securekeyboard.aosp.KeyboardViewAOSP.getKeyIndices(int, int, int[]):int");
    }

    /* access modifiers changed from: private */
    public void detectAndSendKey(int index, int x, int y, long eventTime) {
        if (index != -1) {
            KeyAOSP[] keyAOSPArr = this.mKeys;
            if (index < keyAOSPArr.length) {
                KeyAOSP key = keyAOSPArr[index];
                if (key.text != null) {
                    this.mKeyboardActionListener.onText(key.text);
                    this.mKeyboardActionListener.onRelease(-1);
                } else {
                    int code = key.codes[0];
                    int[] codes = new int[MAX_NEARBY_KEYS];
                    Arrays.fill(codes, -1);
                    getKeyIndices(x, y, codes);
                    if (this.mInMultiTap) {
                        if (this.mTapCount != -1) {
                            this.mKeyboardActionListener.onKey(-5, KEY_DELETE);
                        } else {
                            this.mTapCount = 0;
                        }
                        code = key.codes[this.mTapCount];
                    }
                    this.mKeyboardActionListener.onKey(code, codes);
                    this.mKeyboardActionListener.onRelease(code);
                }
                this.mLastSentIndex = index;
                this.mLastTapTime = eventTime;
            }
        }
    }

    private CharSequence getPreviewText(KeyAOSP key) {
        if (!this.mInMultiTap) {
            return adjustCase(key.label);
        }
        int i = 0;
        this.mPreviewLabel.setLength(0);
        StringBuilder sb = this.mPreviewLabel;
        int[] iArr = key.codes;
        int i2 = this.mTapCount;
        if (i2 >= 0) {
            i = i2;
        }
        sb.append((char) iArr[i]);
        return adjustCase(this.mPreviewLabel);
    }

    private void showPreview(int keyIndex) {
        int oldKeyIndex = this.mCurrentKeyIndex;
        PopupWindow previewPopup = this.mPreviewPopup;
        this.mCurrentKeyIndex = keyIndex;
        KeyAOSP[] keys = this.mKeys;
        if (oldKeyIndex != keyIndex) {
            if (oldKeyIndex != -1 && keys.length > oldKeyIndex) {
                KeyAOSP oldKey = keys[oldKeyIndex];
                oldKey.onReleased(keyIndex == -1);
                invalidateKey(oldKeyIndex);
                int keyCode = oldKey.codes[0];
                sendAccessibilityEventForUnicodeCharacter(256, keyCode);
                sendAccessibilityEventForUnicodeCharacter(65536, keyCode);
            }
            int i = this.mCurrentKeyIndex;
            if (i != -1 && keys.length > i) {
                KeyAOSP newKey = keys[i];
                newKey.onPressed();
                invalidateKey(this.mCurrentKeyIndex);
                int keyCode2 = newKey.codes[0];
                sendAccessibilityEventForUnicodeCharacter(128, keyCode2);
                sendAccessibilityEventForUnicodeCharacter(32768, keyCode2);
            }
        }
        if (oldKeyIndex != this.mCurrentKeyIndex && this.mShowPreview) {
            this.mHandler.removeMessages(1);
            if (previewPopup.isShowing() && keyIndex == -1) {
                Handler handler = this.mHandler;
                handler.sendMessageDelayed(handler.obtainMessage(2), 70);
            }
            if (keyIndex == -1) {
                return;
            }
            if (!previewPopup.isShowing() || this.mPreviewText.getVisibility() != 0) {
                Handler handler2 = this.mHandler;
                handler2.sendMessageDelayed(handler2.obtainMessage(1, keyIndex, 0), 0);
                return;
            }
            showKey(keyIndex);
        }
    }

    /* access modifiers changed from: private */
    public void showKey(int keyIndex) {
        PopupWindow previewPopup = this.mPreviewPopup;
        KeyAOSP[] keys = this.mKeys;
        if (keyIndex >= 0 && keyIndex < this.mKeys.length) {
            KeyAOSP key = keys[keyIndex];
            if (key.icon != null) {
                this.mPreviewText.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, key.iconPreview != null ? key.iconPreview : key.icon);
                this.mPreviewText.setText((CharSequence) null);
            } else {
                this.mPreviewText.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                this.mPreviewText.setText(getPreviewText(key));
                if (key.label.length() <= 1 || key.codes.length >= 2) {
                    this.mPreviewText.setTextSize(0, (float) this.mPreviewTextSizeLarge);
                    this.mPreviewText.setTypeface(Typeface.DEFAULT);
                } else {
                    this.mPreviewText.setTextSize(0, (float) this.mKeyTextSize);
                    this.mPreviewText.setTypeface(Typeface.DEFAULT_BOLD);
                }
            }
            this.mPreviewText.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            int popupWidth = Math.max(this.mPreviewText.getMeasuredWidth(), key.width + this.mPreviewText.getPaddingLeft() + this.mPreviewText.getPaddingRight());
            int popupHeight = this.mPreviewHeight;
            ViewGroup.LayoutParams lp = this.mPreviewText.getLayoutParams();
            if (lp != null) {
                lp.width = popupWidth;
                lp.height = popupHeight;
            }
            if (!this.mPreviewCentered) {
                this.mPopupPreviewX = (key.x - this.mPreviewText.getPaddingLeft()) + getPaddingLeft();
                this.mPopupPreviewY = (key.y - popupHeight) + this.mPreviewOffset;
            } else {
                this.mPopupPreviewX = 160 - (this.mPreviewText.getMeasuredWidth() / 2);
                this.mPopupPreviewY = -this.mPreviewText.getMeasuredHeight();
            }
            this.mHandler.removeMessages(2);
            getLocationInWindow(this.mCoordinates);
            int[] iArr = this.mCoordinates;
            iArr[0] = iArr[0] + this.mMiniKeyboardOffsetX;
            iArr[1] = iArr[1] + this.mMiniKeyboardOffsetY;
            this.mPreviewText.getBackground().setState(key.popupResId != 0 ? LONG_PRESSABLE_STATE_SET : EMPTY_STATE_SET);
            int i = this.mPopupPreviewX;
            int[] iArr2 = this.mCoordinates;
            this.mPopupPreviewX = i + iArr2[0];
            this.mPopupPreviewY += iArr2[1];
            getLocationOnScreen(iArr2);
            if (this.mPopupPreviewY + this.mCoordinates[1] < 0) {
                if (key.x + key.width <= getWidth() / 2) {
                    this.mPopupPreviewX += (int) (((double) key.width) * 2.5d);
                } else {
                    this.mPopupPreviewX -= (int) (((double) key.width) * 2.5d);
                }
                this.mPopupPreviewY += popupHeight;
            }
            if (previewPopup.isShowing()) {
                previewPopup.update(this.mPopupPreviewX, this.mPopupPreviewY, popupWidth, popupHeight);
            } else {
                previewPopup.setWidth(popupWidth);
                previewPopup.setHeight(popupHeight);
                previewPopup.showAtLocation(this.mPopupParent, 0, this.mPopupPreviewX, this.mPopupPreviewY);
            }
            this.mPreviewText.setVisibility(0);
        }
    }

    private void sendAccessibilityEventForUnicodeCharacter(int eventType, int code) {
        String text;
        if (this.mAccessibilityManager.isEnabled()) {
            AccessibilityEvent event = AccessibilityEvent.obtain(eventType);
            onInitializeAccessibilityEvent(event);
            if (code != 10) {
                switch (code) {
                    case KeyboardAOSP.KEYCODE_ALT:
                        text = getContext().getString(R.string.keyboardview_keycode_alt);
                        break;
                    case KeyboardAOSP.KEYCODE_DELETE:
                        text = getContext().getString(R.string.keyboardview_keycode_delete);
                        break;
                    case KeyboardAOSP.KEYCODE_DONE:
                        text = getContext().getString(R.string.keyboardview_keycode_done);
                        break;
                    case KeyboardAOSP.KEYCODE_CANCEL:
                        text = getContext().getString(R.string.keyboardview_keycode_cancel);
                        break;
                    case -2:
                        text = getContext().getString(R.string.keyboardview_keycode_mode_change);
                        break;
                    case -1:
                        text = getContext().getString(R.string.keyboardview_keycode_shift);
                        break;
                    default:
                        text = String.valueOf((char) code);
                        break;
                }
            } else {
                text = getContext().getString(R.string.keyboardview_keycode_enter);
            }
            event.getText().add(text);
            this.mAccessibilityManager.sendAccessibilityEvent(event);
        }
    }

    public void invalidateAllKeys() {
        this.mDirtyRect.union(0, 0, getWidth(), getHeight());
        this.mDrawPending = true;
        invalidate();
    }

    public void invalidateKey(int keyIndex) {
        KeyAOSP[] keyAOSPArr = this.mKeys;
        if (keyAOSPArr != null && keyIndex >= 0 && keyIndex < keyAOSPArr.length) {
            KeyAOSP key = keyAOSPArr[keyIndex];
            this.mInvalidatedKey = key;
            this.mDirtyRect.union(key.x + getPaddingLeft(), key.y + getPaddingTop(), key.x + key.width + getPaddingLeft(), key.y + key.height + getPaddingTop());
            onBufferDraw();
            invalidate(key.x + getPaddingLeft(), key.y + getPaddingTop(), key.x + key.width + getPaddingLeft(), key.y + key.height + getPaddingTop());
        }
    }

    /* access modifiers changed from: private */
    public boolean openPopupIfRequired(MotionEvent me) {
        int i;
        if (this.mPopupLayout != 0 && (i = this.mCurrentKey) >= 0) {
            KeyAOSP[] keyAOSPArr = this.mKeys;
            if (i < keyAOSPArr.length) {
                boolean result = onLongPress(keyAOSPArr[i]);
                if (result) {
                    this.mAbortKey = true;
                    showPreview(-1);
                }
                return result;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean onLongPress(KeyAOSP popupKey) {
        KeyboardAOSP keyboard;
        int popupKeyboardId = popupKey.popupResId;
        if (popupKeyboardId == 0) {
            return false;
        }
        View view = this.mMiniKeyboardCache.get(popupKey);
        this.mMiniKeyboardContainer = view;
        if (view == null) {
            View inflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(this.mPopupLayout, (ViewGroup) null);
            this.mMiniKeyboardContainer = inflate;
            this.mMiniKeyboard = (KeyboardViewAOSP) inflate.findViewById(R.id.keyboardView);
            View closeButton = this.mMiniKeyboardContainer.findViewById(R.id.closeButton);
            if (closeButton != null) {
                closeButton.setOnClickListener(this);
            }
            this.mMiniKeyboard.setOnKeyboardActionListener(new OnKeyboardActionListener() {
                public void onKey(int primaryCode, int[] keyCodes) {
                    KeyboardViewAOSP.this.mKeyboardActionListener.onKey(primaryCode, keyCodes);
                    KeyboardViewAOSP.this.dismissPopupKeyboard();
                }

                public void onText(CharSequence text) {
                    KeyboardViewAOSP.this.mKeyboardActionListener.onText(text);
                    KeyboardViewAOSP.this.dismissPopupKeyboard();
                }

                public void swipeLeft() {
                }

                public void swipeRight() {
                }

                public void swipeUp() {
                }

                public void swipeDown() {
                }

                public void onPress(int primaryCode) {
                    KeyboardViewAOSP.this.mKeyboardActionListener.onPress(primaryCode);
                }

                public void onRelease(int primaryCode) {
                    KeyboardViewAOSP.this.mKeyboardActionListener.onRelease(primaryCode);
                }
            });
            if (popupKey.popupCharacters != null) {
                keyboard = new KeyboardAOSP(getContext(), popupKeyboardId, popupKey.popupCharacters, -1, getPaddingLeft() + getPaddingRight());
            } else {
                keyboard = new KeyboardAOSP(getContext(), popupKeyboardId);
            }
            this.mMiniKeyboard.setKeyboard(keyboard);
            this.mMiniKeyboard.setPopupParent(this);
            this.mMiniKeyboardContainer.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
            this.mMiniKeyboardCache.put(popupKey, this.mMiniKeyboardContainer);
        } else {
            this.mMiniKeyboard = (KeyboardViewAOSP) view.findViewById(R.id.keyboardView);
        }
        getLocationInWindow(this.mCoordinates);
        this.mPopupX = popupKey.x + getPaddingLeft();
        this.mPopupY = popupKey.y + getPaddingTop();
        this.mPopupX = (this.mPopupX + popupKey.width) - this.mMiniKeyboardContainer.getMeasuredWidth();
        this.mPopupY -= this.mMiniKeyboardContainer.getMeasuredHeight();
        int x = this.mPopupX + this.mMiniKeyboardContainer.getPaddingRight() + this.mCoordinates[0];
        int y = this.mPopupY + this.mMiniKeyboardContainer.getPaddingBottom() + this.mCoordinates[1];
        this.mMiniKeyboard.setPopupOffset(x < 0 ? 0 : x, y);
        this.mMiniKeyboard.setShifted(isShifted());
        this.mPopupKeyboard.setContentView(this.mMiniKeyboardContainer);
        this.mPopupKeyboard.setWidth(this.mMiniKeyboardContainer.getMeasuredWidth());
        this.mPopupKeyboard.setHeight(this.mMiniKeyboardContainer.getMeasuredHeight());
        this.mPopupKeyboard.showAtLocation(this, 0, x, y);
        this.mMiniKeyboardOnScreen = true;
        invalidateAllKeys();
        return true;
    }

    public boolean onHoverEvent(MotionEvent event) {
        if (!this.mAccessibilityManager.isTouchExplorationEnabled() || event.getPointerCount() != 1) {
            return true;
        }
        int action = event.getAction();
        if (action == 7) {
            event.setAction(2);
        } else if (action == 9) {
            event.setAction(0);
        } else if (action == 10) {
            event.setAction(1);
        }
        return onTouchEvent(event);
    }

    public boolean onTouchEvent(MotionEvent me) {
        boolean result;
        MotionEvent motionEvent = me;
        int pointerCount = me.getPointerCount();
        int action = me.getAction();
        long now = me.getEventTime();
        if (pointerCount != this.mOldPointerCount) {
            if (pointerCount == 1) {
                MotionEvent down = MotionEvent.obtain(now, now, 0, me.getX(), me.getY(), me.getMetaState());
                result = onModifiedTouchEvent(down, false);
                down.recycle();
                if (action == 1) {
                    result = onModifiedTouchEvent(motionEvent, true);
                }
            } else {
                MotionEvent up = MotionEvent.obtain(now, now, 1, this.mOldPointerX, this.mOldPointerY, me.getMetaState());
                result = onModifiedTouchEvent(up, true);
                up.recycle();
            }
        } else if (pointerCount == 1) {
            result = onModifiedTouchEvent(motionEvent, false);
            this.mOldPointerX = me.getX();
            this.mOldPointerY = me.getY();
        } else {
            result = true;
        }
        this.mOldPointerCount = pointerCount;
        return result;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00cd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean onModifiedTouchEvent(android.view.MotionEvent r18, boolean r19) {
        /*
            r17 = this;
            r6 = r17
            r7 = r18
            float r0 = r18.getX()
            int r0 = (int) r0
            int r1 = r17.getPaddingLeft()
            int r0 = r0 - r1
            float r1 = r18.getY()
            int r1 = (int) r1
            int r2 = r17.getPaddingTop()
            int r1 = r1 - r2
            int r2 = r6.mVerticalCorrection
            int r3 = -r2
            if (r1 < r3) goto L_0x001e
            int r1 = r1 + r2
        L_0x001e:
            int r8 = r18.getAction()
            long r9 = r18.getEventTime()
            r2 = 0
            int r11 = r6.getKeyIndices(r0, r1, r2)
            r12 = r19
            r6.mPossiblePoly = r12
            if (r8 != 0) goto L_0x0036
            com.santander.globile.mobisec.securekeyboard.aosp.KeyboardViewAOSP$SwipeTracker r2 = r6.mSwipeTracker
            r2.clear()
        L_0x0036:
            com.santander.globile.mobisec.securekeyboard.aosp.KeyboardViewAOSP$SwipeTracker r2 = r6.mSwipeTracker
            r2.addMovement(r7)
            boolean r2 = r6.mAbortKey
            r3 = 3
            r13 = 1
            if (r2 == 0) goto L_0x0046
            if (r8 == 0) goto L_0x0046
            if (r8 == r3) goto L_0x0046
            return r13
        L_0x0046:
            android.view.GestureDetector r2 = r6.mGestureDetector
            boolean r2 = r2.onTouchEvent(r7)
            r4 = 4
            r14 = -1
            if (r2 == 0) goto L_0x005e
            r6.showPreview(r14)
            android.os.Handler r2 = r6.mHandler
            r2.removeMessages(r3)
            android.os.Handler r2 = r6.mHandler
            r2.removeMessages(r4)
            return r13
        L_0x005e:
            boolean r2 = r6.mMiniKeyboardOnScreen
            if (r2 == 0) goto L_0x0065
            if (r8 == r3) goto L_0x0065
            return r13
        L_0x0065:
            r4 = 0
            if (r8 == 0) goto L_0x0157
            if (r8 == r13) goto L_0x00ed
            r15 = 2
            if (r8 == r15) goto L_0x0084
            if (r8 == r3) goto L_0x0072
            goto L_0x01ca
        L_0x0072:
            r17.removeMessages()
            r17.dismissPopupKeyboard()
            r6.mAbortKey = r13
            r6.showPreview(r14)
            int r2 = r6.mCurrentKey
            r6.invalidateKey(r2)
            goto L_0x01ca
        L_0x0084:
            r3 = 0
            if (r11 == r14) goto L_0x00c7
            int r15 = r6.mCurrentKey
            if (r15 != r14) goto L_0x0096
            r6.mCurrentKey = r11
            long r4 = r6.mDownTime
            long r4 = r9 - r4
            r6.mCurrentKeyTime = r4
            r16 = r3
            goto L_0x00c9
        L_0x0096:
            if (r11 != r15) goto L_0x00a5
            long r4 = r6.mCurrentKeyTime
            r16 = r3
            long r2 = r6.mLastMoveTime
            long r2 = r9 - r2
            long r4 = r4 + r2
            r6.mCurrentKeyTime = r4
            r3 = 1
            goto L_0x00cb
        L_0x00a5:
            r16 = r3
            int r2 = r6.mRepeatKeyIndex
            if (r2 != r14) goto L_0x00c9
            r17.resetMultiTap()
            int r2 = r6.mCurrentKey
            r6.mLastKey = r2
            int r2 = r6.mLastX
            r6.mLastCodeX = r2
            int r2 = r6.mLastY
            r6.mLastCodeY = r2
            long r2 = r6.mCurrentKeyTime
            long r2 = r2 + r9
            long r13 = r6.mLastMoveTime
            long r2 = r2 - r13
            r6.mLastKeyTime = r2
            r6.mCurrentKey = r11
            r6.mCurrentKeyTime = r4
            goto L_0x00c9
        L_0x00c7:
            r16 = r3
        L_0x00c9:
            r3 = r16
        L_0x00cb:
            if (r3 != 0) goto L_0x00e4
            android.os.Handler r2 = r6.mHandler
            r4 = 4
            r2.removeMessages(r4)
            r2 = -1
            if (r11 == r2) goto L_0x00e4
            android.os.Handler r2 = r6.mHandler
            android.os.Message r2 = r2.obtainMessage(r4, r7)
            android.os.Handler r4 = r6.mHandler
            int r5 = LONGPRESS_TIMEOUT
            long r13 = (long) r5
            r4.sendMessageDelayed(r2, r13)
        L_0x00e4:
            int r2 = r6.mCurrentKey
            r6.showPreview(r2)
            r6.mLastMoveTime = r9
            goto L_0x01ca
        L_0x00ed:
            r17.removeMessages()
            int r2 = r6.mCurrentKey
            if (r11 != r2) goto L_0x00fe
            long r2 = r6.mCurrentKeyTime
            long r4 = r6.mLastMoveTime
            long r4 = r9 - r4
            long r2 = r2 + r4
            r6.mCurrentKeyTime = r2
            goto L_0x0111
        L_0x00fe:
            r17.resetMultiTap()
            int r2 = r6.mCurrentKey
            r6.mLastKey = r2
            long r2 = r6.mCurrentKeyTime
            long r2 = r2 + r9
            long r13 = r6.mLastMoveTime
            long r2 = r2 - r13
            r6.mLastKeyTime = r2
            r6.mCurrentKey = r11
            r6.mCurrentKeyTime = r4
        L_0x0111:
            long r2 = r6.mCurrentKeyTime
            long r4 = r6.mLastKeyTime
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 >= 0) goto L_0x012d
            r4 = 70
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x012d
            int r2 = r6.mLastKey
            r3 = -1
            if (r2 == r3) goto L_0x012d
            r6.mCurrentKey = r2
            int r0 = r6.mLastCodeX
            int r1 = r6.mLastCodeY
            r13 = r0
            r14 = r1
            goto L_0x012f
        L_0x012d:
            r13 = r0
            r14 = r1
        L_0x012f:
            r0 = -1
            r6.showPreview(r0)
            int[] r1 = r6.mKeyIndices
            java.util.Arrays.fill(r1, r0)
            int r1 = r6.mRepeatKeyIndex
            if (r1 != r0) goto L_0x014e
            boolean r0 = r6.mMiniKeyboardOnScreen
            if (r0 != 0) goto L_0x014e
            boolean r0 = r6.mAbortKey
            if (r0 != 0) goto L_0x014e
            int r1 = r6.mCurrentKey
            r0 = r17
            r2 = r13
            r3 = r14
            r4 = r9
            r0.detectAndSendKey(r1, r2, r3, r4)
        L_0x014e:
            r6.invalidateKey(r11)
            r0 = -1
            r6.mRepeatKeyIndex = r0
            r0 = r13
            r1 = r14
            goto L_0x01ca
        L_0x0157:
            r13 = 0
            r6.mAbortKey = r13
            r6.mStartX = r0
            r6.mStartY = r1
            r6.mLastCodeX = r0
            r6.mLastCodeY = r1
            r6.mLastKeyTime = r4
            r6.mCurrentKeyTime = r4
            r4 = -1
            r6.mLastKey = r4
            r6.mCurrentKey = r11
            r6.mDownKey = r11
            long r4 = r18.getEventTime()
            r6.mDownTime = r4
            r6.mLastMoveTime = r4
            r6.checkMultiTap(r9, r11)
            com.santander.globile.mobisec.securekeyboard.aosp.KeyboardViewAOSP$OnKeyboardActionListener r4 = r6.mKeyboardActionListener
            r5 = -1
            if (r11 == r5) goto L_0x0185
            com.santander.globile.mobisec.securekeyboard.aosp.KeyAOSP[] r5 = r6.mKeys
            r5 = r5[r11]
            int[] r5 = r5.codes
            r13 = r5[r13]
        L_0x0185:
            r4.onPress(r13)
            int r4 = r6.mCurrentKey
            if (r4 < 0) goto L_0x01b2
            com.santander.globile.mobisec.securekeyboard.aosp.KeyAOSP[] r5 = r6.mKeys
            r4 = r5[r4]
            boolean r4 = r4.repeatable
            if (r4 == 0) goto L_0x01b2
            int r4 = r6.mCurrentKey
            r6.mRepeatKeyIndex = r4
            android.os.Handler r4 = r6.mHandler
            android.os.Message r3 = r4.obtainMessage(r3)
            android.os.Handler r4 = r6.mHandler
            r13 = 400(0x190, double:1.976E-321)
            r4.sendMessageDelayed(r3, r13)
            r17.repeatKey()
            boolean r4 = r6.mAbortKey
            if (r4 == 0) goto L_0x01b0
            r4 = -1
            r6.mRepeatKeyIndex = r4
            goto L_0x01ca
        L_0x01b0:
            r4 = -1
            goto L_0x01b3
        L_0x01b2:
            r4 = -1
        L_0x01b3:
            int r3 = r6.mCurrentKey
            if (r3 == r4) goto L_0x01c6
            android.os.Handler r3 = r6.mHandler
            r2 = 4
            android.os.Message r2 = r3.obtainMessage(r2, r7)
            android.os.Handler r3 = r6.mHandler
            int r4 = LONGPRESS_TIMEOUT
            long r4 = (long) r4
            r3.sendMessageDelayed(r2, r4)
        L_0x01c6:
            r6.showPreview(r11)
        L_0x01ca:
            r6.mLastX = r0
            r6.mLastY = r1
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.santander.globile.mobisec.securekeyboard.aosp.KeyboardViewAOSP.onModifiedTouchEvent(android.view.MotionEvent, boolean):boolean");
    }

    /* access modifiers changed from: private */
    public boolean repeatKey() {
        KeyAOSP key = this.mKeys[this.mRepeatKeyIndex];
        detectAndSendKey(this.mCurrentKey, key.x, key.y, this.mLastTapTime);
        return true;
    }

    /* access modifiers changed from: protected */
    public void swipeRight() {
        this.mKeyboardActionListener.swipeRight();
    }

    /* access modifiers changed from: protected */
    public void swipeLeft() {
        this.mKeyboardActionListener.swipeLeft();
    }

    /* access modifiers changed from: protected */
    public void swipeUp() {
        this.mKeyboardActionListener.swipeUp();
    }

    /* access modifiers changed from: protected */
    public void swipeDown() {
        this.mKeyboardActionListener.swipeDown();
    }

    public void closing() {
        if (this.mPreviewPopup.isShowing()) {
            this.mPreviewPopup.dismiss();
        }
        removeMessages();
        dismissPopupKeyboard();
        this.mBuffer = null;
        this.mCanvas = null;
        this.mMiniKeyboardCache.clear();
    }

    private void removeMessages() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(3);
            this.mHandler.removeMessages(4);
            this.mHandler.removeMessages(1);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        closing();
    }

    /* access modifiers changed from: private */
    public void dismissPopupKeyboard() {
        if (this.mPopupKeyboard.isShowing()) {
            this.mPopupKeyboard.dismiss();
            this.mMiniKeyboardOnScreen = false;
            invalidateAllKeys();
        }
    }

    public boolean handleBack() {
        if (!this.mPopupKeyboard.isShowing()) {
            return false;
        }
        dismissPopupKeyboard();
        return true;
    }

    private void resetMultiTap() {
        this.mLastSentIndex = -1;
        this.mTapCount = 0;
        this.mLastTapTime = -1;
        this.mInMultiTap = false;
    }

    private void checkMultiTap(long eventTime, int keyIndex) {
        if (keyIndex != -1) {
            KeyAOSP key = this.mKeys[keyIndex];
            if (key.codes.length > 1) {
                this.mInMultiTap = true;
                if (eventTime >= this.mLastTapTime + 800 || keyIndex != this.mLastSentIndex) {
                    this.mTapCount = -1;
                } else {
                    this.mTapCount = (this.mTapCount + 1) % key.codes.length;
                }
            } else if (eventTime > this.mLastTapTime + 800 || keyIndex != this.mLastSentIndex) {
                resetMultiTap();
            }
        }
    }

    private static class SwipeTracker {
        static final int LONGEST_PAST_TIME = 200;
        static final int NUM_PAST = 4;
        final long[] mPastTime;
        final float[] mPastX;
        final float[] mPastY;
        float mXVelocity;
        float mYVelocity;

        private SwipeTracker() {
            this.mPastX = new float[4];
            this.mPastY = new float[4];
            this.mPastTime = new long[4];
        }

        public void clear() {
            this.mPastTime[0] = 0;
        }

        public void addMovement(MotionEvent ev) {
            long time = ev.getEventTime();
            int N = ev.getHistorySize();
            for (int i = 0; i < N; i++) {
                addPoint(ev.getHistoricalX(i), ev.getHistoricalY(i), ev.getHistoricalEventTime(i));
            }
            addPoint(ev.getX(), ev.getY(), time);
        }

        private void addPoint(float x, float y, long time) {
            int drop = -1;
            long[] pastTime = this.mPastTime;
            int i = 0;
            while (i < 4 && pastTime[i] != 0) {
                if (pastTime[i] < time - 200) {
                    drop = i;
                }
                i++;
            }
            if (i == 4 && drop < 0) {
                drop = 0;
            }
            if (drop == i) {
                drop--;
            }
            float[] pastX = this.mPastX;
            float[] pastY = this.mPastY;
            if (drop >= 0) {
                int start = drop + 1;
                int count = (4 - drop) - 1;
                System.arraycopy(pastX, start, pastX, 0, count);
                System.arraycopy(pastY, start, pastY, 0, count);
                System.arraycopy(pastTime, start, pastTime, 0, count);
                i -= drop + 1;
            }
            pastX[i] = x;
            pastY[i] = y;
            pastTime[i] = time;
            int i2 = i + 1;
            if (i2 < 4) {
                pastTime[i2] = 0;
            }
        }

        public void computeCurrentVelocity(int units) {
            computeCurrentVelocity(units, Float.MAX_VALUE);
        }

        public void computeCurrentVelocity(int units, float maxVelocity) {
            float f;
            float f2;
            long[] pastTime;
            float[] pastX;
            int i = units;
            float f3 = maxVelocity;
            float[] pastX2 = this.mPastX;
            float[] pastY = this.mPastY;
            long[] pastTime2 = this.mPastTime;
            float oldestX = pastX2[0];
            float oldestY = pastY[0];
            long oldestTime = pastTime2[0];
            float accumX = 0.0f;
            float accumY = 0.0f;
            int N = 0;
            while (N < 4 && pastTime2[N] != 0) {
                N++;
            }
            int i2 = 1;
            while (i2 < N) {
                int dur = (int) (pastTime2[i2] - oldestTime);
                if (dur == 0) {
                    pastX = pastX2;
                    pastTime = pastTime2;
                } else {
                    pastX = pastX2;
                    pastTime = pastTime2;
                    float vel = ((pastX2[i2] - oldestX) / ((float) dur)) * ((float) i);
                    if (accumX == 0.0f) {
                        accumX = vel;
                    } else {
                        accumX = (accumX + vel) * 0.5f;
                    }
                    float vel2 = ((pastY[i2] - oldestY) / ((float) dur)) * ((float) i);
                    if (accumY == 0.0f) {
                        accumY = vel2;
                    } else {
                        accumY = (accumY + vel2) * 0.5f;
                    }
                }
                i2++;
                pastX2 = pastX;
                pastTime2 = pastTime;
            }
            long[] jArr = pastTime2;
            if (accumX < 0.0f) {
                f = Math.max(accumX, -f3);
            } else {
                f = Math.min(accumX, f3);
            }
            this.mXVelocity = f;
            if (accumY < 0.0f) {
                f2 = Math.max(accumY, -f3);
            } else {
                f2 = Math.min(accumY, f3);
            }
            this.mYVelocity = f2;
        }

        public float getXVelocity() {
            return this.mXVelocity;
        }

        public float getYVelocity() {
            return this.mYVelocity;
        }
    }
}
