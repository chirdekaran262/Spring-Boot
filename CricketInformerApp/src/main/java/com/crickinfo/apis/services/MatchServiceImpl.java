package com.crickinfo.apis.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.lang.model.element.Element;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.crickinfo.apis.entities.Match;
import com.crickinfo.apis.repositories.MatchRepo;

import io.jsonwebtoken.io.IOException;

@Service
public class MatchServiceImpl implements MatchServices {

    private final MatchRepo<Match> matchRepo;

    public MatchServiceImpl(MatchRepo<Match> matchRepo) {
        this.matchRepo = matchRepo;
    }

    @Override
    public List<Match> getAllMatches() {
        return this.matchRepo.findAll();
    }

    @Override
    
    	public List<Match> getLiveMatches() {
            List<Match> matches = new ArrayList<>();
            try {
                String url = "https://www.cricbuzz.com/cricket-match/live-scores";
                Document document = Jsoup.connect(url).get();
                Elements liveScoreElements = document.select("div.cb-mtch-lst.cb-tms-itm");

                for (org.jsoup.nodes.Element match : liveScoreElements) {
                    String teamsHeading = match.select("h3.cb-lv-scr-mtch-hdr a").text();
                    String matchNumberVenue = match.select("span").text();
                    Elements matchBatTeamInfo = match.select("div.cb-hmscg-bat-txt");
                    String battingTeam = matchBatTeamInfo.select("div.cb-hmscg-tm-nm").text();
                    String score = matchBatTeamInfo.select("div.cb-hmscg-tm-nm + div").text();
                    Elements bowlTeamInfo = match.select("div.cb-hmscg-bwl-txt");
                    String bowlTeam = bowlTeamInfo.select("div.cb-hmscg-tm-nm").text();
                    String bowlTeamScore = bowlTeamInfo.select("div.cb-hmscg-tm-nm + div").text();
                    String textLive = match.select("div.cb-text-live").text();
                    String textComplete = match.select("div.cb-text-complete").text();
                    String matchLink = match.select("a.cb-lv-scrs-well.cb-lv-scrs-well-live").attr("href");

                    Match match1 = new Match();
                    match1.setTeamHeading(teamsHeading);
                    match1.setMatchNumbervenue(matchNumberVenue);
                    match1.setBattingTeam(battingTeam);
                    match1.setBattingTeamScore(score);
                    match1.setBowlTeam(bowlTeam);
                    match1.setBowlTeamScore(bowlTeamScore);
                    match1.setLiveText(textLive);
                    match1.setMatchLink(matchLink);
                    match1.setTextComplete(textComplete);
                    match1.setMatchStatus();

                    matches.add(match1);

                    // Update the match in the database
                    updateMatch(match1);
                }
            } catch (IOException | java.io.IOException e) {
                e.printStackTrace();
            }

            return matches;
    }

    private void updateMatch(Match match1) {
        // Save or update the match in the database
        matchRepo.save(match1);
    }

    @Override
    public List<Map<String, String>> getPointTable() {
        // TODO Auto-generated method stub
        return null;
    }
}
