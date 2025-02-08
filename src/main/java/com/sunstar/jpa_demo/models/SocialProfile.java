package com.sunstar.jpa_demo.models;

import jakarta.persistence.*;

@Entity
public class SocialProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// this is the non owning side of the relationship which is supposed to use mappedBy to tell that this
	// relationship is mappedBy socialProfile which exists in SocialUser class.
	// So, dont create a column in this table
	@OneToOne(mappedBy = "socialProfile")
	//@JoinColumn(name = "social_user")
	private SocialUser user;
}
