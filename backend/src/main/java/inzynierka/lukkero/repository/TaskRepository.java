package inzynierka.lukkero.repository;

import inzynierka.lukkero.model.Customer;
import inzynierka.lukkero.model.Project;
import inzynierka.lukkero.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository< Task, BigInteger > {
    List< Task > findTasksByProject ( Project project );
    
    List< Task > findTasksByCustomer ( Customer customer );
}
