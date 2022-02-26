import java.util.*;
import java.awt.event.MouseEvent; 
import java.awt.event.MouseListener; 
import javax.swing.JPanel; 
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Vector;
import java.awt.*;

public class Lienzo2 extends JPanel implements MouseListener {
    private Vector<Nodo> vectorNodos;
    private Vector<Enlace> vectorEnlaces;
    private Point p1, p2;

    public Lienzo2() {
        this.vectorNodos = new Vector<Nodo>();
        this.vectorEnlaces = new Vector<Enlace>();
        this.addMouseListener(this);
    }

    public void paint(Graphics g) {
        for(Nodo nodos: vectorNodos) {
            if(nodos.seleccionado)
                g.setColor(Color.GREEN);
            else 
                g.setColor(Color.RED);

            nodos.pintar(g);
        }
        
        g.setColor(Color.BLACK);

        for (Enlace enlace : vectorEnlaces)
            enlace.pintar(g);
    }

    public int estanSobrespuestos(int x1, int y1, int x2,  int y2, int r1, int r2){
        int distSq = (x1 - x2) * (x1 - x2) + 
                     (y1 - y2) * (y1 - y2); 
        int radSumSq = (r1 + r2) * (r1 + r2); 
        if (distSq == radSumSq) 
            return 1; 
        else if (distSq > radSumSq) 
            return -1; 
        else
            return 0; 
    }

    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) {
            this.vectorNodos.add(new Nodo(e.getX(), e.getY(), 80));
            repaint();
        }

        if(vectorNodos.size() > 1) {   
            Nodo nodoActual = vectorNodos.lastElement();

            p1 = new Point(nodoActual.getX(), nodoActual.getY());
            
            for(int i = 0 ; i < vectorNodos.size() - 1 ; i++){
                int val = estanSobrespuestos(nodoActual.getX(), nodoActual.getY(), vectorNodos.get(i).getX(), vectorNodos.get(i).getY(),nodoActual.getD()/2, vectorNodos.get(i).getD()/2);

                if(val == 0){
                    p2 = new Point(vectorNodos.get(i).getX(), vectorNodos.get(i).getY());
                    this.vectorEnlaces.add(new Enlace(p1.x,p1.y,p2.x,p2.y));
                    repaint();
                }
            }

            p1 = null;
            p2 = null;
        }
    }
}