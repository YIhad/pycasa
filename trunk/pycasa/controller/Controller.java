/*
 * Controller.java
 *
 * Created on 19 de noviembre de 2007, 15:37
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package pycasa.controller;

import com.google.gdata.util.AuthenticationException;

import com.google.gdata.client.photos.PicasawebService;
import com.google.gdata.data.Link;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.media.MediaFileSource;
import com.google.gdata.data.photos.AlbumEntry;
import com.google.gdata.data.photos.AlbumFeed;
import com.google.gdata.data.photos.GphotoEntry;
import com.google.gdata.data.photos.GphotoFeed;
import com.google.gdata.data.photos.PhotoEntry;
import com.google.gdata.data.photos.UserFeed;
import com.google.gdata.util.ServiceException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Vector;
import pycasa.model.Message;

/**
 * basically moved all the code from PicasawebClient here, just to  read it
 * if there is something about the license that i should do, let me know
 * also added some interfaces that specify different methods to be passed
 * to the view classes.
 */
public class Controller implements IfLogin, IfAlbum, IfNotificator{
    private static final String API_PREFIX
      = "http://picasaweb.google.com/data/feed/api/user/";

    private final PicasawebService service;
    
    protected Vector<IfNotificable> notificables;
    
    /** Creates a new instance of Controller */
    public Controller() {
        this.service = new PicasawebService("Pycasa");
        notificables = new Vector<IfNotificable>();
    }
    
    public void registerNotificable(IfNotificable notificable)
    {
        notificables.add(notificable);
    }
    
    public boolean login(String user, String password)
    {
        return login(user, password, null, null);
    }
    
    public boolean login(String user, String password, String proxy, String port)
    {
        if(proxy != null)
        {
            Properties systemSettings = System.getProperties();
            systemSettings.put("http.proxyHost", proxy);
            systemSettings.put("http.proxyPort", port);
            System.setProperties(systemSettings);
        }
        
        try
        {
            service.setUserCredentials(user, password);
            
        }
        catch(AuthenticationException e)
        {
            System.err.println(e.toString());
            return false;
        }
        
        return true;
    }
    
    public void message(String message)
    {
        message(new Message(MessageType.MESSAGE, message));
    }
    
    public void quit()
    {
        System.exit(0);
    }
    
    public void message(Message message)
    {
        for(IfNotificable n: notificables)
        {
            n.messageNotification(message);
        }
    }
    
    public PhotoEntry getPhotoEntryFromFile(File file)
    {
        PhotoEntry photo = new PhotoEntry();
        
        String mimeType = "image/"+file.getAbsolutePath().substring(
                    file.getAbsolutePath().lastIndexOf(".") + 1).replaceFirst("jpg", "jpeg");

        try
        {
            photo.setMediaSource(new MediaFileSource(file, mimeType.toLowerCase()));
            photo.setTitle(new PlainTextConstruct(file.getName()));
        } catch (IOException ex)
        {
            return null;
        }
        
        return photo;
    }
    
    public List<AlbumEntry> getAlbums(String username) throws IOException,
      ServiceException
    {
        String albumUrl = API_PREFIX + username;
        UserFeed userFeed = getFeed(albumUrl, UserFeed.class);

        List<GphotoEntry> entries = userFeed.getEntries();
        List<AlbumEntry> albums = new ArrayList<AlbumEntry>();
        for (GphotoEntry entry : entries) {
          GphotoEntry adapted = entry.getAdaptedEntry();
          if (adapted instanceof AlbumEntry) {
            albums.add((AlbumEntry) adapted);
          }
        }
        return albums;
      }

    
    public List<AlbumEntry> getAlbums() throws IOException, ServiceException 
    {
        return getAlbums("default");
    }
    
    /**
   * Retrieves the photos for the given album.
   */
  public List<PhotoEntry> getPhotos(AlbumEntry album) throws IOException,
      ServiceException {

    String feedHref = getLinkByRel(album.getLinks(), Link.Rel.FEED);
    AlbumFeed albumFeed = getFeed(feedHref, AlbumFeed.class);

    List<GphotoEntry> entries = albumFeed.getEntries();
    List<PhotoEntry> photos = new ArrayList<PhotoEntry>();
    for (GphotoEntry entry : entries) {
      GphotoEntry adapted = entry.getAdaptedEntry();
      if (adapted instanceof PhotoEntry) {
        photos.add((PhotoEntry) adapted);
      }
    }
    return photos;
  }

    
    /**
   * Album-specific insert method to insert into the gallery of the current
   * user, this bypasses the need to have a top-level entry object for parent.
   */
  public AlbumEntry insertAlbum(AlbumEntry album)
      throws IOException, ServiceException {
    String feedUrl = API_PREFIX + "default";
    return service.insert(new URL(feedUrl), album);
  }
    
    /**
   * Insert an entry into another entry.  Because our entries are a hierarchy,
   * this lets you insert a photo into an album even if you only have the
   * album entry and not the album feed, making it quicker to traverse the
   * hierarchy.
   */
  public <T extends GphotoEntry> T insert(GphotoEntry<?> parent, T entry)
      throws IOException, ServiceException {

    String feedUrl = getLinkByRel(parent.getLinks(), Link.Rel.FEED);
    return service.insert(new URL(feedUrl), entry);
  }

  /**
   * Helper function to allow retrieval of a feed by string url, which will
   * create the URL object for you.  Most of the Link objects have a string
   * href which must be converted into a URL by hand, this does the conversion.
   */
  public <T extends GphotoFeed> T getFeed(String feedHref,
      Class<T> feedClass) throws IOException, ServiceException {
    System.out.println("Get Feed URL: " + feedHref);
    return service.getFeed(new URL(feedHref), feedClass);
    }

    /**
   * Helper function to add a kind parameter to a url.
   */
    public String addKindParameter(String url, String kind) {
        if (url.contains("?")) {
          return url + "&kind=" + kind;
        } else {
          return url + "?kind=" + kind;
        }
    }

    /**
    * Helper function to get a link by a rel value.
    */
    public String getLinkByRel(List<Link> links, String relValue) {
        for (Link link : links) {
          if (relValue.equals(link.getRel())) {
            return link.getHref();
          }
        }
        throw new IllegalArgumentException("Missing " + relValue + " link.");
    }
    
}
