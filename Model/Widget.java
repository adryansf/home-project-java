package Model;

import java.awt.Dimension;
import java.awt.Point;

// Tem que especializar

public class Widget {
  Point position;
  Dimension dimension;
  String type;
  

  public Widget(Point pos, Dimension dim, String type){
    this.position = pos;
    this.dimension = dim;
    this.type = type;
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
}
