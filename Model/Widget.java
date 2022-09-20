package Model;

import java.awt.Dimension;
import java.awt.Point;

// Tem que especializar

public class Widget {
  Point position;
  Dimension dimension;
  String type;
  String orientation;

  public Widget(Point pos, Dimension dim, String type, String orientation){
    this.position = pos;
    this.dimension = dim;
    this.type = type;
    this.orientation = orientation;
  }

  public Point getPosition(){
    return this.position;
  }

  public Dimension getDimension(){
    return this.dimension;
  }

  public String getType(){
    return this.type;
  }

  public String getOrientation(){
    return this.orientation;
  }
}
