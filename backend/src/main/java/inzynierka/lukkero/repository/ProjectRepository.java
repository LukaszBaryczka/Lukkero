package inzynierka.lukkero.repository;

import inzynierka.lukkero.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ProjectRepository extends CrudRepository< Project, BigInteger > {

}
