package com.example.examenconjunto.ConexionRoom;

import com.example.examenconjunto.Interfaces.Assistent;

public class MetodosRoom {

    public void insertarAssistentRoom(String nombre,String apellidos,String email,String telefono,int edad){

        AssistentRoom assistentRoom = new AssistentRoom();

        assistentRoom.setNombreAsistente(nombre);

        assistentRoom.setApellido(apellidos);

        assistentRoom.setCorreo(email);

        assistentRoom.setTelefono(telefono);

        assistentRoom.setEdad(edad);

        Assistent.myDatabaseRoom.utilidadesDao().agregarAssistent(assistentRoom);

    }
}
