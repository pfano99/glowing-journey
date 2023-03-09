package za.co.glowing.journey.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import za.co.glowing.journey.model.Budget;
import za.co.glowing.journey.model.Person;
import za.co.glowing.journey.repository.BudgetRepository;
import za.co.glowing.journey.service.BudgetService;
import za.co.glowing.journey.service.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BudgetServiceImpl implements BudgetService {

	private final BudgetRepository budgetRepository;

	private final UserService userService;

	@Override
	public Budget getBudgetById(Long budgetId) {
		return budgetRepository.findById(budgetId).get();
	}

	@Override
	public List<Budget> getAllBudgetByUserId(Long userId) {
		return budgetRepository.findAllByPersonId(userId);
	}

	@Override
	public Budget addBudget(Budget budget, Long userId) {
		Person user = userService.getUser(userId);
		budget.setPerson(user);
		return budgetRepository.save(budget);
	}

	@Override
	public void deleteBudget(Long budgetId) {
		budgetRepository.deleteById((budgetId));
	}

	@Override
	public Budget updateBudget(Budget budget) {
		return null;
	}
}
