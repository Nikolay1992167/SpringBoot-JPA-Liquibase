package by.digital.chief.musicHub.services;

import by.digital.chief.musicHub.dto.request.RequestPeople;
import by.digital.chief.musicHub.dto.respons.ResponsePeople;
import by.digital.chief.musicHub.dto.respons.ResponseSongPlayers;
import by.digital.chief.musicHub.dto.update.UpdateRequestPeople;
import by.digital.chief.musicHub.entitie.PankGroup;
import by.digital.chief.musicHub.entitie.People;
import by.digital.chief.musicHub.entitie.SongPlayers;
import by.digital.chief.musicHub.exeptions.ResourceNotFoundException;
import by.digital.chief.musicHub.mapper.PeopleMapper;
import by.digital.chief.musicHub.repositories.PankGroupRepository;
import by.digital.chief.musicHub.repositories.PeopleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PeopleServiceImpl implements PeopleService{
    private final PeopleMapper peopleMapper;
    private final PeopleRepository peopleRepository;
    private final PankGroupRepository pankGroupRepository;

    @Override
    public List<ResponsePeople> getAllPeople() {
        ResponsePeople responsePeople = new ResponsePeople();
        return responsePeople.getPeopleResponseList(peopleRepository.findAll());
    }

    @Override
    public List<PankGroup> getByHuman(String human) {
        ResponsePeople responsePeople = new ResponsePeople();
        List<ResponsePeople> peopleList = responsePeople.getPeopleResponseList(peopleRepository.searchByHuman(human));
        List<PankGroup> pankGroups = new ArrayList<>();
        for (ResponsePeople people : peopleList) {
            pankGroups.add(people.getGroup());
        }
        return pankGroups;
    }

    @Override
    public List<SongPlayers> getSongByHuman(String human) {
        ResponsePeople responsePeople = new ResponsePeople();
        List<ResponsePeople> peopleResponseList = responsePeople.getPeopleResponseList(peopleRepository.findPeopleByHuman(human));
        List<List<ResponseSongPlayers>> songPlayersResponseList = new ArrayList<>();
        for (ResponsePeople pplResponse : peopleResponseList) {
            songPlayersResponseList.add(pplResponse.getSongPlayersList());
        }
        List<SongPlayers> songPlayersList = new ArrayList<>();
        for (List<ResponseSongPlayers> sngPlResponseList : songPlayersResponseList) {
            for (ResponseSongPlayers sngPlResponse : sngPlResponseList) {
                songPlayersList.add(new SongPlayers(sngPlResponse.getId(), sngPlResponse.getSong()));
            }
        }
        return songPlayersList;
    }

    @Override
    public People addPeople(RequestPeople requestPeople) {
        People people = peopleMapper.buildPeople(requestPeople);
        return peopleRepository.save(people);
    }

    @Override
    public void updPeople(UpdateRequestPeople updateRequestPeople) {
        People updatePeople = peopleRepository.findById(updateRequestPeople.getId())
                .map(people -> {
                    people.setHuman(updateRequestPeople.getHuman());
                    people.setAge(updateRequestPeople.getAge());
                    people.setNationality(updateRequestPeople.getNationality());
                    people.setStile(updateRequestPeople.getStile());
                    people.setPankGroup(pankGroupRepository.findById(updateRequestPeople.getIdGroup()).orElseThrow(() -> new ResourceNotFoundException(String.format("Not find pankgroup."))));
                    return people;
                })
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Not find people.")));
        peopleRepository.save(updatePeople);
    }

    @Override
    public void delPeople(long id) {
        peopleRepository.deleteById(id);
    }
}