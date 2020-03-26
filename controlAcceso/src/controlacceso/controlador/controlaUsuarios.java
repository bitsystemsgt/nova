/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlacceso.controlador;

import controlacceso.modelo.modeloUsuarios;
import java.sql.SQLException;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Dell
 */
public class controlaUsuarios {
    
    public static void cIngresaUsuario(String nombreUsuario, String passUsuario, boolean estadoUsuario, int idPerfil) throws SQLException{
    boolean estadoInsert;    
//llama a encripta
    passUsuario = cEncriptaPass(passUsuario);
        
//llama al modelo ingresaUsuario        
//    estadoInsert = modeloUsuarios.mInsertaUsuario(nombreUsuario, passUsuario, estadoUsuario, idPerfil);
        
        System.out.println(nombreUsuario);
        System.out.println(passUsuario);
        System.out.println(estadoUsuario);
        System.out.println(idPerfil);
        System.out.println("ancho pass: " + passUsuario.length());
    }
    public static String cEncriptaPass(String pass){
        return DigestUtils.sha3_512Hex(pass);        
    }
    
}
