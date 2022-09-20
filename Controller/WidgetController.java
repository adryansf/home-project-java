package Controller;

import java.awt.Dimension;
import java.awt.Point;

import App.App;
import Model.Widget;
import View.DrawArea;

public class WidgetController {
  public static void create(Point location, Dimension dimensions, String type, String orientation){
    App.widgets.add(new Widget(location, dimensions, type, orientation));
    DrawArea.refresh();
  }

  public static void delete(){
    if(App.widgets.isEmpty()) return;
    App.widgets.remove(App.widgets.size() - 1);
    DrawArea.refresh();
  }
}
