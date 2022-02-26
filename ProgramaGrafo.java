  
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.*;


public class ProgramaGrafo {

  public static void main(String[] args) {
    JFrame frame = new JFrame("NUEVA VENTANA");
  
    frame.setLocation(500, 400);
    frame.add(new JLabel("ELIJA EL MODO:"));

    JButton buttonA = new JButton("A");
    JButton buttonB = new JButton("B");

    buttonA.addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e){  
         JFrame ventana = new JFrame("grafo");
          ventana.add(new Lienzo());
          ventana.setSize(800, 900);
          ventana.setLocation(600, 600);
          ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          ventana.setVisible(true);   
      }  
    });  

   buttonB.addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e){  
          JFrame ventana = new JFrame("grafo");
          ventana.add(new Lienzo2());
          ventana.setSize(800, 900);
          ventana.setLocation(600, 600);
          ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          ventana.setVisible(true);   
      }  
    });  
    
    frame.add(buttonA);
    frame.add(buttonB);
    frame.setLocation(600, 600);
    frame.setLayout(new GridLayout( 3,  1, 10, 10));
    frame.pack();
    frame.setSize(300, 300);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}