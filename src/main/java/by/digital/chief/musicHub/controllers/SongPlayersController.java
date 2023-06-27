package by.digital.chief.musicHub.controllers;

import by.digital.chief.musicHub.dto.request.RequestSongPlayers;
import by.digital.chief.musicHub.dto.respons.ResponseSongPlayers;
import by.digital.chief.musicHub.dto.update.UpdateRequestSongPlayers;
import by.digital.chief.musicHub.entitie.People;
import by.digital.chief.musicHub.entitie.SongPlayers;
import by.digital.chief.musicHub.services.SongPlayersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songplayers")
@RequiredArgsConstructor
public class SongPlayersController {

    private final SongPlayersService songPlayersServiceImpl;

    @GetMapping("/all")
    public List<ResponseSongPlayers> getSongPlayers() {
        return songPlayersServiceImpl.getSongPlayers();
    }

    @GetMapping("/getpeoplebysong/{song}")
    public List<People> getPeopleBySong(@PathVariable String song) {
        return songPlayersServiceImpl.getPeopleBySong(song);
    }

    @GetMapping("/getalbumbysong/{song}")
    public List<String> getAlbumBySong(@PathVariable String song) {
        return songPlayersServiceImpl.getAlbumBySong(song);
    }

    @GetMapping("/getsongbycomposer/{composer}")
    public List<String> getSongByComposer(@PathVariable String composer) {
        return songPlayersServiceImpl.getSongByComposer(composer);
    }

    @GetMapping("/getsongbypoet/{poet}")
    public List<String> getSongByPoet(@PathVariable String poet) {
        return songPlayersServiceImpl.getSongByPoet(poet);
    }

    @PostMapping("/add")
    public SongPlayers addSongPlayers(@RequestBody RequestSongPlayers requestSongPlayers) {
        return songPlayersServiceImpl.addSongPlayers(requestSongPlayers);
    }

    @DeleteMapping("/del/{id}")
    public void delSongPlayers(@PathVariable long id) {
        songPlayersServiceImpl.delSongPlayers(id);
    }

    @PutMapping("/upd")
    public void updSongPlayers(@RequestBody UpdateRequestSongPlayers updateRequestSongPlayers) {
        songPlayersServiceImpl.updSongPlayers(updateRequestSongPlayers);
    }
}
