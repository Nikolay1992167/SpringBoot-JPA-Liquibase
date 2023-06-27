package by.digital.chief.musicHub.mapper;

import by.digital.chief.musicHub.dto.request.RequestSongPlayers;
import by.digital.chief.musicHub.entitie.SongPlayers;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class SongPlayersMapper {
    public SongPlayers buildSongPlayers(RequestSongPlayers requestSongPlayers) {
        return SongPlayers.builder()
                .song(requestSongPlayers.getSong())
                .composer(requestSongPlayers.getComposer())
                .poet(requestSongPlayers.getPoet())
                .album(requestSongPlayers.getAlbum())
                .songInstrumentalist(requestSongPlayers.getSongInstrumentalist())
                .build();
    }
}
