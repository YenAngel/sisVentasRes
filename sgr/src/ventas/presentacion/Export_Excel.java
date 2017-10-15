/*
 *  ======================================================
 *  =============== Create/Edit By Anibal MA =============
 *  ======================================================
 *  -> This Default template ☻ <-
 */

package ventas.presentacion;
import java.io.*;
import java.util.List;
import javax.swing.JTable;
import jxl.*;
import jxl.format.PageOrientation;
import jxl.format.UnderlineStyle;
import jxl.write.*;
/**
 * 
 * @author AnibalMA <anibalmarloaguilar@gmail.com>
 */
public class Export_Excel {
    private File file;
    private List<JTable> tabla;
    private List<String> nom_files;
    private String concepto;
    private String medioPago;
    private String fechaInicio;
    private String fechaFin;
    private String Local;
    private double countIngresos;
    private double countEgresos;
    private double countApertura;
    
    public Export_Excel(File file, List<JTable> tabla, List<String> nom_files, String concepto, String medioPago, String fechaInicio, String fechaFin, String Local) throws Exception {
        this.file = file;
        this.tabla = tabla;
        this.nom_files = nom_files;
        this.concepto = concepto;
        this.Local = Local;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.medioPago = medioPago;
    if(nom_files.size()!=tabla.size()){
        throw new Exception("Error");
    }
    }
    public boolean export() {
        countApertura = 0.0;
        countIngresos = 0.0;
        countEgresos = 0.0;
        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
            WritableWorkbook w = Workbook.createWorkbook(out);
            Label cell = new Label(0, 0, " ");
            jxl.format.CellFormat cellFormat = cell.getCellFormat();
            WritableCellFormat wcf = new WritableCellFormat(cellFormat);
            wcf.setAlignment(jxl.format.Alignment.CENTRE);
            
            WritableCellFormat wcfborder = new WritableCellFormat(cellFormat);
            wcfborder.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
            
            WritableFont boldFont = new WritableFont(cellFormat.getFont());
            WritableCellFormat wcfb = new WritableCellFormat(cellFormat);
            boldFont.setBoldStyle(WritableFont.BOLD);
            boldFont.setUnderlineStyle(UnderlineStyle.SINGLE);
            wcfb.setFont(boldFont);
            
            WritableFont boldFonttitles = new WritableFont(cellFormat.getFont());
            WritableCellFormat wcfborderandbold = new WritableCellFormat(cellFormat);
            boldFonttitles.setBoldStyle(WritableFont.BOLD);
            wcfborderandbold.setFont(boldFonttitles);
            wcfborderandbold.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
            wcfborderandbold.setAlignment(jxl.format.Alignment.CENTRE);
            CellView cv = new CellView();
            
            for (int index = 0; index < tabla.size(); index++) {
                JTable table = tabla.get(index);
                WritableSheet s = w.createSheet(nom_files.get(index), 0);
                
                String dateFilter = "Del " + fechaInicio + " al " + fechaFin;
                
                s.addCell(new Label(0,4,"Empresa",wcfb));
                s.addCell(new Label(1,4,"Donde Alfredo"));
                s.addCell(new Label(3,4,"Concepto",wcfb));
                s.addCell(new Label(4,4,concepto));
                s.addCell(new Label(6,4,"Medio Pago",wcfb));
                s.addCell(new Label(7,4,medioPago));
                s.addCell(new Label(0,6,"Caja (Local)",wcfb));
                s.addCell(new Label(3,6,dateFilter,wcfb));
                s.addCell(new Label(6,6,"Local",wcfb));
                s.addCell(new Label(7,6,Local));
                s.addCell(new Label(0,9,"Local",wcfborderandbold));
                s.addCell(new Label(1,9,"Operación",wcfborderandbold));
                s.addCell(new Label(2,9,"Medio Pago",wcfborderandbold));
                s.addCell(new Label(3,9,"Comprobante",wcfborderandbold));
                s.addCell(new Label(4,9,"Numeración",wcfborderandbold));
                s.addCell(new Label(5,9,"Importe",wcfborderandbold));
                s.addCell(new Label(6,9,"Fecha",wcfborderandbold));
                s.addCell(new Label(7,9,"Concepto",wcfborderandbold));
                s.addCell(new Label(8,9,"Cliente",wcfborderandbold));
                for (int i = 0; i < s.getColumns(); i++){
                    if(i!=3){
                    cv = s.getColumnView(i);
                    cv.setAutosize(true);
                    s.setColumnView(i, cv);}
                }
                cv = s.getColumnView(3);
                    cv.setSize(5000);
                    s.setColumnView(3, cv);
                s.addCell(new Label(3,1,"REPORTE DE MOVIMIENTO DE CAJA",wcfb));
                s.setPageSetup(PageOrientation.LANDSCAPE);
                
                s.getSettings().setBottomMargin(0.50);
                s.getSettings().setTopMargin(0.50);
                s.getSettings().setLeftMargin(0.50);
                s.getSettings().setRightMargin(0.50);
                
                
                //s.addCell(new Label(9,9,"Usuario"));
                //System.out.println(table.getRowCount() + "/" + table.getColumnCount());
                 for (int j = 0; j < table.getRowCount(); j++) {
                       
                        if (table.getValueAt(j, 1).equals("Apertura Caja")){
                            countApertura+= Double.parseDouble(table.getValueAt(j, 5).toString());
                        }else if (table.getValueAt(j, 1).equals("Entrada")){
                            countIngresos+= Double.parseDouble(table.getValueAt(j, 5).toString());
                        }else{
                            countEgresos+= Double.parseDouble(table.getValueAt(j, 5).toString());
                        }
                         
                   }
                for (int i = 0; i < table.getColumnCount() - 1; i++) {
                    for (int j = 0; j < table.getRowCount(); j++) {
                        Object object;
                        if (table.getValueAt(j, i) == null){
                            object = "";
                        }else{
                            object = table.getValueAt(j, i);
                        }
                         
                        s.addCell(new Label(i, j+10, "  " + String.valueOf(object),wcfborder));
                        
                    }
                }
                int rcount = table.getRowCount() + 10;
                s.addCell(new Label(7,rcount + 1,"Total Apertura",wcfb));
                s.addCell(new Label(7,rcount + 2,"Total Ingresos",wcfb));
                s.addCell(new Label(7,rcount + 3,"Total Egresos",wcfb));
                s.addCell(new Label(8,rcount + 1,countApertura+"",wcfborder));    
                s.addCell(new Label(8,rcount + 2,countIngresos+"",wcfborder));    
                s.addCell(new Label(8,rcount + 3,countEgresos+"",wcfborder));    
                System.out.println(countApertura);
                System.out.println(countIngresos);
                System.out.println(countEgresos);
            }
            w.write();
            w.close();
            out.close();
            return true;
        } catch (IOException | WriteException e) {
            return false;
        }
    }
}
