package it.matrimonio.simoeleti.repositories;

import it.matrimonio.simoeleti.entities.Oggetto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OggettoRepository extends JpaRepository<Oggetto, String> {

}
