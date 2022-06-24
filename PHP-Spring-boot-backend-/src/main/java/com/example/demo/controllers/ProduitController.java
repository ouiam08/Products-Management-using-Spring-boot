package com.example.demo.controllers;

import com.example.demo.entities.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.type.TypeReference;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.service.ProduitService;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.example.demo.entities.*;

@Controller
public class ProduitController {
	@Autowired
	ProduitService produitService;
	
	
	
	@RequestMapping("/")
	public ModelAndView home(){
		return new ModelAndView("index.jsp");
	}
	
	
	
	
	
	
	/*
	@RequestMapping("/php")
	public void phpSave(HttpServletResponse httpServletResponse,@ModelAttribute("produit") Produit produit) throws JsonMappingException, JsonProcessingException
	{
		
		String jsonText = "";
		try {		
		    BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\xampp\\htdocs\\PhpProduit\\data.json"));

		    String line;
		    while ((line = bufferedReader.readLine()) != null) {
		        jsonText += line + "\n";
		    }

		    bufferedReader.close();

		} catch (Exception e) {
		    e.printStackTrace();
		}   

		    ObjectMapper mapper = new ObjectMapper();
		    List<Produit> participantJsonList = mapper.readValue(jsonText, new TypeReference<List<Produit>>(){});

		    Produit prod = new Produit();
		    String n="";
		    Double pr=0.0;
		    Date d=null;
		    for (Produit p : participantJsonList) {
		    	 n = p.getNomProduit();
		    	 pr = p.getPrixProduit();
		    	 d = p.getDateCreation();
		    }    

		
		    produit.setNomProduit(n);
		    produit.setPrixProduit(pr);
		    produit.setDateCreation(d);
		    
		produitService.saveProduit(produit);
		
		httpServletResponse.setHeader("Location", "http://localhost/PhpProduit/Lister.php");
		httpServletResponse.setStatus(302);
        
	}
	
	
	@RequestMapping("/modifierProduitPhp")
	public void modifierProduitPhp(HttpServletResponse httpServletResponse, @RequestParam("id") Long id, ModelMap modelMap){
	produitService.getProduit(id);
	httpServletResponse.setHeader("Location", "http://localhost/PhpProduit/phpFormEdit.php");
	httpServletResponse.setStatus(302);
	}
	
	@RequestMapping("/supprimerProduitPhp")
	public void supprimerProduitPhp(HttpServletResponse httpServletResponse, @RequestParam("id") Long id, ModelMap modelMap){
	produitService.deleteProduitById(id);
	List<Produit> prods = produitService.getAllproduits();
	modelMap.addAttribute("produits", prods);
	httpServletResponse.setHeader("Location", "http://localhost/PhpProduit/Lister.php");
	httpServletResponse.setStatus(302);
	}*/
	
	
	@RequestMapping("/Listes")
    public RedirectView ListesPHP()
    {
        RedirectView listerPHP = new RedirectView("http://localhost/sb1/toListe.php");
        return listerPHP;
    }
	
	@RequestMapping("/deleteProduit")
    public RedirectView deleteProduit(@RequestParam("id") Long id, ModelMap modelMap)
    {
        produitService.deleteProduitById(id);
        RedirectView listerPHP = new RedirectView("http://localhost/sb1/listes.php");
        return listerPHP;
    }
	
	
	@RequestMapping("/ajouterProduit")
    public RedirectView ajouterProduit(@ModelAttribute("produit") Produit produit, @RequestParam("date")
    String date, ModelMap modelMap) throws ParseException
    {
//conversion de la date
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateformat.parse(String.valueOf(date)); produit.setDateCreation(dateCreation);
        Produit saveProduit = produitService.saveProduit(produit);
        String msg ="produit enregistre avec Id "+saveProduit.getIdProduit();
        RedirectView ajouterPHP = new RedirectView("http://localhost/sb1/listes.php");
        return ajouterPHP;
    }
	
	
	
	
	
	@RequestMapping("/edit/id/{id}")
	public void editProduit(@PathVariable("id") Long id, HttpServletResponse httpServletResponse) {
		Produit p=produitService.getProduit(id);
		String url = "http://localhost/sb1/edit.php?id="+p.getIdProduit()+"&name="+p.getNomProduit()+"&price="+p.getPrixProduit()+"&date="+p.getDateCreation()+"&image="+p.getimage();
		httpServletResponse.setHeader("Location", url);
		httpServletResponse.setStatus(302);
	}
	
	
	
	@RequestMapping("/update")
	public RedirectView editProduit(@ModelAttribute("produit") Produit produit, @RequestParam("date") String date,ModelMap modelMap) throws ParseException{
		
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		produit.setDateCreation(dateCreation);
		produitService.updateProduit(produit);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("http://localhost/sb1/listes.php");
		return redirectView;
		}

	
	
	
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/register")
	public RedirectView register(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return new RedirectView("http://localhost/sb1/login.php");
	}
	
	@RequestMapping("/login")
    public RedirectView login(@ModelAttribute("user") User user, HttpServletRequest request)
    {
		Long count = userService.findMaxID();
		for(int i=1; i<=15 ; i++) {
			if(!userService.existsUser((long) i)) continue;
			if( (user.getUserName().equals(userService.getUser((long) i).getUserName())) && (user.getPassWord().equals(userService.getUser((long) i).getPassWord())))
				return new RedirectView("http://localhost/sb1/loginSuccess.php?userName="+user.getUserName());
		}
		return new RedirectView("http://localhost/sb1/login.php");
    }
	
	@RequestMapping("/logout")
	public RedirectView logout(@ModelAttribute("user") User user, HttpServletRequest request) {
		return new RedirectView("http://localhost/sb1/logout.php");
	}
	
	
	
	
	
	
	
	@RequestMapping("/showCreate")
	public String showCreate(){
		return "createProduit.jsp";
	}
	
	@RequestMapping("/saveProduit")
	public String saveProduit(@ModelAttribute("produit") Produit produit,@RequestParam("date") String date,ModelMap modelMap) throws ParseException
	{
	//conversion de la date
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	Date dateCreation = dateformat.parse(String.valueOf(date)); produit.setDateCreation(dateCreation);
	Produit saveProduit = produitService.saveProduit(produit);
	String msg ="produit enregistré avec Id "+saveProduit.getIdProduit();
	modelMap.addAttribute("msg", msg);
	return "createProduit.jsp";
	}
	
	@RequestMapping("/ListeProduits")
	public String listeProduits(ModelMap modelMap)
	{
	List<Produit> prods = produitService.getAllproduits();
	modelMap.addAttribute("produits", prods);
	return "listeProduits.jsp";
	}
/*
	@RequestMapping("/supprimerProduit")
	public String supprimerProduit(@RequestParam("id") Long id, ModelMap modelMap){
	produitService.deleteProduitById(id);
	List<Produit> prods = produitService.getAllproduits();
	modelMap.addAttribute("produits", prods);
	return "listeProduits.jsp";
	}
	
	@RequestMapping("/modifierProduit")
	public String editerProduit(@RequestParam("id") Long id,ModelMap modelMap){
	Produit p= produitService.getProduit(id);
	modelMap.addAttribute("produit", p);
	return "editerProduits.jsp";
	}
	
	@RequestMapping("/updateProduit")
	public String updateProduit(@ModelAttribute("produit") Produit produit, @RequestParam("date") String date,ModelMap modelMap) throws ParseException{
	//conversion de la date SimpleDateFormatdateformat = new SimpleDateFormat("yyyy-MM-dd");

	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	Date dateCreation = dateformat.parse(String.valueOf(date));
	produit.setDateCreation(dateCreation);
	produitService.updateProduit(produit);
	List<Produit> prods = produitService.getAllproduits();
	modelMap.addAttribute("produits", prods);
	return "listeProduits.jsp";
	}
*/


}
