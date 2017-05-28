package inzynierka.lukkero.repository;

import inzynierka.lukkero.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.List;

public interface UserRepository extends CrudRepository<Customer, BigInteger> {
    List<Customer> findUserByName(String name);
    List<Customer> findUserBySurname(String surname);
}
