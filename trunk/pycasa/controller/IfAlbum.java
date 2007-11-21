/*
 * IfAlbum.java
 *
 * Created on 19 de noviembre de 2007, 19:45
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package pycasa.controller;

import com.google.gdata.data.photos.AlbumEntry;
import com.google.gdata.data.photos.GphotoEntry;
import com.google.gdata.data.photos.PhotoEntry;
import com.google.gdata.util.ServiceException;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author mariano
 */
public interface IfAlbum {
    PhotoEntry getPhotoEntryFromFile(File file);
    
    List<AlbumEntry> getAlbums() throws IOException, ServiceException;
    List<PhotoEntry> getPhotos(AlbumEntry album) throws IOException, ServiceException;
    AlbumEntry insertAlbum(AlbumEntry album) throws IOException, ServiceException;
    <T extends GphotoEntry> T insert(GphotoEntry<?> parent, T entry)
      throws IOException, ServiceException;
}
