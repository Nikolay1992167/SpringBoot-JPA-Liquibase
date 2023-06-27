package by.digital.chief.musicHub.controllers;

import by.digital.chief.musicHub.dto.request.RequestAlbum;
import by.digital.chief.musicHub.dto.respons.ResponseAlbum;
import by.digital.chief.musicHub.dto.update.UpdateRequestAlbum;
import by.digital.chief.musicHub.entitie.Album;
import by.digital.chief.musicHub.services.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/album")
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumService albumServiceImpl;

    @GetMapping("/all")
    public List<ResponseAlbum> getAllAlbum() {
        return albumServiceImpl.getAllAlbum();
    }

    @PostMapping("/add")
    public Album addAlbum(@RequestBody RequestAlbum requestAlbum) {
        return albumServiceImpl.addAlbum(requestAlbum);
    }

    @DeleteMapping("/del/{id}")
    public void delAlbum(@PathVariable long id) {
        albumServiceImpl.delAlbum(id);
    }

    @PutMapping("/upd/{id}")
    public void updAlbum(@RequestBody UpdateRequestAlbum updateRequestAlbum) {
        albumServiceImpl.updAlbum(updateRequestAlbum);
    }
}
