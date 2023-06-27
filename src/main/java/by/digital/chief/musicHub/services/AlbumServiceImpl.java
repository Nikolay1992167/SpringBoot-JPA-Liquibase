package by.digital.chief.musicHub.services;

import by.digital.chief.musicHub.dto.request.RequestAlbum;
import by.digital.chief.musicHub.dto.respons.ResponseAlbum;
import by.digital.chief.musicHub.dto.update.UpdateRequestAlbum;
import by.digital.chief.musicHub.entitie.Album;
import by.digital.chief.musicHub.exeptions.ResourceNotFoundException;
import by.digital.chief.musicHub.mapper.AlbumMapper;
import by.digital.chief.musicHub.repositories.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumServiceImpl implements AlbumService {
    private final AlbumMapper albumMapper;
    private final AlbumRepository albumRepository;


    @Override
    public List<ResponseAlbum> getAllAlbum() {
        ResponseAlbum responseAlbum = new ResponseAlbum();
        return responseAlbum.getAllAlbumResponseList(albumRepository.findAll());
    }

    @Override
    public Album addAlbum(RequestAlbum requestAlbum) {
        Album album = albumMapper.buildAlbum(requestAlbum);
        return albumRepository.save(album);
    }

    @Override
    public void delAlbum(long id) {
        albumRepository.deleteById(id);
    }

    @Override
    public void updAlbum(UpdateRequestAlbum updateRequestAlbum) {
        Album updateAlbum = albumRepository.findById(updateRequestAlbum.getId())
                .map(album -> {
                    album.setAlbum(updateRequestAlbum.getAlbum());
                    return album;
                })
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Not find album.")));
        albumRepository.save(updateAlbum);
    }
}
