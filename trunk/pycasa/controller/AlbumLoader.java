/*
 * AlbumLoader.java
 *
 * Created on 21 de noviembre de 2007, 0:25
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package pycasa.controller;

import com.google.gdata.data.photos.AlbumEntry;
import com.google.gdata.util.ServiceException;
import java.io.IOException;
import java.util.List;
import javax.swing.DefaultListModel;
import pycasa.controller.IfNotificator.MessageType;

/**
 *
 * @author mariano
 */
public class AlbumLoader implements Runnable{
    protected DefaultListModel model;
    protected Controller controller;
    /** Creates a new instance of AlbumLoader */
    public AlbumLoader(DefaultListModel model, Controller controller) {
        this.model = model;
        this.controller = controller;
    }
    
    public void run()
    {
        final List<AlbumEntry> albums;
        Notification.send(new Notification(controller, MessageType.INFORMATION, 
                "Loading Albums"));
        try {
            albums = controller.getAlbums();
        } catch (ServiceException ex) {
            Notification.send(new Notification(controller, MessageType.ERROR, 
                    "Error fetching albums"));
            System.err.println(ex.toString());
            ex.printStackTrace();
            return;
        } catch (IOException ex) {
            Notification.send(new Notification(controller, MessageType.ERROR, 
                    "Error fetching albums"));
            System.err.println(ex.toString());
            ex.printStackTrace();
            return;
        }
        
        for(AlbumEntry album: albums)
            model.addElement(album);
        Notification.send(new Notification(controller, "Albums loaded"));
    }
}
