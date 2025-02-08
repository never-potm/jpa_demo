package com.sunstar.jpa_demo.repositories;

import com.sunstar.jpa_demo.models.SocialProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialProfileRepository extends JpaRepository<SocialProfile, Long> {
}
