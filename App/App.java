package App;
import java.util.ArrayList;

import Model.House;
import Model.Room;
import Model.Widget;
import View.Window;


public class App  {
  public static House house;
  public static ArrayList<Room> rooms = new ArrayList<Room>();
  public static ArrayList<Widget> widgets = new ArrayList<Widget>();
  
  public App(){
    new Window();
  }
}
