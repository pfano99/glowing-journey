package za.co.glowing.journey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.co.glowing.journey.model.Account;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	@Query(value = "SELECT * FROM Account a WHERE a.person_id = ?1", nativeQuery = true)
	List<Account> findAllByUserId(Long userId);

}



