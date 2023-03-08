package za.co.glowing.journey.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account implements Comparable<Account> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	private String name;

	private BigDecimal balance;

	@Enumerated(EnumType.STRING)
	private AccountType accountType;

	@OneToMany(mappedBy = "account")
	@JsonIgnore
	private List<Transaction> transactions = new ArrayList<>();

	@OneToMany(mappedBy = "account")
	@JsonIgnore
	private List<AccountEvent> accountEvents = new ArrayList<>();

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "person_id")
	private Person person;

	@Override
	public int compareTo(Account other) {
		if ( this.getTransactions().size() > other.getTransactions().size() ) {
			return 1;
		} else if ( this.getTransactions().size() < other.getTransactions().size() ) {
			return -1;
		}
		return 0;
	}
}

