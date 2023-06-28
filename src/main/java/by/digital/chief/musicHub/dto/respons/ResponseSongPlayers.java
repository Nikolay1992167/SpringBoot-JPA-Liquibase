package by.digital.chief.musicHub.dto.respons;

import by.digital.chief.musicHub.entitie.People;
import by.digital.chief.musicHub.entitie.SongPlayers;
import lombok.Data;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Data
@EnableTransactionManagement
public class ResponseSongPlayers {
    private long id;
    private String song;
    private String composer;
    private String poet;
    private String album;
    private List<ResponsePeople> songInstrumentalistList;

    @Transactional
    public List<ResponseSongPlayers> getSongPlayersResponseList(List<SongPlayers> songPlayersList) {
        List<ResponseSongPlayers> responseSongPlayersList = new ArrayList<>();
        for (SongPlayers songPlayers : songPlayersList) {
            songInstrumentalistList = new ArrayList<>();
            ResponseSongPlayers responseSongPlayers = new ResponseSongPlayers();
            responseSongPlayers.setId(songPlayers.getId());
            responseSongPlayers.setSong(songPlayers.getSong());
            responseSongPlayers.setComposer(songPlayers.getComposer());
            responseSongPlayers.setPoet(songPlayers.getPoet());
            responseSongPlayers.setAlbum((songPlayers.getAlbum()).getAlbum());
            for (People people : songPlayers.getSongInstrumentalist()) {
                ResponsePeople responsePeople = new ResponsePeople();
                responsePeople.setId(people.getId());
                responsePeople.setHuman(people.getHuman());
                responsePeople.setGroup((people.getPankGroup()).getPankGroup());
                songInstrumentalistList.add(responsePeople);
            }
            responseSongPlayers.setSongInstrumentalistList(songInstrumentalistList);
            responseSongPlayersList.add(responseSongPlayers);
        }
        return responseSongPlayersList;
    }
}
