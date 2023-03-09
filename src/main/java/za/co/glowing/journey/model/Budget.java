package za.co.glowing.journey.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Budget {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(nullable = false)
	private String name;

	private String description;

	@Transient
	private BigDecimal cost;


	@JsonIgnore
	@OneToMany(mappedBy = "budget")
	private List<BudgetItems> budgetItems;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "person_id")
	private Person person;

}
