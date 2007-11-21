/*
 * AlbumCellRenderer.java
 *
 * Created on 19 de noviembre de 2007, 22:39
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package pycasa.view;

import com.google.gdata.data.photos.AlbumEntry;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JList;

/**
 *
 * @author mariano
 */
public class AlbumCellRenderer extends DefaultListCellRenderer{
    protected ImageIcon icon;
    /** Creates a new instance of AlbumCellRenderer */
    public AlbumCellRenderer() {
        icon = new ImageIcon(getClass().getResource("/resources/folder.png"));
    }
    
    public Component getListCellRendererComponent(JList list, Object value 
                                                  , int index, boolean isSelected 
                                                  , boolean cellHasFocus){ 
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); 
        
        setIcon(icon); 
        setText(((AlbumEntry)value).getTitle().getPlainText());
        return this; 
    } 
}
