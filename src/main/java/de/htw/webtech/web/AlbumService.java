package de.htw.webtech.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {
    @Autowired
    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }
    public Album save(Album album) {
        return albumRepository.save(album);
    }

    public Album get(Long id) {
        return albumRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<Album> findAll(){
        List<Album> alben = (List<Album>) albumRepository.findAll();
        if(alben != null) {
            return alben;
        }else{
            throw new RuntimeException("No Alben exist");
        }
    }
}
