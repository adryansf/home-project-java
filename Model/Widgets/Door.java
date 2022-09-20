package Model.Widgets;

import java.awt.Dimension;
import java.awt.Point;

import Model.Widget;

public class Door extends Widget {
  String direction;

  public Door(Point pos, Dimension dim, String direction){
    super(pos, dim, "door");
    this.direction = direction;
  }

  public String getDirection(){
    return this.direction;
  }
}
