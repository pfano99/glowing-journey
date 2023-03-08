package za.co.glowing.journey.service;

import za.co.glowing.journey.model.Transaction;

import java.util.List;

public interface TransactionService {

	Transaction getTransactionById(Long transactionId);

	List<Transaction> getAccountTransactions(Long accountId);

	Transaction addTransaction(Transaction transaction);

	Transaction addTransaction(Transaction transaction, Long accountId);

	Transaction updateTransaction(Transaction transaction, Long transactionId);

	Transaction addTransaction(Transaction transaction, Long fromAccountId, Long toAccountId);

	void deleteTransaction(Long transactionId);
}
