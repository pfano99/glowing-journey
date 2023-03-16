package za.co.glowing.journey.tests;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import za.co.glowing.journey.model.*;
import za.co.glowing.journey.service.AccountService;
import za.co.glowing.journey.service.TransactionService;
import za.co.glowing.journey.service.UserService;

import java.math.BigDecimal;
import java.time.LocalDate;

@Configuration
@Slf4j
public class DatabaseInit implements CommandLineRunner {

	@Value("${spring.profiles.active}")
	private String currentEnv;

	@Autowired
	private AccountService accountService;

	@Autowired
	private UserService userService;

	@Autowired
	private TransactionService transactionService;

	@Override
	public void run(String... args) throws Exception {
		if ( currentEnv.equals("dev") ) {
			log.info("Initializing dev database.....");
			Person person = generateUser("pfano", "sigama", "pfano@email.com");

			Account account = generateAccount("Savings", new BigDecimal(20000.55), AccountType.SAVING,
							person);
			Account account1 = generateAccount("Test account", new BigDecimal(7_000.55), AccountType.CREDIT,
							person);
			Account account2 = generateAccount("Credit account", new BigDecimal(56000.75),
							AccountType.CREDIT,
							person);

			generateTransaction("new transaction 01", new BigDecimal(780.89), TransactionType.SPENT,
							account);

			generateTransaction("transaction 02", new BigDecimal(500.89), TransactionType.TRANSFER,
							account);

			generateTransaction("transaction 04", new BigDecimal(1200.89), TransactionType.DEPOSIT,
							account);

			generateTransaction("transaction 03", new BigDecimal(789.89), TransactionType.SPENT,
							account);
		}
	}

	private Account generateAccount(String name, BigDecimal balance, AccountType accountType,
																	Person person) {
//		Account account = new Account(null, name, balance, accountType, null, person);
		Account account = new Account(null, name, balance, accountType, null, null, person);
		return accountService.addAccount(account);

	}

	private Person generateUser(String name, String lastName, String email) {
		Person person = new Person(null, name, lastName, email, null, null);
		return userService.addUser(person);
	}

	private Transaction generateTransaction(String description, BigDecimal amount,
																					TransactionType transactionType, Account account) {
		Transaction transaction = new Transaction(null, description, amount, transactionType,
						LocalDate.now(), account);
		return transactionService.addTransaction(transaction);
	}

}
