package com.openlab.consumidor.activity;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.openlab.consumidor.R;
import com.openlab.consumidor.entity.ReclamoTO;

public class ReclamoDetalleActivity extends AppCompatActivity {

    private ReclamoTO reclamoTO;
    private TextView tvReclamoEmpresa;
    private TextView tvReclamoDescripcion;
    private TextView tvReclamoSolicitud;
    private TextView tvReclamoEstado;
    private TextView tvReclamoTipo;
    private View viewEstado;
    private LinearLayout lyReclamoColectivo;
    private ImageView imgPrueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reclamo_detalle);
        showToolbar("Detalle del reclamo", true);

        reclamoTO = (ReclamoTO) getIntent().getExtras().getSerializable("reclamo");

        tvReclamoEmpresa = findViewById(R.id.tv_reclamo_empresa);
        tvReclamoDescripcion = findViewById(R.id.tv_reclamo_descripcion);
        tvReclamoSolicitud = findViewById(R.id.tv_reclamo_solicitud);
        tvReclamoEstado = findViewById(R.id.tv_reclamo_estado);
        tvReclamoTipo = findViewById(R.id.tv_reclamo_tipo);
        viewEstado = findViewById(R.id.view_estado);
        lyReclamoColectivo = findViewById(R.id.ly_reclamo_colectivo);
        imgPrueba = findViewById(R.id.img_prueba);

        tvReclamoEmpresa.setText(reclamoTO.getReclamoEmpresa());
        tvReclamoDescripcion.setText(reclamoTO.getReclamoDescripcion());
        tvReclamoSolicitud.setText(reclamoTO.getReclamoSolicitud());
        tvReclamoEstado.setText(reclamoTO.getReclamoEstado());

        switch (reclamoTO.getReclamoEstado()) {
            case "En proceso":
                viewEstado.setBackgroundColor(ContextCompat.getColor(this, R.color.verde_indecopi));
                break;
            case "Conciliado":
                viewEstado.setBackgroundColor(ContextCompat.getColor(this, R.color.plomo_indecopi));
                break;
            case "Abandonado":
                viewEstado.setBackgroundColor(ContextCompat.getColor(this, R.color.naranja_indecopi));
                break;
        }

        if (reclamoTO.getReclamoTipo() == 0) {
            tvReclamoTipo.setVisibility(View.GONE);
            lyReclamoColectivo.setVisibility(View.GONE);
        } else {
            tvReclamoTipo.setVisibility(View.VISIBLE);
            lyReclamoColectivo.setVisibility(View.VISIBLE);
        }

        imgPrueba.setOnClickListener(v -> {
            Intent intent = new Intent(this, PruebaActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_down);
        });

    }

    public void showToolbar(String title, boolean upButton) {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
