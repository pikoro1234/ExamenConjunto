package com.example.examenconjunto.ConexionRoom;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface UtilidadesDao {

    @Insert
    public void agregarAssistent(AssistentRoom assistent);
}
