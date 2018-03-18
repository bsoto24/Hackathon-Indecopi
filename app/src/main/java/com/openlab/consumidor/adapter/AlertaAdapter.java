package com.openlab.consumidor.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.openlab.consumidor.R;
import com.openlab.consumidor.entity.AlertaTO;

import java.util.List;

/**
 * Created by Bryam Soto on 18/03/2018.
 */

public class AlertaAdapter extends RecyclerView.Adapter<AlertaAdapter.ViewHolder> {

    private Activity activity;
    private List<AlertaTO> alertas;

    public AlertaAdapter(Activity activity, List<AlertaTO> alertas) {
        this.activity = activity;
        this.alertas = alertas;
    }

    @NonNull
    @Override
    public AlertaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(activity).inflate(R.layout.item_producto, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AlertaAdapter.ViewHolder holder, int position) {
        holder.bind(alertas.get(position));
    }

    @Override
    public int getItemCount() {
        return alertas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgProducto;
        private TextView tvNombre;
        private TextView tvDescripcion;
        private TextView tvTipoAlerta;

        ViewHolder(View itemView) {
            super(itemView);

            imgProducto = itemView.findViewById(R.id.img_producto);
            tvDescripcion = itemView.findViewById(R.id.tv_alerta_descripcion);
            tvNombre = itemView.findViewById(R.id.tv_nombre_producto);
            tvTipoAlerta = itemView.findViewById(R.id.tv_alerta_tipo);

        }

        void bind(AlertaTO alertaTO) {

            imgProducto.setImageResource(alertaTO.getAlertaProductoImagen());
            tvNombre.setText(alertaTO.getAlertaProductoDescripcion());
            tvDescripcion.setText(alertaTO.getAlertaDescripcion());
            if (alertaTO.getAlertaTipo() == 1) {
                tvTipoAlerta.setVisibility(View.VISIBLE);
            } else {
                tvTipoAlerta.setVisibility(View.GONE);
            }

        }
    }
}
