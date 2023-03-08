package za.co.glowing.journey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.glowing.journey.model.Person;

public interface UserRepository extends JpaRepository<Person, Long> {
}
