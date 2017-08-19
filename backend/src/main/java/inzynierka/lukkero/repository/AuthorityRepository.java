package inzynierka.lukkero.repository;

import inzynierka.lukkero.model.security.Authority;
import inzynierka.lukkero.model.security.AuthorityName;
import org.springframework.data.repository.CrudRepository;

public interface AuthorityRepository  extends CrudRepository< Authority, Long > {
    Authority findByName(AuthorityName name);
}
