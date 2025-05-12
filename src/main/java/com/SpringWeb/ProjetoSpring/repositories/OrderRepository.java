package com.SpringWeb.ProjetoSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringWeb.ProjetoSpring.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
