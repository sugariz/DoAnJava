/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.extension;

/**
 *
 * @author azu
 */
import java.io.FileOutputStream;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.gnostice.pdfone.fonts.PdfFont;
import com.gnostice.pdfone.encodings.PdfEncodings;
import java.util.ArrayList;

public class writePDF {
    private String fileName;
    
    public writePDF(String fileName) {
        this.fileName = fileName;
    }
    
    public void writePDFTeacher(String[] header, ArrayList<Object[]> scoreList) {
        try {
            Font myfont = FontFactory.getFont("arial", 8, Font.BOLD);
            Document my_pdf_data = new Document();
            PdfWriter.getInstance(my_pdf_data, new FileOutputStream(fileName, true));
            my_pdf_data.open();            
            PdfPTable my_first_table = new PdfPTable(10);
            PdfPCell table_cell;
            
            for(String cell : header) {
                table_cell = new PdfPCell(new Phrase(cell.trim(), myfont));
                my_first_table.addCell(table_cell);
            }
            
            for(Object[] row : scoreList)
                for(Object cell : row) {
                    if(cell == null)
                        table_cell = new PdfPCell(new Phrase("",myfont));
                    else
                        table_cell = new PdfPCell(new Phrase(cell.toString().trim(),myfont));
                    my_first_table.addCell(table_cell);
                }

            Paragraph title = new Paragraph("Bảng điểm", myfont);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingBefore(15);
            title.setSpacingAfter(15);
            my_pdf_data.add(title);
            my_pdf_data.add(my_first_table);                       
            my_pdf_data.close();
            System.err.println("\u001B[32m Xong!");
        }
        catch(Exception e) {
            System.err.println(e);
        }
    }
    
    public void writePDFStudent(String[] header, String[][] scoreList, String[] headersDayOff, String[][] dataRowsDayOff, String[] headersSummary, String[][] dataRowsSummary) {
        try { 
            Font myfont = FontFactory.getFont("FreeSans", 8, Font.BOLD);
            Document my_pdf_data = new Document();
            PdfWriter.getInstance(my_pdf_data, new FileOutputStream(this.fileName));
            my_pdf_data.open();            
            PdfPTable my_first_table = new PdfPTable(6);
            PdfPCell table_cell;
            
            for(String cell : header) {
                table_cell = new PdfPCell(new Phrase(cell.trim(), myfont));
                my_first_table.addCell(table_cell);
            }
            
            for(String[] row : scoreList)
                for(String cell : row) {
                    table_cell = new PdfPCell(new Phrase(cell.trim(),myfont));
                    my_first_table.addCell(table_cell);
                }
            
            for(String cell : headersDayOff) {
                table_cell = new PdfPCell(new Phrase(cell.trim(), myfont));
                table_cell.setColspan(3);
                my_first_table.addCell(table_cell);
            }
            
            for(String[] row : dataRowsDayOff)
                for(String cell : row) {
                    table_cell = new PdfPCell(new Phrase(cell.trim(), myfont));
                    table_cell.setColspan(3);
                    my_first_table.addCell(table_cell);
                }
            
            for(int i = 0; i < headersSummary.length; i++) {
                table_cell = new PdfPCell(new Phrase(headersSummary[i].trim(), myfont));
                if(i == 0)
                    table_cell.setColspan(3);
                my_first_table.addCell(table_cell);
            }
            
            for(String[] row : dataRowsSummary)
                for(int i = 0; i < row.length; i++) {
                    table_cell = new PdfPCell(new Phrase(row[i].trim(), myfont));
                    if(i == 0)
                        table_cell.setColspan(3);
                    my_first_table.addCell(table_cell);
                }

            Paragraph title = new Paragraph("Bảng điểm", myfont);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingBefore(15);
            title.setSpacingAfter(15);
            my_pdf_data.add(title);
            my_pdf_data.add(my_first_table);                       
            my_pdf_data.close();
            System.err.println("Xong!");
        }
        catch(Exception e) {
            System.err.println(e);
        }
    }
    
    public static void main(String[] args) throws Exception {

    }

}