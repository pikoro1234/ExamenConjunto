package com.example.examenconjunto.ConexionPSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionPsql {

    public static Connection conectar(){

        Connection conect = null;

        try {

            Class.forName("org.postgresql.Driver");

            conect = DriverManager.getConnection("jdbc:postgresql://192.168.0.22:5432/evelyn","evelyn","berezin");
            //conect = DriverManager.getConnection("jdbc:postgresql://192.168.0.85:5432/postgres","postgres","admin@123");

           /* statement.executeUpdate("insert into userspostsql(userNick,nombre,apellidos,correo,contrasenha,repcontrasenha,rolUsuario) \n" +
                    "            values ('NickPruebaSerio2','jorgePruebaSerio','apellidoPruebaSerio','correoPruebaSerio@gma.com','1234','1234',0);");*/

            System.out.println("ENTRAMOS AL TRY");

        }catch (SQLException e) {

            System.out.println("ERROR UNO AL CONECTARO CON BD\n"+e);

        }catch (ClassNotFoundException e) {

            System.out.println("error dos ");
        }

        return conect;
    }
}

