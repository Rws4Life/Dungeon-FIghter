package character;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeaponGenerator {
	//private List<String> type = new ArrayList<String>(); //Sword, Axe, Lance, Dagger
	private List<String> type = Arrays.asList("Sword", "Lance", "Axe", "Dagger");
	private List<String> rarity = Arrays.asList("common", "rare", "very rare", "legendary");
	Weapon weaponManagement = new Weapon();
	
	public void createBaseWeapons(String Type, String Name, String Rarity, double DmgMultiplier, double AccMultiplier){
		//create Sword
		weaponManagement.setType();
	}
	
	
}
