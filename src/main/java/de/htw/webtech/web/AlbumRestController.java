package de.htw.webtech.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlbumRestController {

    @Autowired
    public final AlbumService albumService;

    @Autowired
    public AlbumRepository albumRepository;

    public AlbumRestController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/album/{id}")
    public Album getAlbum(@PathVariable String id){
        Long albumId = Long.parseLong(id);
        return albumService.get(albumId);
    }

    @GetMapping("/album")
    public ResponseEntity<List<Album>> getAll() {
        return ResponseEntity.ok(albumService.findAll());
    }

    @PostMapping("/album")
    public ResponseEntity<Album> createAlbum(@RequestBody Album album) {
        albumService.save(album);
        return new ResponseEntity<>(album, HttpStatus.CREATED);
    }

    @PutMapping("/album/{albumId}")
    public Album updateAlbum(@PathVariable Long albumId, @RequestBody Album albumRequest) {
        return albumRepository.findById(albumId).map(album -> {
            album.setName(albumRequest.getName());
            return albumRepository.save(album);
        }).orElseThrow(() -> new RuntimeException("AlbumId " + albumId + " not found"));
    }

    @DeleteMapping("album/{albumId}")
    public ResponseEntity<?> deleteAlbum(@PathVariable Long albumId){
        return albumRepository.findById(albumId).map(album -> {
            albumRepository.delete(album);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new RuntimeException("AlbumId " + albumId + " not found"));
    }
}
