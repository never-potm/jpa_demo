package com.sunstar.jpa_demo.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SocialUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// this makes SocialUser class aware of SocialProfile
	// we can fetch profile information using the user
	// this is the non owning side of the relationship which is supposed to use mappedBy to tell that this
	// relationship is mappedBy socialProfile which exists in SocialUser class.
	// So, dont create a column in this table
	@OneToOne(mappedBy = "user") // this creates a foreign-key in social_user table named social_profile_id
	//	@JoinColumn(name = "social_profile_id")
	private SocialProfile socialProfile;

	@OneToMany(mappedBy = "socialUser")
	@ToString.Exclude // using this mappedBy, we are telling that Post class manages the socialUser
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

	@Override
	public final int hashCode() {
		return Objects.hash(id);
	}
}
