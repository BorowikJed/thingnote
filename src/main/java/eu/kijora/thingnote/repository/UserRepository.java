package eu.kijora.thingnote.repository;

import eu.kijora.thingnote.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
