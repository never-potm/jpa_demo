package com.sunstar.jpa_demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SocialProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "social_user_id") // JoinColumn is used in the owning side of the relationship
	@JsonIgnore
	private SocialUser user;

	private String description;

	public void setSocialUser(SocialUser user) {
		this.user = user;
		if (user.getSocialProfile() != null) {
			user.setSocialProfile(this);
		}
	}
}
