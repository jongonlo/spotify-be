/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.umg.spotify.service;

import java.io.IOException;
import java.util.List;
import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.Track;
import se.michaelthelin.spotify.requests.data.albums.GetAlbumRequest;

/**
 *
 * @author jonathangonzalez
 */
public interface ISpotifyService {
    
    public String getAuthorization() throws IOException, SpotifyWebApiException, ParseException;
    public List<Track> searchTracksByIsrc(String isrc);
    public GetAlbumRequest getAlbum(String albumId);
    
}
