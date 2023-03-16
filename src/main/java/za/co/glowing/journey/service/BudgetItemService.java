package za.co.glowing.journey.service;

import za.co.glowing.journey.model.BudgetItem;

import java.util.List;

public interface BudgetItemService {

	BudgetItem getBudgetItemById(Long budgetItemId);

	List<BudgetItem> getAllBudgetItemByBudgetId(Long budgetId);

	BudgetItem addBudgetItem(BudgetItem budgetItem, Long budgetId);

	void deleteBudgetItem(Long budgetItemId);

	BudgetItem updateBudgetItem(BudgetItem budgetItem);
}
