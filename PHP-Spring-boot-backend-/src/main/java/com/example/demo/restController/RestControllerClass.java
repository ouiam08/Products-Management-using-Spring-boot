package com.example.demo.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ProduitService;
import com.example.demo.entities.Produit;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class RestControllerClass {
	
	@Autowired
	ProduitService produitService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Produit> getAllProduits(){
		return produitService.getAllproduits();
	}
		
}
