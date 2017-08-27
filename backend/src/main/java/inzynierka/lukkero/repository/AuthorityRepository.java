package inzynierka.lukkero.repository;

import inzynierka.lukkero.model.security.Authority;
import inzynierka.lukkero.model.security.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AuthorityRepository  extends JpaRepository< Authority, Long > {
    Authority findByName(AuthorityName name);
}
