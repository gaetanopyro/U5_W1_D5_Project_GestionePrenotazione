package gaetanomiscio.U5_W2_D5.entities;

import gaetanomiscio.U5_W2_D5.enums.Tipo;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "postazione")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    private UUID codice;
    private String desrizione;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    private int numMaxOccupanti;
    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;
    @OneToMany(mappedBy = "postazione")
    private List<Prenotazione> prenotazioni;

    public Postazione(String desrizione, Tipo tipo, int numMaxOccupanti, Edificio edificio) {
        this.desrizione = desrizione;
        this.tipo = tipo;
        this.numMaxOccupanti = numMaxOccupanti;
        this.edificio = edificio;
    }
}
