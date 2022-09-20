package Model;

import java.awt.Dimension;
import java.awt.Point;

public class Room {
  Point position;
  Dimension dimension;

  public Room(Point pos, Dimension dim){
    this.position = pos;
    this.dimension = dim;
  }

  public Point getPosition(){
    return this.position;
  }

  public Dimension getDimension(){
    return this.dimension;
  }
}
