/*
 * EditPhoto.java
 *
 * Created on 22 de noviembre de 2007, 2:34
 */

package pycasa.view;

import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.photos.PhotoEntry;
import pycasa.controller.Controller;
import pycasa.controller.IfNotificator.MessageType;
import pycasa.model.Message;

/**
 *
 * @author  mariano
 */
public class EditPhoto extends javax.swing.JFrame {
    protected Controller controller;
    protected PhotoEntry photo;
    protected MainWindow mainWindow;
    /** Creates new form EditPhoto */
    public EditPhoto(Controller controller, MainWindow mainWindow, PhotoEntry photo) {
        initComponents();
        this.controller = controller;
        this.photo = photo;
        this.mainWindow = mainWindow;
        
        this.t_description.setText(photo.getDescription().getPlainText());
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        panel_description = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_description = new javax.swing.JTextArea();
        b_ok = new javax.swing.JButton();
        b_cancel = new javax.swing.JButton();

        setTitle("Edit photo");
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

        b_ok.setText("Ok");
        b_ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_okActionPerformed(evt);
            }
        });

        b_cancel.setText("Cancel");
        b_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancelActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(panel_description, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
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
                .add(panel_description, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(b_ok)
                    .add(b_cancel))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelActionPerformed
        setVisible(false);
    }//GEN-LAST:event_b_cancelActionPerformed

    private void b_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_okActionPerformed
        String desc = t_description.getText();
        String title = photo.getTitle().getPlainText();
        
        photo.setDescription(new PlainTextConstruct(desc));
        
        try {
                controller.message("Updating photo: " + title);
                photo.update();
                controller.message("Photo " + title + " updated");
                mainWindow.loadPhotos(mainWindow.getSelectedAlbum());
            } catch (Exception ex) {
                controller.message(new Message(MessageType.ERROR, "Photo " + title + " could not be updated"));
                ex.printStackTrace();
            }
        
        setVisible(false);
    }//GEN-LAST:event_b_okActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_cancel;
    private javax.swing.JButton b_ok;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel_description;
    private javax.swing.JTextArea t_description;
    // End of variables declaration//GEN-END:variables
    
}