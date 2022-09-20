package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import Controller.HouseController;
import Controller.RoomController;
import Controller.WidgetController;

public class BottomMenu extends JPanel {
  int width;
  int height;

  NewHouseFormFrame newHouseFormFrame;
  NewRoomFormFrame newRoomFormFrame;
  NewWidgetFormFrame newWidgetFormFrame;

  public BottomMenu(Dimension screenSize){
    this.width = (int) Math.round(screenSize.width);
    this.height = (int) Math.round(screenSize.height - (screenSize.height * 0.82));
    this.setLayout(new FlowLayout(1, 10, 20));
    this.setLocation(0, (int)Math.round(screenSize.height * 0.82));
    this.setSize(width, height);
    this.setBackground(Color.DARK_GRAY);
    
    JButton createHouseButton = this.createButton("CRIAR CASA");
    JButton createRoomButton = this.createButton("CRIAR CÔMODO");
    JButton createWidgetButton = this.createButton("CRIAR VÃO");
    JButton deleteHouseButton = this.createButton("DELETAR CASA");
    deleteHouseButton.setBackground(Color.RED);
    deleteHouseButton.setForeground(Color.WHITE);
    JButton undoRoomButton = this.createButton("DESFAZER CÔMODO");
    undoRoomButton.setBackground(Color.RED);
    undoRoomButton.setForeground(Color.WHITE);
    JButton undoWidgetButton = this.createButton("DESFAZER VÃO");
    undoWidgetButton.setBackground(Color.RED);
    undoWidgetButton.setForeground(Color.WHITE);


    createHouseButton.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        if(newHouseFormFrame == null) newHouseFormFrame = new NewHouseFormFrame();
        newHouseFormFrame.setVisible(true);
      }
    });

    createRoomButton.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        if(newRoomFormFrame == null) newRoomFormFrame = new NewRoomFormFrame();
        newRoomFormFrame.setVisible(true);
      }
    });

    createWidgetButton.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        if(newWidgetFormFrame == null) newWidgetFormFrame = new NewWidgetFormFrame();
        newWidgetFormFrame.setVisible(true);
      }
    });

    deleteHouseButton.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        HouseController.delete();
      }
    });

    undoRoomButton.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        RoomController.delete();
      }
    });

    undoWidgetButton.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        WidgetController.delete();
      }
    });


    // Render
    this.add(createHouseButton);
    this.add(createRoomButton);
    this.add(createWidgetButton);
    this.add(new JSeparator(JSeparator.VERTICAL));
    this.add(deleteHouseButton);
    this.add(undoRoomButton);
    this.add(undoWidgetButton);
    this.setVisible(true);
  }

  private JButton createButton(String name){
    JButton button = new JButton(name);
    button.setVisible(true);
    return button;
  }
}
