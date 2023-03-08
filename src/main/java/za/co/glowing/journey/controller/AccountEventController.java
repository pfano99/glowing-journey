package za.co.glowing.journey.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.glowing.journey.model.AccountEvent;
import za.co.glowing.journey.service.AccountEventService;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping("/account_event")
@RequiredArgsConstructor
public class AccountEventController {

	private final AccountEventService accountEventService;

	@GetMapping("/{eventId}")
	public AccountEvent getAccountEvent(@PathVariable Long eventId) {
		return accountEventService.getEventsById(eventId);
	}

	@GetMapping("/account/{accountId}")
	public List<AccountEvent> getAccountEventByAccountId(@PathVariable Long accountId) {
		return accountEventService.getEventsByAccountId(accountId);
	}

	@PostMapping(value = "/{accountId}")
	public AccountEvent addEvent(@PathVariable Long accountId, @RequestBody AccountEvent accountEvent) {
		log.info("adding account event by account id {}", accountId);
		return this.accountEventService.addAccountEvent(accountEvent, accountId);
	}

	@DeleteMapping("/{eventId}")
	public ResponseEntity deleteAccountEvent(@PathVariable Long eventId) {
		accountEventService.deleteEvent(eventId);
		return ResponseEntity.ok().build();
	}
}
