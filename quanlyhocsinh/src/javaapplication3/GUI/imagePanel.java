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
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
//ww  w  .  j av a2s  . com
import javax.swing.ImageIcon;
import javax.swing.JPanel;
class imagePanel extends JPanel {

  private Image img;

  public imagePanel(String img) {
    this(new ImageIcon(img).getImage());
  }

  public imagePanel(Image img) {
    this.img = img;
    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
    setPreferredSize(size);
    setMinimumSize(size);
    setMaximumSize(size);
    setSize(size);
    setLayout(null);
  }

  public void paintComponent(Graphics g) {
    g.drawImage(img, 0, 0, null);
  }

}