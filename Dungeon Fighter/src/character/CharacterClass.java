package character;

import java.util.Arrays;
import java.util.List;

public class CharacterClass {
	private List<String> classes = Arrays.asList("Warrior", "Hunter"); //paladin, thief and so on?
	
	public String getClass(int i){
		return classes.get(i);
	}
	
	public Player getWarriorClass(String Name){
		//create a player with following stats: Name, MaxHealth and CurrentHealth, BaseDamage, BaseAccuracy, BaseSpeed
		Player character = new Player(getClass(0), Name, 130, 1, 1, 1);
		return character;
	}
	
	public Player getHunterClass(String Name){
		//create a player with following stats: Name, MaxHealth and CurrentHealth, BaseDamage, BaseAccuracy, BaseSpeed
		Player character = new Player(getClass(1), Name, 90, 1, 1, 1);
		return character;
	}
}