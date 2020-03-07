/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlacceso.controlador;

import controlacceso.modelo.modeloPerfiles;
import java.sql.SQLException;

/**
 *
 * @author tuxmi
 */
public class controlaPerfiles {
    
    public static int cIngresaPerfiles(String nombrePerfil, boolean estadoPerfil) throws SQLException{
        int estadoInsert;
        estadoInsert = modeloPerfiles.insertaPerfiles(nombrePerfil, estadoPerfil);
        return estadoInsert;
    }
    
}
