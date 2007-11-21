/*
 * Main.java
 *
 * Created on 19 de noviembre de 2007, 14:55
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package pycasa;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import pycasa.controller.Controller;
import pycasa.view.MainWindow;

/**
 *
 * @author mariano
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*try {
	    // Set System L&F
        UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
        } 
        catch (UnsupportedLookAndFeelException e) {
           // handle exception
        }
        catch (ClassNotFoundException e) {
           // handle exception
        }
        catch (InstantiationException e) {
           // handle exception
        }
        catch (IllegalAccessException e) {
           // handle exception
        }
        */
        Controller c = new Controller();
        MainWindow main_window = new MainWindow(c);
        main_window.setVisible(true);
    }
    
}
