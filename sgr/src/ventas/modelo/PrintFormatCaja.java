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
    
   private static String Header(){
       SimpleDateFormat hFormat = new SimpleDateFormat("hh:mm:ss a");
        SimpleDateFormat dFormat = new SimpleDateFormat("dd/MM/yyy");
        String hora = hFormat.format(Time.valueOf(LocalTime.now())).toString();
        String fecha = dFormat.format(Date.valueOf(LocalDate.now())).toString();
       String h = "";
       h = getCaracter("=", 13) + " CEVICHERÍA DONDE ALFREDO " + getCaracter("=", 13);
       switch(TipoDocImpr){
           case "Factura":
               
               h += "\n\n" + getCaracter(" ", 15) + "N° FACTURA: " + Correlativo + "\n"; //Var Fact
               h += getCaracter(" ", 7) + "FECHA: " + fecha + "   HORA: " + hora + "\n\n";
               h += "CLIENTE: " + Cliente + getCaracter(" ",27 - Cliente.length()) + "DOC: " + DNICliente;
               h += "\n" + "MESA   : " + NroMesa + getCaracter(" ",27 - String.valueOf(NroMesa).length()) + "CAJA: CAJA 1";
               h += "\n" + "Tipo de Pago: " + TipoPago;
               h += "\n" + getCaracter("=", 52) + "\n\n";
               break;
           case "Boleta":
               
               h += "\n\n" + getCaracter(" ", 15) + "N° BOLETA: " + Correlativo + "\n"; 
               h += getCaracter(" ", 7) + "FECHA: " + fecha + "   HORA: " + hora + "\n\n";
               h += "CLIENTE: " + Cliente + getCaracter(" ",27 - Cliente.length()) + "DOC: " + DNICliente;
               h += "\n" + "MESA   : " + NroMesa + getCaracter(" ",27 - String.valueOf(NroMesa).length()) + "CAJA: CAJA 1";
               h += "\n" + "Tipo de Pago: " + TipoPago;
               h += "\n" + getCaracter("=", 52) + "\n\n";
               break;
           case "Ticket":
               
               h += "\n\n" + getCaracter(" ", 15) + "N° TICKET: " + Correlativo + "\n";
               h += getCaracter(" ", 7) + "FECHA: " + fecha + "   HORA: " + hora + "\n\n";
               h += "CLIENTE: " + Cliente + getCaracter(" ",27 - Cliente.length()) + "DOC: " + DNICliente;
               h += "\n" + "MESA   : " + NroMesa + getCaracter(" ",27 - String.valueOf(NroMesa).length()) + "CAJA: CAJA 1";
               h += "\n" + "Tipo de Pago: " + TipoPago;
               h += "\n" + getCaracter("=", 52) + "\n\n";
               break;
            default: break;
       }
       return h;
   }
   private static String Body(){
       String b = "";
       for (int i=0; i<CPlato.length; i++){
           String plato = String.valueOf(CPlato[i]);
           if (plato.length()>31){
               plato = plato.substring(0,31);
           }
           String precio = Return2Dec(CPrecio[i]);
           b += " " + getCaracter(" ", 2 - String.valueOf(CCant[i]).length()) + CCant[i] + getCaracter(" ", 4);
           b += plato + getCaracter(" ", 34 - plato.length()) + "S/. " + getCaracter(" ", 6 - precio.length()) + precio + "\n";
       }
       b+= "\n";
       return b; //"\n"
   }
   private static String Footer(){
       String f = getCaracter("=", 52);
       double total = Total();
       double igv = total*0.18;
       switch(TipoDocImpr){
           
           case "Factura":
               f += "\n" + getCaracter(" ", 30) + "V.TOTAL    S/. " + getCaracter(" ",6 - Return2Dec(total).length()) + Return2Dec(total);
               f += "\n" + getCaracter(" ", 30) + "IGV 18%    S/. " + getCaracter(" ",6 - Return2Dec(igv).length()) + Return2Dec(igv);
               f += "\n" + getCaracter(" ", 30) + "TOTAL      S/. " + getCaracter(" ",6 - Return2Dec(total+igv).length()) + Return2Dec(total+igv);
               f += "\n" + getCaracter(" ", 30) + "EFECTIVO   S/. " + getCaracter(" ",6 - Return2Dec(CantPago).length()) + Return2Dec(CantPago);
               f += "\n" + getCaracter(" ", 30) + "VUELTO     S/. " + getCaracter(" ",6 - Return2Dec(CantPago-total-igv).length()) + Return2Dec(CantPago-total-igv) + "\n\n";
               break; //30 ; 20; 3 
           case "Boleta":
               f += "\n" + getCaracter(" ", 30) + "TOTAL      S/. " + getCaracter(" ",6 - Return2Dec(total).length()) + Return2Dec(total);
               f += "\n" + getCaracter(" ", 30) + "EFECTIVO   S/. " + getCaracter(" ",6 - Return2Dec(CantPago).length()) + Return2Dec(CantPago);
               f += "\n" + getCaracter(" ", 30) + "VUELTO     S/. " + getCaracter(" ",6 - Return2Dec(CantPago-total).length()) + Return2Dec(CantPago-total) +"\n\n";
               break;
           case "Ticket":
               f += "\n" + getCaracter(" ", 30) + "TOTAL      S/. " + getCaracter(" ",6 - Return2Dec(total).length()) + Return2Dec(total);
               f += "\n" + getCaracter(" ", 30) + "EFECTIVO   S/. " + getCaracter(" ",6 - Return2Dec(CantPago).length()) + Return2Dec(CantPago);
               f += "\n" + getCaracter(" ", 30) + "VUELTO     S/. " + getCaracter(" ",6 - Return2Dec(CantPago-total).length()) + Return2Dec(CantPago-total) +"\n\n";
               break;
       }
       f += getCaracter("=", 14) + " Gracias por su visita " + getCaracter("=", 15);
       return f;
   }
   public static void ImprimirCaja(){
       System.out.println(Header().concat(Body()).concat(Footer()));
   }
   public static double Total(){
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
   private static String Return2Dec(double value){
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
