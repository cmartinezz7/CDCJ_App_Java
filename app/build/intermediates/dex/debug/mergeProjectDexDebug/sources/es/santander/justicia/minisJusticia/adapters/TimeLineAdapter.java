package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import es.santander.justicia.minisJusticia.dto.TimeLineDetailDTO;
import java.util.ArrayList;

public class TimeLineAdapter extends ArrayAdapter<TimeLineDetailDTO> {
    private Context context;
    private int lastItem;
    private ArrayList<TimeLineDetailDTO> timeLineList;

    public TimeLineAdapter(Context context2, ArrayList<TimeLineDetailDTO> timeLineList2) {
        super(context2, 0, timeLineList2);
        this.context = context2;
        this.timeLineList = timeLineList2;
        this.lastItem = timeLineList2.size() - 1;
    }

    static class ViewHolder {
        public View bottomLine;
        public TextView date;
        public LinearLayout llUserContainer;
        public ImageView statusImageIndicator;
        public TextView statusName;
        public View topLine;
        public TextView userName;

        ViewHolder() {
        }
    }

    public int getCount() {
        return this.timeLineList.size();
    }

    public TimeLineDetailDTO getItem(int position) {
        return this.timeLineList.get(position);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: es.santander.justicia.minisJusticia.adapters.TimeLineAdapter$ViewHolder} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0112, code lost:
        if (r5.equals("accept") != false) goto L_0x0116;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r13, android.view.View r14, android.view.ViewGroup r15) {
        /*
            r12 = this;
            java.util.ArrayList<es.santander.justicia.minisJusticia.dto.TimeLineDetailDTO> r0 = r12.timeLineList
            java.lang.Object r0 = r0.get(r13)
            es.santander.justicia.minisJusticia.dto.TimeLineDetailDTO r0 = (es.santander.justicia.minisJusticia.dto.TimeLineDetailDTO) r0
            es.santander.justicia.minisJusticia.adapters.TimeLineAdapter$ViewHolder r1 = new es.santander.justicia.minisJusticia.adapters.TimeLineAdapter$ViewHolder
            r1.<init>()
            r2 = 0
            if (r14 != 0) goto L_0x006a
            android.content.Context r3 = r12.context
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r3)
            r4 = 2131558738(0x7f0d0152, float:1.87428E38)
            android.view.View r14 = r3.inflate(r4, r15, r2)
            r3 = 2131362429(0x7f0a027d, float:1.8344638E38)
            android.view.View r3 = r14.findViewById(r3)
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r1.llUserContainer = r3
            r3 = 2131363061(0x7f0a04f5, float:1.834592E38)
            android.view.View r3 = r14.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r1.statusName = r3
            r3 = 2131362356(0x7f0a0234, float:1.834449E38)
            android.view.View r3 = r14.findViewById(r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            r1.statusImageIndicator = r3
            r3 = 2131363005(0x7f0a04bd, float:1.8345807E38)
            android.view.View r3 = r14.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r1.date = r3
            r3 = 2131363083(0x7f0a050b, float:1.8345965E38)
            android.view.View r3 = r14.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r1.userName = r3
            r3 = 2131363156(0x7f0a0554, float:1.8346113E38)
            android.view.View r3 = r14.findViewById(r3)
            r1.topLine = r3
            r3 = 2131363153(0x7f0a0551, float:1.8346107E38)
            android.view.View r3 = r14.findViewById(r3)
            r1.bottomLine = r3
            r14.setTag(r1)
            goto L_0x0071
        L_0x006a:
            java.lang.Object r3 = r14.getTag()
            r1 = r3
            es.santander.justicia.minisJusticia.adapters.TimeLineAdapter$ViewHolder r1 = (es.santander.justicia.minisJusticia.adapters.TimeLineAdapter.ViewHolder) r1
        L_0x0071:
            android.widget.TextView r3 = r1.statusName
            java.lang.String r4 = r0.getStatusName()
            r3.setText(r4)
            android.widget.TextView r3 = r1.date
            java.lang.String r4 = r0.getDate()
            r3.setText(r4)
            java.lang.String r3 = r0.getUserName()
            if (r3 == 0) goto L_0x0092
            java.lang.String r3 = r0.getUserName()
            java.lang.String r3 = r3.trim()
            goto L_0x0094
        L_0x0092:
            java.lang.String r3 = ""
        L_0x0094:
            boolean r4 = r3.isEmpty()
            if (r4 != 0) goto L_0x00a5
            android.widget.LinearLayout r4 = r1.llUserContainer
            r4.setVisibility(r2)
            android.widget.TextView r4 = r1.userName
            r4.setText(r3)
            goto L_0x00ac
        L_0x00a5:
            android.widget.LinearLayout r4 = r1.llUserContainer
            r5 = 8
            r4.setVisibility(r5)
        L_0x00ac:
            r4 = 4
            if (r13 != 0) goto L_0x00b5
            android.view.View r5 = r1.topLine
            r5.setVisibility(r4)
            goto L_0x00ba
        L_0x00b5:
            android.view.View r5 = r1.topLine
            r5.setVisibility(r2)
        L_0x00ba:
            int r5 = r12.lastItem
            if (r13 != r5) goto L_0x00c4
            android.view.View r5 = r1.bottomLine
            r5.setVisibility(r4)
            goto L_0x00c9
        L_0x00c4:
            android.view.View r5 = r1.bottomLine
            r5.setVisibility(r2)
        L_0x00c9:
            java.lang.String r5 = r0.getStatus()
            r6 = -1
            int r7 = r5.hashCode()
            r8 = 5
            r9 = 3
            r10 = 2
            r11 = 1
            switch(r7) {
                case -1423461112: goto L_0x010c;
                case -1309235419: goto L_0x0102;
                case -466972329: goto L_0x00f8;
                case -123173735: goto L_0x00ee;
                case 211933510: goto L_0x00e4;
                case 2143357607: goto L_0x00da;
                default: goto L_0x00d9;
            }
        L_0x00d9:
            goto L_0x0115
        L_0x00da:
            java.lang.String r2 = "no_expired"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x00d9
            r2 = r8
            goto L_0x0116
        L_0x00e4:
            java.lang.String r2 = "no_accept"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x00d9
            r2 = r11
            goto L_0x0116
        L_0x00ee:
            java.lang.String r2 = "canceled"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x00d9
            r2 = r10
            goto L_0x0116
        L_0x00f8:
            java.lang.String r2 = "no_canceled"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x00d9
            r2 = r9
            goto L_0x0116
        L_0x0102:
            java.lang.String r2 = "expired"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x00d9
            r2 = r4
            goto L_0x0116
        L_0x010c:
            java.lang.String r7 = "accept"
            boolean r7 = r5.equals(r7)
            if (r7 == 0) goto L_0x00d9
            goto L_0x0116
        L_0x0115:
            r2 = r6
        L_0x0116:
            if (r2 == 0) goto L_0x014c
            if (r2 == r11) goto L_0x0145
            if (r2 == r10) goto L_0x013e
            if (r2 == r9) goto L_0x0137
            if (r2 == r4) goto L_0x0130
            if (r2 == r8) goto L_0x0129
            r2 = 2131231051(0x7f08014b, float:1.8078172E38)
            r4 = 2131100951(0x7f060517, float:1.7814298E38)
            goto L_0x0153
        L_0x0129:
            r2 = 2131231051(0x7f08014b, float:1.8078172E38)
            r4 = 2131100952(0x7f060518, float:1.78143E38)
            goto L_0x0153
        L_0x0130:
            r2 = 2131231050(0x7f08014a, float:1.807817E38)
            r4 = 2131100952(0x7f060518, float:1.78143E38)
            goto L_0x0153
        L_0x0137:
            r2 = 2131231011(0x7f080123, float:1.807809E38)
            r4 = 2131100916(0x7f0604f4, float:1.7814227E38)
            goto L_0x0153
        L_0x013e:
            r2 = 2131231010(0x7f080122, float:1.8078089E38)
            r4 = 2131100916(0x7f0604f4, float:1.7814227E38)
            goto L_0x0153
        L_0x0145:
            r2 = 2131231008(0x7f080120, float:1.8078085E38)
            r4 = 2131100951(0x7f060517, float:1.7814298E38)
            goto L_0x0153
        L_0x014c:
            r2 = 2131231007(0x7f08011f, float:1.8078083E38)
            r4 = 2131100951(0x7f060517, float:1.7814298E38)
        L_0x0153:
            android.widget.TextView r6 = r1.statusName
            android.content.Context r7 = r12.context
            int r7 = androidx.core.content.ContextCompat.getColor(r7, r4)
            r6.setTextColor(r7)
            android.widget.ImageView r6 = r1.statusImageIndicator
            r6.setImageResource(r2)
            android.view.View r6 = r1.topLine
            android.content.Context r7 = r12.context
            int r7 = androidx.core.content.ContextCompat.getColor(r7, r4)
            r6.setBackgroundColor(r7)
            android.view.View r6 = r1.bottomLine
            android.content.Context r7 = r12.context
            int r7 = androidx.core.content.ContextCompat.getColor(r7, r4)
            r6.setBackgroundColor(r7)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.adapters.TimeLineAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }
}
