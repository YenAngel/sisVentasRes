package ventas.modelo;

import javax.crypto.*;
import java.security.*;
import java.io.*;
import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.*;



public class Cripto {
      String comfirmar = "";
    /** Creates a new instance of Encriptar */
    public void encriptar(String clave, String ruta) {
          try  {
     Map map = new TreeMap(System.getProperties()); 
     int number = map.size(); 
     File desFile = new File(ruta);
     FileInputStream fis;
     FileOutputStream fos;
     CipherInputStream cis;
     // Creaciòn de llave sercreta
     int longitud = clave.length();
    byte key[] = clave.getBytes();
    SecretKeySpec secretKey = new SecretKeySpec(key,"DES");
     // Creacion de objetos de cifrado
    Cipher encrypt = Cipher.getInstance("DES/ECB/PKCS5Padding");
    encrypt.init(Cipher.ENCRYPT_MODE, secretKey);
     // abriendo el  archivo Plaintext
     // Escribiendo el archivo encriptado
      fos = new FileOutputStream(desFile); 
      BufferedOutputStream bos = new BufferedOutputStream(fos); 
      CipherOutputStream cos = new CipherOutputStream(bos, encrypt); 
      ObjectOutputStream oos = new ObjectOutputStream(cos); 
 
      // Write objects 
      oos.writeObject(map); 
      oos.writeInt(number); 
      oos.flush(); 
     comfirmar = " <--- Archivo Encriptado\n";
     } catch(Exception e){
         comfirmar = " <--- No se pudo encriptar, error: \""+e+"\"\n";
     }
    }
    
}

