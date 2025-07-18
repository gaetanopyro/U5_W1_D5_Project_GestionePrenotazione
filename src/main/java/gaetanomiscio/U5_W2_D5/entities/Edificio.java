package gaetanomiscio.U5_W2_D5.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "edificio")
@ToString

public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    private String nome;
    private String indirizzo;
    private String città;
    @OneToMany(mappedBy = "edificio")
    private List<Postazione> postazioni;

    public Edificio(String nome, String indirizzo, String città) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.città = città;
    }
}
