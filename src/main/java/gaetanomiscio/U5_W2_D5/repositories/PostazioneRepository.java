package gaetanomiscio.U5_W2_D5.repositories;

import gaetanomiscio.U5_W2_D5.entities.Postazione;
import gaetanomiscio.U5_W2_D5.enums.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {
    List<Postazione> findByTipoAndEdificio_Città(Tipo tipo, String città);
}
