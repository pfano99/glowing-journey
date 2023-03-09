package za.co.glowing.journey.service;

import za.co.glowing.journey.model.AccountEvent;

import java.util.List;

public interface AccountEventService {

	List<AccountEvent> getEventsByAccountId(Long accountId);

	AccountEvent getEventsById(Long eventId);

	AccountEvent addAccountEvent(AccountEvent accountEvent, Long accountId);

	AccountEvent updateAccountEvent(AccountEvent accountEvent);

	void deleteEvent(Long eventId);
}
