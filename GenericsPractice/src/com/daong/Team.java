package com.daong;

public abstract class Team implements Comparable <Team>{
	private String teamName;
	private int played = 0;
	private int won = 0;
	private int tied = 0;
	private int lost = 0;
	
	public Team(String teamName) {
		this.teamName = teamName;
	}
	
	public double ranking(){
		return (double)((won * 2) + tied)/played;
	}
	
	public String matchResult(Team otherTeam, int ourScore, int theirScore){
		String output;
		if (ourScore > theirScore){
			this.won ++;
			output = this + " beat " + otherTeam;
		} else if (ourScore < theirScore){
			this.lost++;
			output = this.getTeamName() + " lost to " + otherTeam;
		} else {
			this.tied++;
			output = this.getTeamName() + " tied with " + otherTeam;
		}
		
		played++;
		
		if (otherTeam != null){
			otherTeam.matchResult(null, theirScore, ourScore);
		}
		
		return output;
	}
	
	@Override
	public int compareTo(Team otherTeam){
		
		return this.ranking() > otherTeam.ranking()? -1 : this.ranking() == otherTeam.ranking()? 0 : 1;
		
	}
	
	public String getTeamName() {
		return teamName;
	}

	public int getWon() {
		return won;
	}

	public int getTied() {
		return tied;
	}

	public int getLost() {
		return lost;
	}

	public int getPlayed() {
		return played;
	}

	@Override
	public String toString() {
		return this.getTeamName();
	}
	
	
	
}
