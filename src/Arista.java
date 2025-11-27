
import java.awt.Color;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jb
 */
public class Arista {
    public void linea (Graphics g, String Nombre, int x1, int y1, int x2, int y2){
        g.setColor(Color.RED);
        g.drawLine(x1, y1, x2, y2);
        g.setColor(Color.BLACK);
        g.drawString(Nombre, ((x1-x2)/2)+x2, ((y1-y2)/2)+y2);
    }
}
