/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg.spotify.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author jonathangonzalez
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Track implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String isrc;
    private String name;
    private String artistName;
    private String albumName;
    private String albumId;
    @Column(name = "is_explicit")
    private boolean explicit;
    private Integer playbackSeconds;
    private String cover;

    public Track(String isrc, String name, String artistName, String albumName, String albumId, boolean explicit, Integer playbackSeconds, String cover) {
        this.isrc = isrc;
        this.name = name;
        this.artistName = artistName;
        this.albumName = albumName;
        this.albumId = albumId;
        this.explicit = explicit;
        this.playbackSeconds = playbackSeconds;
        this.cover = cover;
    }
    
    
    
}
