package gaetanomiscio.U5_W2_D5.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "utenti")
@ToString
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    private String username;
    private String fullname;
    private String email;
    @OneToMany(mappedBy = "utente")
    private List<Prenotazione> prenotazioni;

    public Utente(String username, String fullname, String email) {
        this.username = username;
        this.fullname = fullname;
        this.email = email;
    }
}
