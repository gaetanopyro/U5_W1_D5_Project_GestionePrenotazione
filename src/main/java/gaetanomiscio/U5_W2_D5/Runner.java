package gaetanomiscio.U5_W2_D5;

import gaetanomiscio.U5_W2_D5.entities.Edificio;
import gaetanomiscio.U5_W2_D5.entities.Postazione;
import gaetanomiscio.U5_W2_D5.entities.Utente;
import gaetanomiscio.U5_W2_D5.enums.Tipo;
import gaetanomiscio.U5_W2_D5.services.EdificioService;
import gaetanomiscio.U5_W2_D5.services.PostazioneService;
import gaetanomiscio.U5_W2_D5.services.PrenotazioneService;
import gaetanomiscio.U5_W2_D5.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    private EdificioService edificioService;
    @Autowired
    private PostazioneService postazioneService;
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private PrenotazioneService prenotazioneService;

    @Override
    public void run(String... args) throws Exception {

        Edificio edificio1 = new Edificio("Tower Street", "Via Giuseppe Verdi", "Modena");
        Edificio edificio2 = new Edificio("Kiwi", "Via Mario Rossi", "Milano");
        Edificio edificio3 = new Edificio("Pallazzo della Libertà", "Via Galileo Galilei", "Torino");
        Edificio edificio4 = new Edificio("Campus Universitario", "Via Giuseppe Mazzini", "Roma");
        Edificio edificio5 = new Edificio("Tech USB", "Via Napoli", "Napoli");
        edificio1 = edificioService.saveEdificio(edificio1);
        edificio2 = edificioService.saveEdificio(edificio2);
        edificio3 = edificioService.saveEdificio(edificio3);
        edificio4 = edificioService.saveEdificio(edificio4);
        edificio5 = edificioService.saveEdificio(edificio5);

        Postazione postazione1 = new Postazione("Postazione open space", Tipo.OPENSPACE, 5, edificio1);
        postazione1.setCodice(UUID.randomUUID());
        Postazione postazione2 = new Postazione("Postazione privata", Tipo.PRIVATO, 1, edificio2);
        postazione2.setCodice(UUID.randomUUID());
        Postazione postazione3 = new Postazione("Sala riunioni", Tipo.SALA_RIUNIONI, 10, edificio3);
        postazione3.setCodice(UUID.randomUUID());
        Postazione postazione4 = new Postazione("Postazione open space lato angolo", Tipo.OPENSPACE, 4, edificio4);
        postazione4.setCodice(UUID.randomUUID());
        Postazione postazione5 = new Postazione("Postazione ufficio", Tipo.PRIVATO, 2, edificio5);
        postazione5.setCodice(UUID.randomUUID());
        postazione1 = postazioneService.savePostazione(postazione1);
        postazione2 = postazioneService.savePostazione(postazione2);
        postazione3 = postazioneService.savePostazione(postazione3);
        postazione4 = postazioneService.savePostazione(postazione4);
        postazione5 = postazioneService.savePostazione(postazione5);

        Utente utente1 = new Utente("GiovanniS", "Giovanni Storti", "giovanni.storti@email.com");
        Utente utente2 = new Utente("MarioG", "Mario Giordano", "mario.giordano@email.com");
        Utente utente3 = new Utente("GabrieleV", "Gabriele Vagnato", "gabriele.vagnato@email.com");
        Utente utente4 = new Utente("FabrizioC", "Fabrizio Corona", "fabrizio.corona@email.com");
        Utente utente5 = new Utente("GiovanniM", "Giovanni Mucciaccia", "giovanni.mucciaccia@email.com");
        utente1 = utenteService.saveUtente(utente1);
        utente2 = utenteService.saveUtente(utente2);
        utente3 = utenteService.saveUtente(utente3);
        utente4 = utenteService.saveUtente(utente4);
        utente5 = utenteService.saveUtente(utente5);

        prenotazioneService.newPrenotazione(utente1.getId(), postazione1.getId(), LocalDate.of(2025, 7, 21));
        prenotazioneService.newPrenotazione(utente2.getId(), postazione2.getId(), LocalDate.of(2025, 7, 23));
        prenotazioneService.newPrenotazione(utente3.getId(), postazione3.getId(), LocalDate.of(2025, 7, 25));
        prenotazioneService.newPrenotazione(utente4.getId(), postazione4.getId(), LocalDate.of(2025, 7, 28));
        prenotazioneService.newPrenotazione(utente5.getId(), postazione5.getId(), LocalDate.of(2025, 7, 30));

        System.out.println("Dati delle Gestione delle prenotazioni inserite");
    }
}
