/*
 * EditAlbum.java
 *
 * Created on 22 de noviembre de 2007, 2:05
 */

package pycasa.view;

import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.photos.AlbumEntry;
import com.google.gdata.util.ServiceException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.SwingUtilities;
import pycasa.controller.Controller;
import pycasa.controller.IfNotificator.MessageType;
import pycasa.model.Message;

/**
 *
 * @author  mariano
 */
public class EditAlbum extends javax.swing.JFrame {
    protected Controller controller;
    protected AlbumEntry album;
    protected MainWindow mainWindow;
    protected boolean edit_mode;
    
    public EditAlbum(Controller controller, MainWindow mainWindow)
    {
        this(controller, mainWindow, null);
    }
    
    /** Creates new form EditAlbum */
    public EditAlbum(Controller controller, MainWindow mainWindow, AlbumEntry album) {
        initComponents();
        this.controller = controller;
        this.album = album;
        this.mainWindow = mainWindow;
        
        if(album == null)
        {
            edit_mode = false;
            this.album = new AlbumEntry();
        }
        else
        {
            this.t_title.setText(album.getTitle().getPlainText());
            this.t_place.setText(album.getLocation());
            try {
                this.t_date.setText(new SimpleDateFormat("dd/MM/yyyy").format(album.getDate()));
            } catch (ServiceException ex) {
                ex.printStackTrace();
            }
            this.t_description.setText(album.getDescription().getPlainText());
            edit_mode = true;
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        t_place = new javax.swing.JTextField();
        l_title = new javax.swing.JLabel();
        panel_description = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_description = new javax.swing.JTextArea();
        l_place = new javax.swing.JLabel();
        t_title = new javax.swing.JTextField();
        t_date = new javax.swing.JFormattedTextField();
        l_date = new javax.swing.JLabel();
        b_cancel = new javax.swing.JButton();
        b_ok = new javax.swing.JButton();

        setTitle("Edit album");
        t_place.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_placeActionPerformed(evt);
            }
        });

        l_title.setText("Title");

        panel_description.setBorder(javax.swing.BorderFactory.createTitledBorder("Description"));
        t_description.setColumns(20);
        t_description.setRows(5);
        jScrollPane1.setViewportView(t_description);

        org.jdesktop.layout.GroupLayout panel_descriptionLayout = new org.jdesktop.layout.GroupLayout(panel_description);
        panel_description.setLayout(panel_descriptionLayout);
        panel_descriptionLayout.setHorizontalGroup(
            panel_descriptionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
        );
        panel_descriptionLayout.setVerticalGroup(
            panel_descriptionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
        );

        l_place.setText("Place");

        t_title.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_titleActionPerformed(evt);
            }
        });

        t_date.setText("dd/mm/yyyyy");
        t_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_dateActionPerformed(evt);
            }
        });

        l_date.setText("Date");

        b_cancel.setText("Cancel");
        b_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancelActionPerformed(evt);
            }
        });

        b_ok.setText("Ok");
        b_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_okActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(panel_description, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, l_title, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, l_place, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                                .add(l_date, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 109, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(t_place, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .add(t_title, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .add(t_date))))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(142, Short.MAX_VALUE)
                .add(b_ok)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(b_cancel)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(l_title)
                    .add(t_title, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(l_place)
                    .add(t_place, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(l_date)
                    .add(t_date, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(10, 10, 10)
                .add(panel_description, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(b_cancel)
                    .add(b_ok))
                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelActionPerformed
        setVisible(false);
    }//GEN-LAST:event_b_cancelActionPerformed

    private void b_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_okActionPerformed
        
        final String title;
        String place, date, desc;
        
        title = t_title.getText();
        place = t_place.getText();
        date = t_date.getText();
        desc = t_description.getText();
        
        if(title.equals(""))
        {
            Dialogs.error("Title is empty");
            return;
        }
        
        album.setTitle(new PlainTextConstruct(title));
        album.setDescription(new PlainTextConstruct(desc));
        album.setLocation(place);
    
        try {
            
            album.setDate((new SimpleDateFormat("dd/MM/yyyy")).parse(date));
        } catch (ParseException ex) {
            Dialogs.error("Invalid date format (use dd/mm/yyyy)");
            return;
        }
        
        if(edit_mode)
        {
            controller.message("Updating album: " + title);
            
            Runnable r = new Runnable()
            {
                public void run()
                {
                    boolean success;
                    try {
                        album.update();
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
                                controller.message("Album " + title + " updated");
                                mainWindow.loadAlbums();
                            }
                        };
                    }
                    else
                    {
                        update_gui = new Runnable()
                        {
                            public void run()
                            {
                                controller.message(new Message(MessageType.ERROR, "Album " + title + " could not be updated"));
                            }
                        };
                    }
                    
                    SwingUtilities.invokeLater(update_gui);
                }
                
            };
           
           Thread t = new Thread(r);
           t.start();
        }
        else
        {
            controller.message("Adding album: " + title);

            Runnable r = new Runnable()
            {
                public void run()
                {
                    boolean success;
                    try {
                        controller.insertAlbum(album);
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
                                controller.message("Album " + title + " added");
                                mainWindow.loadAlbums();
                            }
                        };
                    }
                    else
                    {
                        update_gui = new Runnable()
                        {
                            public void run()
                            {
                                controller.message(new Message(MessageType.ERROR, "Album " + title + " could not be created"));
                            }
                        };
                    }
                    
                    SwingUtilities.invokeLater(update_gui);
                }
                
            };
           
           Thread t = new Thread(r);
           t.start();
       }
        
        setVisible(false);
    }//GEN-LAST:event_b_okActionPerformed

    private void t_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_dateActionPerformed
        this.t_description.grabFocus();
    }//GEN-LAST:event_t_dateActionPerformed

    private void t_placeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_placeActionPerformed
        this.t_date.grabFocus();
    }//GEN-LAST:event_t_placeActionPerformed

    private void t_titleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_titleActionPerformed
        this.t_place.grabFocus();
    }//GEN-LAST:event_t_titleActionPerformed
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_cancel;
    private javax.swing.JButton b_ok;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel l_date;
    private javax.swing.JLabel l_place;
    private javax.swing.JLabel l_title;
    private javax.swing.JPanel panel_description;
    private javax.swing.JFormattedTextField t_date;
    private javax.swing.JTextArea t_description;
    private javax.swing.JTextField t_place;
    private javax.swing.JTextField t_title;
    // End of variables declaration//GEN-END:variables
    
}
