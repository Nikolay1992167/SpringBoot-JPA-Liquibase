package by.digital.chief.musicHub.dto.request;

import by.digital.chief.musicHub.entitie.SongPlayers;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RequestAlbum {
    private String album;
    private List<SongPlayers> songPlayersList;
}
