package za.co.glowing.journey.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.glowing.journey.model.Person;
import za.co.glowing.journey.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Person addUser(Person person) {
		return userRepository.save(person);
	}

	@Override
	public Person getUser(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public Person updateUser(Person person) {
		return userRepository.save(person);
	}

	@Override
	public void deleteUser(Long userId) {
			userRepository.deleteById(userId);
	}
}
