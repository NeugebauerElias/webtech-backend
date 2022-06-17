package de.htw.webtech.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/album")
    public Album createAlbum(@RequestBody Album album) {
            return albumService.save(album);
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
