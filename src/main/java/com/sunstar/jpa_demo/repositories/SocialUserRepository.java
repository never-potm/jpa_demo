package com.sunstar.jpa_demo.repositories;

import com.sunstar.jpa_demo.models.SocialUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialUserRepository extends JpaRepository<SocialUser, Long> {
}
