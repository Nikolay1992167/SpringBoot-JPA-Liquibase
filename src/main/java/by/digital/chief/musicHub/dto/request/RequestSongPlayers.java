package by.digital.chief.musicHub.dto.request;

import by.digital.chief.musicHub.entitie.People;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RequestSongPlayers {
    private String song;
    private String composer;
    private String poet;
    private String album;
    private List<People> songInstrumentalist;
}
