package Controller;

import java.awt.Dimension;
import java.awt.Point;

import App.App;
import Model.House;
import View.DrawArea;

public class HouseController {
  public static void create(Point location, Dimension dimensions){
    App.house = new House(location, dimensions);
    DrawArea.refresh();
  }

  public static void delete(){
    if(App.house == null) return;
    App.house = null;
    App.rooms.clear();
    App.widgets.clear();
    DrawArea.refresh();
  }
}
