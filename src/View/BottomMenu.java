package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BottomMenu extends JPanel {
  int width;
  int height;

  public BottomMenu(Dimension screenSize){
    this.width = (int) Math.round(screenSize.width);
    this.height = (int) Math.round(screenSize.height - (screenSize.height * 0.82));
    this.setLayout(new FlowLayout(1, 10, 20));
    this.setLocation(0, (int)Math.round(screenSize.height * 0.82));
    this.setSize(width, height);
    this.setBackground(Color.DARK_GRAY);
    
    JButton createHouseButton = this.createButton("CRIAR CASA");
    JButton createRoomButton = this.createButton("CRIAR CÔMODO");
    JButton createExtraButton = this.createButton("CRIAR VÃO");

    createHouseButton.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        new FormFrame("CRIAR CASA", "house");
      }
    });


    // Render
    this.add(createHouseButton);
    this.add(createRoomButton);
    this.add(createExtraButton);
    this.setVisible(true);
  }

  private JButton createButton(String name){
    JButton button = new JButton(name);
    button.setVisible(true);
    return button;
  }
}
