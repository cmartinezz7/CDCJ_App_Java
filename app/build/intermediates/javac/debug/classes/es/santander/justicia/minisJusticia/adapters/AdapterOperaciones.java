package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import es.santander.justicia.minisJusticia.adapters.AdapterAbstractRecycler.OnRecyclerClickListener;
import es.santander.justicia.minisJusticia.adapters.AdapterOperaciones.1;
import es.santander.justicia.minisJusticia.dto.SpinnerValuesDTO;
import es.santander.justicia.minisJusticia.models.SpinnerContentModel;
import es.santander.justicia.minisJusticia.models.responses.OperacionGlobal;
import es.santander.justicia.utils.CommonUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AdapterOperaciones extends AdapterAbstractRecycler<OperacionGlobal> {
   public static final int TYPE_PENDING = 1;
   public static final int TYPE_DONE = 2;
   private ArrayList<SpinnerValuesDTO> operations = SpinnerContentModel.getSpinnerValues("spnOperationType");
   private int mType;

   public AdapterOperaciones(Context context, OnRecyclerClickListener listener, List<OperacionGlobal> listNews, int type) {
      super(context, listener, listNews);
      this.mType = type;
   }

   public ViewHolderAbstract onCreateViewHolder(ViewGroup parent, int viewType) {
      View v = LayoutInflater.from(this.mContext).inflate(2131558512, parent, false);
      return new es.santander.justicia.minisJusticia.adapters.AdapterOperaciones.ViewHolder(this, v);
   }

   public void onBindViewHolder(ViewHolderAbstract holderAbstract, int position) {
      es.santander.justicia.minisJusticia.adapters.AdapterOperaciones.ViewHolder holder = (es.santander.justicia.minisJusticia.adapters.AdapterOperaciones.ViewHolder)holderAbstract;
      es.santander.justicia.minisJusticia.adapters.AdapterOperaciones.ViewHolder.access$000(holder).setText(CommonUtils.capitalize(this.getOperationDescription(((OperacionGlobal)this.getItem(position)).getTipoOpe())));
      es.santander.justicia.minisJusticia.adapters.AdapterOperaciones.ViewHolder.access$100(holder).setText(((OperacionGlobal)this.getItem(position)).getTotalOperaciones());
      es.santander.justicia.minisJusticia.adapters.AdapterOperaciones.ViewHolder.access$200(holder).setText(CommonUtils.formatImport(((OperacionGlobal)this.getItem(position)).getImporte()) + " " + CommonUtils.getCurrencySymbol(((OperacionGlobal)this.getItem(position)).getCodmon()));
      es.santander.justicia.minisJusticia.adapters.AdapterOperaciones.ViewHolder.access$300(holder).setOnClickListener(new 1(this, position));
   }

   private String getOperationDescription(String code) {
      if (this.mType == 2) {
         Iterator var2 = this.operations.iterator();

         while(var2.hasNext()) {
            SpinnerValuesDTO spinnerValuesDTO = (SpinnerValuesDTO)var2.next();
            if (spinnerValuesDTO.getCode().equals(code)) {
               return spinnerValuesDTO.getValueToShow();
            }
         }
      } else {
         byte var4 = -1;
         switch(code.hashCode()) {
         case 457319128:
            if (code.equals("PTE_COB")) {
               var4 = 0;
            }
            break;
         case 457319140:
            if (code.equals("PTE_CON")) {
               var4 = 1;
            }
            break;
         case 457324868:
            if (code.equals("PTE_ING")) {
               var4 = 2;
            }
         }

         switch(var4) {
         case 0:
            return this.mContext.getString(2131886679);
         case 1:
            return this.mContext.getString(2131886680);
         case 2:
            return this.mContext.getString(2131886681);
         }
      }

      return "";
   }
}
