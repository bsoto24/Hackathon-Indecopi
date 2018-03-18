package com.openlab.consumidor.entity;

/**
 * Created by Bryam Soto on 18/03/2018.
 */

public class AlertaTO {

    private String alertaProductoDescripcion;
    private String alertaDescripcion;
    private int alertaProductoImagen;
    private int alertaTipo;

    public AlertaTO(String alertaProductoDescripcion, String alertaDescripcion, int alertaProductoImagen, int alertaTipo) {
        this.alertaProductoDescripcion = alertaProductoDescripcion;
        this.alertaDescripcion = alertaDescripcion;
        this.alertaProductoImagen = alertaProductoImagen;
        this.alertaTipo = alertaTipo;
    }

    public String getAlertaProductoDescripcion() {
        return alertaProductoDescripcion;
    }

    public void setAlertaProductoDescripcion(String alertaProductoDescripcion) {
        this.alertaProductoDescripcion = alertaProductoDescripcion;
    }

    public String getAlertaDescripcion() {
        return alertaDescripcion;
    }

    public void setAlertaDescripcion(String alertaDescripcion) {
        this.alertaDescripcion = alertaDescripcion;
    }

    public int getAlertaProductoImagen() {
        return alertaProductoImagen;
    }

    public void setAlertaProductoImagen(int alertaProductoImagen) {
        this.alertaProductoImagen = alertaProductoImagen;
    }

    public int getAlertaTipo() {
        return alertaTipo;
    }

    public void setAlertaTipo(int alertaTipo) {
        this.alertaTipo = alertaTipo;
    }
}
