package com.example.examen_unidadii_estrella;
import java.util.Comparator;

public class Producto {

    String idprod;
    String nombreprod;
    String imagenprod;
    String descripcionprod;

    public Producto() {
    }

    public Producto(String idprod, String nombreprod, String imagenprod, String descripcionprod) {
        this.idprod = idprod;
        this.nombreprod = nombreprod;
        this.imagenprod = imagenprod;
        this.descripcionprod = descripcionprod;
    }

    public String getIdprod() {
        return idprod;
    }

    public void setIdprod(String idprod) {
        this.idprod = idprod;
    }

    public String getNombreprod() {
        return nombreprod;
    }

    public void setNombreprod(String nombreprod) {
        this.nombreprod = nombreprod;
    }

    public String getImagenprod() {
        return imagenprod;
    }

    public void setImagenprod(String imagenprod) {
        this.imagenprod = imagenprod;
    }

    public String getDescripcionprod() {
        return descripcionprod;
    }

    public void setDescripcionprod(String descripcionprod) {
        this.descripcionprod = descripcionprod;
    }
}
