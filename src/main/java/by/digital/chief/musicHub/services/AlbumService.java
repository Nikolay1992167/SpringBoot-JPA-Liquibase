package by.digital.chief.musicHub.services;

import by.digital.chief.musicHub.dto.request.RequestAlbum;
import by.digital.chief.musicHub.dto.respons.ResponseAlbum;
import by.digital.chief.musicHub.dto.update.UpdateRequestAlbum;
import by.digital.chief.musicHub.entitie.Album;

import java.util.List;

public interface AlbumService {
    List<ResponseAlbum> getAllAlbum();
    Album addAlbum(RequestAlbum requestAlbum);
    void delAlbum(long id );
    void updAlbum(UpdateRequestAlbum updateRequestAlbum);
}
