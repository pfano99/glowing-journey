package za.co.glowing.journey.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "expense_id", nullable = false)
	@Getter @Setter
	private Long id;

	private String name;

	private LocalDate date;

	private Long amount;

	@Enumerated(EnumType.STRING)
	private ExpenseType expenseType = ExpenseType.VARIABLE;

}
