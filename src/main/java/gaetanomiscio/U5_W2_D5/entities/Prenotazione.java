package gaetanomiscio.U5_W2_D5.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "prenotazioni")
@Getter
@Setter
@NoArgsConstructor
@ToString

public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    @ManyToOne
    @JoinColumn(name = "postazione_id")
    private Postazione postazione;
    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;
    private LocalDate dataPrenotazione;


    public Prenotazione(Postazione postazione, Utente utente, LocalDate dataPrenotazione) {
        this.postazione = postazione;
        this.utente = utente;
        this.dataPrenotazione = dataPrenotazione;
    }


}
