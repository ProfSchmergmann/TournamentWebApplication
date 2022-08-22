package com.github.ProfSchmergmann.TournamentWebApplication.database.models.location.city;

import com.github.ProfSchmergmann.TournamentWebApplication.database.models.IModel;
import com.github.ProfSchmergmann.TournamentWebApplication.database.models.location.Location;
import com.github.ProfSchmergmann.TournamentWebApplication.database.models.location.country.Country;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
public class City implements Serializable, IModel {

	@ManyToOne
	private Country country;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
	@Exclude
	private Set<Location> locations;
	private String name;

	@Override
	public int hashCode() {
		return Objects.hash(this.name, this.country);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof City city)) {
			return false;
		}
		return Objects.equals(this.name, city.name) &&
				Objects.equals(this.country, city.country);
	}
}
