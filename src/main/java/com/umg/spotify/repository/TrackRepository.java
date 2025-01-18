/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.umg.spotify.repository;

import com.umg.spotify.entity.Track;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jonathangonzalez
 */
@Repository
public interface TrackRepository extends CrudRepository<Track, Integer>{
    public Optional<Track> findByIsrc(String isrc);
    public void deleteByIsrc(String isrc);
    public boolean existsByIsrc(String isrc);
}
