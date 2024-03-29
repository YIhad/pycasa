/*
 * LoginDialog.java
 *
 * Created on 19 de noviembre de 2007, 20:36
 */

package pycasa.view;

/**
 *
 * @author  mariano
 */
public class LoginDialog extends javax.swing.JDialog {
    
    protected pycasa.controller.IfLogin controller;
    private boolean success;
    /** Creates new form Login */
    public LoginDialog(pycasa.controller.IfLogin controller) {
        initComponents();
        this.success = false;
        this.controller = controller;
    }
    
    private void doLogin()
    {
        final String user, password, host, port;
        
        user = this.t_user.getText();
        password = this.t_password.getText();
        host = this.t_host.getText();
        port = this.t_port.getText();
        
        if(user == "" || password == "")
        {
            Dialogs.error("Empty user or password");
            return;
        }
            
        if(!host.equals(""))
        {
            if( port.equals(""))
            {
                Dialogs.error("Empty port");
                return;
            }
        }
                
        Runnable r = new Runnable()
        {
            public void run()
            {
                final boolean result;
            
                if(host == "")
                {
                    result = controller.login(user, password);
                }
                else
                {
                    result = controller.login(user, password, host, port);
                }
                
                Runnable r1 = new Runnable()
                {
                    public void run()
                    {
                        if(result)
                        {
                            LoginDialog.this.success = true;
                            LoginDialog.this.setVisible(false);
                        }
                        else
                        {
                            Dialogs.error("Login error, please try again");
                        }
                    }
                };
                
                javax.swing.SwingUtilities.invokeLater(r1);
                
            }
        };
        
        Thread t = new Thread(r);
        t.start();
        
    }
    
    private void doCancel()
    {
        this.success = false;
        this.setVisible(false);
    }

    public boolean isSuccess() {
        return success;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        l_user = new javax.swing.JLabel();
        t_user = new javax.swing.JTextField();
        l_password = new javax.swing.JLabel();
        b_cancel = new javax.swing.JButton();
        b_ok = new javax.swing.JButton();
        t_password = new javax.swing.JPasswordField();
        l_host = new javax.swing.JLabel();
        t_host = new javax.swing.JTextField();
        t_port = new javax.swing.JTextField();
        l_port = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");
        setModal(true);
        l_user.setText("User");

        t_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_userActionPerformed(evt);
            }
        });

        l_password.setText("Password");

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

        t_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_passwordActionPerformed(evt);
            }
        });

        l_host.setText("Proxy host");

        l_port.setText("Proxy port");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(l_port, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(l_host, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(l_password)
                    .add(l_user, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, t_port)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(b_ok, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 57, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(b_cancel))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, t_user, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, t_password, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, t_host))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(t_user, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(l_user))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(l_password)
                    .add(t_password, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(l_host)
                    .add(t_host, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(t_port, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(l_port))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 15, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(b_ok)
                    .add(b_cancel))
                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void t_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_passwordActionPerformed
        this.doLogin();
    }//GEN-LAST:event_t_passwordActionPerformed

    private void b_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_okActionPerformed
        this.doLogin();
    }//GEN-LAST:event_b_okActionPerformed

    private void b_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelActionPerformed
        this.doCancel();
    }//GEN-LAST:event_b_cancelActionPerformed

    private void t_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_userActionPerformed
        this.t_password.grabFocus();
    }//GEN-LAST:event_t_userActionPerformed
    
      
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_cancel;
    private javax.swing.JButton b_ok;
    private javax.swing.JLabel l_host;
    private javax.swing.JLabel l_password;
    private javax.swing.JLabel l_port;
    private javax.swing.JLabel l_user;
    private javax.swing.JTextField t_host;
    private javax.swing.JPasswordField t_password;
    private javax.swing.JTextField t_port;
    private javax.swing.JTextField t_user;
    // End of variables declaration//GEN-END:variables
    
}
