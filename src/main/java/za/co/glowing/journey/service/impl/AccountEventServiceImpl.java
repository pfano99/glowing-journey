package za.co.glowing.journey.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import za.co.glowing.journey.model.Account;
import za.co.glowing.journey.model.AccountEvent;
import za.co.glowing.journey.repository.AccountEventRepository;
import za.co.glowing.journey.service.AccountEventService;
import za.co.glowing.journey.service.AccountService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountEventServiceImpl implements AccountEventService {

	private final AccountEventRepository accountEventRepository;

	private final AccountService accountService;

	@Override
	public List<AccountEvent> getEventsByAccountId(Long accountId) {
		return accountEventRepository.findByAccountId(accountId);
	}

	@Override
	public AccountEvent getEventsById(Long eventId) {
		// Todo
		// add proper implementation
		return accountEventRepository.findById(eventId).get();
	}

	@Override
	public AccountEvent addAccountEvent(AccountEvent accountEvent, Long accountId) {
		Account account = accountService.getAccount(accountId);
		accountEvent.setAccount(account);
		return accountEventRepository.save(accountEvent);
	}

	@Override
	public AccountEvent updateAccountEvent(AccountEvent accountEvent) {
		return accountEventRepository.save(accountEvent);
	}

	@Override
	public void deleteEvent(Long eventId) {
		accountEventRepository.deleteById(eventId);
	}
}
