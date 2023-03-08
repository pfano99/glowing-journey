package za.co.glowing.journey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.glowing.journey.model.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
