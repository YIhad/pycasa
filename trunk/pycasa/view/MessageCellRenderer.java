/*
 * MessageCellRenderer.java
 *
 * Created on 21 de noviembre de 2007, 1:11
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
import pycasa.controller.IfNotificator.MessageType;
import pycasa.model.Message;

/**
 *
 * @author mariano
 */
public class MessageCellRenderer extends DefaultListCellRenderer {
    protected ImageIcon error, info, msg, warning;
    /** Creates a new instance of MessageCellRenderer */
    public MessageCellRenderer() {
         error = new ImageIcon(getClass().getResource("/resources/dialog-error.png"));
         info = new ImageIcon(getClass().getResource("/resources/dialog-information.png"));
         msg = new ImageIcon(getClass().getResource("/resources/dialog-information.png"));
         warning = new ImageIcon(getClass().getResource("/resources/dialog-warning.png"));
    }
    
    public Component getListCellRendererComponent(JList list, Object value 
                                                  , int index, boolean isSelected 
                                                  , boolean cellHasFocus){ 
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); 
        
        switch(((Message)value).getType())
        {
            case ERROR: setIcon(error); break;
            case INFORMATION: setIcon(info); break;
            case MESSAGE: setIcon(msg); break;
            case WARNING: setIcon(warning); break;
        }
        setText(((Message)value).getMessage());
        return this; 
    } 
}
