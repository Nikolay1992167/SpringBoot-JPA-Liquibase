package by.digital.chief.musicHub.mapper;

import by.digital.chief.musicHub.dto.request.RequestSongPlayers;
import by.digital.chief.musicHub.entitie.SongPlayers;
import by.digital.chief.musicHub.services.AlbumService;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class SongPlayersMapper {
    private final AlbumMapper albumMapper;
    private final AlbumService albumService;

    public SongPlayers buildSongPlayers(RequestSongPlayers requestSongPlayers) {
        return SongPlayers.builder()
                .song(requestSongPlayers.getSong())
                .composer(requestSongPlayers.getComposer())
                .poet(requestSongPlayers.getPoet())
                .album(albumMapper.buildAlbum(albumService.getAlbum(requestSongPlayers.getIdAlbum())))
                .build();
    }
}
