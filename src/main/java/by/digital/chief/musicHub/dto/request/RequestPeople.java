package by.digital.chief.musicHub.dto.request;

import by.digital.chief.musicHub.entitie.SongPlayers;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestPeople {
    private String human;
    private Integer age;
    private String nationality;
    private Integer idGroup;
    private String stile;
    private List<SongPlayers> songItems;
}
