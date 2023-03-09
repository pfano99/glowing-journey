package za.co.glowing.journey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.co.glowing.journey.model.Budget;

import java.util.List;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {

//	@Query(name = "SELECT * FROM Budget b WHERE b.person_id = ?1", nativeQuery = true)
	List<Budget> findAllByPersonId(Long userId);
}
