package com.santander.globile.mobisec.securekeyboard.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.santander.globile.mobisec.securekeyboard.R;
import com.santander.globile.mobisec.securekeyboard.enums.InputLanguage;
import com.santander.globile.mobisec.securekeyboard.enums.SpaceKeyState;
import com.santander.globile.mobisec.securekeyboard.keyboard.SanKeyboardManager;
import java.util.EnumMap;
import java.util.Map;

public class SpaceKeyStateManager {
    private final LayoutInflater inflater;
    private final Map<InputLanguage, Drawable[]> spaceStateDrawables = new EnumMap(InputLanguage.class);

    public SpaceKeyStateManager(Context context, int keyWidth, int keyHeight) {
        this.inflater = LayoutInflater.from(context);
        initDrawablesList(context.getResources(), keyWidth, keyHeight);
    }

    public Drawable getDrawableForState(InputLanguage inputLanguage, SpaceKeyState state) {
        return this.spaceStateDrawables.get(inputLanguage)[state.getIndex()];
    }

    private void initDrawablesList(Resources resources, int keyWidth, int keyHeight) {
        int statesCount = SpaceKeyState.values().length;
        for (InputLanguage inputLanguage : SanKeyboardManager.getPossibleLanguages()) {
            Drawable[] drawables = new Drawable[statesCount];
            for (int i = 0; i < statesCount; i++) {
                drawables[i] = generateDrawable(resources, keyWidth, keyHeight, inputLanguage, SpaceKeyState.values()[i]);
            }
            this.spaceStateDrawables.put(inputLanguage, drawables);
        }
    }

    private Drawable generateDrawable(Resources resources, int keyWidth, int keyHeight, InputLanguage inputLanguage, SpaceKeyState state) {
        View spaceView = this.inflater.inflate(R.layout.space_view, (ViewGroup) null);
        spaceView.findViewById(R.id.space_main_layout).setBackgroundResource(state.getDrawableResId());
        if (SanKeyboardManager.getPossibleLanguages().length > 1) {
            ((TextView) spaceView.findViewById(R.id.space_layout_name)).setText(inputLanguage.getText(resources));
        } else {
            spaceView.findViewById(R.id.space_layout_name).setVisibility(4);
            spaceView.findViewById(R.id.space_arrow_left).setVisibility(4);
            spaceView.findViewById(R.id.space_arrow_right).setVisibility(4);
        }
        spaceView.setDrawingCacheEnabled(true);
        spaceView.measure(keyWidth, keyHeight);
        spaceView.layout(0, 0, keyWidth, keyHeight);
        spaceView.buildDrawingCache(true);
        Bitmap viewBitmap = Bitmap.createBitmap(spaceView.getDrawingCache());
        spaceView.setDrawingCacheEnabled(false);
        return new BitmapDrawable(resources, viewBitmap);
    }
}
