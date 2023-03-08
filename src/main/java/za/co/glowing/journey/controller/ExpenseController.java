package za.co.glowing.journey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.glowing.journey.model.Expense;
import za.co.glowing.journey.service.ExpenseService;

import java.util.List;

@RestController()
@RequestMapping("/expenses")
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;

	@GetMapping
	public ResponseEntity<List<Expense>> getAllExpenses() {
		return ResponseEntity.ok().body(expenseService.getAllExpenses());
	}

	@PostMapping
	public ResponseEntity<Expense> addExpense(@RequestBody Expense expense) {
		return ResponseEntity.ok().body(expenseService.addExpense(expense));
	}

	@PutMapping
	public ResponseEntity<Expense> updateExpense(@RequestBody Expense expense) {
		return ResponseEntity.ok().body(expenseService.updateExpense(expense));
	}

	@DeleteMapping("/{expenseId}")
	public ResponseEntity<Expense> deleteExpense(@PathVariable Long expenseId) {
		expenseService.deleteExpense(expenseId);
		return ResponseEntity.ok().build();
	}

}
