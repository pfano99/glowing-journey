package za.co.glowing.journey.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.glowing.journey.model.Account;
import za.co.glowing.journey.model.Person;
import za.co.glowing.journey.repository.AccountRepository;
import za.co.glowing.journey.service.AccountService;
import za.co.glowing.journey.service.UserService;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private UserService userService;

	@Override
	public Account getAccount(Long accountId) {
		return accountRepository.findById(accountId).get();
	}

	@Override
	public Account addAccount(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public Account addAccount(Account account, Long userId) {
		Person user = userService.getUser(userId);
		account.setPerson(user);
		return accountRepository.save(account);
	}

	@Override
	public Account updatedAccount(Account account) {
		return accountRepository.save(account);
	}

	@Override
	public void deleteAccount(Long accountId) {
		accountRepository.deleteById(accountId);
	}

	@Override
	public List<Account> getAllUserAccounts(Long personId) {
		return accountRepository.findAllByUserId(personId);

	}
}
