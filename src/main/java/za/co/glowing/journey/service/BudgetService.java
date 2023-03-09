package za.co.glowing.journey.service;

import za.co.glowing.journey.model.Budget;

import java.util.List;

public interface BudgetService {

	Budget getBudgetById(Long budgetId);

	List<Budget> getAllBudgetByUserId(Long userId);

	Budget addBudget(Budget budget, Long userId);

	void deleteBudget(Long budgetId);

	Budget updateBudget(Budget budget);
}
