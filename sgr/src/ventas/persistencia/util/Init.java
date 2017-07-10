
package ventas.persistencia.util;

import java.io.File;
import ventas.modelo.Area;
import ventas.presentacion.Login;
import ventas.presentacion.Splash;
import ventas.presentacion.frmPrincipal;

public class Init {
    public static void main(String[] args) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if (BDUtil.conectar()) {
                    System.out.println("App Corriendo");
                    Login splash =new Login();
                    splash.setVisible(true);
                }else
                    System.out.println("No App Corriendo");
            }
        });                
    }
}
