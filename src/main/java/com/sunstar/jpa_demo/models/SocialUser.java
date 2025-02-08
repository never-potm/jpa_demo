package com.sunstar.jpa_demo.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

	@OneToMany(mappedBy = "socialUser") // using this mappedBy, we are telling that Post class manages the socialUser
	// defined in Post class
	private List<Post> posts = new ArrayList<>();
}
