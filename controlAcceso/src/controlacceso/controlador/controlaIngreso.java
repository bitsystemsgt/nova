/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlacceso.controlador;

import java.sql.ResultSet;
import controlacceso.modelo.seguridadModelo;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author Dell
 */
public class controlaIngreso {
    public static boolean controladorLogin(String user, String pass) throws SQLException{

        boolean concedeAcceso;
        
        concedeAcceso  = seguridadModelo.consultaUsuario(user, pass);
//        concedeAcceso = comparaLogin(consultaBD, user, pass);
        return concedeAcceso;
        
            
    }
    
    public static boolean comparaLogin(ResultSet consultaBD, String user, String pass) throws SQLException{
        String usuario="", contrasena="", estado = null;
        while(consultaBD.next()){
            usuario = consultaBD.getString("usuarios_nombre");
            contrasena = consultaBD.getString("usuarios_contrasena");
            estado = consultaBD.getString("usuarios_estado");
        }
            
            if(usuario.equals(user) && contrasena.equals(pass)){
                if(estado.equals("1")){
                    return true;
                } else {
                    System.out.println("el usuario se encuentra deshabilitado");
                    return false;
            }
            }else{
                System.out.println("el usuario y/o contraseña no coinciden");
                return false;
            }
  
        
    }
    
}
