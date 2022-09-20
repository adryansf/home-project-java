package Controller;

import java.awt.Dimension;
import java.awt.Point;

import App.App;
import Model.Widgets.Door;
import Model.Widgets.Way;
import Model.Widgets.Window;
import View.DrawArea;

public class WidgetController {
  public static void create(Point location, Dimension dimensions, String type, String orientation){
    switch (type){
      case "window":
       App.widgets.add(new Window(location, dimensions, orientation));
       break;
      case "way":
        App.widgets.add(new Way(location, dimensions, orientation));
        break;
    }
    DrawArea.refresh();
  }

  public static void create(Point location, Dimension dimensions, String direction){
    App.widgets.add(new Door(location, dimensions, direction));
    DrawArea.refresh();
  }

  public static void delete(){
    if(App.widgets.isEmpty()) return;
    App.widgets.remove(App.widgets.size() - 1);
    DrawArea.refresh();
  }
}
