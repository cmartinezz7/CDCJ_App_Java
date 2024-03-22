package es.santander.branchlocator;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.text.TextUtils;
import androidx.core.content.res.ResourcesCompat;
import java.util.HashMap;
import java.util.Map;

class BLFontManager {
    private static BLFontManager instance;
    private AssetManager assetManager;
    Context context;
    private Map<String, Typeface> fonts;

    public BLFontManager(Context context2) {
        this.context = context2;
    }

    private BLFontManager(AssetManager _assetManager) {
        this.assetManager = _assetManager;
        this.fonts = new HashMap();
    }

    public static void init(AssetManager mgr) {
        instance = new BLFontManager(mgr);
    }

    public static BLFontManager getInstance(Context context2) {
        if (instance == null) {
            init(context2.getAssets());
        }
        return instance;
    }

    public Typeface getFont(String asset) {
        if (this.fonts.containsKey(asset)) {
            return this.fonts.get(asset);
        }
        Typeface font = Typeface.createFromAsset(this.assetManager, asset);
        this.fonts.put(asset, font);
        if (font != null) {
            return font;
        }
        String fixedAsset = fixAssetFilename(asset);
        Typeface font2 = Typeface.createFromAsset(this.assetManager, fixedAsset);
        this.fonts.put(asset, font2);
        this.fonts.put(fixedAsset, font2);
        return font2;
    }

    private String fixAssetFilename(String asset) {
        if (TextUtils.isEmpty(asset) || asset.endsWith(".ttf") || asset.endsWith(".ttc")) {
            return asset;
        }
        return String.format("%s.ttf", new Object[]{asset});
    }

    public void inserTypeFont(BLTextView BLTextView, Integer fontName) {
        BLTextView.setTypeface(ResourcesCompat.getFont(this.context, fontName.intValue()));
    }
}
