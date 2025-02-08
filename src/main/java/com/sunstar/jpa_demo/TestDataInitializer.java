package com.sunstar.jpa_demo;

import com.sunstar.jpa_demo.models.Post;
import com.sunstar.jpa_demo.models.SocialGroup;
import com.sunstar.jpa_demo.models.SocialProfile;
import com.sunstar.jpa_demo.models.SocialUser;
import com.sunstar.jpa_demo.repositories.PostRepository;
import com.sunstar.jpa_demo.repositories.SocialGroupRepository;
import com.sunstar.jpa_demo.repositories.SocialProfileRepository;
import com.sunstar.jpa_demo.repositories.SocialUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestDataInitializer {

	private final SocialUserRepository socialUserRepository;
	private final SocialGroupRepository socialGroupRepository;
	private final SocialProfileRepository socialProfileRepository;
	private final PostRepository postRepository;

	public TestDataInitializer(SocialUserRepository socialUserRepository, SocialGroupRepository socialGroupRepository,
	                           SocialProfileRepository socialProfileRepository, PostRepository postRepository) {
		this.socialUserRepository = socialUserRepository;
		this.socialGroupRepository = socialGroupRepository;
		this.socialProfileRepository = socialProfileRepository;
		this.postRepository = postRepository;
	}

	@Bean
	public CommandLineRunner initializeData() {
		return args -> {
			SocialUser user1 = new SocialUser();
			SocialUser user2 = new SocialUser();
			SocialUser user3 = new SocialUser();

			socialUserRepository.save(user1);
			socialUserRepository.save(user2);
			socialUserRepository.save(user3);


			SocialGroup group1 = new SocialGroup();
			SocialGroup group2 = new SocialGroup();

			// add users into groups
			group1.getSocialUsers().add(user1);
			group1.getSocialUsers().add(user2);
			group2.getSocialUsers().add(user2);
			group2.getSocialUsers().add(user3);

			socialGroupRepository.save(group1);
			socialGroupRepository.save(group2);

			// add groups into users
			user1.getGroups().add(group1);
			user2.getGroups().add(group1);
			user2.getGroups().add(group2);
			user3.getGroups().add(group2);

			// update user association
			socialUserRepository.save(user1);
			socialUserRepository.save(user2);
			socialUserRepository.save(user3);


			Post post1 = new Post();
			Post post2 = new Post();
			Post post3 = new Post();

			post1.setSocialUser(user1);
			post2.setSocialUser(user2);
			post3.setSocialUser(user3);

			postRepository.save(post1);
			postRepository.save(post2);
			postRepository.save(post3);

			SocialProfile profile1 = new SocialProfile();
			SocialProfile profile2 = new SocialProfile();
			SocialProfile profile3 = new SocialProfile();

			profile1.setUser(user1);
			profile2.setUser(user2);
			profile3.setUser(user3);

			socialProfileRepository.save(profile1);
			socialProfileRepository.save(profile2);
			socialProfileRepository.save(profile3);

		};
	}
}
