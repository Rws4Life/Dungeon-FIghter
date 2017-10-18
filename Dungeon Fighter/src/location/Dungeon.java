package location;

import core.GamePlay;

public class Dungeon {

	private int rooms;
	
	GamePlay gp = new GamePlay();
	
	//where the magic happens
	public void dungeonJourney(){
		
	}
	
	
	
	public void chooseDungeonType(int roomNr){
		rooms = roomNr;
	}
	
	public int getRooms(){
		return rooms;
	}
	
	
}
