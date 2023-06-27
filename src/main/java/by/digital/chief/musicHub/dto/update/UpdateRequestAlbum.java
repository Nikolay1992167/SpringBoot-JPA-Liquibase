package by.digital.chief.musicHub.dto.update;

import by.digital.chief.musicHub.entitie.SongPlayers;
import lombok.Data;

import java.util.List;

@Data
public class UpdateRequestAlbum {
    private long id;
    private String album;
    private List<SongPlayers> songPlayersList;
}
