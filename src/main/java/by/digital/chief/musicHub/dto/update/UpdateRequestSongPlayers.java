package by.digital.chief.musicHub.dto.update;

import by.digital.chief.musicHub.entitie.People;
import lombok.Data;

import java.util.List;
@Data
public class UpdateRequestSongPlayers {
    private long id;
    private String song;
    private String composer;
    private String poet;
    private String album;
    private List<People> songInstrumentalist;
}
