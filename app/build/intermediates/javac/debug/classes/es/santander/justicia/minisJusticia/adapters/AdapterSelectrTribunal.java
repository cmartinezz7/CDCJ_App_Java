package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import es.santander.justicia.minisJusticia.adapters.AdapterAbstractRecycler.OnRecyclerClickListener;
import es.santander.justicia.minisJusticia.adapters.AdapterSelectrTribunal.1;
import es.santander.justicia.minisJusticia.models.responses.consultaOrganosAsignados.ConsultaOrganoAsignadoDetail;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.PreferencesHelper;
import java.util.List;

public class AdapterSelectrTribunal extends AdapterAbstractRecycler<ConsultaOrganoAsignadoDetail> {
   private boolean makeAnimation;

   public AdapterSelectrTribunal(Context context, List<ConsultaOrganoAsignadoDetail> listNews) {
      super(context, (OnRecyclerClickListener)context, listNews);
   }

   public ViewHolderAbstract onCreateViewHolder(ViewGroup parent, int viewType) {
      View v = null;
      v = LayoutInflater.from(this.mContext).inflate(2131558514, parent, false);
      return new es.santander.justicia.minisJusticia.adapters.AdapterSelectrTribunal.ViewHolder(this, v);
   }

   public void onBindViewHolder(ViewHolderAbstract abstractHolder, int position) {
      es.santander.justicia.minisJusticia.adapters.AdapterSelectrTribunal.ViewHolder holder = (es.santander.justicia.minisJusticia.adapters.AdapterSelectrTribunal.ViewHolder)abstractHolder;
      es.santander.justicia.minisJusticia.adapters.AdapterSelectrTribunal.ViewHolder.access$000(holder).setOnClickListener(new 1(this, position));
      if (PreferencesHelper.newInstance(this.mContext).getString("preference_user") != null && !PreferencesHelper.newInstance(this.mContext).getString("preference_user").isEmpty() && position == 0) {
         es.santander.justicia.minisJusticia.adapters.AdapterSelectrTribunal.ViewHolder.access$100(holder).setVisibility(0);
      } else {
         es.santander.justicia.minisJusticia.adapters.AdapterSelectrTribunal.ViewHolder.access$100(holder).setVisibility(8);
      }

      es.santander.justicia.minisJusticia.adapters.AdapterSelectrTribunal.ViewHolder.access$200(holder).setText(((ConsultaOrganoAsignadoDetail)this.getItem(position)).getCodUo() + " " + ((ConsultaOrganoAsignadoDetail)this.getItem(position)).getDesUo());
      es.santander.justicia.minisJusticia.adapters.AdapterSelectrTribunal.ViewHolder.access$300(holder).setText(((ConsultaOrganoAsignadoDetail)this.getItem(position)).getDesTipRelacion());
      es.santander.justicia.minisJusticia.adapters.AdapterSelectrTribunal.ViewHolder.access$400(holder).setText(((ConsultaOrganoAsignadoDetail)this.getItem(position)).getDesCargo());
      es.santander.justicia.minisJusticia.adapters.AdapterSelectrTribunal.ViewHolder.access$500(holder).setText(CommonUtils.getDateFromExp(((ConsultaOrganoAsignadoDetail)this.getItem(position)).getFecInicio()));
      es.santander.justicia.minisJusticia.adapters.AdapterSelectrTribunal.ViewHolder.access$600(holder).setText(CommonUtils.getDateFromExp(((ConsultaOrganoAsignadoDetail)this.getItem(position)).getFecFin()));
      if (position == 0 && this.makeAnimation) {
         this.animate(holder, 2130772010);
         this.setMakeAnimation(false);
      }

   }

   public void setMakeAnimation(boolean value) {
      this.makeAnimation = value;
   }

   private void animate(androidx.recyclerview.widget.RecyclerView.ViewHolder viewHolder, int animation) {
      Animation enterAnimation = AnimationUtils.loadAnimation(this.mContext, animation);
      viewHolder.itemView.setAnimation(enterAnimation);
   }
}
