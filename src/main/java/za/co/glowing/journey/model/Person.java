package za.co.glowing.journey.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "person_id", nullable = false)
	private Long id;

	@Column(nullable = false, name = "first_name")
	private String firstName;

	@Column(nullable = false, name = "last_name")
	private String lastName;

	@Column(nullable = false, unique = true)
	private String email;

	@JsonIgnore
	@OneToMany(mappedBy = "person")
	private List<Account> account;

	@JsonIgnore
	@OneToMany(mappedBy = "person")
	private List<Budget> budgets;

}
