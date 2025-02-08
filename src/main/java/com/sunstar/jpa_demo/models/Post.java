package com.sunstar.jpa_demo.models;

import jakarta.persistence.*;

@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private SocialUser socialUser;
}
