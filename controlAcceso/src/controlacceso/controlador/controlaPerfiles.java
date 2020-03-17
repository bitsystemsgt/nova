/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlacceso.controlador;

import controlacceso.modelo.modeloPerfiles;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author tuxmi
 */
public class controlaPerfiles {
    public static boolean cPerfilExisgte(String nombrePerfil) throws SQLException{
        
        boolean perfilExiste;
        String cPerfil, perfilBD ="";        
        ResultSet perfil;
        
        cPerfil = "where perfiles_nombre = '" + nombrePerfil + "'";
        perfil = modeloPerfiles.mConsultaPerfiles(cPerfil);
        
        
        while(perfil.next()){
            perfilBD = perfil.getString(2);
        }
//es verdadero si son iguales es falso si son distintas        
        perfilExiste = nombrePerfil.equals(perfilBD);
        
        System.out.println("perfil existe: " + perfilExiste);
        modeloPerfiles.cierraSesion();
        
        return perfilExiste;
    }
 
     
}