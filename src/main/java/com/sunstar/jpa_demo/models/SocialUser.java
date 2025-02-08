package com.sunstar.jpa_demo.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	@ManyToMany
	@JoinTable(
			name = "user_group", // name of table
			joinColumns = @JoinColumn(name = "user_id"), // foreign key of SocialUser is user_id
			inverseJoinColumns = @JoinColumn(name = "group_id") // foreign key for other side of relationship ( Group
			// table ) is group_id
	)
	private Set<SocialGroup> groups = new HashSet<>();
}
