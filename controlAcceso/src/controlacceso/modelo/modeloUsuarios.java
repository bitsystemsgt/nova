/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlacceso.modelo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Dell
 */
public class modeloUsuarios {
    
    static Connection con;
    
    public static boolean mInsertaUsuario(String nombreUsuario, String passUsuario, boolean estadoUsuario, int idPerfil) throws SQLException{
        con = conecta.conexion();
        String isql = "INSERT INTO tbl_usuarios (usuarios_nombre, usuarios_contrasena, usuarios_estado, fk_idperfiles) values (?, ?, ?, ?); ";
        
        PreparedStatement pst = (PreparedStatement) con.prepareStatement(isql);
        pst.setString(1, nombreUsuario);
        pst.setString(2, passUsuario);
        pst.setBoolean(3, estadoUsuario);
        pst.setInt(4, idPerfil);
        
        int resultado = pst.executeUpdate();
        cierraSesion();
        
        return false;   
    }
    
    public static void cierraSesion() throws SQLException{
        con.close();
        System.out.println("Conexion cerrada Usuarios");
    }
    
}
