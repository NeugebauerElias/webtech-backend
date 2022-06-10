package de.htw.webtech.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AlbumRestController {

    @Autowired
    public AlbumService albumService;

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
}
