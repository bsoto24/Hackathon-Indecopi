package com.openlab.consumidor.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.openlab.consumidor.adapter.MisReclamosAdapter;
import com.openlab.consumidor.R;
import com.openlab.consumidor.entity.ReclamoTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bryam Soto on 18/03/2018.
 */

public class MisReclamosActivity extends AppCompatActivity {

    private RecyclerView rvMisReclamos;
    private List<ReclamoTO> reclamos;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_reclamos);
        showToolbar("Mis Reclamos", true);

        rvMisReclamos = findViewById(R.id.rv_mis_reclamos);

        reclamos = new ArrayList<>();
        reclamos.add(new ReclamoTO("Cineplex S.A.", "El día 24/04/18 tuve un problema con la empresa Cineplanet, su personal evito que entre con mis alimentos, negandome el derecho de ingresar a la sala pese a que tenía mi entrada.", "Solicito a la empresa el reembolso total de mi entrada y las disculpas públicas correspondientes.", "En proceso", 1));
        reclamos.add(new ReclamoTO("Banco Internacional del Perú S.A.A", "El día 24/04/18 tuve un problema con la empresa Cineplanet, su personal evito que entre con mis alimentos, negandome el derecho de ingresar a la sala pese a que tenía mi entrada.", "Solicito a la empresa el reembolso total de mi entrada y las disculpas públicas correspondientes.", "Conciliado", 0));
        reclamos.add(new ReclamoTO("Inmortal Producciones S.A.C", "El día 24/04/18 tuve un problema con la empresa Cineplanet, su personal evito que entre con mis alimentos, negandome el derecho de ingresar a la sala pese a que tenía mi entrada.", "Solicito a la empresa el reembolso total de mi entrada y las disculpas públicas correspondientes.", "Abandonado", 0));

        rvMisReclamos.setLayoutManager(new LinearLayoutManager(this));
        rvMisReclamos.setAdapter(new MisReclamosAdapter(reclamos, this));

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
