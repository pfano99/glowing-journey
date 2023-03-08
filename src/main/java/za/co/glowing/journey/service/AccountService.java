package za.co.glowing.journey.service;

import za.co.glowing.journey.model.Account;

import java.util.List;

public interface AccountService {

	Account getAccount(Long accountId);

	Account addAccount(Account account);

	Account addAccount(Account account, Long userId);

	Account updatedAccount(Account account);

	void deleteAccount(Long accountId);

	List<Account> getAllUserAccounts(Long personId);

}
