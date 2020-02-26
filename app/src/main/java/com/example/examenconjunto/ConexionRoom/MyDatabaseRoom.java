package com.example.examenconjunto.ConexionRoom;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {AssistentRoom.class}, version = 1, exportSchema = false)
public abstract class MyDatabaseRoom extends RoomDatabase {

    public abstract UtilidadesDao utilidadesDao();

}