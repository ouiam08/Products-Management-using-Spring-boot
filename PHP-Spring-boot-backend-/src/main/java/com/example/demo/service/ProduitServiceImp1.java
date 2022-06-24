package com.example.demo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Produit;
import com.example.demo.repos.*;

@Service
public class ProduitServiceImp1 implements ProduitService{
	
	@Autowired
    ProduitRepository produitRepository;
    
	@Override
    public Produit saveProduit(Produit P) {
        return produitRepository.save(P);
    }

    @Override
    public Produit updateProduit(Produit P) {
        return produitRepository.save(P);
    }

    @Override
    public Produit getProduit(Long id) {
        return produitRepository.getById(id);
    }

    @Override
    public List<Produit> getAllproduits() {
        return produitRepository.findAll();
    }
    
	@Override
	public void deleteProduit(Produit p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduitById(Long id) {
		produitRepository.deleteById(id);
		
	}


}
