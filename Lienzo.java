import java.util.*;
import java.awt.event.MouseEvent; 
import java.awt.event.MouseListener; 
import javax.swing.JPanel; 
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Vector;
import java.awt.*;


public class Lienzo extends JPanel implements MouseListener {
    private Vector<Nodo> vectorNodos;
    private Vector<Enlace> vectorEnlaces;
    private Point p1, p2;

    public Lienzo() {
        this.vectorNodos = new Vector<Nodo>();
        this.vectorEnlaces = new Vector<Enlace>();
        this.addMouseListener(this);
    }

    public void paint(Graphics g) {
        for(Nodo nodos: vectorNodos) {
            if(nodos.seleccionado) {
                g.setColor(Color.GREEN);
            }else {
                 g.setColor(Color.RED);
            }
            nodos.pintar(g);
        }
        
        g.setColor(Color.BLACK);

        for (Enlace enlace : vectorEnlaces){    
            enlace.pintar(g);
        }
    }

    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) {
            this.vectorNodos.add(new Nodo(e.getX(), e.getY()));
            repaint();
        }

        if (e.getButton() == MouseEvent.BUTTON3){
            for (Nodo nodo : vectorNodos){
    
                if (new Rectangle(nodo.getX() - Nodo.getD()/2, nodo.getY() - Nodo.getD()/2, Nodo.getD(),Nodo.getD()).contains(e.getPoint())){
                    if (p1 == null){
                        p1 = new Point(nodo.getX(), nodo.getY());
                        nodo.setPintado(true);
                        repaint();
                    }else{
                        nodo.setPintado(true);
                        p2 = new Point(nodo.getX(), nodo.getY());
                        this.vectorEnlaces.add(new Enlace(p1.x, p1.y, p2.x, p2.y));
                        repaint();
                        p1 = null;
                        p2 =null;
                    }
                }
            }
        }

    }
}