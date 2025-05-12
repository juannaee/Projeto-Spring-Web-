package com.SpringWeb.ProjetoSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringWeb.ProjetoSpring.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
