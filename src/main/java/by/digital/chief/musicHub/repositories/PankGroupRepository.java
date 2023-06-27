package by.digital.chief.musicHub.repositories;

import by.digital.chief.musicHub.entitie.PankGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PankGroupRepository extends JpaRepository <PankGroup, Long>{
}
