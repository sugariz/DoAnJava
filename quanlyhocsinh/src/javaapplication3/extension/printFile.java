/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.extension;

import javax.print.attribute.standard.MediaTray;
import javax.print.attribute.standard.SheetCollate;
import javax.print.attribute.standard.Sides;

import com.gnostice.pdfone.PDFOne;
import com.gnostice.pdfone.PdfDocument;
import com.gnostice.pdfone.PdfPageSize;
import com.gnostice.pdfone.PdfPrinter;

/**
 *
 * @author azu
 */

public class printFile {
   static {
      PDFOne.activate("your-pdfone-activation-key",
                      "your-pdfone-product-key");
   }
   private String fileName;
   public printFile(String fileName) {
       this.fileName = fileName;
   }

   public void print() {
     PdfDocument d = new PdfDocument();    
    
     try {
         
        // Load a PDF document
        d.load(fileName);
      
        // Create a PDF printer object
        PdfPrinter printer = new PdfPrinter();

        // Specify the document that needs to be printed
        printer.setDocument(d);        

        // Select a printer
        printer.setSelectedPrinterName(
           // Name of first printer 
           printer.getAvailablePrinterNames()[0]);
                  
        // Set margins
        printer.setPageMargins(
           // Left, top, right, bottom margins
           new double[] {1, 0.5, 1, 0.5}, 
           // Measurement units
           PdfPrinter.MU_INCHES);                

        // Specify page size
        printer.setPageSize(PdfPageSize.A4);
        // Specify page orientation
        printer.setOrientation(PdfPrinter.Orientation_LANDSCAPE);
        // Specify pages that need to be printed
        printer.setPageRange("1-8");
        // Specify number of copies
        printer.setCopies(3);
        // Specify scaling
        printer.setPageScale(PdfPrinter.SCALE_REDUCE_TO_PRINTER_MARGINS);
        // Specify how page of different copies need to be collated
        printer.setPrintSheetCollate(SheetCollate.COLLATED);
        // Specify paper bin
        printer.setPrintMediaTray(MediaTray.SIDE);
        // Specify printing order
        printer.setReverse(true);
        // Specify which sides of paper need to be printed on
        printer.setPrintSides(Sides.TWO_SIDED_SHORT_EDGE);
        
        // Show printer dialog to user
        printer.showPrintDialog();        
     }
     catch (Exception ex1) {        
        System.out.println(ex1);        
     } finally {
           try {
              // Release I/O resources
              d.close();   
           } catch (Exception ex2) {
              System.out.println(ex2.getMessage());
           }
     }
  }
}