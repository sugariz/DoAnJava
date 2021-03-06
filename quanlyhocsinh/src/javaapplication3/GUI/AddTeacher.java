/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3.GUI;

/**
 *
 * @author thien
 */
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.border.EmptyBorder;
import javaapplication3.BUS.AddTeacherBUS;
import javax.swing.JComboBox;
import javaapplication3.BUS.monHocBUS;
import java.util.ArrayList;
import javaapplication3.DTO.subjectDTO;
import java.util.List;

public class AddTeacher {

    /**
     * Creates new form AddTeacher
     */
    private static final int Number_OF_COMBOS = 1;
    private List<JComboBox<subjectDTO>> listOfComboBoxes;

//    private JPanel combosPanel;
    private int xPosition = 530;
    private int yPosition = 380;
    private int width = 130;
    private int height = 40;
    private int counter = 0;

    public AddTeacher(JPanel myPanel) {
        initComponents(myPanel);
        ArrayList<subjectDTO> namBus = new monHocBUS().getListMonHoc();
        namBus.forEach(cnsmr -> {
            Mon.addItem(cnsmr);
            System.out.print(cnsmr);
        });

        Dimension size2 = new Dimension(50, 50);
        configInput(jTextField1, size2, false);
        configInput(jTextField2, size2, false);
        configInput(jTextField3, size2, false);
        configInput(jTextField4, size2, false);
        makeCombos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(JPanel myPanel) {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        Mon = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        Them = new javax.swing.JToggleButton();

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MA GV");

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("T??n GV");

        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("?????a Ch???");

        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("S??T");

        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButton1.setBackground(new java.awt.Color(0, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Th??m");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Mon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MonActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("M??n");

        Them.setText("+");
        Them.setToolTipText("");
        Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemActionPerformed(evt, myPanel);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(myPanel);
        myPanel.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
                                .addGap(61, 61, 61)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField1)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                                .addGap(259, 259, 259)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 374, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(112, 112, 112)
                                                .addComponent(Mon, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(63, 63, 63)
                                .addComponent(Them)
                                .addGap(322, 322, 322))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(89, 89, 89)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Mon, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Them))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String MAGV = jTextField1.getText();
        String hoten = jTextField2.getText();
        String diachi = jTextField3.getText();
        String s??t = jTextField4.getText();
//        String tenMH = (String)(Mon.getSelectedItem());
//        String maMH
        System.out.println("" + MAGV);
        System.out.println("" + hoten);
        System.out.println("" + diachi);
        System.out.println("" + s??t);
        String regexMAGV = ".*([0-9]{0,9})";
        String regexHoTen = "^[A-Za-z???????????????????????????????????????????????????????????????????????????????????????????-???\\s]+$";
        String regexDiachi = "^[A-Za-z???????????????????????????????????????????????????????????????????????????????????????????-???\\s]+$";
        String regexS??T = "^0{1}[1-9]{1}[0-9]{8}$";
        AddTeacherBUS update = new AddTeacherBUS();
        if (MAGV.matches(regexMAGV) == true && hoten.matches(regexHoTen) == true && diachi.matches(regexDiachi) == true && s??t.matches(regexS??T) == true) {
            update.getValue(MAGV, hoten, diachi, s??t, ((subjectDTO) Mon.getSelectedItem()).getIdSubject());
        } else {
            JOptionPane.showMessageDialog(null, "B???n nh???p sai c?? ph??p th??ng tin.Xin vui l??ng nh???p l???i!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void MonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MonActionPerformed

    private void ThemActionPerformed(java.awt.event.ActionEvent evt, JPanel myPanel) {//GEN-FIRST:event_ThemActionPerformed
        // TODO add your handling code here:
        if (counter >= listOfComboBoxes.size()) {
            return;
        }

        //////////////////////////////////////////////////////////////////////////////
        //////////////// note : all this block could be moved to MakeCombos() ////////
        // (adding content and setting bounds could have been done when creating ////
        //the combo
        //add content to the combo
        ////////////////////////////////////////////////////////////////////////////
        /////////////////////// end of move-to-makeCombos() block //////////////////
        ////////////////////////////////////////////////////////////////////////////
        //add the combo to the combos panel
        listOfComboBoxes.get(counter).setBounds(xPosition, yPosition, width, height);

        //increment position
        xPosition = xPosition + 10;
        yPosition = yPosition + 10;
        myPanel.add(listOfComboBoxes.get(1));

        //set layout bounds to each combo
        //increment position and counter
        counter++;
    }//GEN-LAST:event_ThemActionPerformed

    private void makeCombos() {
        listOfComboBoxes = new ArrayList<JComboBox<subjectDTO>>();
        listOfComboBoxes.add(Mon);
//        System.out.println(listOfComboBoxes.size());
//        List<JComboBox<subjectDTO>> combos = new ArrayList<JComboBox<subjectDTO>>();
        JComboBox<subjectDTO> combo = new JComboBox<>(new subjectDTO[]{});
        listOfComboBoxes.add(combo);
        ArrayList<subjectDTO> namBus = new monHocBUS().getListMonHoc();
        namBus.forEach(cnsmr -> {
            combo.addItem(cnsmr);
            System.out.print(cnsmr);
        });
    }

    private void configInput(JTextField myTextField, Dimension size, boolean check) {
        myTextField.setFont(new Font("DENSE", Font.PLAIN, 16));
        myTextField.setPreferredSize(size);
        myTextField.setBorder(new javax.swing.border.LineBorder(new Color(206, 210, 214), 1));
        myTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                System.err.println("CLICK");
                myTextField.setBorder(new javax.swing.border.LineBorder(new Color(1, 122, 255), 1));
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                System.err.println("ENTER");
                myTextField.setBorder(new javax.swing.border.LineBorder(new Color(166, 170, 173), 1));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                myTextField.setBorder(new javax.swing.border.LineBorder(new Color(206, 210, 214), 1));
            }
        });
        if (check) {
            myTextField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
                @Override
                public void changedUpdate(javax.swing.event.DocumentEvent e) {
                    warn();
                }

                @Override
                public void removeUpdate(javax.swing.event.DocumentEvent e) {
                    warn();
                }

                @Override
                public void insertUpdate(javax.swing.event.DocumentEvent e) {
                    warn();
                }

                public void warn() {
                    try {
                        float num = Float.parseFloat(myTextField.getText());
                        if (num < 0 || num > 10) {
                            myTextField.setBorder(new javax.swing.border.LineBorder(new Color(232, 64, 64), 1));
                        } else {
                            myTextField.setBorder(new javax.swing.border.LineBorder(new Color(1, 122, 255), 1));
                        }
                    } catch (NumberFormatException e) {
                        myTextField.setBorder(new javax.swing.border.LineBorder(new Color(232, 64, 64), 1));
                    }
                }
            });
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new AddTeacher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<subjectDTO> Mon;
    private javax.swing.JToggleButton Them;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
