package com.crickinfo.apis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.google.common.base.Optional;

public interface MatchRepo<Match> extends JpaRepository<Match,Integer> {
	//Fetch the match 
	//provide team heading
	Optional<Match> findByTeamHeading(String teamHeading);
}
