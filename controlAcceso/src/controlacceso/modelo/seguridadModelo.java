/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlacceso.modelo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import controlacceso.controlador.controlaIngreso;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author Dell
 */
public class seguridadModelo {
    public static boolean consultaUsuario(String user, String pass)throws SQLException{
        Connection conexion;
                
        conexion = conecta.conexion();
        
        Statement s = (Statement) conexion.createStatement();
        ResultSet resultadoBD = s.executeQuery("select * from tbl_usuarios where usuarios_nombre = '" + user + "'");
    
        boolean concedeAcceso = controlaIngreso.comparaLogin(resultadoBD, user, pass);
        
        conexion.close();
        System.out.println("conexion cerrada");
        
        return concedeAcceso;        
        
    }
    
}
