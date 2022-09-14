package View;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Window extends JFrame {
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

  public Window(){
    this.setLayout(null);
    this.setTitle("Trabalho Casa");
    this.setSize(screenSize.width,screenSize.height);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setResizable(false);
    this.setVisible(true);
    Container container = this.getContentPane();
    DrawArea drawArea = new DrawArea(screenSize);
    BottomMenu bottomMenu = new BottomMenu(screenSize);


    // Render
    container.add(drawArea);
    container.add(bottomMenu);
    
  }
}
