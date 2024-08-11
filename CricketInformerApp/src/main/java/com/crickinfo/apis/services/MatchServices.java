package com.crickinfo.apis.services;
import java.util.*;

import com.crickinfo.apis.entities.Match;

public interface MatchServices {
	//get all match
	List<Match> getAllMatches();
	
	
	//get live match

	List<Match> getLiveMatches();
	
	//get T20 World Cup 2024 point table
	List<Map<String,String>> getPointTable();
}
