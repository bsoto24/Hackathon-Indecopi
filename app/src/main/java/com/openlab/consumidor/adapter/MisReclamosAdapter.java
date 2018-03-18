package com.openlab.consumidor.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.openlab.consumidor.R;
import com.openlab.consumidor.entity.ReclamoTO;
import com.openlab.consumidor.activity.ReclamoDetalleActivity;

import java.util.List;

/**
 * Created by Bryam Soto on 18/03/2018.
 */

public class MisReclamosAdapter extends RecyclerView.Adapter<MisReclamosAdapter.ViewHolder> {

    private List<ReclamoTO> reclamos;
    private Activity activity;

    public MisReclamosAdapter(List<ReclamoTO> reclamos, Activity activity) {
        this.reclamos = reclamos;
        this.activity = activity;
    }

    @Override
    public MisReclamosAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(activity).inflate(R.layout.item_reclamo, parent, false));
    }

    @Override
    public void onBindViewHolder(MisReclamosAdapter.ViewHolder holder, int position) {
        holder.bind(reclamos.get(position));
    }

    @Override
    public int getItemCount() {
        return reclamos.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvReclamoEmpresa;
        private TextView tvReclamoDescripcion;
        private TextView tvReclamoSolicitud;
        private TextView tvReclamoEstado;
        private TextView tvReclamoTipo;
        private View viewEstado;

        ViewHolder(View itemView) {
            super(itemView);

            tvReclamoEmpresa = itemView.findViewById(R.id.tv_reclamo_empresa);
            tvReclamoDescripcion = itemView.findViewById(R.id.tv_reclamo_descripcion);
            tvReclamoSolicitud = itemView.findViewById(R.id.tv_reclamo_solicitud);
            tvReclamoEstado = itemView.findViewById(R.id.tv_reclamo_estado);
            tvReclamoTipo = itemView.findViewById(R.id.tv_reclamo_tipo);
            viewEstado = itemView.findViewById(R.id.view_estado);

            itemView.setOnClickListener(v -> {
                Intent intent = new Intent(activity, ReclamoDetalleActivity.class);
                intent.putExtra("reclamo", reclamos.get(getAdapterPosition()));
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            });

        }

        void bind(ReclamoTO reclamoTO) {

            tvReclamoEmpresa.setText(reclamoTO.getReclamoEmpresa());
            tvReclamoDescripcion.setText(reclamoTO.getReclamoDescripcion());
            tvReclamoSolicitud.setText(reclamoTO.getReclamoSolicitud());
            tvReclamoEstado.setText(reclamoTO.getReclamoEstado());

            switch (reclamoTO.getReclamoEstado()) {
                case "En proceso":
                    viewEstado.setBackgroundColor(ContextCompat.getColor(activity, R.color.verde_indecopi));
                    break;
                case "Conciliado":
                    viewEstado.setBackgroundColor(ContextCompat.getColor(activity, R.color.plomo_indecopi));
                    break;
                case "Abandonado":
                    viewEstado.setBackgroundColor(ContextCompat.getColor(activity, R.color.naranja_indecopi));
                    break;
            }

            if (reclamoTO.getReclamoTipo() == 0) {
                tvReclamoTipo.setVisibility(View.GONE);
            } else {
                tvReclamoTipo.setVisibility(View.VISIBLE);
            }

        }

    }
}
