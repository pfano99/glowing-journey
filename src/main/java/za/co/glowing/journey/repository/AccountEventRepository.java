package za.co.glowing.journey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.co.glowing.journey.model.AccountEvent;

import java.util.List;

@Repository
public interface AccountEventRepository extends JpaRepository<AccountEvent, Long> {

	@Query(value = "SELECT * FROM account_event a WHERE a.account_id = ?1", nativeQuery = true)
	List<AccountEvent> findByAccountId(Long accountId);
}
