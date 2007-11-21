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
import javax.swing.SwingUtilities;
import pycasa.controller.IfNotificator.MessageType;
import pycasa.model.Message;
import pycasa.view.Dialogs;

/**
 *
 * @author mariano
 */
public class PhotoAdder implements Runnable {
    protected AlbumEntry album;
    protected PhotoEntry photo;
    protected Controller controller;
    /** Creates a new instance of PhotoAdder */
    public PhotoAdder(AlbumEntry album, PhotoEntry photo, Controller controller) {
        this.photo = photo;
        this.album = album;
        this.controller = controller;
    }
    
    public void run()
    {
        String title = photo.getTitle().getPlainText();
        
        try {
            controller.insert(album, photo);
            
            Runnable notify = new Runnable()
            {
                public void run()
                {
                    String s = "Photo " + PhotoAdder.this.photo.getTitle().getPlainText() + " uploaded";
                    MessageType t = MessageType.MESSAGE;
                    controller.message(new Message(t, s));
                }
            };
            
            SwingUtilities.invokeLater(notify);
        } catch (ServiceException ex) {
            controller.message(new Message(MessageType.ERROR, "Could not upload photo: " + photo.getTitle().getPlainText()));
        } catch (IOException ex) {
            controller.message(new Message(MessageType.ERROR, "Could not upload photo: " + photo.getTitle().getPlainText()));
        }
    }
    
}
