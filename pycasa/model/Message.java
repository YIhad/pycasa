/*
 * Message.java
 *
 * Created on 21 de noviembre de 2007, 1:01
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package pycasa.model;

import pycasa.controller.IfNotificator.MessageType;

/**
 *
 * @author mariano
 */
public class Message {
    private MessageType type;
    private String message;
    /** Creates a new instance of Message */
    public Message(MessageType type, String message) {
        this.setType(type);
        this.setMessage(message);
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
