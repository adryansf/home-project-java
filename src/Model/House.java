package Model;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JPanel;

public class House extends JPanel {
  Point position;
  Dimension dimension;

  public House(Point pos, Dimension dim){
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