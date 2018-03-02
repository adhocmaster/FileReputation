package com.fileReputation2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fileReputation2.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
