package es.santander.justicia.minisJusticia.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import es.santander.justicia.minisJusticia.dto.MovementItemDTO;
import es.santander.justicia.utils.CommonUtils;
import es.santander.justicia.utils.ComparadorFechas;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DetalleDeMovimientoTimeLineDetailFragment extends Fragment {
   private Context context;
   private MovementItemDTO movementItemDTO;
   private TextView tv_exp_destino;
   private TextView txt_exp_destino;
   private TextView tv_importe;
   private TextView txt_importe;
   private TextView tv_repesentado;
   private TextView txt_repesentado;
   private TextView tv_documento;
   private TextView txt_documento;
   private TextView tv_representante;
   private TextView txt_representante;
   private TextView tv_fecha;
   private TextView txt_fecha;
   private TextView tv_concepto;
   private TextView txt_concepto;
   private TextView tv_saldo;
   private TextView txt_saldo;

   public static DetalleDeMovimientoTimeLineDetailFragment newInstance(MovementItemDTO movementItemDTO) {
      DetalleDeMovimientoTimeLineDetailFragment fragment = new DetalleDeMovimientoTimeLineDetailFragment();
      fragment.movementItemDTO = movementItemDTO;
      return fragment;
   }

   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      this.context = this.getActivity().getApplicationContext();
   }

   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      return inflater.inflate(2131558583, container, false);
   }

   public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
      super.onViewCreated(view, savedInstanceState);
      this.tv_exp_destino = (TextView)view.findViewById(2131363013);
      this.tv_importe = (TextView)view.findViewById(2131363022);
      this.tv_repesentado = (TextView)view.findViewById(2131363039);
      this.tv_documento = (TextView)view.findViewById(2131363011);
      this.tv_representante = (TextView)view.findViewById(2131363040);
      this.tv_fecha = (TextView)view.findViewById(2131363014);
      this.tv_concepto = (TextView)view.findViewById(2131363004);
      this.tv_saldo = (TextView)view.findViewById(2131363044);
      this.txt_exp_destino = (TextView)view.findViewById(2131363119);
      this.txt_importe = (TextView)view.findViewById(2131363127);
      this.txt_repesentado = (TextView)view.findViewById(2131363135);
      this.txt_documento = (TextView)view.findViewById(2131363118);
      this.txt_representante = (TextView)view.findViewById(2131363136);
      this.txt_fecha = (TextView)view.findViewById(2131363120);
      this.txt_concepto = (TextView)view.findViewById(2131363117);
      this.txt_saldo = (TextView)view.findViewById(2131363137);
      List<String> listaFechas = new ArrayList();
      if (CommonUtils.isNotNullNotBlack(this.movementItemDTO.getFecha())) {
         listaFechas.add(this.movementItemDTO.getFecha());
      }

      if (CommonUtils.isNotNullNotBlack(this.movementItemDTO.getjFechaAnulacion())) {
         listaFechas.add(this.movementItemDTO.getjFechaAnulacion());
      }

      if (CommonUtils.isNotNullNotBlack(this.movementItemDTO.getjFechaAutorizacion())) {
         listaFechas.add(this.movementItemDTO.getjFechaAutorizacion());
      }

      if (CommonUtils.isNotNullNotBlack(this.movementItemDTO.getjFechaCaducidad())) {
         listaFechas.add(this.movementItemDTO.getjFechaCaducidad());
      }

      if (CommonUtils.isNotNullNotBlack(this.movementItemDTO.getjFechaConfirmacion())) {
         listaFechas.add(this.movementItemDTO.getjFechaConfirmacion());
      }

      if (CommonUtils.isNotNullNotBlack(this.movementItemDTO.getjFechaFirma())) {
         listaFechas.add(this.movementItemDTO.getjFechaFirma());
      }

      if (CommonUtils.isNotNullNotBlack(this.movementItemDTO.getjFechaFirmeza())) {
         listaFechas.add(this.movementItemDTO.getjFechaFirmeza());
      }

      Collections.sort(listaFechas, new ComparadorFechas());
      if (CommonUtils.isNotNullNotBlack(this.movementItemDTO.getExpedienteDestino())) {
         this.tv_exp_destino.setText(CommonUtils.getProceedingFormatted(this.movementItemDTO.getExpedienteDestino()));
      } else {
         this.tv_exp_destino.setVisibility(8);
         this.txt_exp_destino.setVisibility(8);
      }

      if (CommonUtils.isNotNullNotBlack(this.movementItemDTO.getImporteDetalle()) && CommonUtils.isNotNullNotBlack(this.movementItemDTO.getCodmon())) {
         this.tv_importe.setText(CommonUtils.formatImport(this.movementItemDTO.getImporteDetalle()) + " " + CommonUtils.getCurrencySymbol(this.movementItemDTO.getCodmon()));
      } else {
         this.tv_importe.setVisibility(4);
      }

      if (CommonUtils.isNotNullNotBlack(this.movementItemDTO.getImporteSaldo()) && CommonUtils.isNotNullNotBlack(this.movementItemDTO.getCodmon())) {
         this.tv_saldo.setText(CommonUtils.formatImport(this.movementItemDTO.getImporteSaldo()) + " " + CommonUtils.getCurrencySymbol(this.movementItemDTO.getCodmon()));
      } else {
         this.tv_saldo.setVisibility(4);
      }

      if (CommonUtils.isNotNullNotBlack(this.movementItemDTO.getRepresentado())) {
         this.tv_repesentado.setText(this.movementItemDTO.getRepresentado());
      } else {
         this.tv_repesentado.setVisibility(4);
      }

      if (CommonUtils.isNotNullNotBlack(this.movementItemDTO.getDocumento())) {
         this.tv_documento.setText(this.movementItemDTO.getDocumento());
      } else {
         this.tv_documento.setVisibility(4);
      }

      if (CommonUtils.isNotNullNotBlack(this.movementItemDTO.getRepresentante())) {
         this.tv_representante.setText(this.movementItemDTO.getRepresentante());
      } else {
         this.tv_representante.setVisibility(4);
      }

      String date = this.movementItemDTO.getFecha();
      if (date.isEmpty()) {
         date = this.movementItemDTO.getJfechare();
      }

      this.tv_fecha.setText(date);
      if (!listaFechas.isEmpty()) {
         this.tv_concepto.setText(this.movementItemDTO.getConcepto());
      } else {
         this.tv_concepto.setVisibility(4);
      }

   }
}
