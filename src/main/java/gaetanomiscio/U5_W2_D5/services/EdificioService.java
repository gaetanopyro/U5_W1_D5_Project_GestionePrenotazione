package gaetanomiscio.U5_W2_D5.services;

import gaetanomiscio.U5_W2_D5.entities.Edificio;
import gaetanomiscio.U5_W2_D5.exceptions.NotFoundException;
import gaetanomiscio.U5_W2_D5.repositories.EdificioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EdificioService {
    @Autowired
    private EdificioRepository edificioRepository;

    public Edificio saveEdificio(Edificio edificio) {
        return edificioRepository.save(edificio);
    }

    public Edificio findById(long id) {
        return edificioRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

}
