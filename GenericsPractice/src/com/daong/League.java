package com.daong;

import java.util.ListIterator;
import java.util.List;
import java.util.Collections;
import java.util.LinkedList;

public class League<T extends Team> {
	private String leagueName;
	private List<T> teams = new LinkedList<>(); 
	
	public League(String leagueName) {
		this.leagueName = leagueName;
	}

	public boolean addTeam(T t) {
		return teams.contains(t)? false:teams.add(t);	
	}

	@Override
	public String toString() {
		Collections.sort(teams);
		StringBuffer sb = new StringBuffer("\nStandings for " + this.leagueName + "\nteamName\tPlayed:Wins:Loss:Tie\n");
		for(T t : teams){
			sb.append(t.toString() + "\t\t" + t.getPlayed() + ":" + t.getWon() + ":" + t.getLost() + ":" + t.getTied()+ "\n");
		}
		return sb.toString();
	}
	
	private T findTeam(String teamName){
		ListIterator<T> it = teams.listIterator();
		while (it.hasNext()){
			if (it.next().toString().equals(teamName)){
				return it.previous();
			}
		}
		return null;
	}
	
	public void match(String teamName1, String teamName2, int teamPoint1, int teamPoint2){
		System.out.println(findTeam(teamName1).matchResult(findTeam(teamName2), teamPoint1, teamPoint2));
	}

	
	
	
}
