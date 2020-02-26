package com.example.examenconjunto.Adaptadores;

public class RegistroEvent {

    private String nombreevent,fechaevent,lugarevent,organizador,sala,descripcion;
    private int precio,aforo;

    public RegistroEvent() {
    }

    public RegistroEvent(String nombreevent, String fechaevent, String lugarevent, String organizador, String sala, String descripcion, int precio, int aforo) {
        this.nombreevent = nombreevent;
        this.fechaevent = fechaevent;
        this.lugarevent = lugarevent;
        this.organizador = organizador;
        this.sala = sala;
        this.descripcion = descripcion;
        this.precio = precio;
        this.aforo = aforo;
    }

    public String getNombreevent() {
        return nombreevent;
    }

    public void setNombreevent(String nombreevent) {
        this.nombreevent = nombreevent;
    }

    public String getFechaevent() {
        return fechaevent;
    }

    public void setFechaevent(String fechaevent) {
        this.fechaevent = fechaevent;
    }

    public String getLugarevent() {
        return lugarevent;
    }

    public void setLugarevent(String lugarevent) {
        this.lugarevent = lugarevent;
    }

    public String getOrganizador() {
        return organizador;
    }

    public void setOrganizador(String organizador) {
        this.organizador = organizador;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }
}
