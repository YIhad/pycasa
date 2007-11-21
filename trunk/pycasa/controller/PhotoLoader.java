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
import javax.swing.SwingUtilities;
import pycasa.controller.IfNotificator.MessageType;
import pycasa.model.Message;
import pycasa.view.Dialogs;

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
        controller.message(new Message(MessageType.INFORMATION, "Loading photos"));
        try {
            photos = controller.getPhotos(album);
        } catch (ServiceException ex) {
            Dialogs.error("Could not fetch photos");
            ex.printStackTrace();
            return;
        } catch (IOException ex) {
            Dialogs.error("Could not fetch photos");
            ex.printStackTrace();
            return;
        }
        
        Runnable r = new Runnable()
        { 
            public void run()
            {
                
                for(PhotoEntry photo: photos)
                    model.addElement(photo);
                controller.message(new Message(MessageType.INFORMATION, "Photos loaded"));
            }
         };
     
         SwingUtilities.invokeLater(r);
      
    }
    
}
