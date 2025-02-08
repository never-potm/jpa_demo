package com.sunstar.jpa_demo.services;

import com.sunstar.jpa_demo.models.SocialUser;
import com.sunstar.jpa_demo.repositories.SocialUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialService {

	@Autowired
	SocialUserRepository socialUserRepository;

	public List<SocialUser> getAllUsers() {
		return socialUserRepository.findAll();
	}

	public SocialUser saveUser(SocialUser socialUser) {
		return socialUserRepository.save(socialUser);
	}

	public SocialUser deleteUser(Long id) {
		SocialUser user = socialUserRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
		socialUserRepository.deleteById(user.getId());
		return user;
	}
}
