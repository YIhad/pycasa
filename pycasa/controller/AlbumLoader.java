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
import javax.swing.SwingUtilities;
import pycasa.model.Message;

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
        controller.message(new Message(MessageType.INFORMATION, "Loading Albums"));
        try {
            albums = controller.getAlbums();
        } catch (ServiceException ex) {
            controller.message(new Message(MessageType.ERROR, "Error fetching albums"));
            System.err.println(ex.toString());
            ex.printStackTrace();
            return;
        } catch (IOException ex) {
            controller.message(new Message(MessageType.ERROR, "Error fetching albums"));
            System.err.println(ex.toString());
            ex.printStackTrace();
            return;
        }
        
        Runnable r = new Runnable()
        {
            public void run()
            {
                for(AlbumEntry album: albums)
                    model.addElement(album);
                controller.message(new Message(MessageType.INFORMATION, "Albums loaded"));
            }
        };
        
        SwingUtilities.invokeLater(r);
    }
}
