/*
 * IfLogin.java
 *
 * Created on 19 de noviembre de 2007, 15:09
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package pycasa.controller;

/**
 *
 * @author mariano
 */
public interface IfLogin {
    boolean login(String user, String password, String proxy, String port);
    boolean login(String user, String password);
}
