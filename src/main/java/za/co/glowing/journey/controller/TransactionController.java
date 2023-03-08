package za.co.glowing.journey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.glowing.journey.model.Transaction;
import za.co.glowing.journey.service.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/transaction")
@CrossOrigin(origins = { "http://localhost:4200" })
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@GetMapping("/{transactionId}")
	public ResponseEntity<Transaction> getTransaction(@PathVariable Long transactionId) {
		return ResponseEntity.ok(transactionService.getTransactionById(transactionId));
	}

	@GetMapping("/account/{accountId}")
	public ResponseEntity<List<Transaction>> getAccountTransactions(@PathVariable Long accountId) {
		return ResponseEntity.ok(transactionService.getAccountTransactions(accountId));
	}

	@PostMapping("/{accountId}")
	public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction,
																										@PathVariable("accountId") Long accountId
	) {
		return ResponseEntity.ok(transactionService.addTransaction(transaction, accountId));
	}

	@PostMapping("/from/{fromId}/to/{toId}")
	public ResponseEntity<Transaction> addTransactionTransfer(@RequestBody Transaction transaction,
																										@PathVariable("fromId") Long fromId,
																										@PathVariable("toId") Long toId
	) {
		return ResponseEntity.ok(transactionService.addTransaction(transaction, fromId, toId));
	}

	@PutMapping("/{transactionId}")
	public ResponseEntity<Transaction> updateTransaction(@PathVariable Long transactionId,
																											 @RequestBody Transaction transaction) {
		return ResponseEntity.ok(transactionService.updateTransaction(transaction, transactionId));
	}


	@DeleteMapping("/{transactionId}")
	public ResponseEntity deleteTransaction(@PathVariable Long transactionId) {
		transactionService.deleteTransaction(transactionId);
		return ResponseEntity.ok().build();
	}
}
