package za.co.glowing.journey.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AccountEvent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	private String name;

	private BigDecimal amount;

	@Column(name = "transaction_date")
	private int eventDate = 1;

	@Enumerated(EnumType.STRING)
	@Column(name = "eventType")
	private AccountEventType eventType;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "account_id")
	private Account account;

}
