package com.crickinfo.apis.entities;

import java.sql.Date;
import java.time.*;
import org.springframework.beans.factory.config.YamlProcessor.MatchStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="crick_matches")
public class Match {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int matchid;
	
	private String teamHeading;
	
	private String matchNumbervenue;
	
	private String battingTeam;
	
	private String battingTeamScore;
	
	private String bowlTeam;
	
	private String bowlTeamScore;
	
	

	private String liveText;
	
	private String matchLink;
	
	private String textComplete;
	
	@Enumerated
	private Matchstatus status;

	private Date date=new Date(matchid);

	public Match(int matchid, String teamHeading, String matchNumbervenue, String battingTeam, String battingTeamScore,
			String bowlTeam, String liveText, String matchLink, String textComplete, Matchstatus status, Date date) {
		
		this.matchid = matchid;
		this.teamHeading = teamHeading;
		this.matchNumbervenue = matchNumbervenue;
		this.battingTeam = battingTeam;
		this.battingTeamScore = battingTeamScore;
		this.bowlTeam = bowlTeam;
		this.bowlTeamScore = bowlTeamScore;
		this.liveText = liveText;
		this.matchLink = matchLink;
		this.textComplete = textComplete;
		this.status = status;
		this.date = date;
	}

	public Match() {
		
	}
	
	//set match status according to match completed or not
	public void setMatchStatus() {
		if(textComplete.isBlank()) {
			this.status=Matchstatus.LIVE;
		}
		else {
			this.status=Matchstatus.COMPLETED;
		}
	}
	
	public int getMatchid() {
		return matchid;
	}

	public void setMatchid(int matchid) {
		this.matchid = matchid;
	}

	public String getTeamHeading() {
		return teamHeading;
	}

	public void setTeamHeading(String teamHeading) {
		this.teamHeading = teamHeading;
	}

	public String getMatchNumbervenue() {
		return matchNumbervenue;
	}

	public void setMatchNumbervenue(String matchNumbervenue) {
		this.matchNumbervenue = matchNumbervenue;
	}

	public String getBattingTeam() {
		return battingTeam;
	}

	public void setBattingTeam(String battingTeam) {
		this.battingTeam = battingTeam;
	}

	public String getBattingTeamScore() {
		return battingTeamScore;
	}

	public void setBattingTeamScore(String battingTeamScore) {
		this.battingTeamScore = battingTeamScore;
	}

	public String getBowlTeam() {
		return bowlTeam;
	}

	public void setBowlTeam(String bowlTeam) {
		this.bowlTeam = bowlTeam;
	}
	public String getBowlTeamScore() {
		return bowlTeamScore;
	}

	public void setBowlTeamScore(String bowlTeamScore) {
		this.bowlTeamScore = bowlTeamScore;
	}
	public String getLiveText() {
		return liveText;
	}

	public void setLiveText(String liveText) {
		this.liveText = liveText;
	}

	public String getMatchLink() {
		return matchLink;
	}

	public void setMatchLink(String matchLink) {
		this.matchLink = matchLink;
	}

	public String getTextComplete() {
		return textComplete;
	}

	public void setTextComplete(String textComplete) {
		this.textComplete = textComplete;
	}

	public Matchstatus getStatus() {
		return status;
	}

	public void setStatus(Matchstatus status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
		
}
