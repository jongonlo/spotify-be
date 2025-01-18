/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg.spotify.exception;

/**
 *
 * @author jonathangonzalez
 */
public class AlreadyExistsException extends RuntimeException{
    
    public AlreadyExistsException(String msg) {
        super(msg);
    }
}
