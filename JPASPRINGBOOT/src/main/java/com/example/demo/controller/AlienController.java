package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;

@RestController
public class AlienController {
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String toString() {
		return "home.jsp";
	}
	@PostMapping(path="/addAlien",consumes={"application/json"})
	public Alien addAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
	@PutMapping(path="/addAlien",consumes={"application/json"})
	public Alien SaveOrUpdateAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
	@GetMapping("/aliens")
	@ResponseBody
	public List<Alien> getAlien() {
		return repo.findAll();
	}
	@RequestMapping("/alien/{aid}")
	@ResponseBody
	public Optional<Alien> getAlien(@PathVariable("aid") int aid) {
		return repo.findById(aid);
	}
	
//	@RequestMapping("/getAlien")
//	public ModelAndView getAlien(@RequestParam int aid) {
//		ModelAndView mv=new ModelAndView("showAlien.jsp");
//		Alien alien=repo.findById(aid).orElse(new Alien());
//		System.out.println(repo.findByTech("cpp"));
//		System.out.println(repo.findByAidGreaterThan(102));
//		System.out.println(repo.findByTechSorted("cpp"));
//
//		mv.addObject(alien);
//		return mv;
//	}
	@DeleteMapping("/alien/{aid}")
	public String removeAlien(@PathVariable int aid) {
		Alien alien=repo.getOne(aid);
		repo.delete(alien);
		return "Deleted";
	}
}
