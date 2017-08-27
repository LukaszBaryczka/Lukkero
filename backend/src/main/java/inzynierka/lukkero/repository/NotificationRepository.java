package inzynierka.lukkero.repository;

import inzynierka.lukkero.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface NotificationRepository extends JpaRepository< Notification, BigInteger > {
}
