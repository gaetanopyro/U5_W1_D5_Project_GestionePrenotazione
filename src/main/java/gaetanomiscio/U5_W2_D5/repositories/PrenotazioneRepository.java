package gaetanomiscio.U5_W2_D5.repositories;

import gaetanomiscio.U5_W2_D5.entities.Postazione;
import gaetanomiscio.U5_W2_D5.entities.Prenotazione;
import gaetanomiscio.U5_W2_D5.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    boolean existsByPostazioneAndDataPrenotazione(Postazione postazione, LocalDate date);

    boolean existsByUtenteAndDataPrenotazione(Utente utente, LocalDate data);

    List<Prenotazione> findByUtenteId(Long utenteId);
}
