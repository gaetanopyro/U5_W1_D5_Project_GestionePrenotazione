package gaetanomiscio.U5_W2_D5.services;

import gaetanomiscio.U5_W2_D5.entities.Postazione;
import gaetanomiscio.U5_W2_D5.enums.Tipo;
import gaetanomiscio.U5_W2_D5.exceptions.NotFoundException;
import gaetanomiscio.U5_W2_D5.repositories.PostazioneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PostazioneService {
    @Autowired
    private PostazioneRepository postazioneRepository;

    public Postazione savePostazione(Postazione postazione) {
        return postazioneRepository.save(postazione);
    }

    public Postazione findById(Long id) {
        return postazioneRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    List<Postazione> ricercaPerTipoCittà(Tipo tipo, String città) {
        return postazioneRepository.findByTipoAndEdificio_Città(tipo, città);
    }
}
