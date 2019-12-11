package com.example.examen_unidadii_estrella;

public class Usuario {


    String nombre_usuario;
    String dni_usuario;
    String fecha_nacimiento_usuario;
    String domicilio_usuario;
    String celular_usuario;
    String email_usuario;
    String contrasena_usuario;


    public Usuario() {
    }

    public Usuario(String nombre_usuario, String dni_usuario, String fecha_nacimiento_usuario, String domicilio_usuario, String celular_usuario, String email_usuario, String contrasena_usuario) {
        this.nombre_usuario = nombre_usuario;
        this.dni_usuario = dni_usuario;
        this.fecha_nacimiento_usuario = fecha_nacimiento_usuario;
        this.domicilio_usuario = domicilio_usuario;
        this.celular_usuario = celular_usuario;
        this.email_usuario = email_usuario;
        this.contrasena_usuario = contrasena_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getDni_usuario() {
        return dni_usuario;
    }

    public void setDni_usuario(String dni_usuario) {
        this.dni_usuario = dni_usuario;
    }

    public String getFecha_nacimiento_usuario() {
        return fecha_nacimiento_usuario;
    }

    public void setFecha_nacimiento_usuario(String fecha_nacimiento_usuario) {
        this.fecha_nacimiento_usuario = fecha_nacimiento_usuario;
    }

    public String getDomicilio_usuario() {
        return domicilio_usuario;
    }

    public void setDomicilio_usuario(String domicilio_usuario) {
        this.domicilio_usuario = domicilio_usuario;
    }

    public String getCelular_usuario() {
        return celular_usuario;
    }

    public void setCelular_usuario(String celular_usuario) {
        this.celular_usuario = celular_usuario;
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public String getContrasena_usuario() {
        return contrasena_usuario;
    }

    public void setContrasena_usuario(String contrasena_usuario) {
        this.contrasena_usuario = contrasena_usuario;
    }
}
