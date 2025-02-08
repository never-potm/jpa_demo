package com.sunstar.jpa_demo.models;

import jakarta.persistence.*;

@Entity
public class SocialUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// this makes SocialUser class aware of SocialProfile
	// we can fetch profile information using the user
	@OneToOne // this creates a foreign-key in social_user table named social_profile_id

	// JoinColumn is used in the owning side of the relationship
	@JoinColumn(name = "social_profile_id")
	private SocialProfile socialProfile;
}
