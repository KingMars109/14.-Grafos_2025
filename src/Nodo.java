
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jb
 */
public class Nodo extends JPanel implements MouseListener, MouseMotionListener{
    private String Nombre;
    private int x1, y1;
    private boolean b = false;
    private Graphics lienzo;
    private Arista a;
    private int pos = -1;
    
    public Nodo (char Nombre, Graphics lienzo){
        this.Nombre = Character.toString(Nombre);
        this.lienzo = lienzo;
        Point p;
        p = MouseInfo.getPointerInfo().getLocation();
        this.setBounds (p.x-30, p.y-112, 31, 31);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        a = new Arista();
        this.pos = Principal.c;
        Principal.c++;
        setVisible(true);
    }
    
    public void dibuja (Graphics g){
        g.drawOval(0, 0, 30, 30);
        Font FuenteV = getFont();
        Font FuenteNueva = new  Font ("Monospaced", Font.BOLD, 16);
        g.setFont(FuenteNueva);
        g.setColor(Color.BLUE);
        g.drawString(Nombre, 12, 19);
        g.setFont(FuenteV);
        this.setName(this.Nombre);
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        Point p;
        p = this.getLocation();
        if (!Principal.edoArista){
            Principal.x1 = p.x;
            Principal.y1 = p.y;
            Principal.edoArista = true;
            Principal.i = this.pos;
        } else {
            Principal.x2 = p.x;
            Principal.y2 = p.y;
            a.linea (lienzo,"e"+Principal.indArista,Principal.x1+15, Principal.y1 +15, Principal.x2 + 15, Principal.y2 + 15);
            Principal.indArista++;
            Principal.edoArista = false;
            Principal.j = this.pos;
            Principal.MAdyacencia[Principal.i][Principal.j] = true;
            Principal.MAdyacencia[Principal.j][Principal.i] = true;
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
        
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        
    }
    
}
