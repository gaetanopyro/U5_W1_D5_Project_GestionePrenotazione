package gaetanomiscio.U5_W2_D5.services;

import gaetanomiscio.U5_W2_D5.entities.Utente;
import gaetanomiscio.U5_W2_D5.exceptions.NotFoundException;
import gaetanomiscio.U5_W2_D5.exceptions.ValidationException;
import gaetanomiscio.U5_W2_D5.repositories.UtenteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UtenteService {
    @Autowired
    private UtenteRepository utenteRepository;

    public Utente saveUtente(Utente utente) {
        if (utenteRepository.existsByUsername(utente.getUsername()))
            throw new ValidationException("L'username:" + utente.getUsername() + " è in uso");
        return utenteRepository.save(utente);
    }

    public Utente findById(long id) {
        return utenteRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

}
