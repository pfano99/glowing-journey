package za.co.glowing.journey.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.glowing.journey.model.Account;
import za.co.glowing.journey.model.Transaction;
import za.co.glowing.journey.model.TransactionType;
import za.co.glowing.journey.repository.TransactionRepository;
import za.co.glowing.journey.service.AccountService;
import za.co.glowing.journey.service.TransactionService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private AccountService accountService;

	@Override
	public Transaction getTransactionById(Long transactionId) {
		return transactionRepository.findById(transactionId).get();
	}

	@Override
	public List<Transaction> getAccountTransactions(Long accountId) {
		return this.transactionRepository.findByAccountIdOrderByTransactionDateDesc(accountId);
	}

	@Override
	public Transaction addTransaction(Transaction transaction) {
		return addTransaction(transaction, transaction.getAccount().getId());
	}

	@Override
	@Transactional
	public Transaction addTransaction(Transaction transaction, Long accountId) {
		Account account = accountService.getAccount(accountId);
		BigDecimal newBalance;

		if ( transaction.getTransactionType() != TransactionType.DEPOSIT ) {
			log.info("Deducting spent amount from total account balance");
			newBalance = new BigDecimal(account.getBalance().doubleValue() - transaction.getAmount().doubleValue());
		} else {
			newBalance = new BigDecimal(account.getBalance().doubleValue() + transaction.getAmount().doubleValue());
		}
		account.setBalance(newBalance);

		accountService.updatedAccount(account);

		transaction.setAccount(account);

		return transactionRepository.save(transaction);
	}

	@Override
	@Transactional
	public Transaction addTransaction(Transaction transaction, Long fromAccountId, Long toAccountId) {

		if ( transaction.getTransactionType() == TransactionType.TRANSFER ) {

			Account fromAccount = accountService.getAccount(fromAccountId);
			Account toAccount = accountService.getAccount(toAccountId);

			BigDecimal fromAccountNewBalance =
							new BigDecimal(fromAccount.getBalance().doubleValue() - transaction.getAmount().doubleValue());

			BigDecimal toAccountNewBalance =
							new BigDecimal(toAccount.getBalance().doubleValue() + transaction.getAmount().doubleValue());

			toAccount.setBalance(toAccountNewBalance);
			fromAccount.setBalance(fromAccountNewBalance);

			transaction.setAccount(fromAccount);

			Transaction depositToAccount = new Transaction(
							null,
							String.format("Money transferred from %s", fromAccount.getName()),
							toAccountNewBalance,
							TransactionType.DEPOSIT,
							LocalDate.now(),
							toAccount
			);
			transactionRepository.save(depositToAccount);
			return transactionRepository.save(transaction);
		} else {
			return this.addTransaction(transaction, fromAccountId);
		}

	}

	@Override
	public void deleteTransaction(Long transactionId) {
		transactionRepository.deleteById(transactionId);
	}

	@Override
	public Transaction updateTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

}
