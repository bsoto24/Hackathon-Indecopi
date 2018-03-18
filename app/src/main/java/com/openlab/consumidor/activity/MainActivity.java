package com.openlab.consumidor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.openlab.consumidor.adapter.MisReclamosAdapter;
import com.openlab.consumidor.R;
import com.openlab.consumidor.entity.ReclamoTO;
import com.openlab.consumidor.maps.EventActivity;
import com.synnapps.carouselview.CarouselView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView rvReclamos;
    private List<ReclamoTO> reclamos;

    private CarouselView carousel;
    private int[] images = {R.drawable.noticia_1, R.drawable.noticia_2, R.drawable.noticia_3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        carousel = findViewById(R.id.carouselView);
        carousel.setPageCount(images.length);
        carousel.setImageListener((position, imageView) -> imageView.setImageResource(images[position]));

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        rvReclamos = findViewById(R.id.rv_mis_reclamos);

        reclamos = new ArrayList<>();
        reclamos.add(new ReclamoTO("Cineplex S.A.", "El día 24/04/18 tuve un problema con la empresa Cineplanet, su personal evito que entre con mi pollito a la brasa, negandome el derecho de ingresar a la sala pese a que tenía mi entrada.", "Solicito a la empresa el reembolso total de mi entrada y las disculpas públicas correspondientes.", "En proceso", 1));
        reclamos.add(new ReclamoTO("Banco Internacional del Perú S.A.A", "El día 24/04/18 tuve un problema con la empresa Cineplanet, su personal evito que entre con mi pollito a la brasa, negandome el derecho de ingresar a la sala pese a que tenía mi entrada.", "Solicito a la empresa el reembolso total de mi entrada y las disculpas públicas correspondientes.", "Conciliado", 1));
        reclamos.add(new ReclamoTO("Inmortal Producciones S.A.C", "El día 24/04/18 tuve un problema con la empresa Cineplanet, su personal evito que entre con mi pollito a la brasa, negandome el derecho de ingresar a la sala pese a que tenía mi entrada.", "Solicito a la empresa el reembolso total de mi entrada y las disculpas públicas correspondientes.", "Abandonado", 1));

        rvReclamos.setLayoutManager(new LinearLayoutManager(this));
        rvReclamos.setAdapter(new MisReclamosAdapter(reclamos, this));

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_presenta_reclamo) {
            Intent intent = new Intent(this, PresentaReclamoActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        } else if (id == R.id.nav_mis_reclamos) {
            Intent intent = new Intent(this, MisReclamosActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        } else if (id == R.id.nav_productos_peligrosos) {
            Intent intent = new Intent(this, ProductosAlertaActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        } else if (id == R.id.nav_sedes_oficinas) {
            Intent intent = new Intent(this, EventActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        } else if (id == R.id.nav_acerca_de) {

        } else if (id == R.id.nav_cerrar_sesion) {
            finish();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}