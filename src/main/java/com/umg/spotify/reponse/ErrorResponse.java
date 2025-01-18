/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg.spotify.reponse;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author jonathangonzalez
 */
@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
    
    private String message;
    private int errorCode;
    private String timestamp;
    private String errorType;
}
