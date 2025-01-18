/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umg.spotify.controller;

import com.umg.spotify.entity.Track;
import com.umg.spotify.reponse.DataResponse;
import com.umg.spotify.service.ITrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jonathangonzalez
 */
@RestController
@RequestMapping("/codechallenge")
@CrossOrigin(origins = "http://localhost:5173")
public class TrackController {
    
    @Autowired
    private ITrackService service;
    
    @PostMapping("/createTrack")
    public ResponseEntity<DataResponse<Track>> store(@RequestParam(required = true) String isrc){
        Track track = service.save(isrc);
        return ResponseEntity.ok(new DataResponse<>(true, track));
    }
    
    @GetMapping("/getTrackMetadata")
    public ResponseEntity<DataResponse<Track>> get(@RequestParam(required = true) String isrc){
        Track track = service.findByIsrc(isrc);
        return ResponseEntity.ok(new DataResponse<>(true, track));
    }
}
