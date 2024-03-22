package com.tealium.internal.tagbridge;

import com.tealium.internal.b;
import com.tealium.internal.c;
import com.tealium.internal.e;
import com.tealium.library.R;
import com.tealium.library.Tealium;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONException;

public final class d {
    private static final Pattern a = Pattern.compile("^tealium://.+", 2);
    private final Map<String, RemoteCommand> b;
    private final c c;
    private final b d;

    public d(Tealium.Config config, c cVar) {
        if (config != null) {
            this.c = cVar;
            if (cVar != null) {
                HashMap hashMap = new HashMap(1);
                this.b = hashMap;
                hashMap.put("_config", new a(cVar));
                this.d = config.getLogger();
                return;
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException("config must not be null.");
    }

    private void a(c cVar) throws JSONException, UnsupportedEncodingException {
        if (e.a()) {
            RemoteCommand remoteCommand = this.b.get(cVar.a());
            if (remoteCommand == null && (remoteCommand = d(cVar.a())) == null) {
                if (this.d.d()) {
                    this.d.e(R.string.tagbridge_no_command_found, cVar.a());
                }
                cVar.b().setStatus(404).setBody(String.format(Locale.ROOT, "No remote command found with id \"%s\"", new Object[]{cVar.a()})).send();
                return;
            }
            this.d.a(R.string.tagbridge_detected_command, cVar.a(), cVar.b().getRequestPayload());
            remoteCommand.a(cVar);
            return;
        }
        throw new UnsupportedOperationException("processRequest must be called in the main thread");
    }

    public static boolean a(String str) {
        if (str == null) {
            return false;
        }
        return a.matcher(str).matches();
    }

    public static boolean b(String str) {
        return str.matches("^tealium://_config");
    }

    private RemoteCommand d(String str) {
        b bVar = "_http".equals(str) ? new b() : null;
        if (bVar != null) {
            this.b.put(bVar.a(), bVar);
        }
        return bVar;
    }

    public final void a(RemoteCommand remoteCommand) {
        if (!e.a()) {
            throw new UnsupportedOperationException("Remote commands must be added in the main thread.");
        } else if (remoteCommand != null) {
            this.b.put(remoteCommand.a(), remoteCommand);
        } else {
            throw new IllegalArgumentException("remoteCommand must not be null.");
        }
    }

    public final void b(RemoteCommand remoteCommand) {
        if (!e.a()) {
            throw new UnsupportedOperationException("Remote commands must be removed in the main thread.");
        } else if (remoteCommand != null) {
            this.b.remove(remoteCommand.a());
        } else {
            throw new IllegalArgumentException("remoteCommand must not be null.");
        }
    }

    public void c(String str) {
        try {
            a(new c(this.c, str));
        } catch (Throwable th) {
            this.d.a(th);
        }
    }
}
