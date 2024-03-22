package es.santander.justicia.soap.service.login.soap.service.ListaPeticiones;

import es.santander.justicia.utils.Constants;
import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class FiltradoExpedientePeticiones implements KvmSerializable {
    private String datefrom;
    private String dateto;
    private String part1;
    private String part2;
    private String part3;
    private String part4;
    private String part5;

    public FiltradoExpedientePeticiones() {
    }

    public FiltradoExpedientePeticiones(String part12, String part22, String part32, String part42, String part52, String datefrom2, String dateto2) {
        this.part1 = part12;
        this.part2 = part22;
        this.part3 = part32;
        this.part4 = part42;
        this.part5 = part52;
        this.datefrom = datefrom2;
        this.dateto = dateto2;
    }

    public void setPart1(String part12) {
        this.part1 = part12;
    }

    public void setPart2(String part22) {
        this.part2 = part22;
    }

    public void setPart3(String part32) {
        this.part3 = part32;
    }

    public void setPart4(String part42) {
        this.part4 = part42;
    }

    public void setPart5(String part52) {
        this.part5 = part52;
    }

    public void setDateto(String dateto2) {
        this.dateto = dateto2;
    }

    public void setDatefrom(String datefrom2) {
        this.datefrom = datefrom2;
    }

    public String getPart1() {
        return this.part1;
    }

    public String getPart2() {
        return this.part2;
    }

    public String getPart3() {
        return this.part3;
    }

    public String getPart4() {
        return this.part4;
    }

    public String getPart5() {
        return this.part5;
    }

    public String getDateto() {
        return this.dateto;
    }

    public String getDatefrom() {
        return this.datefrom;
    }

    public Object getProperty(int index) {
        switch (index) {
            case 0:
                return this.part1;
            case 1:
                return this.part2;
            case 2:
                return this.part3;
            case 3:
                return this.part4;
            case 4:
                return this.part5;
            case 5:
                return this.dateto;
            case 6:
                return this.datefrom;
            default:
                return null;
        }
    }

    public int getPropertyCount() {
        return 7;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r1.part2 = (java.lang.String) r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000e, code lost:
        r1.part3 = (java.lang.String) r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0013, code lost:
        r1.part4 = (java.lang.String) r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0018, code lost:
        r1.part5 = (java.lang.String) r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001d, code lost:
        r1.dateto = (java.lang.String) r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0022, code lost:
        r1.datefrom = (java.lang.String) r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProperty(int r2, java.lang.Object r3) {
        /*
            r1 = this;
            switch(r2) {
                case 0: goto L_0x0004;
                case 1: goto L_0x0009;
                case 2: goto L_0x000e;
                case 3: goto L_0x0013;
                case 4: goto L_0x0018;
                case 5: goto L_0x001d;
                case 6: goto L_0x0022;
                default: goto L_0x0003;
            }
        L_0x0003:
            goto L_0x0027
        L_0x0004:
            r0 = r3
            java.lang.String r0 = (java.lang.String) r0
            r1.part1 = r0
        L_0x0009:
            r0 = r3
            java.lang.String r0 = (java.lang.String) r0
            r1.part2 = r0
        L_0x000e:
            r0 = r3
            java.lang.String r0 = (java.lang.String) r0
            r1.part3 = r0
        L_0x0013:
            r0 = r3
            java.lang.String r0 = (java.lang.String) r0
            r1.part4 = r0
        L_0x0018:
            r0 = r3
            java.lang.String r0 = (java.lang.String) r0
            r1.part5 = r0
        L_0x001d:
            r0 = r3
            java.lang.String r0 = (java.lang.String) r0
            r1.dateto = r0
        L_0x0022:
            r0 = r3
            java.lang.String r0 = (java.lang.String) r0
            r1.datefrom = r0
        L_0x0027:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.soap.service.login.soap.service.ListaPeticiones.FiltradoExpedientePeticiones.setProperty(int, java.lang.Object):void");
    }

    public void getPropertyInfo(int index, Hashtable properties, PropertyInfo info) {
        switch (index) {
            case 0:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "parte1";
                return;
            case 1:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "parte2";
                return;
            case 2:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "parte3";
                return;
            case 3:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "parte4";
                return;
            case 4:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "parte5";
                return;
            case 5:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = Constants.DATE_TO;
                return;
            case 6:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = Constants.DATE_FROM;
                return;
            default:
                return;
        }
    }
}
