package za.co.glowing.journey.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.glowing.journey.model.Budget;
import za.co.glowing.journey.service.BudgetService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/budget")
@CrossOrigin(origins = { "http://localhost:4200" })
@RequiredArgsConstructor
public class BudgetController {

	private final BudgetService budgetService;

	@GetMapping("/{budgetId}")
	public ResponseEntity<Budget> getBudgets(@PathVariable Long budgetId) {
		return ResponseEntity.ok(budgetService.getBudgetById(budgetId));
	}

	@GetMapping("/all/{userId}")
	public ResponseEntity<List<Budget>> getAllUserBudgets(@PathVariable Long userId) {
		return ResponseEntity.ok(budgetService.getAllBudgetByUserId(userId));
	}

	@PostMapping("/{userId}")
	public ResponseEntity<Budget> addBudget(@PathVariable Long userId, @RequestBody Budget budget) {
		return ResponseEntity.ok(budgetService.addBudget(budget, userId));
	}

	@PutMapping
	public ResponseEntity<Budget> updateBudget(@RequestBody Budget budget) {
		return ResponseEntity.ok(budgetService.updateBudget(budget));
	}

	@DeleteMapping("/{budgetId}")
	public ResponseEntity updateBudget(@PathVariable Long budgetId) {
		budgetService.deleteBudget(budgetId);
		return ResponseEntity.ok().build();
	}

}
