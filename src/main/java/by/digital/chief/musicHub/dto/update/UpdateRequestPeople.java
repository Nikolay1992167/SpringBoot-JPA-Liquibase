package by.digital.chief.musicHub.dto.update;

import by.digital.chief.musicHub.entitie.PankGroup;
import by.digital.chief.musicHub.entitie.SongPlayers;
import lombok.Data;

import java.util.List;

@Data
public class UpdateRequestPeople {
    private long id;
    private String human;
    private Integer age;
    private String nationality;
    private PankGroup group;
    private String stile;
    private List<SongPlayers> songItems;
}
