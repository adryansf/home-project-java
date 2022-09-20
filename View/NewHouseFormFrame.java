package View;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import Controller.HouseController;


public class NewHouseFormFrame extends JFrame {
  private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  JTextField fieldPosX;
  JTextField fieldPosY;
  JTextField fieldWidth;
  JTextField fieldHeight;
  JButton submitButton;
  JTextPane errorMessage;
  
  public NewHouseFormFrame(){
    this.setTitle("CRIAR CASA");
    this.setSize(300,200);
    this.setLocation((int)Math.round((screenSize.width * 0.5) - 150), (int)Math.round((screenSize.height * 0.5) - 100));
    this.setResizable(false);
    this.setLayout(null);

    JLabel labelPosX = new JLabel("POS. X:");
    labelPosX.setSize(60,20);
    labelPosX.setLocation(10,20);
    this.fieldPosX = new JTextField();
    labelPosX.setLabelFor(this.fieldPosX);
    this.fieldPosX.setSize(50,20);
    this.fieldPosX.setLocation(75,20);

    JLabel labelPosY = new JLabel("POS. Y:");
    labelPosY.setSize(60,20);
    labelPosY.setLocation(150,20);
    this.fieldPosY = new JTextField();
    labelPosY.setLabelFor(this.fieldPosY);
    this.fieldPosY.setSize(50,20);
    this.fieldPosY.setLocation(210,20);

    JLabel labelWidth = new JLabel("Comp.:");
    labelWidth.setSize(60,20);
    labelWidth.setLocation(10,60);
    this.fieldWidth = new JTextField();
    labelWidth.setLabelFor(this.fieldWidth);
    this.fieldWidth.setSize(50,20);
    this.fieldWidth.setLocation(75,60);

    JLabel labelHeight = new JLabel("Larg.:");
    labelHeight.setSize(60,20);
    labelHeight.setLocation(150,60);
    this.fieldHeight = new JTextField();
    labelHeight.setLabelFor(this.fieldHeight);
    this.fieldHeight.setSize(50,20);
    this.fieldHeight.setLocation(210,60);

    this.errorMessage = new JTextPane();
    this.errorMessage.setEditable(false);
    this.errorMessage.setForeground(Color.RED);
    this.errorMessage.setLocation(10,100);
    this.errorMessage.setSize(280, 25);

    
    this.submitButton = new JButton("CRIAR");
    this.submitButton.setSize(100,25);
    this.submitButton.setLocation(100,130);
    this.registerEvent();

    
    // Render
    this.add(labelPosX);
    this.add(fieldPosX);
    this.add(labelPosY);
    this.add(fieldPosY);
    this.add(labelWidth);
    this.add(fieldWidth);
    this.add(labelHeight);
    this.add(fieldHeight);
    this.add(errorMessage);
    this.add(submitButton);

    this.setVisible(false);
  }

  private void registerEvent(){
    
      this.submitButton.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
          try{
            int posX = Integer.parseInt(fieldPosX.getText());
            if(posX > DrawArea.getSizeX() - 1 - (DrawArea.padding * 2)){
              errorMessage.setText("O valor X máx. é "+ Integer.toString(DrawArea.getSizeX()- 1 - (DrawArea.padding * 2)));
              return;
            }
    
            int posY = Integer.parseInt(fieldPosY.getText());
            if(posY > DrawArea.getSizeY() - 21){
              errorMessage.setText("O valor Y máx. é "+ Integer.toString(DrawArea.getSizeY()- 1 - (DrawArea.padding * 2)));
              return;
            }
    
            int width = Integer.parseInt(fieldWidth.getText());
            if(width > DrawArea.getSizeX() - posX - (DrawArea.padding * 2)){
              errorMessage.setText("O Comp.Máx. é "+Integer.toString(DrawArea.getSizeX() - posX - (DrawArea.padding * 2)) + " para esta pos.X");
              return;
            }
    
            int height = Integer.parseInt(fieldHeight.getText());
            if(height > DrawArea.getSizeY() - posY - (DrawArea.padding * 2)){
              errorMessage.setText("A Larg.Máx. é "+Integer.toString(DrawArea.getSizeY() - posY - (DrawArea.padding * 2)) + " para esta pos.Y");
              return;
            }
    
        
            HouseController.create(new Point(posX, posY), new Dimension(width, height));
    
          
            setVisible(false);
          }catch(NumberFormatException erro){
            errorMessage.setText("Algum campo está incorreto");
          }
        }
      });
  }

  public void paint(Graphics g) {
    errorMessage.setText("");
    super.paint(g);
  }
}
