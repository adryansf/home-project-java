package Controller;

import java.awt.Dimension;
import java.awt.Point;

import App.App;
import Model.Room;
import View.DrawArea;

public class RoomController {
  public static void create(Point location, Dimension dimensions){
    App.rooms.add(new Room(location, dimensions));
    DrawArea.refresh();
  }

  public static void delete(){
    if(App.rooms.isEmpty()) return;
    App.rooms.remove(App.rooms.size() - 1);
    DrawArea.refresh();
  }
}
