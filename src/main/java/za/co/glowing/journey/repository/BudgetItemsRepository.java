package za.co.glowing.journey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.glowing.journey.model.BudgetItems;

@Repository
public interface BudgetItemsRepository extends JpaRepository<BudgetItems, Long> {
}
