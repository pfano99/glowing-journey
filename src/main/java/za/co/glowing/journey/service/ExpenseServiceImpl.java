package za.co.glowing.journey.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.glowing.journey.model.Expense;
import za.co.glowing.journey.repository.ExpenseRepository;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService{

	@Autowired
	private ExpenseRepository expenseRepository;

	@Override
	public List<Expense> getAllExpenses() {
		return expenseRepository.findAll();
	}

	@Override
	public Expense addExpense(Expense expense) {
		return expenseRepository.save(expense);
	}

	@Override
	public Expense updateExpense(Expense expense) {
				return expenseRepository.save(expense);
	}

	@Override
	public void deleteExpense(Long expenseId) {
		expenseRepository.deleteById(expenseId);
	}
}
