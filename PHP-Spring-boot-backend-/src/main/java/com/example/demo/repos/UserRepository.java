package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.*;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query(value = "select MAX(id_user) from User", nativeQuery = true)
    Long findMaxID();

}
