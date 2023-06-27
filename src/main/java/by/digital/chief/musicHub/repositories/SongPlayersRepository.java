package by.digital.chief.musicHub.repositories;

import by.digital.chief.musicHub.entitie.SongPlayers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongPlayersRepository extends JpaRepository<SongPlayers, Long> {
    List<SongPlayers> findSongPlayersBySong(String song);
    List<SongPlayers> findSongPlayersByComposer(String composer);
    List<SongPlayers> findSongPlayersByPoet(String poet);
}
