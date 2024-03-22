package es.santander.justicia.minisJusticia.views.font;

import es.santander.justicia.utils.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Les/santander/justicia/minisJusticia/views/font/Font;", "", "id", "", "path", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getId", "()I", "getPath", "()Ljava/lang/String;", "REGULAR", "MEDIUM", "Companion", "app_debug"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: Font.kt */
public enum Font {
    REGULAR(0, Constants.FIRASANS_REGULAR),
    MEDIUM(1, Constants.FIRASANS_MEDIUM);
    
    public static final Companion Companion = null;
    private final int id;
    private final String path;

    private Font(int id2, String path2) {
        this.id = id2;
        this.path = path2;
    }

    public final int getId() {
        return this.id;
    }

    public final String getPath() {
        return this.path;
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Les/santander/justicia/minisJusticia/views/font/Font$Companion;", "", "()V", "getFromId", "Les/santander/justicia/minisJusticia/views/font/Font;", "id", "", "app_debug"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: Font.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Font getFromId(int id) {
            for (Font it : Font.values()) {
                if (it.getId() == id) {
                    return it;
                }
            }
            return null;
        }
    }
}
