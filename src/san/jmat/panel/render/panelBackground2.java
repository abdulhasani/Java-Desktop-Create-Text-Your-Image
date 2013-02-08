/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.panel.render;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/**
 *
 * @author joker
 */
public class panelBackground2 extends JPanel{

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D create = (Graphics2D) g.create();
        //Penggambaran kotak
        //dimana shape ni merupakan interface 
        //dalam interface tersebut ada metode yang namanya Rectangle
        //jadi ini konsep polimorphymisme
        Shape shape=new Rectangle2D.Double(0, 0, getWidth(), getHeight());
        //buat objek Gradiaent dimana 
        //Kelas Paint sebagai tipe datanya
        Paint paint=new GradientPaint(
                getHeight(),getWidth(),Color.MAGENTA,getHeight(),0,Color.LIGHT_GRAY
                );
        //menggambar setPaint
        create.setPaint(paint);
        create.fill(shape);
        
        create.draw(shape);
        create.dispose();
    }
    
    
    
}
