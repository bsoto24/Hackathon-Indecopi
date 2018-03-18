package com.openlab.consumidor.maps;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterManager;
import com.openlab.consumidor.R;
import com.openlab.consumidor.entity.ReclamoTO;

import java.util.ArrayList;
import java.util.List;

public class EventView extends Fragment implements Event.View, OnMapReadyCallback, ClusterManager.OnClusterClickListener<ReclamoTO>, ClusterManager.OnClusterItemClickListener<ReclamoTO> {

    private Event.Presenter presenter;
    private GoogleMap mMap;
    private MapView mMapView;
    private LatLng defaultPosition;

    private ClusterManager mClusterManager;

    public static EventView newInstance() {
        return new EventView();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_map, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MapsInitializer.initialize(getActivity());

        mMapView = view.findViewById(R.id.map);
        mMapView.onCreate(savedInstanceState);
        mMapView.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        defaultPosition = new LatLng(-12.0858177, -77.0099917);

        mMap.clear();

        if (Build.VERSION.SDK_INT >= 23) {
            mMap.moveCamera(CameraUpdateFactory.newLatLng(defaultPosition));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(14));
        }

        presenter = new EventPresenter(this);
        presenter.findAllReclamos();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        mMapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mMapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mMap == null) {
            mMapView.onResume();
        }
        mMapView.onResume();
    }

    private void setUpMapIfNeeded() {
        if (mMap == null) {
            ((SupportMapFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.map)).getMapAsync(this);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public GoogleMap getMap() {
        setUpMapIfNeeded();
        return mMap;
    }

    @Override
    public boolean onClusterClick(Cluster<ReclamoTO> cluster) {
        double minLatitud = 0;
        double minLongitud = 0;
        double maxLatitud = 0;
        double maxLongitud = 0;

        for (ReclamoTO e : cluster.getItems()) {
            double lat = e.getPosition().latitude;
            double lng = e.getPosition().longitude;
            if (minLatitud == 0 & minLongitud == 0 & maxLatitud == 0 & maxLongitud == 0) {
                minLatitud = maxLatitud = lat;
                minLongitud = maxLongitud = lng;
            }
            if (lat > maxLatitud) {
                maxLatitud = lat;
            }
            if (lng > maxLongitud) {
                maxLongitud = lng;
            }
            if (lat < minLatitud) {
                minLatitud = lat;
            }
            if (lng < minLongitud) {
                minLongitud = lng;
            }
        }

        LatLng sw = new LatLng(minLatitud, minLongitud);
        LatLng ne = new LatLng(maxLatitud, maxLongitud);
        LatLngBounds bounds = new LatLngBounds(sw, ne);

        mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 50));
        if (mMap.getCameraPosition().zoom == mMap.getMaxZoomLevel()) {
            ArrayList<ReclamoTO> eventTOS = (ArrayList<ReclamoTO>) cluster.getItems();
            Toast.makeText(getContext(), eventTOS.get(0).getReclamoEmpresa(), Toast.LENGTH_SHORT).show();
        }

        return true;
    }

    @Override
    public boolean onClusterItemClick(ReclamoTO reclamoTO) {
        BottomSheetDialogFragment bsdFragment = BSDialogMapa.newInstance();
        bsdFragment.show(getActivity().getSupportFragmentManager(), "BSDialog");
        return false;
    }

    @Override
    public void showMarkers(List<ReclamoTO> reclamos) {

        mClusterManager = new ClusterManager<>(getContext(), mMap);
        mClusterManager.setRenderer(new MarkerRenderer(getContext(), this, mMap, mClusterManager));
        mMap.setOnCameraChangeListener(mClusterManager);
        mMap.setOnMarkerClickListener(mClusterManager);
        mMap.setOnInfoWindowClickListener(mClusterManager);
        mClusterManager.setOnClusterClickListener(this);
        mClusterManager.setOnClusterItemClickListener(this);
        mClusterManager.addItems(reclamos);
        mClusterManager.cluster();

    }

}
