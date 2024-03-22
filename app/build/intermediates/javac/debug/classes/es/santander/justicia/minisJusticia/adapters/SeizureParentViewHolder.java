package es.santander.justicia.minisJusticia.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import com.alexandrius.accordionswipelayout.library.SwipeLayout;
import com.bignerdranch.expandablerecyclerview.ParentViewHolder;
import es.santander.justicia.minisJusticia.views.QTextView;

public class SeizureParentViewHolder extends ParentViewHolder {
   protected CardView mCard;
   protected SwipeLayout mSwipeLayout;
   protected LinearLayout mLinearGlobal;
   protected LinearLayout mLinear;
   protected ImageView mImageSwipe;
   protected QTextView mTextExpediente;
   protected QTextView mTextFechaAlta;
   protected QTextView mTextTipoEmbargo;
   protected QTextView mTextSituacion;
   protected QTextView mTextImporte;
   protected ImageView mImageLateral;

   public SeizureParentViewHolder(@NonNull View itemView) {
      super(itemView);
      this.mCard = (CardView)itemView.findViewById(2131361981);
      this.mSwipeLayout = (SwipeLayout)itemView.findViewById(2131362772);
      this.mLinearGlobal = (LinearLayout)itemView.findViewById(2131362404);
      this.mImageSwipe = (ImageView)itemView.findViewById(2131362300);
      this.mLinear = (LinearLayout)itemView.findViewById(2131362393);
      this.mTextExpediente = (QTextView)itemView.findViewById(2131362888);
      this.mTextFechaAlta = (QTextView)itemView.findViewById(2131362889);
      this.mTextTipoEmbargo = (QTextView)itemView.findViewById(2131362925);
      this.mTextSituacion = (QTextView)itemView.findViewById(2131362920);
      this.mTextImporte = (QTextView)itemView.findViewById(2131362893);
      this.mImageLateral = (ImageView)itemView.findViewById(2131362298);
   }
}
