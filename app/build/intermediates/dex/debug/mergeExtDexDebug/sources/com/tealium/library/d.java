package com.tealium.library;

import com.tealium.collect.listeners.VisitorProfileUpdateListener;
import com.tealium.collect.visitor.VisitorProfile;
import com.tealium.internal.c;
import com.tealium.internal.data.PublishSettings;
import com.tealium.internal.e;
import com.tealium.internal.listeners.PublishSettingsUpdateListener;
import com.tealium.library.Tealium;
import java.io.File;
import org.json.JSONException;

final class d implements VisitorProfileUpdateListener, PublishSettingsUpdateListener {
    private final c a;
    private final File b;

    d(Tealium.Config config, c cVar) {
        this.b = config.getTealiumDir();
        this.a = cVar;
    }

    static PublishSettings a(File file) {
        try {
            return PublishSettings.from(e.a.a(new File(file, "mobile_publish_settings.json")));
        } catch (PublishSettings.DisabledLibraryException e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: private */
    public void a(VisitorProfile visitorProfile) {
        String source = visitorProfile.getSource();
        if (source != null) {
            e.a.a(new File(this.b, "visitor_profile.json"), source);
            return;
        }
        throw new IllegalArgumentException();
    }

    static VisitorProfile b(File file) {
        File file2 = new File(file, "visitor_profile.json");
        if (!file2.exists()) {
            return null;
        }
        try {
            return VisitorProfile.fromJSON(e.a.a(file2));
        } catch (JSONException e) {
            c(file2);
            return null;
        }
    }

    private static void c(File file) {
        file.renameTo(new File(file.getParentFile(), System.nanoTime() + ".old"));
        file.delete();
    }

    public void onPublishSettingsUpdate(PublishSettings publishSettings) {
        if (publishSettings.getSource() != null) {
            e.a.a(new File(this.b, "mobile_publish_settings.json"), publishSettings.getSource());
        }
    }

    public void onVisitorProfileUpdated(VisitorProfile visitorProfile, final VisitorProfile visitorProfile2) {
        if (visitorProfile2 != null && visitorProfile2.getSource() != null) {
            this.a.b((Runnable) new Runnable() {
                public void run() {
                    d.this.a(visitorProfile2);
                }
            });
        }
    }
}
