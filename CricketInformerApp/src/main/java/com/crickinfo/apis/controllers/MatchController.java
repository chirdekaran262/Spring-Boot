package com.crickinfo.apis.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crickinfo.apis.entities.Match;
import com.crickinfo.apis.services.MatchServices;

@RestController
@RequestMapping("/match")
public class MatchController {
	private MatchServices matchservice;
	
	public MatchController(MatchServices matchservice) {
		this.matchservice=matchservice;
	}
	
	//get all live match
	@GetMapping("/live")
	public ResponseEntity<List<Match>> getLiveMatches(){
		return new ResponseEntity<>(this.matchservice.getLiveMatches(),HttpStatus.OK);
	}
}
