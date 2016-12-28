package com.softtek.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softtek.jpa.domain.UserEntity;

@Repository
public interface UserRepository extends JpaRepository< UserEntity , Integer> {

	
}
