package za.co.glowing.journey.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class BudgetItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private BigDecimal price;

	@Column(nullable = false, name = "items_count")
	private int itemsCount;

	@ManyToOne
	@JoinColumn(name = "budget_id")
	private Budget budget;

}
