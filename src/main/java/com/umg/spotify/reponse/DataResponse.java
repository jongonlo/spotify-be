/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg.spotify.reponse;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author jonathangonzalez
 */
@Getter
@Setter
public class DataResponse<T> {
    
    private boolean success;
    private T data;
    private ErrorResponse error;

    public DataResponse(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public DataResponse(boolean success, ErrorResponse error) {
        this.success = success;
        this.error = error;
    }
    
    
}
