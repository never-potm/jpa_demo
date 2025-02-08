package com.sunstar.jpa_demo.models;

import jakarta.persistence.*;

@Entity
public class SocialProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "social_user") // social_user will be the name of foreign key
	private SocialUser user;
}
