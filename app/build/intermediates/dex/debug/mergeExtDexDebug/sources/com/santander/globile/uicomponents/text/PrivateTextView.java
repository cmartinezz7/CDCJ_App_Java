package com.santander.globile.uicomponents.text;

import android.app.Activity;
import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.tealium.internal.tagbridge.RemoteCommand;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u001a\u0010 \u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\u00162\u0006\u0010\"\u001a\u00020\bH\u0016J\u0012\u0010#\u001a\u00020\u001d2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010\u001b\u001a\u00020\u001dH\u0002J\b\u0010&\u001a\u00020\u001dH\u0002R\u000e\u0010\n\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R$\u0010\u0019\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011¨\u0006'"}, d2 = {"Lcom/santander/globile/uicomponents/text/PrivateTextView;", "Lcom/santander/globile/uicomponents/text/SantanderTextView;", "Landroid/hardware/SensorEventListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "WAVE_TIME", "value", "", "enableSensor", "getEnableSensor", "()Z", "setEnableSensor", "(Z)V", "isObfuscated", "lastWaveTime", "", "mProximitySensor", "Landroid/hardware/Sensor;", "mSensorManager", "Landroid/hardware/SensorManager;", "private", "getPrivate", "setPrivate", "initTextView", "", "activity", "Landroid/app/Activity;", "onAccuracyChanged", "sensor", "accuracy", "onSensorChanged", "event", "Landroid/hardware/SensorEvent;", "setPublic", "uicomponentslib_debug"}, k = 1, mv = {1, 1, 15})
/* compiled from: PrivateTextView.kt */
public final class PrivateTextView extends SantanderTextView implements SensorEventListener {
    private int WAVE_TIME;
    private HashMap _$_findViewCache;
    private boolean enableSensor;
    private boolean isObfuscated;
    private long lastWaveTime;
    private Sensor mProximitySensor;
    private SensorManager mSensorManager;

    /* renamed from: private  reason: not valid java name */
    private boolean f0private;

    public PrivateTextView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public PrivateTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.santander.globile.uicomponents.text.PrivateTextView, android.view.View] */
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
    public PrivateTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.WAVE_TIME = RemoteCommand.Response.STATUS_BAD_REQUEST;
        this.f0private = true;
        this.enableSensor = true;
        this.isObfuscated = true;
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, (Paint) null);
        }
        BlurMaskFilter filter = new BlurMaskFilter(getTextSize() / ((float) 3), BlurMaskFilter.Blur.NORMAL);
        TextPaint paint = getPaint();
        Intrinsics.checkExpressionValueIsNotNull(paint, "this.paint");
        paint.setMaskFilter(filter);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PrivateTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final boolean getPrivate() {
        return this.f0private;
    }

    public final void setPrivate(boolean value) {
        this.f0private = value;
        if (value) {
            setPrivate();
        } else {
            setPublic();
        }
    }

    public final boolean getEnableSensor() {
        return this.enableSensor;
    }

    public final void setEnableSensor(boolean value) {
        this.enableSensor = value;
        if (value) {
            SensorManager sensorManager = this.mSensorManager;
            if (sensorManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSensorManager");
            }
            sensorManager.registerListener(this, this.mProximitySensor, 3);
            return;
        }
        SensorManager sensorManager2 = this.mSensorManager;
        if (sensorManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSensorManager");
        }
        sensorManager2.unregisterListener(this);
    }

    public final void initTextView(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Object systemService = activity.getSystemService("sensor");
        if (systemService != null) {
            SensorManager sensorManager = (SensorManager) systemService;
            this.mSensorManager = sensorManager;
            if (sensorManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSensorManager");
            }
            Sensor it = sensorManager.getDefaultSensor(8);
            this.mProximitySensor = it;
            if (it != null) {
                SensorManager sensorManager2 = this.mSensorManager;
                if (sensorManager2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSensorManager");
                }
                sensorManager2.registerListener(this, it, 3);
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.hardware.SensorManager");
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    private final void setPrivate() {
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, (Paint) null);
        }
        BlurMaskFilter filter = new BlurMaskFilter(getTextSize() / ((float) 3), BlurMaskFilter.Blur.NORMAL);
        TextPaint paint = getPaint();
        Intrinsics.checkExpressionValueIsNotNull(paint, "this.paint");
        paint.setMaskFilter(filter);
    }

    private final void setPublic() {
        setLayerType(1, (Paint) null);
        TextPaint paint = getPaint();
        Intrinsics.checkExpressionValueIsNotNull(paint, "this.paint");
        paint.setMaskFilter((MaskFilter) null);
    }

    public void onSensorChanged(SensorEvent event) {
        Sensor sensor;
        if (event != null && (sensor = event.sensor) != null && sensor.getType() == 8 && event.values[0] == 0.0f && this.lastWaveTime + ((long) this.WAVE_TIME) < System.currentTimeMillis()) {
            this.lastWaveTime = System.currentTimeMillis();
            if (this.isObfuscated) {
                setLayerType(1, (Paint) null);
                TextPaint paint = getPaint();
                Intrinsics.checkExpressionValueIsNotNull(paint, "this.paint");
                paint.setMaskFilter((MaskFilter) null);
            } else {
                if (Build.VERSION.SDK_INT >= 11) {
                    setLayerType(1, (Paint) null);
                }
                BlurMaskFilter filter = new BlurMaskFilter(getTextSize() / ((float) 3), BlurMaskFilter.Blur.NORMAL);
                TextPaint paint2 = getPaint();
                Intrinsics.checkExpressionValueIsNotNull(paint2, "this.paint");
                paint2.setMaskFilter(filter);
            }
            this.isObfuscated = !this.isObfuscated;
        }
    }
}
