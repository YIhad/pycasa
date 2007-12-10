/*
 * PhotoAdder.java
 *
 * Created on 20 de noviembre de 2007, 21:21
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package pycasa.controller;

import com.google.gdata.data.photos.AlbumEntry;
import com.google.gdata.data.photos.PhotoEntry;
import com.google.gdata.util.ServiceException;
import java.io.IOException;
import java.util.Vector;
import pycasa.controller.IfNotificator.MessageType;

/**
 *
 * @author mariano
 */
public class PhotoAdder implements Runnable {
    protected AlbumEntry album;
    protected Vector<PhotoEntry> photos;
    protected Controller controller;
    /** Creates a new instance of PhotoAdder */
    public PhotoAdder(AlbumEntry album, Vector<PhotoEntry> photos, Controller controller) {
        this.photos = photos;
        this.album = album;
        this.controller = controller;
    }
    
    public void run()
    {
        for(PhotoEntry photo:photos)
        {
            String title = photo.getTitle().getPlainText();

            try {
                controller.insert(album, photo);
                
                Notification.send(new Notification(controller, 
                        MessageType.MESSAGE,
                        "Photo " + title + " uploaded"));
            } catch (ServiceException ex) {
                Notification.send(new Notification(controller, 
                        MessageType.ERROR, "Could not upload photo: " + title));
            } catch (IOException ex) {
                Notification.send(new Notification(controller, 
                        MessageType.ERROR, "Could not upload photo: " + title));
            }
        }
        
        Notification.send(new Notification(controller, "Upload finished"));
    }
    
}
