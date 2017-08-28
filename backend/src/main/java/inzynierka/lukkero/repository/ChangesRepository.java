package inzynierka.lukkero.repository;

import inzynierka.lukkero.model.Change;
import inzynierka.lukkero.model.Customer;
import inzynierka.lukkero.model.Project;
import inzynierka.lukkero.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface ChangesRepository extends JpaRepository< Change, BigInteger > {
    List<Change> findChangesByProject(Project project);
    List<Change> findChangesByTask(Task task);
}
