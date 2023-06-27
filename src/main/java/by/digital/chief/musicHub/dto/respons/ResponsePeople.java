package by.digital.chief.musicHub.dto.respons;

import by.digital.chief.musicHub.entitie.PankGroup;
import by.digital.chief.musicHub.entitie.People;
import by.digital.chief.musicHub.entitie.SongPlayers;
import lombok.Data;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Data
@EnableTransactionManagement
public class ResponsePeople {
    private long id;
    private String human;
    private Integer age;
    private String nationality;
    private String stile;
    private PankGroup group;
    private List<ResponseSongPlayers> songPlayersList;

    @Transactional
    public List<ResponsePeople> getPeopleResponseList(List<People> peopleList) {
        List<ResponsePeople> responsePeopleList = new ArrayList<>();

        for (People people : peopleList) {
            songPlayersList = new ArrayList<>();

            ResponsePeople responsePeople = new ResponsePeople();
            responsePeople.setId(people.getId());
            responsePeople.setHuman(people.getHuman());
            responsePeople.setAge(people.getAge());
            responsePeople.setNationality(people.getNationality());
            responsePeople.setStile(people.getStile());
            responsePeople.setGroup(people.getPankGroup());
            for (SongPlayers songPlayers : people.getSongItems()) {
                ResponseSongPlayers responseSongPlayers = new ResponseSongPlayers();
                responseSongPlayers.setId(songPlayers.getId());
                responseSongPlayers.setSong(songPlayers.getSong());
                responseSongPlayers.setPoet(songPlayers.getPoet());
                responseSongPlayers.setComposer(songPlayers.getComposer());
                responseSongPlayers.setAlbum(songPlayers.getAlbum());
                songPlayersList.add(responseSongPlayers);
            }
            responsePeople.setSongPlayersList(songPlayersList);
            responsePeopleList.add(responsePeople);
        }
        return responsePeopleList;
    }
}
