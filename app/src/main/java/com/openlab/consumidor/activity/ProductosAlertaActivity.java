package com.openlab.consumidor.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.openlab.consumidor.R;
import com.openlab.consumidor.adapter.AlertaAdapter;
import com.openlab.consumidor.entity.AlertaTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bryam Soto on 18/03/2018.
 */

public class ProductosAlertaActivity extends AppCompatActivity {

    private RecyclerView rvProductosAlerta;
    private List<AlertaTO> alertas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos_alerta);

        showToolbar("Productos en alerta", true);

        rvProductosAlerta = findViewById(R.id.rv_productos_alerta);
        rvProductosAlerta.setLayoutManager(new GridLayoutManager(this, 2));

        alertas = new ArrayList<>();
        alertas.add(new AlertaTO("Multiprotector Perfect Block Kids", "Podrían producir una irritación dérmica leve o temporal", R.drawable.producto1, 1));
        alertas.add(new AlertaTO("Teteras eléctricas KitchenAid", "Posible falla en el mango", R.drawable.producto2, 0));
        alertas.add(new AlertaTO("Autos Lexus (LC500, GS-F y RC-F)", "Presentarían falla en amortiguador de pulsaciones de bomba de combustible", R.drawable.producto3, 0));
        alertas.add(new AlertaTO("Autos Mercedes-Benz (ML 400 4MATIC y GLE 400 4MATIC)", "Presentarían falla en parabrisas delantero", R.drawable.producto4, 0));
        alertas.add(new AlertaTO("Autos Dodge, Jeep y Chrysler", "Presentan posible falla en el alternador", R.drawable.producto5, 1));
        alertas.add(new AlertaTO("Bicicletas Trek", "Corren el riesgo de que la rueda delantera pueda separarse o frenar repentinamente", R.drawable.producto6, 0));

        rvProductosAlerta.setAdapter(new AlertaAdapter(this, alertas));

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

