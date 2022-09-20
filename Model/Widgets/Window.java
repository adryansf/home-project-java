package Model.Widgets;

import java.awt.Dimension;
import java.awt.Point;

import Model.Widget;

public class Window extends Widget {
  String orientation;

  public Window(Point pos, Dimension dim, String orientation){
    super(pos, dim, "window");
    this.orientation = orientation;
  }

  public String getOrientation(){
    return this.orientation;
  }
}
