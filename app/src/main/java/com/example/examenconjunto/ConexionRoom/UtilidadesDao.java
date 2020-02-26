package com.example.examenconjunto.ConexionRoom;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UtilidadesDao {

    @Insert
    public void agregarAssistent(AssistentRoom assistent);

    @Query("SELECT * FROM asistentRoom")
    public List<AssistentRoom> mostrarUsuarios();
}
