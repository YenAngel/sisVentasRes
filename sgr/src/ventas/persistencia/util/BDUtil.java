
package ventas.persistencia.util;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BDUtil {    
    private static String driver="com.mysql.jdbc.Driver";
    private static String url="jdbc:mysql://107.180.46.230:3306/srg_ventas?zeroDateTimeBehavior=convertToNull";
    private static Connection cnn;  
    
    public static boolean conectar(){
        try {
            Class.forName(driver);
            try {
                cnn = (Connection) DriverManager.getConnection(url,"pruebabd","lasfijas123");  
                System.out.println("Conectado");
                System.out.println(setTimeout());
                return true;
            } catch (Exception e) {
                System.err.println("Error al conectar a la Base de Datos " + e.getMessage());
                return false;
            }
        } catch (Exception ex) {
            System.err.println("Error al cargar el Driver " + ex.getMessage());
            return false;
        }        
    }
    
    public static boolean desconectar(){        
        try{
            if (cnn!=null){
                if(cnn.isClosed()== false){
                    return true;
                }
            }                    
        }catch (SQLException ex){
            System.err.println("Error al desconectar de la base de datos: " + ex.getMessage());
            return false;
        }
        return false;
    }        
    public static boolean setTimeout(){
        try {
            String sql = "SET SESSION wait_timeout = 28800";
            PreparedStatement ps = getCnn().prepareStatement(sql);
            ps.executeQuery();
            return true;
        } catch (SQLException e) {
            return false;
        }
        
    }
    public static String getDriver() {
        return driver;
    }

    public static void setDriver(String driver) {
        BDUtil.driver = driver;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        BDUtil.url = url;
    }

    public static Connection getCnn() {
        return cnn;
    }

    public static void setCnn(Connection cnn) {
        BDUtil.cnn = cnn;
    }
    
            
}
