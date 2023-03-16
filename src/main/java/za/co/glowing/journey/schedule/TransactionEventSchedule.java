package za.co.glowing.journey.schedule;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import za.co.glowing.journey.model.AccountEvent;
import za.co.glowing.journey.model.AccountEventType;
import za.co.glowing.journey.model.Transaction;
import za.co.glowing.journey.model.TransactionType;
import za.co.glowing.journey.service.AccountEventService;
import za.co.glowing.journey.service.TransactionService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
@RequiredArgsConstructor
public class TransactionEventSchedule {

	private final AccountEventService accountEventService;

	private final TransactionService transactionService;

	//	This should run every day at 00:30
	@Scheduled(cron = "00 30 00 * * *")
	public void checkDailyEvents() {
		log.info("Running scheduled monthly event");
		System.out.println("LocalDate.now().getDayOfMonth() = " + LocalDate.now().getDayOfMonth());
		for ( AccountEvent accountEvent : accountEventService.getAllAccounts() ) {
			if ( accountEvent.getEventDate() == LocalDate.now().getDayOfMonth() ) {
				handler(accountEvent, eventTypeToTransactionType(accountEvent.getEventType()));
			}
		}
	}

	private TransactionType eventTypeToTransactionType(AccountEventType accountEventType) {
		final Map<AccountEventType, TransactionType> data = new HashMap<>();
		data.put(AccountEventType.BILLS, TransactionType.SPENT);
		data.put(AccountEventType.INCOME, TransactionType.DEPOSIT);
		return data.get(accountEventType);
	}

	private void handler(AccountEvent event, TransactionType transactionType) {
		if ( event.getAccount() != null ) {
			Transaction transaction = new Transaction(
							null,
							String.format("Monthly transaction: %s", event.getName()),
							event.getAmount(),
							transactionType,
							LocalDate.now(),
							event.getAccount()
			);
			transactionService.addTransaction(transaction);
		}
	}

}
