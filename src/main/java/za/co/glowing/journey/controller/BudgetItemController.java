package za.co.glowing.journey.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.glowing.journey.model.BudgetItem;
import za.co.glowing.journey.service.BudgetItemService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/budget_item")
@CrossOrigin(origins = { "http://localhost:4200" })
@RequiredArgsConstructor
public class BudgetItemController {

	private final BudgetItemService budgetItemService;

	@GetMapping("/{budgetItemId}")
	public BudgetItem getBudgetItemById(@PathVariable Long budgetItemId) {
		return budgetItemService.getBudgetItemById(budgetItemId);
	}

	@GetMapping("/all/{budgetId}")
	public List<BudgetItem> getBudgetItemByBudgetId(@PathVariable Long budgetId) {
		return budgetItemService.getAllBudgetItemByBudgetId(budgetId);
	}

	@PostMapping("/{budgetId}")
	public BudgetItem addBudgetItem(@PathVariable Long budgetId, @RequestBody BudgetItem budgetItem) {
		return budgetItemService.addBudgetItem(budgetItem, budgetId);
	}

	@PutMapping
	public BudgetItem updateBudgetItem(@RequestBody BudgetItem budgetItem) {
		return budgetItemService.updateBudgetItem(budgetItem);
	}

	@DeleteMapping("/{budgetItemId}")
	private ResponseEntity deleteBudgetItem(@PathVariable Long budgetItemId) {
		budgetItemService.deleteBudgetItem(budgetItemId);
		return ResponseEntity.ok().build();
	}

}
