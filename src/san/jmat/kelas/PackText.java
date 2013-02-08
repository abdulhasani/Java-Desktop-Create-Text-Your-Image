/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.kelas;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author joker
 */
public class PackText {
    private int textSelection=-1;
    private ArrayList arrayList=new ArrayList(10);
    private Image image;
    private Dimension size=new Dimension(1,1);
    private DefaultComboBoxModel comboBoxModel;

    public PackText() {
    }

    public void setImage(Image image) {
        this.image = image;
        this.size=new Dimension(image.getWidth(null), image.getHeight(null));
        
    }
    
    public void setText(CreateText createText){
        arrayList.add(createText);
        comboBoxModel.addElement(createText.getText());
    }
    public CreateText getText(int i){
        return (CreateText) arrayList.get(i);
    }
    
    public void updateText(CreateText createText, int i){
        arrayList.remove(i);
        arrayList.add(createText);
        comboBoxModel.removeElementAt(i);
        comboBoxModel.addElement(createText.getText());
    }

    public Dimension getSize() {
        return size;
    }

    public int getTextSelection() {
        return textSelection;
    }

    public void setTextSelection(int textSelection) {
        this.textSelection = textSelection;
    }

    public void setComboBoxModel(DefaultComboBoxModel comboBoxModel) {
        this.comboBoxModel = comboBoxModel;
    }

   public void gambarText(Graphics2D g){
       
       g.drawImage(image, 0, 0, null);
       Iterator it=arrayList.iterator();
       /** digunakan untuk menelusuri koleksi 
        hasNext mengembalikan nilai boolean 
       yang memberi tahu apakah ada item berikutnya 
       yang bisa diproses */
       while(it.hasNext()){
           CreateText createText=((CreateText) it.next());
           createText.gambarText(g);
       }
   } 
   
    
}
