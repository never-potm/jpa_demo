package com.sunstar.jpa_demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SocialGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToMany(mappedBy = "groups")
	@JsonIgnore
	private Set<SocialUser> socialUsers = new HashSet<>();

	@Override
	public final int hashCode() {
		return Objects.hash(id);
	}

}
