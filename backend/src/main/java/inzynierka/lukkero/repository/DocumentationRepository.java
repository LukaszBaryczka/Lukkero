package inzynierka.lukkero.repository;

import inzynierka.lukkero.model.Change;
import inzynierka.lukkero.model.Documentation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface DocumentationRepository extends JpaRepository< Documentation, BigInteger > {
}
