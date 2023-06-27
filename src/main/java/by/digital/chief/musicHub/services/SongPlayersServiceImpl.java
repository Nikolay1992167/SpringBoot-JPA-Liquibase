package by.digital.chief.musicHub.services;

import by.digital.chief.musicHub.dto.request.RequestSongPlayers;
import by.digital.chief.musicHub.dto.respons.ResponsePeople;
import by.digital.chief.musicHub.dto.respons.ResponseSongPlayers;
import by.digital.chief.musicHub.dto.update.UpdateRequestSongPlayers;
import by.digital.chief.musicHub.entitie.People;
import by.digital.chief.musicHub.entitie.SongPlayers;
import by.digital.chief.musicHub.exeptions.ResourceNotFoundException;
import by.digital.chief.musicHub.mapper.SongPlayersMapper;
import by.digital.chief.musicHub.repositories.SongPlayersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SongPlayersServiceImpl implements SongPlayersService {
    private final SongPlayersMapper songPlayersMapper;
    private final SongPlayersRepository songPlayersRepository;

    @Override
    public List<ResponseSongPlayers> getSongPlayers() {
        ResponseSongPlayers responseSongPlayers = new ResponseSongPlayers();
        return responseSongPlayers.getSongPlayersResponseList(songPlayersRepository.findAll());
    }

    @Override
    public List<People> getPeopleBySong(String song) {
        ResponseSongPlayers songPlayersResponse = new ResponseSongPlayers();
        List<ResponseSongPlayers> songPlayersResponseList = songPlayersResponse.getSongPlayersResponseList(songPlayersRepository.findSongPlayersBySong(song));
        List<List<ResponsePeople>> peopleResponseList = new ArrayList<>();
        for (ResponseSongPlayers sngPlResponse : songPlayersResponseList) {
            peopleResponseList.add(sngPlResponse.getSongInstrumentalistList());
        }
        List<People> peopleList = new ArrayList<>();
        for (List<ResponsePeople> pplResponseList : peopleResponseList) {
            for (ResponsePeople pplResponse : pplResponseList) {
                peopleList.add(new People(pplResponse.getId(), pplResponse.getHuman()));
            }
        }
        return peopleList;
    }

    @Override
    public List<String> getAlbumBySong(String song) {
        ResponseSongPlayers songPlayersResponse = new ResponseSongPlayers();
        List<ResponseSongPlayers> songPlayersResponseList = songPlayersResponse.getSongPlayersResponseList(songPlayersRepository.findSongPlayersBySong(song));
        List<String> albumList = new ArrayList<>();
        for (ResponseSongPlayers sngPlResponse : songPlayersResponseList) {
            albumList.add(sngPlResponse.getAlbum());
        }
        return albumList;
    }

    @Override
    public List<String> getSongByComposer(String composer) {
        ResponseSongPlayers songPlayersResponse = new ResponseSongPlayers();
        List<ResponseSongPlayers> songPlayersResponseList = songPlayersResponse.getSongPlayersResponseList(songPlayersRepository.findSongPlayersByComposer(composer));
        List<String> songList = new ArrayList<>();
        for (ResponseSongPlayers sngPlResponse : songPlayersResponseList) {
            songList.add(sngPlResponse.getSong());
        }
        return songList;
    }

    @Override
    public List<String> getSongByPoet(String poet) {
        ResponseSongPlayers songPlayersResponse = new ResponseSongPlayers();
        List<ResponseSongPlayers> songPlayersResponseList = songPlayersResponse.getSongPlayersResponseList(songPlayersRepository.findSongPlayersByPoet(poet));
        List<String> songList = new ArrayList<>();
        for (ResponseSongPlayers sngPlResponse : songPlayersResponseList) {
            songList.add(sngPlResponse.getSong());
        }
        return songList;
    }

    @Override
    public SongPlayers addSongPlayers(RequestSongPlayers requestSongPlayers) {
        SongPlayers songPlayers = songPlayersMapper.buildSongPlayers(requestSongPlayers);
        return songPlayersRepository.save(songPlayers);
    }

    @Override
    public void delSongPlayers(long id) {
        songPlayersRepository.deleteById(id);
    }

    @Override
    public void updSongPlayers(UpdateRequestSongPlayers updateRequestSongPlayers) {
        SongPlayers updateSongPlayers = songPlayersRepository.findById(updateRequestSongPlayers.getId())
                .map(songPlayers -> {
                    songPlayers.setSong(updateRequestSongPlayers.getSong());
                    songPlayers.setComposer(updateRequestSongPlayers.getComposer());
                    songPlayers.setPoet(updateRequestSongPlayers.getPoet());
                    songPlayers.setAlbum(updateRequestSongPlayers.getAlbum());
                    songPlayers.setSongInstrumentalist(updateRequestSongPlayers.getSongInstrumentalist());
                    return songPlayers;
                })
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Not find songplayers.")));
        songPlayersRepository.save(updateSongPlayers);
    }
}

