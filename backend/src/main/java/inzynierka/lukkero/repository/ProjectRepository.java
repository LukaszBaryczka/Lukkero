package inzynierka.lukkero.repository;

import inzynierka.lukkero.model.Customer;
import inzynierka.lukkero.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository< Project, BigInteger > {
    List<Project> findProjectByCustomers( Customer customer);
}
