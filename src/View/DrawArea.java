package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JPanel;

import Model.House;

public class DrawArea extends JPanel {
  static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  int width;
  int height;
  int padding = 10;

  static DrawArea current;
  static House house;


  public DrawArea(Dimension screenSize){
    this.width = (int) Math.round(screenSize.width);
    this.height = (int) Math.round(screenSize.height * 0.82);
    this.setLocation(0,0);
    this.setSize(width, height);
    this.setBackground(Color.WHITE);
    this.setVisible(true);  
    DrawArea.current = this;  

  }

  public static int getSizeX(){
    return screenSize.width;
  }

  public static int getSizeY(){
    return (int) Math.round(screenSize.height * 0.82);
  }

  public static void setHouse(House newHouse){
    house = newHouse;
    if(current != null){
      current.refresh();
    }
  }

  private void refresh(){
    this.revalidate();
    this.repaint();
  }

  public void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.setColor(Color.RED);
      if(house != null){
        g.drawRect(house.getPosition().x, house.getPosition().y, house.getDimension().width, house.getDimension().height);
      }
      
  }
}
