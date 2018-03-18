package com.openlab.consumidor.entity;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

import java.io.Serializable;

/**
 * Created by Bryam Soto on 18/03/2018.
 */

public class ReclamoTO implements Serializable, ClusterItem {

    private String reclamoEmpresa;
    private String reclamoDescripcion;
    private String reclamoSolicitud;
    private String reclamoEstado;
    private int reclamoTipo;
    private double latitud;
    private double longitud;


    public ReclamoTO(String reclamoEmpresa, String reclamoDescripcion, String reclamoSolicitud, String reclamoEstado, int tipoReclamo) {
        this.reclamoEmpresa = reclamoEmpresa;
        this.reclamoDescripcion = reclamoDescripcion;
        this.reclamoSolicitud = reclamoSolicitud;
        this.reclamoEstado = reclamoEstado;
        this.reclamoTipo = tipoReclamo;
    }

    public ReclamoTO(String reclamoEmpresa, double latitud, double longitud) {
        this.reclamoEmpresa = reclamoEmpresa;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getReclamoDescripcion() {
        return reclamoDescripcion;
    }

    public void setReclamoDescripcion(String reclamoDescripcion) {
        this.reclamoDescripcion = reclamoDescripcion;
    }

    public String getReclamoSolicitud() {
        return reclamoSolicitud;
    }

    public void setReclamoSolicitud(String reclamoSolicitud) {
        this.reclamoSolicitud = reclamoSolicitud;
    }

    public String getReclamoEmpresa() {
        return reclamoEmpresa;
    }

    public void setReclamoEmpresa(String reclamoEmpresa) {
        this.reclamoEmpresa = reclamoEmpresa;
    }

    public String getReclamoEstado() {
        return reclamoEstado;
    }

    public void setReclamoEstado(String reclamoEstado) {
        this.reclamoEstado = reclamoEstado;
    }

    public int getReclamoTipo() {
        return reclamoTipo;
    }

    public void setReclamoTipo(int reclamoTipo) {
        this.reclamoTipo = reclamoTipo;
    }

    @Override
    public LatLng getPosition() {
        return new LatLng(latitud, longitud);
    }
}
