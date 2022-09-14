package Controller;

import java.awt.Dimension;
import java.awt.Point;

import Model.House;
import View.DrawArea;

public class HouseController {
  public static void create(Point location, Dimension dimensions){
    House newHouse = new House(location, dimensions);
    DrawArea.setHouse(newHouse);
  }
}
