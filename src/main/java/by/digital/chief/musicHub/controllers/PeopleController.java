package by.digital.chief.musicHub.controllers;

import by.digital.chief.musicHub.dto.request.RequestPeople;
import by.digital.chief.musicHub.dto.respons.ResponsePeople;
import by.digital.chief.musicHub.dto.update.UpdateRequestPeople;
import by.digital.chief.musicHub.entitie.PankGroup;
import by.digital.chief.musicHub.entitie.People;
import by.digital.chief.musicHub.entitie.SongPlayers;
import by.digital.chief.musicHub.services.PeopleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
@RequiredArgsConstructor
public class PeopleController{

    private final PeopleService peopleServiceImpl;

    @GetMapping("/all")
    public List<ResponsePeople> getAllPeople() {
        return peopleServiceImpl.getAllPeople();
    }

    @GetMapping("/getbyhuman/{human}")
    public List<String> getByHuman(@PathVariable String human) {
        return peopleServiceImpl.getByHuman(human);
    }

    @GetMapping("/getsongbyhuman/{human}")
    public List<SongPlayers> getSongByHuman(@PathVariable String human) {
        return peopleServiceImpl.getSongByHuman(human);
    }

    @PostMapping("/add")
    public People addPeople(@RequestBody RequestPeople requestPeople) {
        return peopleServiceImpl.addPeople(requestPeople);
    }

    @DeleteMapping("/del/{id}")
    public void delPeople(@PathVariable long id) {
        peopleServiceImpl.delPeople(id);
    }

    @PutMapping("/upd")
    public void updPeople(@RequestBody UpdateRequestPeople updateRequestPeople) {
        peopleServiceImpl.updPeople(updateRequestPeople);
    }
}
