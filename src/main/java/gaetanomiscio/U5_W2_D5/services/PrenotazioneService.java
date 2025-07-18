package gaetanomiscio.U5_W2_D5.services;

import gaetanomiscio.U5_W2_D5.entities.Postazione;
import gaetanomiscio.U5_W2_D5.entities.Prenotazione;
import gaetanomiscio.U5_W2_D5.entities.Utente;
import gaetanomiscio.U5_W2_D5.exceptions.NotFoundException;
import gaetanomiscio.U5_W2_D5.exceptions.ValidationException;
import gaetanomiscio.U5_W2_D5.repositories.PostazioneRepository;
import gaetanomiscio.U5_W2_D5.repositories.PrenotazioneRepository;
import gaetanomiscio.U5_W2_D5.repositories.UtenteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class PrenotazioneService {
    @Autowired
    UtenteRepository utenteRepository;
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;
    @Autowired
    private PostazioneRepository postazioneRepository;

    public Prenotazione newPrenotazione(Long idUtente, Long idPostazione, LocalDate data) {
        Utente utente = utenteRepository.findById(idUtente).orElseThrow(() -> new NotFoundException(idUtente));
        Postazione postazione = postazioneRepository.findById(idPostazione).orElseThrow(() -> new NotFoundException(idPostazione));

        boolean postazionePresa = prenotazioneRepository.existsByPostazioneAndDataPrenotazione(postazione, data);
        if (postazionePresa) {
            throw new ValidationException("Mi dispiace, la postazione è gia stata occupata per quella data");
        }
        boolean utentePrenotatoGg = prenotazioneRepository.existsByUtenteAndDataPrenotazione(utente, data);
        if (utentePrenotatoGg) {
            throw new ValidationException("Mi dispiace, l'utente ha gia prenotato per quel giorno");
        }
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setUtente(utente);
        prenotazione.setPostazione(postazione);
        prenotazione.setDataPrenotazione(data);
        return prenotazioneRepository.save(prenotazione);
    }

    public List<Prenotazione> findPrenotazioniByUtente(long idUtente) {
        return prenotazioneRepository.findByUtenteId(idUtente);
    }


}
