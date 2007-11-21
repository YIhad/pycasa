/*
 * PhotoCellRenderer.java
 *
 * Created on 19 de noviembre de 2007, 23:49
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package pycasa.view;

import com.google.gdata.data.photos.PhotoEntry;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JList;

/**
 *
 * @author mariano
 */
public class PhotoCellRenderer extends DefaultListCellRenderer {
    protected ImageIcon icon;
    /** Creates a new instance of PhotoCellRenderer */
    public PhotoCellRenderer() {
        icon = new ImageIcon(getClass().getResource("/resources/image-x-generic.png"));
    }
    
    public Component getListCellRendererComponent(JList list, Object value 
                                                  , int index, boolean isSelected 
                                                  , boolean cellHasFocus){ 
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); 
        
        setIcon(icon); 
        String desc = ((PhotoEntry)value).getDescription().getPlainText();
        
        if(!desc.equals(""))
        {
            setText(desc);
        }
        else
        {
            setText(((PhotoEntry)value).getTitle().getPlainText());
        }
        
 
        return this; 
    } 
}
