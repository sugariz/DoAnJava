/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javaapplication3.BUS.classBUS;
import javaapplication3.BUS.nhapDiemBUS;
import javaapplication3.BUS.semesterBUS;
import javaapplication3.BUS.yearBUS;
import javaapplication3.DTO.classDTO;
import javaapplication3.DTO.infoClassDTO;
import javaapplication3.DTO.scoreDTO;
import javaapplication3.DTO.semesterDTO;
import javaapplication3.DTO.studentDTO;
import javaapplication3.DTO.yearDTO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author azu
 */
public class statisticalGUI {
    
    private aTable tableClass;
    private aTable tableInfoClass;
    private JComboBox<yearDTO> jComboYear;
    private JComboBox<semesterDTO> jComboSemester;
    private JComboBox<String> jComboClassify;
    private JButton jButtonFilter;
    private JButton classify;
    private JPanel panelOption;
    private String[] headerClass = {"Tên khối", "Tên lớp"};
    private String[] headerInfoClass = {"STT", "Tên học sinh", "Toán", "Sinh Học", "Vật Lý", "Hóa Học", "Địa Lý", "Tiếng Anh", "Thể Dục", "Công Nghệ"};
    private ArrayList<Object[]> oBodyClass;
    private ArrayList<Object[]> oBodyInfoClass;
    private classBUS listClass;
    private JLabel labelYear;
    private JLabel labelSemester;
    private nhapDiemBUS nhapdiemBus = new nhapDiemBUS("");

    public statisticalGUI(JPanel myPanel) {
        this.build(myPanel);
    }
    
    private void build(JPanel myJPanel) {
        jComboYear = new JComboBox<yearDTO>();
        jComboSemester = new JComboBox<semesterDTO>();
        panelOption = new JPanel();
        labelSemester = new JLabel("Học kỳ");
        labelYear = new JLabel("Năm học");
        jButtonFilter = new JButton("Tìm kiếm");
        configPanel(myJPanel, Color.WHITE, new Dimension(950, 300));
        
        ArrayList<yearDTO> oYears = new yearBUS().getNamHocDTO();
        ArrayList<semesterDTO> oSemester = new semesterBUS().getSemesterDTO();
        oYears.forEach(cnsmr -> {
            jComboYear.addItem(cnsmr);
        });
        
        oSemester.forEach(cnsmr -> {
            jComboSemester.addItem(cnsmr);
        });
        listClass = new classBUS();
        oBodyClass = listClass.getListClass1(((yearDTO)jComboYear.getSelectedItem()).getMaNamHoc());
//        oBodyInfoClass = listClass.getListClass1(((yearDTO)jComboYear.getSelectedItem()).getMaNamHoc());
       
        this.createData();
        
        tableClass = new aTable(oBodyClass, headerClass);
        tableInfoClass = new aTable(oBodyInfoClass, headerInfoClass);
        JScrollPane jScrollPanelClass = new JScrollPane(tableClass);
        JScrollPane jScrollPanelInfoClass = new JScrollPane(tableInfoClass);
        setScrollPanel(jScrollPanelClass, new Dimension(200, 600));
        setScrollPanel(jScrollPanelInfoClass, new Dimension(750, 600));
        panelOption.add(labelYear);
        panelOption.add(jComboYear);
        panelOption.add(labelSemester);
        panelOption.add(jComboSemester);
        panelOption.add(jButtonFilter);
        
        this.action(jButtonFilter, tableClass);
        
        tableClass.getColumnModel().getColumn(0).setPreferredWidth(100);
        myJPanel.add(panelOption, BorderLayout.NORTH);
        myJPanel.add(jScrollPanelClass, BorderLayout.WEST);
        myJPanel.add(jScrollPanelInfoClass, BorderLayout.EAST);
    }
    
    private void createData() {
        Object obj = oBodyClass.get(0);
        String[] idSub = {"MH001", "MH002", "MH003", "MH004", "MH005", "MH006", "MH007", "MH008", "MH009"};
        for(int j = 0; j < idSub.length; j++) {
            ArrayList<infoClassDTO> listClassScore = nhapdiemBus.getScore(
                    idSub[j],
                    ((semesterDTO)jComboSemester.getSelectedItem()).getMaHocKy(),
                    ((classDTO)obj).getMaLop(),
                    ((yearDTO)jComboYear.getSelectedItem()).getMaNamHoc());
            oBodyInfoClass = new ArrayList<Object[]>();
            
            for(int i = 0; i < listClassScore.size(); i++) {
                int index = 0;
                infoClassDTO ttd = listClassScore.get(i);
                Object[] rowData = new Object[12];
                rowData[index] = i + 1;
                index += 1;
                // filter
                rowData[index] = new studentDTO(ttd.getIdStudent(), ttd.getSurname(), ttd.getName());
                index += 1;
                
                float scoreFinal = ttd.generateDiemTongKet();
                if(scoreFinal != -1)
                    rowData[j + 2] = scoreFinal;
                oBodyInfoClass.add(rowData);
            }
            
            for(infoClassDTO row : listClassScore) {

            }
        }
    }
    
    private void action(JButton myButton, aTable myTable) {
        ActionListener btnActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oBodyClass = listClass.getListClass1(((yearDTO)jComboYear.getSelectedItem()).getMaNamHoc());
                javax.swing.table.DefaultTableModel tm = new javax.swing.table.DefaultTableModel(new Object[0][0], headerClass);
                DefaultTableModel model = (DefaultTableModel) myTable.getModel();
                for(Object[] ele : oBodyClass) {
                    tm.addRow(ele);
                }
                myTable.setData(tm);
                myTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            }
        };
        myButton.addActionListener(btnActionListener);
    }
    
    private void configPanel(JPanel myPanel, Color colorBackGround, Dimension size) {
        myPanel.setBackground(colorBackGround);
        myPanel.setPreferredSize(size);
    }
    
    private void setScrollPanel(JScrollPane myScrollPane, Dimension size) {
        myScrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        myScrollPane.setPreferredSize(size);
        myScrollPane.setBackground(new Color(255, 255, 255));
    }
    
}
