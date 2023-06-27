package by.digital.chief.musicHub.repositories;

import by.digital.chief.musicHub.entitie.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {
    List<People> searchByHuman(String human);
    List<People> findPeopleByHuman(String human);
}
