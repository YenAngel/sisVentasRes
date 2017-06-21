
package ventas.persistencia.util;

import java.io.File;
import ventas.modelo.Area;
import ventas.modelo.Cripto;
import ventas.presentacion.Splash;
import ventas.presentacion.frmPrincipal;

public class Init {
    public static void main(String[] args) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if (BDUtil.conectar()) {
                    System.out.println("App Corriendo");
                    Splash splash =new Splash();
                    splash.setVisible(true);
                }else
                    System.out.println("No App Corriendo");
            }
        });
        File file=new File("Area.java");
        String ry= file.getAbsolutePath();
        System.out.println(ry);
        Cripto c=new Cripto();
        c.encriptar("dat", ry);
    }
}
