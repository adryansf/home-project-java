package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JPanel;

import App.App;
import Model.House;
import Model.Room;
import Model.Widget;

public class DrawArea extends JPanel {
  static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  public static int padding = 10;
  int width;
  int height;
  

  static DrawArea current;


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


  public static void refresh(){
    if(current == null) return;
    current.revalidate();
    current.repaint();
  }

  public void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.setColor(Color.RED);

      House house = App.house;

      if(house != null){
        g.drawRect(house.getPosition().x + padding, house.getPosition().y + padding, house.getDimension().width, house.getDimension().height);
      }
      
      if(!App.rooms.isEmpty()){
        for(Room room: App.rooms){
          g.setColor(Color.BLUE);
          g.drawRect(room.getPosition().x + padding, room.getPosition().y + padding, room.getDimension().width, room.getDimension().height);
        }
      }

      if(!App.widgets.isEmpty()){
        for(Widget widget: App.widgets){
          Point pos = new Point(widget.getPosition().x + padding, widget.getPosition().y + padding);
          Dimension dim = widget.getDimension();
          String ori = widget.getOrientation();
          if(ori == "Vertical"){
            dim.setSize(widget.getDimension().height, widget.getDimension().width);
          }

          String type = widget.getType();
          switch (type){
            case "door":
              g.setColor(Color.BLACK);
              g.drawRect(pos.x, pos.y, dim.width, dim.height);
              break;
            case "way":
              g.setColor(Color.MAGENTA);
              g.drawRect(pos.x, pos.y , dim.width, dim.height);
              g.setColor(Color.WHITE);
              if(ori == "Horizontal"){
                g.drawRect(pos.x, pos.y, 1, dim.height);
                g.drawRect(pos.x + dim.width, pos.y, 1, dim.height);
              }else{
                g.drawRect(pos.x, pos.y, dim.width, 1);
                g.drawRect(pos.x, pos.y + dim.height, dim.width, 1);
              }
              break;
            case "window":
              g.setColor(Color.GREEN);
              g.drawRect(pos.x, pos.y, dim.width, dim.height);
              break;
          }      
        }
      }
  }
}
