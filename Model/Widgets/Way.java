package Model.Widgets;

import java.awt.Dimension;
import java.awt.Point;

import Model.Widget;

public class Way extends Widget {
  String orientation;

  public Way(Point pos, Dimension dim, String orientation){
    super(pos, dim, "way");
    this.orientation = orientation;
  }

  public String getOrientation(){
    return this.orientation;
  }
  
}
