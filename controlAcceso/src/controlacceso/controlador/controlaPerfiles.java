/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlacceso.controlador;

import controlacceso.modelo.modeloPerfiles;
//import static controlacceso.modelo.modeloPerfiles.mActualizaPerfil;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author tuxmi
 */
public class controlaPerfiles {
    public static boolean cPerfilExiste(String nombrePerfil) throws SQLException{
        
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
    
    public static int cActualizaPerfil(String perfilIdS, String perfilNombre, boolean perfilEstado) throws SQLException{
        
        
        int perfilActualizado = 0;
        Integer perfilId;
//revisa que el boton actualizar halla enviado el valor id del perfil a modificar
        if(perfilIdS.equals("")){
            System.out.println("no se ha seleccionado un perfil de la tabla o este no existe");
        }else{
//pasa String a Integer        
            perfilId = Integer.parseInt(perfilIdS);
//llama a metodo para actualizar el perfil
            perfilActualizado = modeloPerfiles.mActualizaPerfil(perfilId, perfilNombre, perfilEstado);
        }        
        return perfilActualizado;
    }
 
     
}