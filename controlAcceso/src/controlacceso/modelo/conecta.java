/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlacceso.modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Dell
 */
public class conecta {
    
    static  Connection con;
    
    public static  Connection conexion() throws SQLException{
        //declaracion de variables de conexion   
            String driver = "com.mysql.jdbc.Driver";
            String user = "bits";
//            String pass = "Phanter5919";
            String pass = "Coffee5919";
//            String url = "jdbc:mysql://localhost:3306/bd_controlacceso";
            String url = "jdbc:mysql://sigma.bitsystems.sytes.net:3306/bd_controlacceso";
       
        try {
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, user, pass);
//            Class.forName("com.mysql.jdbc.Driver");
//            con = (Connection) DriverManager.getConnection("jdbc:mysql//localhost:3306/bd_controlacceso","root","Phanter5919");
        if (con!=null){
                System.out.println("Conexion establecida");
                return con;
        }
        }
        catch (ClassNotFoundException | SQLException e){
            System.out.println("Error de conexion" + e);
            
        }
        return con;
    }
}
