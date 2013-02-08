/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.kelas;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;

/**
 *
 * @author joker
 */
public class CreateText {
    private String text="Java Master";
    private int X=20; 
    private int Y=100;
    private int newX=0;
    private int newY=0;
    private int XX=0;
    private int YY=0;
    
    private Color color=new Color(255, 0, 0);
    private int sizeFont=20;
    private String fontDefault="Times New Roman";
    private Font font=new Font(fontDefault, Font.PLAIN, sizeFont);

    public CreateText() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getSizeFont() {
        return sizeFont;
    }

    public void setSizeFont(int sizeFont) {
        this.sizeFont = sizeFont;
        font=new Font(fontDefault, Font.PLAIN, this.sizeFont);
    }

    public String getFontDefault() {
        return fontDefault;
    }

    public void setFontDefault(String fontDefault) {
        this.fontDefault = fontDefault;
        font=new Font(this.fontDefault, Font.PLAIN, sizeFont);
    }
    
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    public void setPosisi(int X, int Y){
        this.X=X;
        this.Y=Y;
    }
    public void move(float X, float Y){
        newX=(int) X;
        newY=(int) Y;
        
        XX=newX-this.X;
        YY=newY-this.Y;
        
        this.X=this.X+XX;
        this.Y=this.Y+YY;
        
        
    }
    
    public void gambarText(Graphics2D g){
        FontRenderContext fontRenderContext;
        fontRenderContext = g.getFontRenderContext();
        TextLayout textLayout;
        textLayout=new TextLayout(text, font, fontRenderContext);
        g.setColor(color);
        textLayout.draw(g, (float)X, (float)Y);
    }
}
