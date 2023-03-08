package za.co.glowing.journey.service;

import za.co.glowing.journey.model.Expense;

import java.util.List;

public interface ExpenseService {

	List<Expense> getAllExpenses();

	 Expense addExpense(Expense expense);

	 Expense updateExpense(Expense expense);

	 void deleteExpense(Long expenseId);
}
