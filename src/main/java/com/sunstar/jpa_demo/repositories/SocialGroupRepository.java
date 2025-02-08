package com.sunstar.jpa_demo.repositories;

import com.sunstar.jpa_demo.models.SocialGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialGroupRepository extends JpaRepository<SocialGroup, Long> {
}
