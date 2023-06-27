package by.digital.chief.musicHub.services;

import by.digital.chief.musicHub.dto.request.RequestSongPlayers;
import by.digital.chief.musicHub.dto.respons.ResponseSongPlayers;
import by.digital.chief.musicHub.dto.update.UpdateRequestSongPlayers;
import by.digital.chief.musicHub.entitie.People;
import by.digital.chief.musicHub.entitie.SongPlayers;

import java.util.List;

public interface SongPlayersService {
    List<ResponseSongPlayers> getSongPlayers();
    List<People> getPeopleBySong(String song);
    List<String> getAlbumBySong(String song);
    List<String> getSongByComposer(String composer);
    List<String> getSongByPoet(String poet);
    SongPlayers addSongPlayers(RequestSongPlayers requestSongPlayers);
    void delSongPlayers(long id);
    void updSongPlayers(UpdateRequestSongPlayers updateRequestSongPlayers);
}
