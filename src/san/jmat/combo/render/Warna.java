/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.combo.render;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
 * @author joker
 */
public class Warna extends DefaultListCellRenderer{

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component component=super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
    if(isSelected){
     component.setBackground(Color.red);   
    }else{
        if(index%2==1){
        component.setBackground(Color.GREEN);
    }
    else{
        component.setBackground(Color.YELLOW);
    }
    }
    return component;
    }
    
   
    
}
