package location;

import java.util.Scanner;

import core.GamePlay;
import entities.Monster;
import entities.MonsterGenerator;

public class Dungeon {

	private int rooms;
	private int currentRoomNr;
	private boolean bossDungeon;
	
	//GamePlay gp = new GamePlay();
	
	//where the magic happens
	@SuppressWarnings("resource")
	public void dungeonJourney(GamePlay gp){ // use the gamePlay session
		//Ask for length of dungeon -> if %5 then boss dungeon
		System.out.println("Hello! What type of dungeon do you want to choose?");
		if(gp.getDungeonsCleared() != 0 && gp.getDungeonsCleared()%5==0){
			setBossDungeonState(true);
			System.out.println("It seems like it is time for a boss dungeon, since you have cleared" + gp.getDungeonsCleared() + "dungeons!");
			System.out.println("1. Easy Dungeon (Only a boss)");
			System.out.println("2. Medium Dungeon (5 Fights and a boss)");
			System.out.println("3. Hard Dungeon (10 Fights and a boss)");
			Scanner roomOptionIn = new Scanner(System.in);
			int roomOption = roomOptionIn.nextInt();
			
			switch(roomOption){
			case 1: chooseDungeonType(1, true);
			case 2: chooseDungeonType(5, true);
			case 3: chooseDungeonType(10, true);
			}
			
		}
		else{
			System.out.println("1. Short Dungeon (10 Fights)");
			System.out.println("2. Long Dungeon (25 Fights)");
			Scanner roomOptionIn = new Scanner(System.in);
			int roomOption = roomOptionIn.nextInt();
			
			switch(roomOption){
			case 1: chooseDungeonType(10, false);
			case 2: chooseDungeonType(25, false);
			
			}
		}
		
		//generate Dungeon and start: NO NEED FOR THIS, really. Only to set up current room number...
		setCurrentRoomNr(1);
		
		//check room number - loop here
		for(;getCurrentRoomNr() < getRooms();){
			//Ask
			System.out.println("You are standing in a hallway. What do you want to do?");
			System.out.println("1. Enter room.");
			System.out.println("2. Prepare");
			Scanner roomOptionIn = new Scanner(System.in);
			int roomOption = roomOptionIn.nextInt();
			
			switch(roomOption){
			case 1: break;
			case 2: break;
			}
			
			
		}
		
		//Ask if to enter (first) room or prepare
		
		//if enter room
		
		{
			//generate monster
			
			//introduce monster
			
			//ask what to do: run or fight
			
			//if fight
			{
				//loop (bool check = true) for as long as someone has over 0 health check (bool check == false)
				
				//attack TODO: Add option to use potions and stuff at one point
				
				//check speed of people
				
				//if player faster
				{
					//player attacks
					
					//check health of enemy
					{
						//if <= 0 -> end fight in victory: roomNr+1 (bool check = false)
					}
					
					//monster attacks
					
					//check health of player
					{
						// if <= 0 -> lose screen
					}
				}
				
				//if monster faster
				{
					//monster attacks
					
					//check health of player
					{
						// if <= 0 -> lose screen
					}
					
					//player attacks
					
					//check health of enemy
					{
						//if <= 0 -> end fight in victory: roomNr+1 (bool check = false)
					}
				}
				
				//loop again as long as someone has more than 0 health
				
				
			}
			// if run -> go back to village
			
		}
		//if prepare
		{
			//Implement stuff later such as use potions, sleep, give up dungeon and go with limited res back, maybe add story elements
		}
		
	}
	
	
	
	public void chooseDungeonType(int roomNr, boolean boss){
		rooms = roomNr;
		bossDungeon = boss;
	}
	
	public int getRooms(){
		return rooms;
	}
	public void riseCurrentRoomNr(int roomNr){
		currentRoomNr = roomNr + 1;
	}
	public void setCurrentRoomNr(int roomNr){
		currentRoomNr = roomNr;
	}
	public int getCurrentRoomNr(){
		return currentRoomNr;
	}
	public void setBossDungeonState(boolean value){
		bossDungeon = value;
	}
	public boolean getBossDungeonState(){
		return bossDungeon;
	}
	
	public void enterRoom(GamePlay gp){
		MonsterGenerator mg = new MonsterGenerator();
		
		Monster mon = mg.generateMonster(gp);
		introduceMonster(mon);
		
		
		
	}
	
	public void introduceMonster(Monster mon){
		System.out.println("A new enemy is appearing. It's a " + mon.getEnemyType() + "!" + System.lineSeparator() +
				"What a surprise. Looking closer at it... It seems to have " + mon.getHealth() + " HP and is not afraid to kick some butt."); 
		/*to be a weak enemy ->if(health<70) and such*/
	}
	public void decisionInRoom(){
		
	}
	//if enter room
	
			{
				//generate monster
				
				//introduce monster
				
				//ask what to do: run or fight
				
				//if fight
				{
					//loop (bool check = true) for as long as someone has over 0 health check (bool check == false)
					
					//attack TODO: Add option to use potions and stuff at one point
					
					//check speed of people
					
					//if player faster
					{
						//player attacks
						
						//check health of enemy
						{
							//if <= 0 -> end fight in victory: roomNr+1 (bool check = false)
						}
						
						//monster attacks
						
						//check health of player
						{
							// if <= 0 -> lose screen
						}
					}
					
					//if monster faster
					{
						//monster attacks
						
						//check health of player
						{
							// if <= 0 -> lose screen
						}
						
						//player attacks
						
						//check health of enemy
						{
							//if <= 0 -> end fight in victory: roomNr+1 (bool check = false)
						}
					}
					
					//loop again as long as someone has more than 0 health
					
					
				}
				// if run -> go back to village
				
			}
	
}



