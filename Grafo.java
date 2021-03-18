import javax.swing.JFrame;

class Grafo {

    public static void main(String[] args) {
        JFrame ventana = new JFrame("grafo");
        ventana.add(new Lienzo2());
        ventana.setSize(800, 800);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }

}