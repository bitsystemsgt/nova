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
import java.sql.ResultSetMetaData;

import java.sql.SQLException;

/**
 *
 * @author tuxmi
 */
public class modeloPerfiles {
    
    public static int insertaPerfiles(String nombrePerfil, boolean estadoPerfil) throws SQLException{
     
        Connection con;
        String isql = "INSERT INTO tbl_perfiles (perfiles_nombre, perfiles_estado) VALUES (?,?)";
        con = conecta.conexion();
//        Statement stmt = (Statement) conexion.prepareStatement("insert into tbl_perfiles perfiles_nombre, perfiles_estado values (" +nombrePerfil+","+estadoPerfil +")");
        PreparedStatement pst = (PreparedStatement) con.prepareStatement(isql);
        pst.setString(1, nombrePerfil);
        pst.setBoolean(2, estadoPerfil);
        
        int resultado;
        resultado = pst.executeUpdate();
        con.close();
        System.out.println("registro guardado " + resultado);
        return resultado;
    }
    
    public static void mConsultaPerfiles() throws SQLException{
        Connection con;
        con = conecta.conexion();
        
        Statement stmt = (Statement) con.createStatement();
        ResultSet resultadoPerfiles = stmt.executeQuery("Select * from tbl_perfiles where 1");
        ResultSetMetaData rsmd = resultadoPerfiles.getMetaData();
            
        int cantReg = 0;
        if(resultadoPerfiles.last()){
            cantReg = resultadoPerfiles.getRow();
            resultadoPerfiles.beforeFirst();
        }
                        
               
        System.out.println("el numero de registros es " + cantReg);
    
        
    }
    
    
}
