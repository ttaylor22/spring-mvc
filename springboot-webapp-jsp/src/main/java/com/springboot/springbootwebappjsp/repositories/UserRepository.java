package com.springboot.springbootwebappjsp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.springbootwebappjsp.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
