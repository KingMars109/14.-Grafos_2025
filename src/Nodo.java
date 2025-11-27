
import java.awt.Point;

public class Nodo {
    private String nombre;
    private int x, y;
    private static final int DIAMETRO = 30;

    public Nodo(String nombre, int x, int y) {
        this.nombre = nombre;
        this.x = x;
        this.y = y;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public Point getCentro() {
        return new Point(x + DIAMETRO / 2, y + DIAMETRO / 2);
    }
    
    public static int getDiametro() {
        return DIAMETRO;
    }
}
