package inzynierka.lukkero.repository;

import inzynierka.lukkero.model.Change;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ChangesRepository extends CrudRepository< Change, BigInteger > {
}
