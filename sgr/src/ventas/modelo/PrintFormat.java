/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventas.modelo;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttribute;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaSizeName;

/**
 * 
 * @author AnibalMA <anibalmarloaguilar@gmail.com>
 */
public class PrintFormat {
        public static String[] ListPlatosName;
        public static String[] ListPlatosDescr;
        //public static double[] ListPlatosPrice;
        public static int[] DishCantidad;
        public static int NMesa, NPedido;
        public static String Mesero;
        public static String TipoEnvio;
        public static String NumSalon;
    public static void ImprimirToCocinaBar()   {
        String Print = "";
        SimpleDateFormat hFormat = new SimpleDateFormat("hh:mm:ss a");
        SimpleDateFormat dFormat = new SimpleDateFormat("dd/MM/yyy");
        String hora = hFormat.format(Time.valueOf(LocalTime.now())).toString();
        String fecha = dFormat.format(Date.valueOf(LocalDate.now())).toString();
        String header = "\n\n\n" + getCaracter("=", 18) + "   DONDE ALFREDO   " + getCaracter("=", 18) + "\n\n";
        header += getCaracter("=", 55) + "\n\n";
        String body = getCaracter(" ", 19) + "N° PEDIDO: " + NPedido + "\n\n";
        
        body   += "TIPO ENVIO......:  " + TipoEnvio + "\n";
        body   += "MESA............:  Mesa " + NMesa + "\n";
        body   += "CLIENTE.........:  (Publico General) \n";
        body   += "MESERO..........:  " + Mesero + "\n";
        body   += "ESTADO..........:  " + "Atención" + "\n";
        body   += "SALÓN...........:  " + NumSalon + "\n";
        body   += "FECHA...........:  " + fecha + " " + hora + "\n\n";
        body   += getDetallePedidoCocina();
        
        
        String footer = "\n" + getCaracter("=",55) + "\n";
        Print = header + body + footer;
        System.out.println(Print);
        imprimirCocinaBar(Print);
    }
    public static void ImpCancelToCocinaBar()   {
        String Print = "";
        SimpleDateFormat hFormat = new SimpleDateFormat("hh:mm:ss a");
        SimpleDateFormat dFormat = new SimpleDateFormat("dd/MM/yyy");
        String hora = hFormat.format(Time.valueOf(LocalTime.now())).toString();
        String fecha = dFormat.format(Date.valueOf(LocalDate.now())).toString();
        String header = "\n\n\n" + getCaracter("=", 18) + "   DONDE ALFREDO   " + getCaracter("=", 18) + "\n\n";
        header += getCaracter(" ", 19) + "PLATO O BEBIDA ELIMINADA" + "\n";
        header += getCaracter("=", 55) + "\n\n";
        String body = getCaracter(" ", 15) + "N° PEDIDO: " + NPedido + "\n\n";
        
        body   += "TIPO ENVIO......:  " + TipoEnvio + "\n";
        body   += "MESA............:  Mesa " + NMesa + "\n";
        body   += "CLIENTE.........:  (Publico General) \n";
        body   += "MESERO..........:  " + Mesero + "\n";
        body   += "SALÓN...........:  " + NumSalon + "\n";
        body   += "FECHA...........:  " + fecha + " " + hora + "\n\n";
        body   += getDetallePedidoCocina();
        
        
        String footer = "\n" + getCaracter("=",55) + "\n";
        Print = header + body + footer;
        System.out.println(Print);
        imprimirCocinaBar(Print);
    }
    public static void ImpAnuladoToCocinaBar()   {
        String Print = "";
        SimpleDateFormat hFormat = new SimpleDateFormat("hh:mm:ss a");
        SimpleDateFormat dFormat = new SimpleDateFormat("dd/MM/yyy");
        String hora = hFormat.format(Time.valueOf(LocalTime.now())).toString();
        String fecha = dFormat.format(Date.valueOf(LocalDate.now())).toString();
        String header = "\n\n\n" + getCaracter("=", 18) + "   DONDE ALFREDO   " + getCaracter("=", 18) + "\n";
        header += getCaracter(" ", 23) + "ANULADO" + "\n";
        header += getCaracter("=", 55) + "\n\n";
        String body = getCaracter(" ", 19) + "N° PEDIDO: " + NPedido + "\n\n";
        
        body   += "TIPO ENVIO......:  " + TipoEnvio + "\n";
        body   += "MESA............:  Mesa " + NMesa + "\n";
        body   += "CLIENTE.........:  (Publico General) \n";
        body   += "MESERO..........:  " + Mesero + "\n";
        body   += "ESTADO..........:  " + "Anulado" + "\n";
        body   += "SALÓN...........:  " + NumSalon + "\n";
        body   += "FECHA...........:  " + fecha + " " + hora + "\n\n";
        body   += getDetallePedidoCocina();
        
        
        String footer = "\n" + getCaracter("=",55) + "\n";
        Print = header + body + footer;
        System.out.println(Print);
        imprimirCocinaBar(Print);
    }
    public static String getCaracter(String Caracter, int longitud){
        String R = "";
        for(int i = 1; i <= longitud; i++){
            R = R.concat(Caracter);
        }
        return R;
    }
    public static String getDetallePedidoCocina(){
        String Result = "";
        for(int i=0; i<DishCantidad.length; i++){
            Result+= "\n " + getCaracter(" ", 17) + DishCantidad[i] + " " + ListPlatosName[i] + " ";
           /* System.out.println("Index Current: " + i);
            System.out.println("Tamaño Array: " + ListPlatosDescr.length);
            System.out.println("Plato: " + ListPlatosDescr[i]);*/
            if(!ListPlatosDescr[i].equals("-1")){
                Result+= "(" + ListPlatosDescr[i] + ")";
            }
        }
        return Result;
    }
    public static void imprimirCocinaBar(String textoAImprimir) {
        
        PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null); 

        byte[] bytes = textoAImprimir.getBytes();
        
        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
		aset.add(MediaSizeName.ISO_A4);
		aset.add(new Copies(1));
                
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;

        Doc doc = new SimpleDoc(bytes, flavor,null);
        DocPrintJob job = null;
        if (services.length > 0) {
            for (PrintService service : services) {
                System.out.println(service.getName());
                if (service.getName().equals("Printer_AnibalMA")) {
                    job = service.createPrintJob(); // System.out.println(i+": "+services[i].getName());
                }
            }
        }

        try {
            job.print(doc,aset);
        } catch (PrintException ex) {
            System.out.println(ex);
        }

    }

}
