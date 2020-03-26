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
     
        con = conecta.conexion();
        
        String isql = "INSERT INTO tbl_perfiles (perfiles_nombre, perfiles_estado) VALUES (?,?)";

        PreparedStatement pst = (PreparedStatement) con.prepareStatement(isql);
        pst.setString(1, nombrePerfil);
        pst.setBoolean(2, estadoPerfil);
        
        int resultado;
        resultado = pst.executeUpdate();
        cierraSesion();
        
        return resultado;
    }
    
    public static ResultSet mConsultaPerfiles(String cPerfil) throws SQLException{
        
        con = conecta.conexion();
        
        Statement stmt = (Statement) con.createStatement();
//        System.out.println("Select * from tbl_perfiles " + cPerfil + "");
        ResultSet resultadoPerfiles = stmt.executeQuery("Select * from tbl_perfiles " + cPerfil +"");
        return resultadoPerfiles;
        
    }
    
    public static int mActualizaPerfil(Integer perfilId, String perfilNombre, boolean perfilEstado) throws SQLException{

        con = conecta.conexion();
        int respuesta;
        String usql = "UPDATE tbl_perfiles SET perfiles_nombre = ?, perfiles_estado = ? WHERE id_perfiles = ?";
        
        PreparedStatement pst = (PreparedStatement) con.prepareStatement(usql);
        pst.setString(1, perfilNombre);
        pst.setBoolean(2, perfilEstado);
        pst.setInt(3, perfilId);
        
        respuesta = pst.executeUpdate();
        cierraSesion();
        
        return respuesta;
        
    }
    
    public static void cierraSesion() throws SQLException{
        con.close();
        System.out.println("Conexion cerrada Perfiles");
    }
    
    
}
