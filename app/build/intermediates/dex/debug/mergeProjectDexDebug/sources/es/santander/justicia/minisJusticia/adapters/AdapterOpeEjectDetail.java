package es.santander.justicia.minisJusticia.adapters;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.alexandrius.accordionswipelayout.library.SwipeLayout;
import es.santander.justicia.R;
import es.santander.justicia.minisJusticia.ActivityDetalleOperacion;
import es.santander.justicia.minisJusticia.adapters.AdapterAbstractRecycler;
import es.santander.justicia.minisJusticia.models.responses.consultaOperaciones.ConsultaOperaciones;
import es.santander.justicia.minisJusticia.views.QTextView;
import es.santander.justicia.utils.CommonUtils;
import java.util.List;

public class AdapterOpeEjectDetail extends AdapterAbstractRecycler<ConsultaOperaciones> {
    public static final int TYPE_DONE = 2;
    public static final int TYPE_PENDING = 1;
    public static final int VIEW_TYPE_ANULAR = 2;
    public static final int VIEW_TYPE_FIRMAR_ANULAR = 3;
    public static final int VIEW_TYPE_NADA = 1;
    private int mCurrentType;
    /* access modifiers changed from: private */
    public OnOperativeClicked mOperativeListener;

    public interface OnOperativeClicked {
        void onOperativeClicked(int i, int i2);
    }

    public AdapterOpeEjectDetail(Context context, List<ConsultaOperaciones> listNews, int type) {
        super(context, (AdapterAbstractRecycler.OnRecyclerClickListener) context, listNews);
        this.mCurrentType = type;
        this.mOperativeListener = (OnOperativeClicked) context;
    }

    public ViewHolderAbstract onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = null;
        if (viewType == 1) {
            v = LayoutInflater.from(this.mContext).inflate(R.layout.card_detail_operations_no_operative, parent, false);
        } else if (viewType == 2) {
            v = LayoutInflater.from(this.mContext).inflate(R.layout.card_detail_operations_anular, parent, false);
        } else if (viewType == 3) {
            v = LayoutInflater.from(this.mContext).inflate(R.layout.card_detail_operations_firmar_anular, parent, false);
        }
        return new ViewHolder(v);
    }

    public void onBindViewHolder(ViewHolderAbstract abstractHolder, final int position) {
        final ViewHolder holder = (ViewHolder) abstractHolder;
        holder.textNumExp.setText(CommonUtils.formatExpedientWithSpaces(((ConsultaOperaciones) getItem(position)).getJuzgadoDestino(), ((ConsultaOperaciones) getItem(position)).getJuzgadoOrigen(), ((ConsultaOperaciones) getItem(position)).getProcedimiento(), ((ConsultaOperaciones) getItem(position)).getNumExpediente(), ((ConsultaOperaciones) getItem(position)).getAnyoApertura()));
        holder.textTitular.setText(((ConsultaOperaciones) getItem(position)).getTitular());
        holder.textNMandamiento.setText(((ConsultaOperaciones) getItem(position)).getNumMandamiento());
        holder.textDate.setText(CommonUtils.getDateFromExp(((ConsultaOperaciones) getItem(position)).getFechaAltaOperacion()));
        holder.textAmmount.setText(CommonUtils.formatImport(((ConsultaOperaciones) getItem(position)).getImporte()) + " " + CommonUtils.getCurrencySymbol(((ConsultaOperaciones) getItem(position)).getCodigoMoneda()));
        if (holder.imageSwipe != null) {
            holder.imageSwipe.setOnClickListener(new View.OnClickListener() {
                public void onClick(final View view) {
                    holder.swipeLayout.onTouch(holder.swipeLayout, MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 2, view.getX(), view.getY(), 0));
                    holder.swipeLayout.onTouch(holder.swipeLayout, MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 2, holder.swipeLayout.isExpanded() ? view.getX() + 1000.0f : view.getX() - 1000.0f, view.getY(), 0));
                    holder.swipeLayout.requestFocus();
                    if (!holder.swipeLayout.isExpanded()) {
                        new Handler().postDelayed(new Runnable() {
                            public void run() {
                                holder.swipeLayout.onTouch(holder.swipeLayout, MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, view.getX() + 1000.0f, view.getY(), 0));
                                holder.swipeLayout.onTouch(holder.swipeLayout, MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, view.getX() + 1000.0f, view.getY(), 0));
                            }
                        }, 100);
                    }
                }
            });
        }
        holder.imageState.setImageResource(this.mCurrentType == 1 ? R.drawable.ic_pendiente_v2 : R.drawable.ic_alta_v2);
        holder.imageState.setBackgroundColor(ContextCompat.getColor(this.mContext, this.mCurrentType == 1 ? R.color.lista_movimientos_pte : R.color.expOperativo));
        holder.swipeLayout.setOnSwipeItemClickListener(new SwipeLayout.OnSwipeItemClickListener() {
            public void onSwipeItemClick(boolean b, int i) {
                AdapterOpeEjectDetail.this.mOperativeListener.onOperativeClicked(i == 0 ? 1 : 2, position);
            }
        });
        holder.swipeLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AdapterOpeEjectDetail.this.mListener.onItemClickListener(position);
            }
        });
    }

    public int getItemViewType(int position) {
        String str;
        if (this.mCurrentType == 1 && ((ConsultaOperaciones) getItem(position)).getCodigoEstadoOperacion() != null) {
            String codigoEstadoOperacion = ((ConsultaOperaciones) getItem(position)).getCodigoEstadoOperacion();
            char c = 65535;
            int hashCode = codigoEstadoOperacion.hashCode();
            if (hashCode != 65) {
                if (hashCode != 70) {
                    if (hashCode != 73) {
                        if (hashCode == 80 && codigoEstadoOperacion.equals(ActivityDetalleOperacion.CODIGO_ESTADO_P)) {
                            c = 2;
                        }
                    } else if (codigoEstadoOperacion.equals(ActivityDetalleOperacion.CODIGO_ESTADO_I)) {
                        c = 1;
                    }
                } else if (codigoEstadoOperacion.equals(ActivityDetalleOperacion.CODIGO_ESTADO_F)) {
                    c = 3;
                }
            } else if (codigoEstadoOperacion.equals(ActivityDetalleOperacion.CODIGO_ESTADO_A)) {
                c = 0;
            }
            if (c == 0) {
                String codTipoMovimiento = ((ConsultaOperaciones) getItem(position)).getCodTipoMovimiento();
                int hashCode2 = codTipoMovimiento.hashCode();
                if (hashCode2 == 2673) {
                    str = ActivityDetalleOperacion.COD_TRASPASO_TE;
                } else if (hashCode2 == 2686) {
                    str = ActivityDetalleOperacion.COD_TRASPASO_TR;
                } else if (hashCode2 == 2688) {
                    str = ActivityDetalleOperacion.COD_TRASPASO_TT;
                } else if (hashCode2 == 2797) {
                    str = ActivityDetalleOperacion.COD_TRANSFERENCIA_XE;
                }
                boolean equals = codTipoMovimiento.equals(str);
            } else if (!(c == 1 || c == 2)) {
                if (c != 3) {
                    return 1;
                }
                return 3;
            }
            return 2;
        }
        return 1;
    }

    public class ViewHolder extends ViewHolderAbstract {
        /* access modifiers changed from: private */
        public ImageView imageState;
        /* access modifiers changed from: private */
        public ImageView imageSwipe;
        /* access modifiers changed from: private */
        public SwipeLayout swipeLayout;
        /* access modifiers changed from: private */
        public QTextView textAmmount;
        /* access modifiers changed from: private */
        public QTextView textDate;
        /* access modifiers changed from: private */
        public QTextView textNMandamiento;
        /* access modifiers changed from: private */
        public QTextView textNumExp;
        /* access modifiers changed from: private */
        public QTextView textTitular;

        public ViewHolder(View itemView) {
            super(itemView);
            this.textNumExp = (QTextView) itemView.findViewById(R.id.text_num_exp);
            this.textTitular = (QTextView) itemView.findViewById(R.id.text_titular);
            this.textNMandamiento = (QTextView) itemView.findViewById(R.id.text_n_mandamiento);
            this.textDate = (QTextView) itemView.findViewById(R.id.text_date);
            this.textAmmount = (QTextView) itemView.findViewById(R.id.text_ammount);
            this.imageSwipe = (ImageView) itemView.findViewById(R.id.image_swipe);
            this.imageState = (ImageView) itemView.findViewById(R.id.image_state);
            this.swipeLayout = itemView.findViewById(R.id.swipe_layout);
        }
    }
}
