/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg.spotify.service;

import com.umg.spotify.entity.Track;
import com.umg.spotify.exception.AlreadyExistsException;
import com.umg.spotify.exception.ResourceNotFoundException;
import com.umg.spotify.repository.TrackRepository;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.michaelthelin.spotify.model_objects.specification.ArtistSimplified;

/**
 *
 * @author jonathangonzalez
 */
@Service
public class TrackService implements ITrackService {

    @Autowired
    private TrackRepository repo;

    @Autowired
    private ISpotifyService spotifyService;

    @Override
    public List<Track> findAll() {
        return (List<Track>) repo.findAll();
    }

    @Override
    public Track save(String isrc) {
        List<se.michaelthelin.spotify.model_objects.specification.Track> spotifyTracks = spotifyService.searchTracksByIsrc(isrc);
        if (spotifyTracks == null || spotifyTracks.isEmpty()) {
            throw new ResourceNotFoundException("ISRC: " + isrc + " Not Found in Spotify");
        }
        if(repo.existsByIsrc(isrc)){
            throw new AlreadyExistsException("ISRC: " + isrc + " Already exists");
        }
        Track track = spotifyTracks.stream().findFirst()
                .map((spotifyTrack) -> new Track(isrc, spotifyTrack.getName(), artistNames(spotifyTrack.getArtists()), spotifyTrack.getAlbum().getName(),
                        spotifyTrack.getAlbum().getId(), spotifyTrack.getIsExplicit(), spotifyTrack.getDurationMs(), spotifyTrack.getAlbum().getImages()[0].getUrl()))
                .orElseThrow(() -> new RuntimeException("There was an error creating the Track"));
        
        return repo.save(track);
    }

    @Override
    public Track findByIsrc(String isrc) {
        return repo.findByIsrc(isrc).orElseThrow(() -> new ResourceNotFoundException("ISRC: " + isrc + " Not Found"));
    }

    @Override
    public void deleteByIsrc(String isrc) {
        if (repo.existsByIsrc(isrc)) {
            repo.deleteByIsrc(isrc);
        }
    }

    private String artistNames(ArtistSimplified[] artists) {
        String names = Arrays.asList(artists).stream().map(artist -> artist.getName())
                .collect(Collectors.joining(", "));
        return names;
    }

}
