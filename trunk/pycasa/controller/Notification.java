/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pycasa.controller;

import javax.swing.SwingUtilities;
import pycasa.controller.IfNotificator.MessageType;
import pycasa.model.Message;

/**
 *
 * @author mariano
 */
public class Notification implements Runnable{
    protected Message message;
    protected IfNotificator notificator;
    
    public Notification(IfNotificator notificator, String message)
    {
        this(notificator, MessageType.INFORMATION, message);
    }
    
    public Notification(IfNotificator notificator, 
            MessageType messageType, String message)
    {
        this(notificator, new Message(messageType, message));
    }
    
    public Notification(IfNotificator notificator, Message message)
    {
        this.message = message;
        this.notificator = notificator;
    }
    
    public void run()
    {
        notificator.message(message);
    }
    
    static void send(Notification notification)
    {
        SwingUtilities.invokeLater(notification);
    }
}
