/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlacceso.modelo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author tuxmi
 */
public class modeloPerfiles {
    
    static Connection con;
    
    public static int insertaPerfiles(String nombrePerfil, boolean estadoPerfil) throws SQLException{
     
//        Connection con;
        String isql = "INSERT INTO tbl_perfiles (perfiles_nombre, perfiles_estado) VALUES (?,?)";
        con = conecta.conexion();
//        Statement stmt = (Statement) conexion.prepareStatement("insert into tbl_perfiles perfiles_nombre, perfiles_estado values (" +nombrePerfil+","+estadoPerfil +")");
        PreparedStatement pst = (PreparedStatement) con.prepareStatement(isql);
        pst.setString(1, nombrePerfil);
        pst.setBoolean(2, estadoPerfil);
        
        int resultado;
        resultado = pst.executeUpdate();
        cierraSesion();
        System.out.println("registro guardado " + resultado);
        return resultado;
    }
    
    public ResultSet mConsultaPerfiles() throws SQLException{
        
        con = conecta.conexion();
        
        Statement stmt = (Statement) con.createStatement();
        ResultSet resultadoPerfiles = stmt.executeQuery("Select * from tbl_perfiles where 1");
        return resultadoPerfiles;
        
    }
    
    public static void cierraSesion() throws SQLException{
        con.close();
        System.out.println("Conexion cerrada");
    }
    
    
}
