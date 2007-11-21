/*
 * Dialogs.java
 *
 * Created on 19 de noviembre de 2007, 15:12
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package pycasa.view;

import java.io.File;

/**
 *
 * @author mariano
 */
public class Dialogs {
    
    public static void error(String title, String message)
    {
        javax.swing.JOptionPane.showMessageDialog(null, message, title,
                javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    
    public static void error(String message)
    {
        error("Error", message);
    }
    
    public static void warning(String title, String message)
    {
        javax.swing.JOptionPane.showMessageDialog(null, message, title,
                javax.swing.JOptionPane.WARNING_MESSAGE);
    }
    
    public static void warning(String message)
    {
        warning("Warning", message);
    }
    
    
    
    public static void information(String title, String message)
    {
        javax.swing.JOptionPane.showMessageDialog(null, message, title,
                javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void information(String message)
    {
        information("Information", message);
    }
    
    public static void main(String []args)
    {
        error("mensaje error");
        warning("el cuco!");
        information("ya se fue");
    }
    
    public static File[] openMultipleFiles(String path, javax.swing.filechooser.FileFilter filter)
    {
        javax.swing.JFileChooser fc = new javax.swing.JFileChooser(path);
        fc.setDialogType(javax.swing.JFileChooser.OPEN_DIALOG);
        fc.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);
        fc.setMultiSelectionEnabled(true);
        fc.setFileFilter(filter);
        
        fc.showOpenDialog(null);
        
        return fc.getSelectedFiles();
    }
    
    
}


