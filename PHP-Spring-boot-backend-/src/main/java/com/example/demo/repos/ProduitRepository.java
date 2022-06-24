package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Produit;

import com.example.demo.entities.*;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
