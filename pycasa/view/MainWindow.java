/*
 * MainWindow.java
 *
 * Created on 19 de noviembre de 2007, 16:04
 */

package pycasa.view;

import com.google.gdata.data.photos.AlbumEntry;
import com.google.gdata.data.photos.PhotoEntry;
import java.io.File;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;
import pycasa.controller.AlbumLoader;
import pycasa.controller.Controller;
import pycasa.controller.IfNotificable;
import pycasa.controller.IfNotificator;
import pycasa.controller.IfNotificator.MessageType;
import pycasa.controller.PhotoAdder;
import pycasa.controller.PhotoLoader;
import pycasa.model.Message;

/**
 *
 * @author  mariano
 */
public class MainWindow extends javax.swing.JFrame implements IfNotificable {
    protected Controller controller;
    protected DefaultListModel photo_model;
    protected DefaultListModel album_model;
    protected DefaultListModel info_model;
    /**
     * Creates new form MainWindow
     */
    public MainWindow(Controller controller) {
        album_model = new DefaultListModel();
        photo_model = new DefaultListModel();
        info_model = new DefaultListModel();
        
        this.controller = controller;
        this.controller.registerNotificable(this);
        
        initComponents();
        
        list_album.setModel(album_model) ;
        list_photo.setModel(photo_model);
        list_info.setModel(info_model);
        
        list_album.setCellRenderer(new AlbumCellRenderer());
        list_photo.setCellRenderer(new PhotoCellRenderer());
        list_info.setCellRenderer(new MessageCellRenderer());
        
        this.b_album_add.setEnabled(false);
        this.b_album_remove.setEnabled(false);
        this.b_album_edit.setEnabled(false);
        
        this.b_photo_add.setEnabled(false);
        this.b_photo_remove.setEnabled(false);
        this.b_photo_edit.setEnabled(false);
               
    }
    
    public void messageNotification(Message message)
    {
        info_model.addElement(message);
    }
    
    public void loadAlbums() {
        album_model.clear();
        
        Thread t = new Thread(new AlbumLoader(album_model, controller));
        t.start();
    }
    
    public void loadPhotos(AlbumEntry album) {
        photo_model.clear();
        
        if(album == null)
            return;
        
        Thread t = new Thread(new PhotoLoader(photo_model, album, controller));
        t.start();
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        panel_albums = new javax.swing.JPanel();
        tb_album = new javax.swing.JToolBar();
        b_album_add = new javax.swing.JButton();
        b_album_remove = new javax.swing.JButton();
        b_album_edit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_album = new javax.swing.JList();
        panel_photos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        list_photo = new javax.swing.JList();
        tb_photos = new javax.swing.JToolBar();
        b_photo_add = new javax.swing.JButton();
        b_photo_remove = new javax.swing.JButton();
        b_photo_edit = new javax.swing.JButton();
        panel_info = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        list_info = new javax.swing.JList();
        b_info_clear = new javax.swing.JButton();
        menubar = new javax.swing.JMenuBar();
        menu_file = new javax.swing.JMenu();
        mi_login = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        mi_quit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pycasa");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panel_albums.setBorder(javax.swing.BorderFactory.createTitledBorder("Albums"));
        tb_album.setBorder(null);
        tb_album.setFloatable(false);
        tb_album.setBorderPainted(false);
        b_album_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/list-add.png")));
        b_album_add.setToolTipText("Add album");
        b_album_add.setBorderPainted(false);
        b_album_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_album_addActionPerformed(evt);
            }
        });

        tb_album.add(b_album_add);

        b_album_remove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/list-remove.png")));
        b_album_remove.setBorderPainted(false);
        b_album_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_album_removeActionPerformed(evt);
            }
        });

        tb_album.add(b_album_remove);

        b_album_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/document-properties.png")));
        b_album_edit.setBorderPainted(false);
        b_album_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_album_editActionPerformed(evt);
            }
        });

        tb_album.add(b_album_edit);

        list_album.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list_albumMouseClicked(evt);
            }
        });

        jScrollPane1.setViewportView(list_album);

        org.jdesktop.layout.GroupLayout panel_albumsLayout = new org.jdesktop.layout.GroupLayout(panel_albums);
        panel_albums.setLayout(panel_albumsLayout);
        panel_albumsLayout.setHorizontalGroup(
            panel_albumsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
            .add(panel_albumsLayout.createSequentialGroup()
                .add(tb_album, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(169, Short.MAX_VALUE))
        );
        panel_albumsLayout.setVerticalGroup(
            panel_albumsLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panel_albumsLayout.createSequentialGroup()
                .add(tb_album, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
        );

        panel_photos.setBorder(javax.swing.BorderFactory.createTitledBorder("Photos"));
        list_photo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list_photoMouseClicked(evt);
            }
        });

        jScrollPane2.setViewportView(list_photo);

        tb_photos.setBorder(null);
        tb_photos.setFloatable(false);
        b_photo_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/list-add.png")));
        b_photo_add.setBorderPainted(false);
        b_photo_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_photo_addActionPerformed(evt);
            }
        });

        tb_photos.add(b_photo_add);

        b_photo_remove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/list-remove.png")));
        b_photo_remove.setBorderPainted(false);
        b_photo_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_photo_removeActionPerformed(evt);
            }
        });

        tb_photos.add(b_photo_remove);

        b_photo_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/document-properties.png")));
        b_photo_edit.setBorderPainted(false);
        b_photo_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_photo_editActionPerformed(evt);
            }
        });

        tb_photos.add(b_photo_edit);

        org.jdesktop.layout.GroupLayout panel_photosLayout = new org.jdesktop.layout.GroupLayout(panel_photos);
        panel_photos.setLayout(panel_photosLayout);
        panel_photosLayout.setHorizontalGroup(
            panel_photosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
            .add(panel_photosLayout.createSequentialGroup()
                .add(tb_photos, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(260, Short.MAX_VALUE))
        );
        panel_photosLayout.setVerticalGroup(
            panel_photosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, panel_photosLayout.createSequentialGroup()
                .add(tb_photos, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(7, 7, 7)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
        );

        panel_info.setBorder(javax.swing.BorderFactory.createTitledBorder("Information"));
        jScrollPane3.setViewportView(list_info);

        b_info_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/edit-clear.png")));
        b_info_clear.setToolTipText("clear");
        b_info_clear.setBorder(null);
        b_info_clear.setBorderPainted(false);
        b_info_clear.setContentAreaFilled(false);
        b_info_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_info_clearActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout panel_infoLayout = new org.jdesktop.layout.GroupLayout(panel_info);
        panel_info.setLayout(panel_infoLayout);
        panel_infoLayout.setHorizontalGroup(
            panel_infoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, panel_infoLayout.createSequentialGroup()
                .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(b_info_clear, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 31, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        panel_infoLayout.setVerticalGroup(
            panel_infoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, panel_infoLayout.createSequentialGroup()
                .add(b_info_clear, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(86, 86, 86))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
        );

        menubar.setBorder(null);
        menubar.setBorderPainted(false);
        menu_file.setText("File");
        mi_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/network-transmit-receive.png")));
        mi_login.setText("Login");
        mi_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_loginActionPerformed(evt);
            }
        });

        menu_file.add(mi_login);

        menu_file.add(jSeparator1);

        mi_quit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/system-log-out.png")));
        mi_quit.setText("Quit");
        mi_quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_quitActionPerformed(evt);
            }
        });

        menu_file.add(mi_quit);

        menubar.add(menu_file);

        setJMenuBar(menubar);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(panel_albums, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panel_photos, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(panel_info, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, panel_albums, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, panel_photos, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panel_info, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mi_quitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_quitActionPerformed
        controller.quit();
    }//GEN-LAST:event_mi_quitActionPerformed

    private void b_info_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_info_clearActionPerformed
        info_model.clear();
    }//GEN-LAST:event_b_info_clearActionPerformed
    
    private void mi_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_loginActionPerformed
        LoginDialog ld = new LoginDialog((Controller)controller);
        ld.setVisible(true);
        
        if(ld.isSuccess()) {
            this.b_album_add.setEnabled(true);
            this.b_album_remove.setEnabled(true);
            this.b_album_edit.setEnabled(true);

            this.b_photo_add.setEnabled(true);
            this.b_photo_remove.setEnabled(true);
            this.b_photo_edit.setEnabled(true);
            loadAlbums();
        }
    }//GEN-LAST:event_mi_loginActionPerformed
    
    private void list_photoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list_photoMouseClicked
        PhotoEntry photo = getSelectedPhoto();
        
        if(photo != null) {
            updatePhotoInfo(photo);
        }
    }//GEN-LAST:event_list_photoMouseClicked
    
    private void b_photo_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_photo_editActionPerformed
        PhotoEntry photo = getSelectedPhoto();
        
        if(photo == null)
        {
            this.messageNotification(new Message(MessageType.ERROR, "Photo not selected"));
            return;
        }
        
        EditPhoto ep = new EditPhoto(controller, this, photo);
        ep.setVisible(true);
    }//GEN-LAST:event_b_photo_editActionPerformed
    
    private void b_photo_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_photo_removeActionPerformed
        PhotoEntry photo = getSelectedPhoto();
        
        if(photo == null)
        {
            this.messageNotification(new Message(MessageType.ERROR, "Photo not selected"));
            return;
        }
        
        int result = Dialogs.confirm("Delete selected image?");
        
        if(result == javax.swing.JOptionPane.YES_OPTION)
        {
            deletePhoto(photo);
        }
    }//GEN-LAST:event_b_photo_removeActionPerformed
    
    private void b_photo_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_photo_addActionPerformed
        File []files = Dialogs.openMultipleFiles(".", new ImageFilter());
        
        AlbumEntry album = getSelectedAlbum();
        
        if(album == null) {
            Dialogs.error("Select an album");
            return;
        }
        
        Vector <PhotoEntry>photos = new Vector<PhotoEntry>();
        
        for(File file: files) {
            if(file.isDirectory())
                continue;
            
            PhotoEntry photo = controller.getPhotoEntryFromFile(file);
            
            if(photo == null)
            {
                this.messageNotification(new Message(IfNotificator.MessageType.ERROR,
                        "Error sending photo " + photo.getTitle().getPlainText()));
                continue;
            }
            
            photos.add(photo);
        }
        
        Thread t = new Thread(new PhotoAdder(album, photos, controller));
        t.start();
    }//GEN-LAST:event_b_photo_addActionPerformed
    
    private void b_album_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_album_editActionPerformed
        AlbumEntry album = getSelectedAlbum();
        
        if(album == null)
        {
            this.messageNotification(new Message(MessageType.ERROR, "Album not selected"));
            return;
        }
        
        EditAlbum ae = new EditAlbum(controller, this, album);
        ae.setVisible(true);
    }//GEN-LAST:event_b_album_editActionPerformed
    
    private void b_album_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_album_removeActionPerformed
        AlbumEntry album = getSelectedAlbum();
        
        if(album == null)
        {
            this.messageNotification(new Message(MessageType.ERROR, "Album not selected"));
            return;
        }
        
        int result = Dialogs.confirm("Delete selected album?");
        
        if(result == javax.swing.JOptionPane.YES_OPTION)
        {
            deleteAlbum(album);
        }
    }//GEN-LAST:event_b_album_removeActionPerformed
    
    private void b_album_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_album_addActionPerformed
        EditAlbum ae = new EditAlbum(controller, this);
        ae.setVisible(true);
    }//GEN-LAST:event_b_album_addActionPerformed
    
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
    }//GEN-LAST:event_formWindowActivated
    
    public AlbumEntry getSelectedAlbum() {
        int index = list_album.getSelectedIndex();
        
        if(index == -1)
            return null;
        
        return (AlbumEntry)album_model.getElementAt(index);
    }
    
    private PhotoEntry getSelectedPhoto() {
        int index = list_photo.getSelectedIndex();
        
        if(index == -1)
            return null;
        
        return (PhotoEntry)photo_model.getElementAt(index);
    }
    
    private void updatePhotoInfo(PhotoEntry photo) {
        System.out.println(photo.getTitle().getPlainText());
        System.out.println(photo.getDescription().getPlainText());
    }
    
    public void deletePhoto(final PhotoEntry photo)
    {
        if(photo == null)
            return;
        
        final String title = photo.getTitle().getPlainText();
        
        controller.message("Deleting photo: " + title);
        
        Runnable r = new Runnable()
        {
            public void run()
            {
                boolean success;
                try {
                    photo.delete();
                    success = true;
                } catch (Exception ex) {
                    success = false;
                    ex.printStackTrace();
                }

                Runnable update_gui;

                if(success)
                {
                    update_gui = new Runnable()
                    {
                        public void run()
                        {
                            controller.message("Photo " + title + " deleted");
                            loadPhotos(getSelectedAlbum());
                        }
                    };
                }
                else
                {
                    update_gui = new Runnable()
                    {
                        public void run()
                        {
                            controller.message(new Message(MessageType.ERROR, "Photo " + title + " could not be deleted"));
                        }
                    };
                }

                SwingUtilities.invokeLater(update_gui);
            }

        };

       Thread t = new Thread(r);
       t.start();
    }

    public void deleteAlbum(final AlbumEntry album)
    {
        if(album == null)
            return;
        
        final String title = album.getTitle().getPlainText();
        
        controller.message("Deleting album: " + title);
        
        Runnable r = new Runnable()
        {
            public void run()
            {
                boolean success;
                try {
                    album.delete();
                    success = true;
                } catch (Exception ex) {
                    success = false;
                    ex.printStackTrace();
                }

                Runnable update_gui;

                if(success)
                {
                    update_gui = new Runnable()
                    {
                        public void run()
                        {
                            controller.message("Album " + title + " deleted");
                            loadAlbums();
                        }
                    };
                }
                else
                {
                    update_gui = new Runnable()
                    {
                        public void run()
                        {
                            controller.message(new Message(MessageType.ERROR, "Album " + title + " could not be deleted"));
                        }
                    };
                }

                SwingUtilities.invokeLater(update_gui);
            }

        };

       Thread t = new Thread(r);
       t.start();
    }

    
    private void list_albumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list_albumMouseClicked
        AlbumEntry album = getSelectedAlbum();
        
        if(album != null)
            loadPhotos(album);
    }//GEN-LAST:event_list_albumMouseClicked
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
    }//GEN-LAST:event_formWindowOpened
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_album_add;
    private javax.swing.JButton b_album_edit;
    private javax.swing.JButton b_album_remove;
    private javax.swing.JButton b_info_clear;
    private javax.swing.JButton b_photo_add;
    private javax.swing.JButton b_photo_edit;
    private javax.swing.JButton b_photo_remove;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JList list_album;
    private javax.swing.JList list_info;
    private javax.swing.JList list_photo;
    private javax.swing.JMenu menu_file;
    private javax.swing.JMenuBar menubar;
    private javax.swing.JMenuItem mi_login;
    private javax.swing.JMenuItem mi_quit;
    private javax.swing.JPanel panel_albums;
    private javax.swing.JPanel panel_info;
    private javax.swing.JPanel panel_photos;
    private javax.swing.JToolBar tb_album;
    private javax.swing.JToolBar tb_photos;
    // End of variables declaration//GEN-END:variables
    
    class ImageFilter extends javax.swing.filechooser.FileFilter {
        public boolean accept(File file) {
            String filename = file.getName().toLowerCase();
            return filename.endsWith(".gif") || filename.endsWith(".jpg") ||
                    filename.endsWith(".png") || filename.endsWith(".bmp") ||
                    file.isDirectory();
        }
        public String getDescription() {
            return "Image files";
        }
    }
}
