package character;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WeaponGenerator {
	//private List<String> type = new ArrayList<String>(); //Sword, Axe, Lance, Dagger
	private List<String> type = Arrays.asList("Sword", "Lance", "Axe", "Dagger");
	private List<String> rarity = Arrays.asList("Common", "Rare", "Very Rare", "Legendary");
	
	
	public ArrayList<Weapon> createBaseWeapons(){
		//create Sword, Lance, Axe
		ArrayList<Weapon> list = new ArrayList<Weapon>();
		for(int i=0; i<3; i++){
			Weapon weaponManagement = new Weapon();
			weaponManagement.setType(type.get(i));
			switch(i){
				case 0:weaponManagement.setName("Sword"); break;
				case 1:weaponManagement.setName("Lance"); break;
				case 2:weaponManagement.setName("Axe"); break;
			}
			weaponManagement.setRarity(rarity.get(0));
			weaponManagement.setDmgMultiplier(1);
			weaponManagement.setAccMultiplier(1);
		
			list.add(weaponManagement);
		}
		return list;
	}
	
	/*public void createWeapon(String Type, String Name, String Rarity, double DmgMultiplier, double AccMultiplier){
		weaponManagement.setType(Type);
		weaponManagement.setName(Name);
		weaponManagement.setRarity(Rarity);
		weaponManagement.setDmgMultiplier(DmgMultiplier);
		weaponManagement.setAccMultiplier(AccMultiplier);
	}*/
	
	
}
/*Random randomGenerator = new Random();
int typeID = randomGenerator.nextInt(3);
type.get(typeID);*/

/*Random randomGenerator = new Random();
    for (int idx = 1; idx <= 10; ++idx){
      int randomInt = randomGenerator.nextInt(100);
      log("Generated : " + randomInt);
    }*/

//Check rarity function -> if rare, set multiplier to this