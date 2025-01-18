/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg.spotify.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.hc.core5.http.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.SpotifyHttpManager;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.Track;
import se.michaelthelin.spotify.requests.data.albums.GetAlbumRequest;
import se.michaelthelin.spotify.requests.data.search.simplified.SearchTracksRequest;

/**
 *
 * @author jonathangonzalez
 */
@Service
public class SpotifyService implements ISpotifyService {

    private final SpotifyApi spotifyApi;

    public SpotifyService(@Value("${spotify.client.id}") String clientId,
            @Value("${spotify.client.secret}") String clientSecret,
            @Value("${redirect.server.ip}") String redirect) {

        this.spotifyApi = new SpotifyApi.Builder()
                .setClientId(clientId)
                .setClientSecret(clientSecret)
                .setRedirectUri(SpotifyHttpManager.makeUri(redirect))
                .build();
    }

    @Override
    public String getAuthorization() {
        try {
            return spotifyApi.clientCredentials().build().execute().getAccessToken();
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            throw new RuntimeException("Error getting code authorization", e);
        }
    }

    @Override
    public List<Track> searchTracksByIsrc(String isrc) {
        try {
            spotifyApi.setAccessToken(getAuthorization());
            SearchTracksRequest searchTracks = spotifyApi.searchTracks("isrc:" + isrc).build();
            Paging<Track> trackPaging = searchTracks.executeAsync().get();
            List<Track> tracks = Arrays.asList(trackPaging.getItems());
            return tracks;
        } catch (InterruptedException | ExecutionException ex ) {
            Logger.getLogger(SpotifyService.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("There was an internal error in Spotify service");
        }
    }

    @Override
    public GetAlbumRequest getAlbum(String albumId){
        spotifyApi.setAccessToken(getAuthorization());
        GetAlbumRequest album = spotifyApi.getAlbum(albumId).build();
        return album;
    }

}
