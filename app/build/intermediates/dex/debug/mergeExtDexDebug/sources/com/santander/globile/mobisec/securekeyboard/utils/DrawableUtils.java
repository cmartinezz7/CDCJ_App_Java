package com.santander.globile.mobisec.securekeyboard.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class DrawableUtils {
    private DrawableUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static Drawable generateTextViewCanvas(Context context, int width, int height, int bgColor, int textColor, String text, boolean roundBorders) {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColor(bgColor);
        paint.setStyle(Paint.Style.FILL);
        RectF rect = new RectF(5.0f, 5.0f, (float) (width - 5), (float) (height - 5));
        if (roundBorders) {
            int cornerRadius = Math.min(width, height) / 8;
            canvas.drawRoundRect(rect, (float) cornerRadius, (float) cornerRadius, paint);
        } else {
            canvas.drawRect(rect, paint);
        }
        paint.setColor(textColor);
        paint.setAntiAlias(true);
        float textSize = ((float) height) / 3.33f;
        paint.setTextSize(textSize);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(text, ((float) width) / 2.0f, (((float) height) + (textSize / 2.0f)) / 1.87f, paint);
        return new BitmapDrawable(context.getResources(), bitmap);
    }
}
