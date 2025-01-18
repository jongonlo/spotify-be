/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.umg.spotify.service;

import com.umg.spotify.entity.Track;
import java.util.List;

/**
 *
 * @author jonathangonzalez
 */
public interface ITrackService {
    
    public List<Track> findAll();

    public Track save(String isrc);

    public Track findByIsrc(String isrc);

    public void deleteByIsrc(String isrc);

}
