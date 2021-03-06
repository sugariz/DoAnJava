/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.GUI;

import javaapplication3.extension.printFile;
import javaapplication3.extension.writeCSV;
import javaapplication3.extension.writePDF;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javaapplication3.DTO.semesterDTO;
import javaapplication3.DTO.yearDTO;
import javaapplication3.BUS.scoreStudentBUS;
import javaapplication3.BUS.hocKyBUS;
import javaapplication3.BUS.yearBUS;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javaapplication3.BUS.semesterBUS;

/**
 *
 * @author azu
 */
public class scoreGUI {
    private Font fontOfLabel = new Font("DENSE", Font.BOLD, 14);
    private javaapplication3.GUI.aTable tableDataScore;
    private javaapplication3.GUI.aTable tableDataDayOff;
    private javaapplication3.GUI.aTable tableDataSummary;
    private javax.swing.JScrollPane scrollPanelScore;
    private javax.swing.JScrollPane scrollPanelDayOff;
    private javax.swing.JScrollPane scrollPanelSummary;
    private javax.swing.JPanel JPanelChooseYear;
    private javax.swing.JLabel schoolYear;
    private javax.swing.JButton exportCSV;
    private javax.swing.JButton printScore;
    private javax.swing.JButton exportPDF;
    private String maHS;
    
    public scoreGUI(JPanel myJPanel, String maHS) {
        super();
        this.maHS = maHS;
        try{
            this.createscoreLayout(myJPanel);
        }
        catch(Exception e) {
            System.err.println(e);
        }
    }
    
    private void createscoreLayout(JPanel myJPanel) {
//        String[] columns = {"MAHS", "H???", "T??n", "Ng??y sinh", "?????a ch???", "Gi???i t??nh", "Email", "S??? ??i???n tho???i"};
        String[] column1 = {"      M??n", "KT Mi???ng HK1", "KT 15 ph??t KH1", "1 ti???t HK1", "Thi HK1", "TBHK1"};
        String[][] data = new scoreStudentBUS().getScoreListOfStudent(this.maHS, "HK1", "NH1920");
        String[] headersDayOff = {"      C??c ng??y ngh??? trong n??m", "C??c ng??y vi ph???m trong n??m"};
        String[][] dataRowsDayOff = {{"        T???ng s??? ng??y ngh??? : 0 ", "T???ng s??? ng??y vi ph???m : 0 "}};
        String[] headersSummary = {"      N???i dung", "HK I", "HK II", "C??? n??m"};
        String[][] dataRowsSummary = {{"        1. ??i???m trung b??nh", "10", "10", "10"},
                                    {"        2. H???c l???c", "Gi???i", "Gi???i", "Gi???i"},
                                    {"        3. H???nh ki???m", "T???t", "T???t", "T???t"}};
        
        String[] hocKy = new hocKyBUS().getHocKy();
        String[] namHoc = new yearBUS().getNamHoc();
        String[] years = new String[hocKy.length * namHoc.length];
        int index = 0;
        
        for(int i = 0; i < namHoc.length; i++)
            for(int j = 0; j < hocKy.length; j++) {
                years[index] = String.format("%s - N??m h???c %s", hocKy[j], namHoc[i]);
                index++;
            }
        
        JPanelChooseYear = new JPanel();
        schoolYear = new JLabel("Ch???n h???c k??? xem ??i???m");
        tableDataScore = new aTable(data,column1);
        tableDataDayOff = new aTable(dataRowsDayOff,headersDayOff);
        tableDataSummary = new aTable(dataRowsSummary, headersSummary);
        scrollPanelScore = new JScrollPane(tableDataScore);
        scrollPanelDayOff = new JScrollPane(tableDataDayOff);
        scrollPanelSummary = new JScrollPane(tableDataSummary);
        exportCSV = new JButton("Xu???t b???ng ??i???m");
        exportPDF = new JButton("Xu???t file PDF");
        printScore = new JButton("In");
        
        JComboBox jComboBoxYears = new JComboBox(years);
        this.configJComboBox(jComboBoxYears, new Dimension(250, 30));
        jComboBoxYears.setFocusable(false);
        jComboBoxYears.setOpaque(true);
        jComboBoxYears.setFont(new java.awt.Font("DENSE", java.awt.Font.BOLD, 14));
        jComboBoxYears.setBackground(Color.WHITE);
        
        this.action(jComboBoxYears, this.maHS, hocKy, namHoc, column1);
        this.action(exportCSV, column1, data, headersDayOff, dataRowsDayOff, headersSummary, dataRowsSummary);
        this.actionPDF(exportPDF, column1, data, headersDayOff, dataRowsDayOff, headersSummary, dataRowsSummary);
        this.actionPrint(printScore, column1, data, headersDayOff, dataRowsDayOff, headersSummary, dataRowsSummary);
        
        this.setScrollPanel(scrollPanelScore, 350);
        this.setScrollPanel(scrollPanelDayOff, 70);
        this.setScrollPanel(scrollPanelSummary, 140);
        this.configPanel(JPanelChooseYear, Color.WHITE, new Dimension(950, 40));
        Dimension size = new Dimension(150, 30);
        this.configButton(exportCSV, size);
        this.configButton(exportPDF, size);
        this.configButton(printScore, new Dimension(50, 30));
        
        JPanelChooseYear.add(schoolYear);
        JPanelChooseYear.add(jComboBoxYears);
        JPanelChooseYear.add(exportCSV);
        JPanelChooseYear.add(exportPDF);
        JPanelChooseYear.add(printScore);        
        
        myJPanel.add(JPanelChooseYear);
        myJPanel.add(scrollPanelScore);
        myJPanel.add(scrollPanelScore);
        myJPanel.add(scrollPanelDayOff);
        myJPanel.add(scrollPanelSummary);
    }
    
    private void action(JComboBox jComboBox, String maHS, String[] tenHocKy, String[] tenNamHoc, String[] headers) {
        ArrayList<semesterDTO> semester = new semesterBUS().getSemesterDTO();
        ArrayList<yearDTO> year = new yearBUS().getNamHocDTO();
        ActionListener cbActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String condi = (String) jComboBox.getSelectedItem();
                
                for(int i = 0; i < tenNamHoc.length; i++)
                    for(int j = 0; j < tenHocKy.length; j++)
                        if(condi.equals(String.format("%s - N??m h???c %s", tenHocKy[j], tenNamHoc[i]))) {
                            String[][] dataRow = new scoreStudentBUS().getScoreListOfStudent(maHS, semester.get(j).getMaHocKy(), year.get(i).getMaNamHoc());
                            javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(dataRow, headers);
                            tableDataScore.setData(model);
                            return;
                        }
                }
        };
        
        jComboBox.addActionListener(cbActionListener);
    }
    
    private void action(JButton myButton, String[] header, String[][] data, String[] headersDayOff, String[][] dataRowsDayOff, String[] headersSummary, String[][] dataRowsSummary) {
        ActionListener btnActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
//                chooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY); 
//                chooser.showOpenDialog(null);
//                String path = chooser.getCurrentDirectory().toString();
                String fileName = maHS + " - score.csv";
                new writeCSV(fileName).writeCSVScoreStudent(header, data, headersDayOff, dataRowsDayOff, headersSummary, dataRowsSummary);
            }
        };
        
        myButton.addActionListener(btnActionListener);
    }
    
    private void actionPDF(JButton myButton, String[] header, String[][] data, String[] headersDayOff, String[][] dataRowsDayOff, String[] headersSummary, String[][] dataRowsSummary) {
        ActionListener btnActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
//                chooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY); 
//                chooser.showOpenDialog(null);
//                String path = chooser.getCurrentDirectory().toString();
//                String fileName = maHS + " - score.csv";
//                new writeCSV(fileName).writeCSVScoreStudent(header, data, headersDayOff, dataRowsDayOff, headersSummary, dataRowsSummary);
                String fileName = maHS + " - score.pdf";
                new writePDF(fileName).writePDFStudent(header, data, headersDayOff, dataRowsDayOff, headersSummary, dataRowsSummary);
            }
        };
        
        myButton.addActionListener(btnActionListener);
    }
    
    private void actionPrint(JButton myButton, String[] header, String[][] data, String[] headersDayOff, String[][] dataRowsDayOff, String[] headersSummary, String[][] dataRowsSummary) {
        ActionListener btnActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = maHS + " - score.pdf";
                new writePDF(fileName).writePDFStudent(header, data, headersDayOff, dataRowsDayOff, headersSummary, dataRowsSummary);
                new printFile(fileName).print();
            }
        };
        
        myButton.addActionListener(btnActionListener);
    }
    
    private void configJComboBox(JComboBox combobox, Dimension size) {
        UIManager.put("ComboBox.background", new ColorUIResource(Color.WHITE));
        UIManager.put("JTextField.background", new ColorUIResource(Color.WHITE));
        UIManager.put("ComboBox.selectionBackground", new ColorUIResource(Color.WHITE));
        UIManager.put("ComboBox.selectionForeground", new ColorUIResource(new Color(72,128,248)));
        combobox.setFont(new Font("DENSE", Font.PLAIN, 14));
        combobox.getEditor().getEditorComponent().setBackground(Color.WHITE);
        ((JTextField) combobox.getEditor().getEditorComponent()).setBackground(Color.WHITE);
        combobox.setPreferredSize(size);
        combobox.setBorder(new javax.swing.border.LineBorder(new Color(206,210,214), 1));

        combobox.setUI(new javax.swing.plaf.basic.BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton b = super.createArrowButton();
                b.setBorder(new EmptyBorder(0, 0, 0, 0));
                b.setBackground(Color.WHITE);
                b.setBorderPainted(false);
                return b; 
           }
        });
    }
    
    private void configButton(JButton myButton, Dimension size) {
        myButton.setPreferredSize(size);
        myButton.setFont(fontOfLabel);
        myButton.setBackground(new Color(1, 122, 255));
        myButton.setForeground(Color.WHITE);
        myButton.setFocusPainted(false);
        myButton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                myButton.setBackground(new Color(1, 122, 255));
            }
            
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                myButton.setBackground(new Color(0, 80, 200));
            }
            
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                myButton.setBackground(new Color(12, 98, 228));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                myButton.setBackground(new Color(1, 122, 255));
            }
        });
    }
    
    private void setScrollPanel(JScrollPane myScrollPane, int height) {
        myScrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        myScrollPane.setPreferredSize(new Dimension(950, height));
        myScrollPane.setBackground(new Color(255, 255, 255));
    }
    
    private void configPanel(JPanel myPanel, Color colorBackGround, Dimension size) {
        myPanel.setBackground(colorBackGround);
        myPanel.setPreferredSize(size);
    }

}
