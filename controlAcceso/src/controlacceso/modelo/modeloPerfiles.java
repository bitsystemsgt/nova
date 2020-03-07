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
 * @author tuxmi
 */
public class modeloPerfiles {
    public static int insertaPerfiles(String nombrePerfil, boolean estadoPerfil) throws SQLException{
     
        Connection conexion;
        String isql = "INSERT INTO tbl_perfiles (perfiles_nombre, perfiles_estado) VALUES (?,?)";
        conexion = conecta.conexion();
//        Statement stmt = (Statement) conexion.prepareStatement("insert into tbl_perfiles perfiles_nombre, perfiles_estado values (" +nombrePerfil+","+estadoPerfil +")");
        PreparedStatement pst = (PreparedStatement) conexion.prepareStatement(isql);
        pst.setString(1, nombrePerfil);
        pst.setBoolean(2, estadoPerfil);
        
        int resultado;
        resultado = pst.executeUpdate();
        conexion.close();
        System.out.println("registro guardado " + resultado);
        return resultado;
    }
    
    
}
