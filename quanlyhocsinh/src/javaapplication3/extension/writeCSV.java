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

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class writeCSV {
    private String fileName;
    public writeCSV(String fileName) {
        this.fileName = fileName;
    }
    
    public void writeCSVScoreStudent(String[] header, String[][] scoreList, String[] headersDayOff, String[][] dataRowsDayOff, String[] headersSummary, String[][] dataRowsSummary) {
        FileWriter fileWriter = null;
 
        try {
            fileWriter = new FileWriter(fileName);
 
            for(String subHeader : header) {
                fileWriter.append(subHeader);
                fileWriter.append(",");
            }
            fileWriter.append("\n");
            for(String[] row : scoreList) {
                for(String cell : row) {
                    fileWriter.append(cell.trim());
                    fileWriter.append(",");
                }
                fileWriter.append("\n");
            }
            
            for(String cell : headersDayOff) {
                fileWriter.append(cell.trim());
                fileWriter.append(",");
            }
            fileWriter.append("\n");
            
            for(String[] row : dataRowsDayOff) {
                for(String cell : row) {
                    fileWriter.append(cell.trim());
                    fileWriter.append(",");
                }
                fileWriter.append("\n");
            }
            
            for(String cell : headersSummary) {
                fileWriter.append(cell.trim());
                fileWriter.append(",");
            }
            fileWriter.append("\n");
            for(String[] row : dataRowsSummary) {
                for(String cell : row) {
                    fileWriter.append(cell.trim());
                    fileWriter.append(",");
                }
                fileWriter.append("\n");
            }
 
            System.out.println("CSV file was created successfully !!!");
 
            } catch (Exception e) {
                System.out.println("Error in CsvFileWriter !!!");
                e.printStackTrace();
            } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }
    
    public void writeCSVScoreTeacher(String[] header, ArrayList<Object[]> scoreList) {
        FileWriter fileWriter = null;
 
        try {
            fileWriter = new FileWriter(fileName);
 
            for(String subHeader : header) {
                fileWriter.append(subHeader);
                fileWriter.append(",");
            }
            fileWriter.append("\n");
            for(Object[] row : scoreList) {
                for(Object cell : row) {
                    if(cell == null)
                        fileWriter.append("");
                    else
                        fileWriter.append(cell.toString().trim());
                    fileWriter.append(",");
                }
                fileWriter.append("\n");
            }
 
            System.out.println("CSV file was created successfully !!!");
 
            } catch (Exception e) {
                System.out.println("Error in CsvFileWriter !!!");
                e.printStackTrace();
            } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }
    
}
