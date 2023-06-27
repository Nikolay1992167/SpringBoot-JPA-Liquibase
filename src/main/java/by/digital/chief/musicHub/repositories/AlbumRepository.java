package by.digital.chief.musicHub.repositories;

import by.digital.chief.musicHub.entitie.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
}
