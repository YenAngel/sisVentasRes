/*
 *  ======================================================
 *  =============== Create/Edit By Anibal MA =============
 *  ======================================================
 *  -> This Default template ☻ <-
 */

package ventas.modelo;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;


/**
 * 
 * @author AnibalMA <anibalmarloaguilar@gmail.com>
 */
public class PrintFormatCaja {
        public static String CPlato[];
        public static int CCant[];
        public static double CPrecio[];
        public static String Cliente;
        public static String DNICliente;
        public static String TipoPago;
        public static double CantPago;
        public static String Correlativo;
        public static String TipoDocImpr;
        public static int NroMesa;
    
   private String Header(){
       SimpleDateFormat hFormat = new SimpleDateFormat("hh:mm:ss a");
        SimpleDateFormat dFormat = new SimpleDateFormat("dd/MM/yyy");
        String hora = hFormat.format(Time.valueOf(LocalTime.now())).toString();
        String fecha = dFormat.format(Date.valueOf(LocalDate.now())).toString();
       String h = "";
       h = getCaracter("=", 18) + "CEVICHERÍA DONDE ALFREDO" + getCaracter(" ", 18);
       switch(TipoDocImpr){
           case "Factura":
               
               h += "\n\n" + getCaracter(" ", 18) + "N° FACTURA: " + Correlativo + "\n"; //Var Fact
               h += getCaracter(" ", 15) + "FECHA: " + fecha + "   HORA: " + hora + "\n";
               h += "CLIENTE:  " + Cliente + getCaracter(" ",30 - Cliente.length()) + "DOC: " + DNICliente;
               h += "\n" + "MESA: " + NroMesa + getCaracter(" ",30 - String.valueOf(NroMesa).length()) + "CAJA: CAJA 1";
               h += "\n" + "Tipo de Pago: " + TipoPago;
               h += "\n" + getCaracter("=", 50) + "\n";
               break;
           case "Boleta":
               
               h += "\n\n" + getCaracter(" ", 18) + "N° BOLETA: " + Correlativo + "\n"; 
               h += getCaracter(" ", 15) + "FECHA: " + fecha + "   HORA: " + hora + "\n";
               h += "CLIENTE:  " + Cliente + getCaracter(" ",30 - Cliente.length()) + "DOC: " + DNICliente;
               h += "\n" + "MESA: " + NroMesa + getCaracter(" ",30 - String.valueOf(NroMesa).length()) + "CAJA: CAJA 1";
               h += "\n" + "Tipo de Pago: " + TipoPago;
               h += "\n" + getCaracter("=", 50) + "\n";
               break;
           case "Ticket":
               
               h += "\n\n" + getCaracter(" ", 18) + "N° TICKET: " + Correlativo + "\n";
               h += getCaracter(" ", 15) + "FECHA: " + fecha + "   HORA: " + hora + "\n";
               h += "CLIENTE:  " + Cliente + getCaracter(" ",30 - Cliente.length()) + "DOC: " + DNICliente;
               h += "\n" + "MESA: " + NroMesa + getCaracter(" ",30 - String.valueOf(NroMesa).length()) + "CAJA: CAJA 1";
               h += "\n" + "Tipo de Pago: " + TipoPago;
               h += "\n" + getCaracter("=", 50) + "\n";
               break;
            default: break;
       }
       return h;
   }
   private String Body(){
       String b = "";
       for (int i=0; i<CPlato.length; i++){
           String plato = String.valueOf(CPlato[i]);
           if (plato.length()>30){
               plato = plato.substring(0,30);
           }
           b += CCant[i] + getCaracter(" ", 6 - String.valueOf(CCant[i]).length());
           b += plato + getCaracter(" ", 5) + "S/. " + CPrecio[i] + "\n";
       }
       return b; //"\n"
   }
   private String Footer(){
       String f = getCaracter("=", 50);
       double total = Total();
       double igv = total*0.18;
       switch(TipoDocImpr){
           
           case "Factura":
               f += "\n" + getCaracter(" ", 25) + "V.TOTAL    S/. " + Return2Dec(total);
               f += "\n" + getCaracter(" ", 25) + "IGV 18%    S/. " + Return2Dec(igv);
               f += "\n" + getCaracter(" ", 25) + "TOTAL     S/. " + Return2Dec(total+igv);
               f += "\n" + getCaracter(" ", 25) + "EFECTIVO   S/. " + Return2Dec(CantPago);
               f += "\n" + getCaracter(" ", 25) + "VUELTO     S/. " + Return2Dec(CantPago-total-igv) + "\n";
               break; //30 ; 20; 3 
           case "Boleta":
               f += "\n" + getCaracter(" ", 25) + "TOTAL     S/. " + Return2Dec(total);
               f += "\n" + getCaracter(" ", 25) + "EFECTIVO   S/. " + Return2Dec(CantPago);
               f += "\n" + getCaracter(" ", 25) + "VUELTO     S/. " + Return2Dec(CantPago-total) +"\n";
               break;
           case "Ticket":
               f += "\n" + getCaracter(" ", 25) + "TOTAL     S/. " + Return2Dec(total);
               f += "\n" + getCaracter(" ", 25) + "EFECTIVO   S/. " + Return2Dec(CantPago);
               f += "\n" + getCaracter(" ", 25) + "VUELTO     S/. " + Return2Dec(CantPago-total) +"\n";
               break;
       }
       f += getCaracter("=", 13) + " Gracias por su visita " + getCaracter("=", 14);
       return f;
   }
   public void ImprimirCaja(){
       System.out.println(Header()+Body()+Footer());
   }
   public double Total(){
       double total = 0.0;
       for (int i = 0; i<CPlato.length; i++){
           total += CPrecio[i];
       }
       return total;
   }
   
   public static String getCaracter(String Caracter, int longitud){
        String R = "";
        for(int i = 1; i <= longitud; i++){
            R = R.concat(Caracter);
        }
        return R;
    }
   private String Return2Dec(double value){
        double parteEntera, resultado;
        resultado = value;
        parteEntera = Math.floor(resultado);
        resultado=(resultado-parteEntera)*Math.pow(10, 2);
        resultado=Math.round(resultado);
        resultado=(resultado/Math.pow(10, 2))+parteEntera;
        System.out.println("Resultado: " + resultado);
        String rs = resultado+"";
        if(rs.substring(rs.indexOf('.')+1, rs.length()).length()!=2){
            rs = rs + "0";
            return rs;
        }
        return resultado + "";
    }
}
