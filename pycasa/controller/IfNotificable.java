/*
 * IfNotificable.java
 *
 * Created on 20 de noviembre de 2007, 21:51
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
public interface IfNotificable {
    void messageNotification(Message message);
}
