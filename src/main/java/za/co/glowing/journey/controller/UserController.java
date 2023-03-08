package za.co.glowing.journey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.glowing.journey.model.Person;
import za.co.glowing.journey.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/{userId}")
	public ResponseEntity<Person> getUser(@PathVariable Long userId) {
		return ResponseEntity.ok(userService.getUser(userId));
	}

	@PostMapping
	public ResponseEntity<Person> addUser(@RequestBody Person person) {
		return ResponseEntity.ok().body(userService.addUser(person));
	}

	@PutMapping
	public ResponseEntity<Person> updateUser(@RequestBody Person person) {
		return ResponseEntity.ok().body(userService.addUser(person));
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity deleteUser(@PathVariable Long userId) {
		userService.deleteUser(userId);
		return ResponseEntity.ok().build();
	}

}
