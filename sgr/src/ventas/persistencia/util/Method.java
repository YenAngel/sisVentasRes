/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.persistencia.util;

/**
 *
 * @author AnibalMA
 */
public class Method {
    
    public static boolean Caracter(String value){
        if(value.length() > 0){
            for(int i = 0; i < value.length(); i++){
                if((!Character.isAlphabetic(value.charAt(i))) && value.charAt(i) != ' ')
                    return false;
            }
        }
        return true;
    }
}
