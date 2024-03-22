package es.santander.justicia.utils;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class ComparadorFechas implements Comparator<String> {
    private SimpleDateFormat formaterBarra = new SimpleDateFormat("dd/MM/yyyy");
    private SimpleDateFormat formaterGuion = new SimpleDateFormat("yyyy-MM-dd");

    public int compare(String o1, String o2) {
        Date date1 = getDate(o1);
        Date date2 = getDate(o2);
        if (date1 == null || date2 == null) {
            return 0;
        }
        return getDate(o1).compareTo(getDate(o2));
    }

    /* Debug info: failed to restart local var, previous not found, register: 3 */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.Date getDate(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            r0 = 0
            java.lang.String r1 = "/"
            int r1 = r4.indexOf(r1)     // Catch:{ Exception -> 0x0023, all -> 0x0025 }
            r2 = -1
            if (r1 == r2) goto L_0x0013
            java.text.SimpleDateFormat r1 = r3.formaterBarra     // Catch:{ Exception -> 0x0023, all -> 0x0025 }
            java.util.Date r1 = r1.parse(r4)     // Catch:{ Exception -> 0x0023, all -> 0x0025 }
            r0 = r1
            goto L_0x0022
        L_0x0013:
            java.lang.String r1 = "-"
            int r1 = r4.indexOf(r1)     // Catch:{ Exception -> 0x0023, all -> 0x0025 }
            if (r1 == r2) goto L_0x0022
            java.text.SimpleDateFormat r1 = r3.formaterGuion     // Catch:{ Exception -> 0x0023, all -> 0x0025 }
            java.util.Date r1 = r1.parse(r4)     // Catch:{ Exception -> 0x0023, all -> 0x0025 }
            r0 = r1
        L_0x0022:
            goto L_0x0029
        L_0x0023:
            r1 = move-exception
            goto L_0x0029
        L_0x0025:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        L_0x0028:
            r1 = move-exception
        L_0x0029:
            monitor-exit(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.utils.ComparadorFechas.getDate(java.lang.String):java.util.Date");
    }
}
