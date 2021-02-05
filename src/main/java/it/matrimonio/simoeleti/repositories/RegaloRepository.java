package it.matrimonio.simoeleti.repositories;

import it.matrimonio.simoeleti.entities.Regalo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegaloRepository extends JpaRepository<Regalo, Long> {

}
