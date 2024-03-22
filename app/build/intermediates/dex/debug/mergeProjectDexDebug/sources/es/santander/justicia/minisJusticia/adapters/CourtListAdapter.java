package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import es.santander.justicia.minisJusticia.dto.CourtDataDto;
import java.util.ArrayList;

public class CourtListAdapter extends ArrayAdapter<CourtDataDto> {
    private Context context;
    private ArrayList<CourtDataDto> courtList;

    public CourtListAdapter(Context context2, ArrayList<CourtDataDto> courtList2) {
        super(context2, 0, courtList2);
        this.context = context2;
        this.courtList = courtList2;
    }

    static class ViewHolder {
        public TextView judicialEnvironment;
        public TextView organismName;
        public TextView province;
        public TextView status;

        ViewHolder() {
        }
    }

    public int getCount() {
        return this.courtList.size();
    }

    public CourtDataDto getItem(int position) {
        return this.courtList.get(position);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: es.santander.justicia.minisJusticia.adapters.CourtListAdapter$ViewHolder} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
            r5 = this;
            java.util.ArrayList<es.santander.justicia.minisJusticia.dto.CourtDataDto> r0 = r5.courtList
            java.lang.Object r0 = r0.get(r6)
            es.santander.justicia.minisJusticia.dto.CourtDataDto r0 = (es.santander.justicia.minisJusticia.dto.CourtDataDto) r0
            es.santander.justicia.minisJusticia.adapters.CourtListAdapter$ViewHolder r1 = new es.santander.justicia.minisJusticia.adapters.CourtListAdapter$ViewHolder
            r1.<init>()
            if (r7 != 0) goto L_0x004d
            android.content.Context r2 = r5.context
            android.view.LayoutInflater r2 = android.view.LayoutInflater.from(r2)
            r3 = 2131558726(0x7f0d0146, float:1.8742776E38)
            r4 = 0
            android.view.View r7 = r2.inflate(r3, r8, r4)
            r2 = 2131363030(0x7f0a04d6, float:1.8345857E38)
            android.view.View r2 = r7.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r1.organismName = r2
            r2 = 2131363024(0x7f0a04d0, float:1.8345845E38)
            android.view.View r2 = r7.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r1.judicialEnvironment = r2
            r2 = 2131363060(0x7f0a04f4, float:1.8345918E38)
            android.view.View r2 = r7.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r1.status = r2
            r2 = 2131363037(0x7f0a04dd, float:1.8345872E38)
            android.view.View r2 = r7.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r1.province = r2
            r7.setTag(r1)
            goto L_0x0054
        L_0x004d:
            java.lang.Object r2 = r7.getTag()
            r1 = r2
            es.santander.justicia.minisJusticia.adapters.CourtListAdapter$ViewHolder r1 = (es.santander.justicia.minisJusticia.adapters.CourtListAdapter.ViewHolder) r1
        L_0x0054:
            android.widget.TextView r2 = r1.organismName
            java.lang.String r3 = r0.getOrganismName()
            java.lang.String r3 = es.santander.justicia.utils.CommonUtils.wordCapitalize(r3)
            r2.setText(r3)
            android.widget.TextView r2 = r1.judicialEnvironment
            java.lang.String r3 = r0.getJudicialEnvironment()
            java.lang.String r3 = es.santander.justicia.utils.CommonUtils.wordCapitalize(r3)
            r2.setText(r3)
            android.widget.TextView r2 = r1.status
            java.lang.String r3 = r0.getStatus()
            r2.setText(r3)
            android.widget.TextView r2 = r1.province
            java.lang.String r3 = r0.getProvince()
            java.lang.String r3 = es.santander.justicia.utils.CommonUtils.wordCapitalize(r3)
            r2.setText(r3)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: es.santander.justicia.minisJusticia.adapters.CourtListAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }
}
