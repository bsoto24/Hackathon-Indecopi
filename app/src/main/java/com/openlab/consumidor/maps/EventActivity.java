package com.openlab.consumidor.maps;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.Button;

import com.openlab.consumidor.R;
import com.openlab.consumidor.util.ActivityUtils;

/**
 * Created by Bryam Soto on 24/11/2017.
 */

public class EventActivity extends AppCompatActivity {

    private Button btnSedes, btnEstadisticas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        showToolbar("Sedes y estadisticas", true);

        btnEstadisticas = findViewById(R.id.btn_estadisticas);
        btnSedes = findViewById(R.id.btn_sedes);

        btnEstadisticas.setOnClickListener(v -> {
            SpannableString estadisticas = new SpannableString("Estadísticas");
            estadisticas.setSpan(new UnderlineSpan(), 0, estadisticas.length(), 0);
            btnEstadisticas.setText(estadisticas);
            btnSedes.setText("Sedes");
        });

        btnSedes.setOnClickListener(v -> {
            SpannableString sedes = new SpannableString("Sedes");
            sedes.setSpan(new UnderlineSpan(), 0, sedes.length(), 0);
            btnSedes.setText(sedes);
            btnEstadisticas.setText("Estadísticas");
        });


        EventView eventView = (EventView) getSupportFragmentManager().findFragmentById(R.id.body_events);
        if (eventView == null) {
            eventView = EventView.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), eventView, R.id.body_events);
        }

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