/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.panel.render;

import java.awt.AlphaComposite;
import java.awt.Dimension; 
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import san.jmat.kelas.CreateText;
import san.jmat.kelas.PackText;

/**
 *
 * @author joker
 */
public class panelMain extends JPanel implements MouseMotionListener, MouseListener {
    //untuk gambar latar
    private Image image = new ImageIcon(getClass().getResource("/san/jmat/image/default.jpg")).getImage();
    //Background hitang belakang gambar latar
    private BufferedImage bufferedImage;
    private Dimension size = new Dimension(100, 100);
    private CreateText createText;
    private PackText packText=null;
    
    public panelMain() {
        
        this.setPreferredSize(size);
        this.setSize(size);
        this.setVisible(true);
        addMouseMotionListener(this);
        addMouseListener(this);
    }
    
    public panelMain(Dimension z) {
        this.setPreferredSize(z);
        this.setSize(z);
        this.setVisible(true);
        addMouseMotionListener(this);
        addMouseListener(this);
        
    }
    
    public void setPackText(PackText packText) {
        this.packText = packText;
        this.repaint();
    }
    
    public void resize() {
        this.size = this.packText.getSize();
        this.setSize(size);
        this.setPreferredSize(size);
        this.repaint();
    }
    
    public void setText(CreateText createText) {
        this.createText = new CreateText();
        this.createText = createText;
        this.repaint();
    }
    
    public BufferedImage getBufferedImage() {
        return bufferedImage.getSubimage(0, 0, packText.getSize().width, packText.getSize().height);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        
        Graphics2D g2 = (Graphics2D) g;
        //buat objek bufferimage dengan ukuran sesuai JPanel dan warna rgb
        bufferedImage = new BufferedImage(getWidth(),getHeight(), BufferedImage.TYPE_INT_RGB);
        //panggil method createGraphic denga return value Objek Graphic2D
        //sercara logika tidak mungkin menggambarnya langsung
        //bufferedImagae.drawImage untuk menggambar 2D 
        //pasti menggunakan kelas Graphics2D
        Graphics2D createGraphics = bufferedImage.createGraphics();
        createGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //pertama gambarkan latar dasar 
        //secara logika
        //kalau kita menggambarkan gambar lebih dahulu nanti 
        //akan tertutup oleh gambar latas dasarnya
        createGraphics.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        if (packText != null) {
            
           packText.gambarText(createGraphics);
        }
        if (createText != null) {
            
            createText.gambarText(createGraphics);
        }
        //gambar yang diinputkan
        g2.drawImage(bufferedImage, 0,0,this);
        this.repaint();
        g2.dispose();
        
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        if (packText != null) {
            if (packText.getTextSelection() != -1) {
                packText.getText(packText.getTextSelection()).move((int) e.getPoint().getX(), (int) e.getPoint().getY());
            }
            
        }
        this.repaint();
    }
    
    @Override
    public void mouseMoved(MouseEvent e) {
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
    }
}
