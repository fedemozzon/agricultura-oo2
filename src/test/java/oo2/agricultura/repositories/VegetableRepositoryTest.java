package oo2.agricultura.repositories;

import oo2.agricultura.model.Vegetal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class VegetableRepositoryTest {

    @Autowired
    private VegetalRepository vegetalRepository;

    @Test
    void createVegetable() {
        Vegetal veg1 = new Vegetal("Lechuga","Hace bien a la digestion","https://es.wikipedia.org/wiki/Lactuca_sativa");
        vegetalRepository.save(veg1);
        Optional<Vegetal> vegPersist = vegetalRepository.findById(veg1.getId());
        Assertions.assertEquals("Lechuga",vegPersist.get().getName());
        Assertions.assertEquals("Hace bien a la digestion",vegPersist.get().getProperties());
        Assertions.assertEquals("https://es.wikipedia.org/wiki/Lactuca_sativa",vegPersist.get().getLinkToWikipedia());
    }
}
