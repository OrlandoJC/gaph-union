import java.awt.event.*; 
import java.awt.*; 
import javax.swing.*; 

public class Nodo {
    private int x, y, r;
    boolean seleccionado = false;
    boolean radio = false;
    public  static int d;

    public Nodo(int x, int y) {
        this.x = x;
        this.y = y;
        this.d = 120;
    }

     public Nodo(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.radio = true;
        this.d =  r * 2;
    }

    public void setPintado(boolean e) {
        this.seleccionado = e;
    }

    public void pintar(Graphics g){

        g.fillArc( this.x-10, this.y-10, 20, 20,  0, 360);

        if(radio) {
            g.setColor(Color.BLUE);
            g.drawOval(this.x - d/2, this.y - d/2, d, d);
        }
    }

    public static int getD() {
        return d;
    }

    public int getX(){
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY(){
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}