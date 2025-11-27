
public class Arista {
    private Nodo nodo1;
    private Nodo nodo2;
    private String nombre;

    public Arista(Nodo nodo1, Nodo nodo2, String nombre) {
        this.nodo1 = nodo1;
        this.nodo2 = nodo2;
        this.nombre = nombre;
    }

    public Nodo getNodo1() {
        return nodo1;
    }

    public void setNodo1(Nodo nodo1) {
        this.nodo1 = nodo1;
    }

    public Nodo getNodo2() {
        return nodo2;
    }

    public void setNodo2(Nodo nodo2) {
        this.nodo2 = nodo2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
