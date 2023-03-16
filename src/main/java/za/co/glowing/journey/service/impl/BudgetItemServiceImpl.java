package za.co.glowing.journey.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import za.co.glowing.journey.model.Budget;
import za.co.glowing.journey.model.BudgetItem;
import za.co.glowing.journey.repository.BudgetItemsRepository;
import za.co.glowing.journey.service.BudgetItemService;
import za.co.glowing.journey.service.BudgetService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BudgetItemServiceImpl implements BudgetItemService {

	private final BudgetItemsRepository budgetItemsRepository;

	private final BudgetService budgetService;

	@Override
	public BudgetItem getBudgetItemById(Long budgetItemId) {
		// Todo: handle optional correct ... better logic
		return budgetItemsRepository.findById(budgetItemId).get();
	}

	@Override
	public List<BudgetItem> getAllBudgetItemByBudgetId(Long budgetId) {
		return budgetItemsRepository.findByBudgetId(budgetId);
	}

	@Override
	public BudgetItem addBudgetItem(BudgetItem budgetItem, Long budgetId) {
		Budget budget = budgetService.getBudgetById(budgetId);
		budgetItem.setBudget(budget);
		return budgetItemsRepository.save(budgetItem);
	}

	@Override
	public void deleteBudgetItem(Long budgetItemId) {
		budgetItemsRepository.deleteById(budgetItemId);
	}

	@Override
	public BudgetItem updateBudgetItem(BudgetItem budgetItem) {
		return budgetItemsRepository.save(budgetItem);
	}
}
