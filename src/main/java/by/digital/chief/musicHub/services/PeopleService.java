package by.digital.chief.musicHub.services;

import by.digital.chief.musicHub.dto.request.RequestPeople;
import by.digital.chief.musicHub.dto.respons.ResponsePeople;
import by.digital.chief.musicHub.dto.update.UpdateRequestPeople;
import by.digital.chief.musicHub.entitie.PankGroup;
import by.digital.chief.musicHub.entitie.People;
import by.digital.chief.musicHub.entitie.SongPlayers;

import java.util.List;

public interface PeopleService {
    List<ResponsePeople> getAllPeople();
    List<PankGroup> getByHuman(String human);
    List<SongPlayers> getSongByHuman(String human);
    People addPeople(RequestPeople requestPeople);
    void updPeople(UpdateRequestPeople updateRequestPeople);
    void delPeople(long id);
}
