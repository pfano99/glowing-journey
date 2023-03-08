package za.co.glowing.journey.service;

import za.co.glowing.journey.model.Person;

public interface UserService {

	Person addUser(Person person);
	Person getUser(Long id);
	Person updateUser(Person person);
	void deleteUser(Long userId);

}
