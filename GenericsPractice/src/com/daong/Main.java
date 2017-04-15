package com.daong;

public class Main {
	
	public static void main(String[] args){
		League<BaseballTeam> superLeague = new League<>("Super League");
		BaseballTeam t1 = new BaseballTeam("t1");
		BaseballTeam t2 = new BaseballTeam("t2");
		BaseballTeam t3 = new BaseballTeam("t3");
		BaseballTeam t4 = new BaseballTeam("t4");
		
		BasketballTeam t5 = new BasketballTeam("t5");
			
		
		superLeague.addTeam(t1);
		superLeague.addTeam(t2);
		superLeague.addTeam(t3);
		superLeague.addTeam(t4);
		//superLeague.addTeam(t5); ÉGÉâÅ[Ç…Ç»ÇÈÅB
		
		superLeague.match("t1", "t2", 3, 1);
		superLeague.match("t3", "t1", 5, 3);
		superLeague.match("t4", "t1", 1, 3);
		superLeague.match("t2", "t4", 1, 3);
		superLeague.match("t2", "t3", 1, 3);
		superLeague.match("t3", "t1", 1, 1);
		
		System.out.println(superLeague);
	}
	
}
