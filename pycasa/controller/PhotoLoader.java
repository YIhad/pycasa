/*
 * PhotoLoader.java
 *
 * Created on 21 de noviembre de 2007, 0:40
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package pycasa.controller;

import com.google.gdata.data.photos.AlbumEntry;
import com.google.gdata.data.photos.PhotoEntry;
import com.google.gdata.util.ServiceException;
import java.io.IOException;
import java.util.List;
import javax.swing.DefaultListModel;
import pycasa.controller.IfNotificator.MessageType;

/**
 *
 * @author mariano
 */
public class PhotoLoader implements Runnable{
    protected DefaultListModel model;
    protected Controller controller;
    protected AlbumEntry album;
    
    /** Creates a new instance of PhotoLoader */
    public PhotoLoader(DefaultListModel model, AlbumEntry album, Controller controller) {
        this.model = model;
        this.album = album;
        this.controller = controller;
    }
    
    public void run()
    {
        final List<PhotoEntry> photos;
        Notification.send(new Notification(controller, MessageType.INFORMATION, "Loading photos"));
        try {
            photos = controller.getPhotos(album);
        } catch (ServiceException ex) {
            Notification.send(new Notification(controller, 
                    MessageType.ERROR, "Could not fetch photos"));
            ex.printStackTrace();
            return;
        } catch (IOException ex) {
            Notification.send(new Notification(controller, 
                    MessageType.ERROR, "Could not fetch photos"));
            ex.printStackTrace();
            return;
        }
        
        for(PhotoEntry photo: photos)
            model.addElement(photo);
        
        Notification.send(new Notification(controller, MessageType.INFORMATION, "Photos loaded"));
    }
    
}
