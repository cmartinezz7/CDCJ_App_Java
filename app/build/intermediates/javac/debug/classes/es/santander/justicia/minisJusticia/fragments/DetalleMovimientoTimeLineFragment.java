package es.santander.justicia.minisJusticia.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import es.santander.justicia.minisJusticia.adapters.TimeLineAdapter;
import es.santander.justicia.minisJusticia.dto.MovementItemDTO;
import es.santander.justicia.minisJusticia.dto.TimeLineDetailDTO;
import es.santander.justicia.utils.CommonUtils;
import java.util.ArrayList;

public class DetalleMovimientoTimeLineFragment extends Fragment {
   private Context context;
   private MovementItemDTO movementItemDTO;

   public static DetalleMovimientoTimeLineFragment newInstance(MovementItemDTO movementItemDTO) {
      DetalleMovimientoTimeLineFragment fragment = new DetalleMovimientoTimeLineFragment();
      fragment.movementItemDTO = movementItemDTO;
      return fragment;
   }

   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.context = this.getActivity().getBaseContext();
   }

   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      return inflater.inflate(2131558750, container, false);
   }

   public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
      super.onViewCreated(view, savedInstanceState);
      ListView list = (ListView)view.findViewById(2131362452);
      ArrayList<TimeLineDetailDTO> timeLineList = new ArrayList();
      if (CommonUtils.isNotNullNotBlack(this.movementItemDTO.getJfechare()) && CommonUtils.isNotNullNotBlack(this.movementItemDTO.getjResponsableAlta())) {
         timeLineList.add(new TimeLineDetailDTO("Alta", "accept", this.movementItemDTO.getJfechare(), this.movementItemDTO.getjResponsableAlta(), 0));
      } else {
         timeLineList.add(new TimeLineDetailDTO("Alta", "no_accept", this.movementItemDTO.getJfechare(), this.movementItemDTO.getjResponsableAlta(), 0));
      }

      if (CommonUtils.isNotNullNotBlack(this.movementItemDTO.getjFechaFirma()) && CommonUtils.isNotNullNotBlack(this.movementItemDTO.getjResponsableFirma())) {
         timeLineList.add(new TimeLineDetailDTO("Firma", "accept", this.movementItemDTO.getjFechaFirma(), this.movementItemDTO.getjResponsableFirma(), 1));
      } else {
         timeLineList.add(new TimeLineDetailDTO("Firma", "no_accept", this.movementItemDTO.getjFechaFirma(), this.movementItemDTO.getjResponsableFirma(), 1));
      }

      if (CommonUtils.isNotNullNotBlack(this.movementItemDTO.getjFechaConfirmacion()) && CommonUtils.isNotNullNotBlack(this.movementItemDTO.getjResponsableConfirmacion())) {
         timeLineList.add(new TimeLineDetailDTO("Confirmación", "accept", this.movementItemDTO.getjFechaConfirmacion(), this.movementItemDTO.getjResponsableConfirmacion(), 2));
      } else {
         timeLineList.add(new TimeLineDetailDTO("Confirmación", "no_accept", this.movementItemDTO.getjFechaConfirmacion(), this.movementItemDTO.getjResponsableConfirmacion(), 2));
      }

      if (this.movementItemDTO.isEsLetrado()) {
         if (!CommonUtils.isNotNullNotBlack(this.movementItemDTO.getjFechaFirmeza()) && !CommonUtils.isNotNullNotBlack(this.movementItemDTO.getjResponsableFirmeza())) {
            timeLineList.add(new TimeLineDetailDTO("Firmeza", "no_accept", this.movementItemDTO.getjFechaFirmeza(), this.movementItemDTO.getjResponsableFirmeza(), 3));
         } else {
            timeLineList.add(new TimeLineDetailDTO("Firmeza", "accept", this.movementItemDTO.getjFechaFirmeza(), this.movementItemDTO.getjResponsableFirmeza(), 3));
         }

         if (CommonUtils.isNotNullNotBlack(this.movementItemDTO.getjFechaAutorizacion()) && CommonUtils.isNotNullNotBlack(this.movementItemDTO.getjResponsableAutorizacion())) {
            timeLineList.add(new TimeLineDetailDTO("Autorización", "accept", this.movementItemDTO.getjFechaAutorizacion(), this.movementItemDTO.getjResponsableAutorizacion(), 4));
         } else {
            timeLineList.add(new TimeLineDetailDTO("Autorización", "no_accept", this.movementItemDTO.getjFechaAutorizacion(), this.movementItemDTO.getjResponsableAutorizacion(), 4));
         }
      }

      if (!CommonUtils.isNotNullNotBlack(this.movementItemDTO.getjFechaAnulacion())) {
         timeLineList.add(new TimeLineDetailDTO("Anulación", "no_canceled", this.movementItemDTO.getjFechaAnulacion(), "", 5));
      } else {
         timeLineList.add(new TimeLineDetailDTO("Anulación", "canceled", this.movementItemDTO.getjFechaAnulacion(), "", 5));
      }

      if (!CommonUtils.isNotNullNotBlack(this.movementItemDTO.getjFechaCaducidad())) {
         timeLineList.add(new TimeLineDetailDTO("Caducidad", "no_expired", this.movementItemDTO.getjFechaCaducidad(), "", 6));
      } else {
         timeLineList.add(new TimeLineDetailDTO("Caducidad", "expired", this.movementItemDTO.getjFechaCaducidad(), "", 6));
      }

      TimeLineAdapter adapter = new TimeLineAdapter(this.context, timeLineList);
      list.setAdapter(adapter);
      list.setClickable(false);
      list.setDividerHeight(0);
   }
}
