package za.co.glowing.journey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.glowing.journey.model.BudgetItem;

import java.util.List;

@Repository
public interface BudgetItemsRepository extends JpaRepository<BudgetItem, Long> {

	List<BudgetItem> findByBudgetId(Long budgetId);

}
