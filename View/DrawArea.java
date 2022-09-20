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
import Model.Widgets.Door;
import Model.Widgets.Way;
import Model.Widgets.Window;

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
          int widgetWidth = widget.getDimension().width;
          int widgetHeight = widget.getDimension().height;
          String ori = "";
          String type = widget.getType();
          if(type == "way"){
            ori = ((Way) widget).getOrientation();
          }else if(type == "window"){
            ori = ((Window) widget).getOrientation();
          }

          if(ori == "Vertical"){
            widgetWidth = widget.getDimension().height;
            widgetHeight = widget.getDimension().width;
          }
          
          switch (type){
            case "door":
              String direction = ((Door) widget).getDirection();
              int startAngle = 0;
              if(direction == "Cima"){
                startAngle = 270;
                g.setColor(Color.WHITE);
                g.fillArc(pos.x - Math.round(widgetWidth/2), pos.y - (widgetHeight/2), widgetWidth, widgetHeight, startAngle, 90);
                g.setColor(Color.BLACK);
                g.drawArc(pos.x - Math.round(widgetWidth/2), pos.y - (widgetHeight/2), widgetWidth, widgetHeight, startAngle, 90);
                g.drawLine(pos.x, pos.y, pos.x, pos.y+(widgetHeight/2));
                
              }else if(direction == "Esquerda"){
                startAngle = 270;
                g.setColor(Color.WHITE);
                g.fillArc(pos.x - Math.round(widgetWidth/2), pos.y - (widgetHeight/2), widgetWidth, widgetHeight, startAngle, 90);
                g.setColor(Color.BLACK);
                g.drawArc(pos.x - Math.round(widgetWidth/2), pos.y - (widgetHeight/2), widgetWidth, widgetHeight, startAngle, 90);
                g.drawLine(pos.x, pos.y, pos.x+(widgetWidth/2), pos.y);
              }else if(direction == "Baixo"){
                startAngle = 0;
                g.setColor(Color.WHITE);
                g.fillArc(pos.x - Math.round(widgetWidth/2), pos.y - (widgetHeight/2), widgetWidth, widgetHeight, startAngle, 90);
                g.setColor(Color.BLACK);
                g.drawArc(pos.x - Math.round(widgetWidth/2), pos.y - (widgetHeight/2), widgetWidth, widgetHeight, startAngle, 90);
                g.drawLine(pos.x, pos.y, pos.x, pos.y-(widgetHeight/2) );
              }else if(direction == "Direita"){
                startAngle = 180;
                g.setColor(Color.WHITE);
                g.fillArc(pos.x - Math.round(widgetWidth/2), pos.y - (widgetHeight/2), widgetWidth, widgetHeight, startAngle, 90);
                g.setColor(Color.BLACK);
                g.drawArc(pos.x - Math.round(widgetWidth/2), pos.y - (widgetHeight/2), widgetWidth, widgetHeight, startAngle, 90);
                g.drawLine(pos.x, pos.y, pos.x-(widgetWidth/2), pos.y);
              }
              break;
            case "way":
              g.setColor(Color.MAGENTA);
              g.drawRect(pos.x, pos.y , widgetWidth, widgetHeight);
              g.setColor(Color.WHITE);
              if(ori == "Horizontal"){
                g.fillRect(pos.x, pos.y + 1, widgetWidth+1, widgetHeight-1);
              }else{
                g.fillRect(pos.x+1, pos.y, widgetWidth-1, widgetHeight+1);
              }
              break;
            case "window":
              g.setColor(Color.GREEN);
              g.drawRect(pos.x, pos.y, widgetWidth, widgetHeight);
              break;
          }      
        }
      }
  }
}
