package gaetanomiscio.U5_W2_D5.repositories;

import gaetanomiscio.U5_W2_D5.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {
    boolean existsByUsername(String username);
}
