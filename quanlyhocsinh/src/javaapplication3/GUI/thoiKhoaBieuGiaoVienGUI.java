/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.GUI;

import javaapplication3.BUS.thoiKhoaBieuGiaoVienBUS;
import javaapplication3.BUS.yearBUS;
import javaapplication3.BUS.namHocKyBUS;

import java.util.*;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author azu
 */

public class thoiKhoaBieuGiaoVienGUI {
    private ArrayList<ArrayList<Object>> thoikhoabieu;
    private ArrayList<Object> namKy;
    private String[] years;
    private String[] yearID;
    private String[] semester;
    private String[] semID;
    private JComboBox yearsComboBox;
    private JComboBox semComboBox;
    private DefaultTableModel model;
    private DefaultComboBoxModel<String> modelCb;
    private JButton display;
    private JPanel option;
    private JPanel tablePN;
    private JTable table;
    private JScrollPane scroll;
    private String columnNames[] = {"", "THỨ 2", "THỨ 3", "THỨ 4", "THỨ 5", "THỨ 6", "THỨ 7", "CHỦ NHẬT"};
    private String currentYears;
    private String currentSem;
    private String newYear;
    private String newSem;
    private JLabel yearJLabel;
    private JLabel semJLabel;
    private String maGv;
    
    public thoiKhoaBieuGiaoVienGUI(String maGv, JPanel myPanel) {
        this.maGv = maGv;
        this.build(this.maGv, myPanel);
    }

    public void build(String maGv, JPanel myPanel) {

        table = new JTable();
        table.setRowHeight(30);
        scroll = new JScrollPane(table);
        model = new DefaultTableModel() {
        public Class getColumnClass(int columnIndex) {
        return String.class;
            }
        };
        model.setDataVector(new Object[0][0], columnNames);
        years = new yearBUS().getNamHoc();
        yearID = new yearBUS().getMaNamHoc();
        newYear = yearID[yearID.length - 1];

        namKy = new namHocKyBUS().getNamHocKy(maGv, newYear);
  
        semester = namKy.toArray(new String[namKy.size()]);
        Arrays.sort(semester);
        for (String i : semester) {
            System.out.print("Sem start " + i);
        }
        newSem = semester[semester.length - 1];

        yearsComboBox = new JComboBox(years);
        
        modelCb = new DefaultComboBoxModel<String>();
        
        if (modelCb.getSize() == 0) {
            for (String s : semester) {
                modelCb.addElement(s);
            }
        }
        semComboBox = new JComboBox(modelCb);
        yearsComboBox.setSelectedIndex(years.length - 1);
        semComboBox.setSelectedIndex(semester.length - 1);

        changeContent(maGv,newYear, newSem);
       
        table.setRowHeight(table.getRowHeight() * 1);
        table.setDefaultRenderer(String.class, new MultiLineCellRenderer()); 
        try {
            yearsComboBox.addActionListener(
                    new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int i = yearsComboBox.getSelectedIndex();
                    currentYears = yearID[i];
                    namKy = new namHocKyBUS().getNamHocKy(maGv, currentYears);
                    semester = namKy.toArray(new String[namKy.size()]);
                    DefaultComboBoxModel modelCb2 = new DefaultComboBoxModel();
                    semComboBox.setModel(modelCb2);
                    Arrays.sort(semester);
                    for (String k : semester) {
                        System.out.println("add " + k);
                        modelCb2.addElement(k);
                    }
                }
            }
            );
        } catch (NullPointerException e) {
            System.err.println(e);
        }
        semComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {         
                currentSem = semComboBox.getSelectedItem().toString();

                System.out.println(currentSem);
            }
        });

        display = new JButton("Xem");
        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                changeContent(maGv,currentYears, currentSem);
            }
        });

        yearJLabel = new JLabel("Năm Học: ");
        semJLabel = new JLabel("Học Kỳ: ");

        option = new JPanel();
        option.add(yearJLabel);
        option.add(yearsComboBox);
        option.add(semJLabel);
        option.add(semComboBox);
        option.add(display);
        myPanel.add(option, BorderLayout.PAGE_START);
        myPanel.add(scroll, BorderLayout.CENTER);
    }

    public void changeContent(String maGv, String years, String sem) {

        if (model.getRowCount() == 0) {
            if (years == null && sem == null) {
                years = newYear;
                sem = newSem;
            } else if (years == null && sem != null) {
                years = newYear;
            } else if (years != null && sem == null) {
                sem = newSem;
            }
            thoikhoabieu = new thoiKhoaBieuGiaoVienBUS().getThoiKhoaBieuGiaoVien(maGv,years, sem);
            for (ArrayList<Object> tkb : thoikhoabieu) {
                model.addRow(tkb.toArray());
            }

            table.setModel(model);
        } else {
            model.setRowCount(0);
            changeContent(maGv,years, sem);
        }

    }

}

class MultiLineCellRenderer extends JTextArea implements TableCellRenderer {

  public MultiLineCellRenderer() {
    setLineWrap(true);
    setWrapStyleWord(true);
    setOpaque(true);
  }

  public Component getTableCellRendererComponent(JTable table, Object value,
      boolean isSelected, boolean hasFocus, int row, int column) {
    if (isSelected) {
      setForeground(table.getSelectionForeground());
      setBackground(table.getSelectionBackground());
    } else {
      setForeground(table.getForeground());
      setBackground(table.getBackground());
    }
    setFont(table.getFont());
    if (hasFocus) {
      setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
      if (table.isCellEditable(row, column)) {
        setForeground(UIManager.getColor("Table.focusCellForeground"));
        setBackground(UIManager.getColor("Table.focusCellBackground"));
      }
    } else {
      setBorder(new EmptyBorder(1, 2, 1, 2));
    }
    setText((value == null) ? "" : value.toString());
    return this;
  }
}