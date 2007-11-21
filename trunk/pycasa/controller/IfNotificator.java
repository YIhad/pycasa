/*
 * IfNotificator.java
 *
 * Created on 20 de noviembre de 2007, 21:55
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package pycasa.controller;

import pycasa.model.Message;

/**
 *
 * @author mariano
 */
public interface IfNotificator {
    public enum MessageType { MESSAGE, ERROR, WARNING, INFORMATION, PROGRESS, DEBUG };
    void message(String message);
    void message(Message message);
    
    void registerNotificable(IfNotificable notificable);
}
