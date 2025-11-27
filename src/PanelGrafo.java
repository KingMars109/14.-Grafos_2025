
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class PanelGrafo extends JPanel implements MouseListener, MouseMotionListener {
    
    private List<Nodo> nodos;
    private List<Arista> aristas;
    private int modo; // 0=Nada, 1=Nodo, 2=Arista
    private Nodo nodoSeleccionado1;
    private char[] nombres = {'A','B','C','D','E','F','G','H','I','J','K',
                              'L','M','N','O','P','Q','R','S','T','U','V',
                              'W','X','Y','Z'};
    private int indiceNombre = 0;
    
    public static final int MODO_NADA = 0;
    public static final int MODO_NODO = 1;
    public static final int MODO_ARISTA = 2;

    public PanelGrafo() {
        this.nodos = new ArrayList<>();
        this.aristas = new ArrayList<>();
        this.modo = MODO_NADA;
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(800, 600));
    }

    public void setModo(int modo) {
        this.modo = modo;
        this.nodoSeleccionado1 = null; // Reset selection when changing mode
        repaint();
    }
    
    public int getModo() {
        return modo;
    }

    public void limpiar() {
        nodos.clear();
        aristas.clear();
        indiceNombre = 0;
        nodoSeleccionado1 = null;
        repaint();
    }
    
    public boolean[][] getMatrizAdyacencia() {
        int n = nodos.size();
        boolean[][] matriz = new boolean[n][n];
        for (Arista a : aristas) {
            int i = nodos.indexOf(a.getNodo1());
            int j = nodos.indexOf(a.getNodo2());
            if (i >= 0 && j >= 0) {
                matriz[i][j] = true;
                matriz[j][i] = true;
            }
        }
        return matriz;
    }
    
    public List<Nodo> getNodos() {
        return nodos;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibujar aristas
        g2.setColor(Color.RED);
        for (Arista a : aristas) {
            Point p1 = a.getNodo1().getCentro();
            Point p2 = a.getNodo2().getCentro();
            g2.drawLine(p1.x, p1.y, p2.x, p2.y);
            
            // Dibujar nombre de la arista
            g2.setColor(Color.BLACK);
            int midX = (p1.x + p2.x) / 2;
            int midY = (p1.y + p2.y) / 2;
            g2.drawString(a.getNombre(), midX, midY);
            g2.setColor(Color.RED);
        }

        // Dibujar nodos
        for (Nodo n : nodos) {
            g2.setColor(Color.WHITE);
            g2.fillOval(n.getX(), n.getY(), Nodo.getDiametro(), Nodo.getDiametro());
            g2.setColor(Color.BLACK);
            g2.drawOval(n.getX(), n.getY(), Nodo.getDiametro(), Nodo.getDiametro());
            
            g2.setColor(Color.BLUE);
            g2.drawString(n.getNombre(), n.getX() + 10, n.getY() + 20);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (modo == MODO_NODO) {
            if (indiceNombre < nombres.length) {
                String nombre = String.valueOf(nombres[indiceNombre++]);
                nodos.add(new Nodo(nombre, e.getX() - Nodo.getDiametro()/2, e.getY() - Nodo.getDiametro()/2));
                repaint();
            }
        } else if (modo == MODO_ARISTA) {
            Nodo nodoClickeado = getNodoEn(e.getPoint());
            if (nodoClickeado != null) {
                if (nodoSeleccionado1 == null) {
                    nodoSeleccionado1 = nodoClickeado;
                } else {
                    if (nodoSeleccionado1 != nodoClickeado) {
                        String nombreArista = "e" + (aristas.size() + 1);
                        aristas.add(new Arista(nodoSeleccionado1, nodoClickeado, nombreArista));
                        nodoSeleccionado1 = null;
                        repaint();
                    }
                }
            }
        }
    }
    
    private Nodo getNodoEn(Point p) {
        for (Nodo n : nodos) {
            if (p.x >= n.getX() && p.x <= n.getX() + Nodo.getDiametro() &&
                p.y >= n.getY() && p.y <= n.getY() + Nodo.getDiametro()) {
                return n;
            }
        }
        return null;
    }

    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseDragged(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {}
}
