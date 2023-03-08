package za.co.glowing.journey.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.glowing.journey.model.Account;
import za.co.glowing.journey.service.AccountService;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/{accountId}")
	public ResponseEntity<Account> getAccountById(@PathVariable Long accountId) {
		return ResponseEntity.ok().body(accountService.getAccount(accountId));
	}

	@GetMapping("/all/{accountId}")
	public ResponseEntity<List<Account>> getAllUserAccountsByUserId(@PathVariable Long accountId) {
		return ResponseEntity.ok().body(accountService.getAllUserAccounts(accountId));
	}

	@PostMapping("/{userId}")
	public ResponseEntity<Account> addAccount(@RequestBody Account account, @PathVariable Long userId) {
		log.info("adding account...");
		return ResponseEntity.ok().body(accountService.addAccount(account, userId));
	}

	@DeleteMapping("/{accountId}")
	public ResponseEntity deleteAccount(@PathVariable Long accountId) {
		accountService.deleteAccount(accountId);
		return ResponseEntity.ok().build();
	}
}
