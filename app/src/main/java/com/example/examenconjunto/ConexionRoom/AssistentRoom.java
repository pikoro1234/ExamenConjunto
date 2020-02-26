package com.example.examenconjunto.ConexionRoom;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "asistentRoom")

public class AssistentRoom {

    @PrimaryKey (autoGenerate = true)
    private int id;

    @ColumnInfo(name = "nombre")
    private String nombreAsistente;

    @ColumnInfo(name = "apellidos")
    private  String apellido;

    @ColumnInfo(name = "correo")
    private  String correo;

    @ColumnInfo(name = "telefono")
    private  String telefono;

    @ColumnInfo(name = "edad")
    private  int edad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreAsistente() {
        return nombreAsistente;
    }

    public void setNombreAsistente(String nombreAsistente) {
        this.nombreAsistente = nombreAsistente;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
