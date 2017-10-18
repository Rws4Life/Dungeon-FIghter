package character;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class WeaponGenerator {
	//private List<String> type = new ArrayList<String>(); //Sword, Axe, Lance, Dagger
	private List<String> type = Arrays.asList("Sword", "Lance", "Axe", "Dagger");
	private List<String> rarity = Arrays.asList("Common", "Rare", "Very Rare", "Legendary");
	
	public String getType(int i){
		return type.get(i);
	}
	public String getRarity(int i){
		return rarity.get(i);
	}
	
	/**
	 * Create the four basic weapons and add them to a list:
	 * Sword, Lance, Axe, (Dagger)
	 * Each weapon has random (reasonable) Damage and Accuracy Multipliers
	 * @return list with the four basic weapons available at the start
	 */
	public ArrayList<Weapon> createBaseWeapons(){
		//create Sword, Lance, Axe - TODO: Add Dagger
		ArrayList<Weapon> list = new ArrayList<Weapon>();
		for(int i=0; i<3; i++){	
			String nameOfWeapon = "";
			double speed = 0;
			switch(i){
				case 0:nameOfWeapon = "Sword"; speed = 0.5; break;
				case 1:nameOfWeapon = "Lance"; speed = 0.25; break;
				case 2:nameOfWeapon = "Axe"; speed = 0.1; break;
			}
			double dmgMultiplier = randomDamage(getType(i));
			double accMultiplier = randomAccuracy(getType(i));
			
			Weapon weaponManagement = new Weapon(getType(i), nameOfWeapon, getRarity(0), dmgMultiplier, accMultiplier, speed);
		
			list.add(weaponManagement);
		}
		return list;
	}

	
	public Weapon generateWeapon(){ //make gen weapon with rarity inputs? //Implement try catches instead of initialising variables, such as weapDmgMult or weapRarity
		//random choose type
		String weaponType = type.get(randomInt(0, 3));
		String weaponName = weaponType; //change to something interesting later
		
		//if type then -> damage and accuracy
		double weaponDmgMultiplier= randomDamage(weaponType);
		double weaponAccMultiplier= randomAccuracy(weaponType);
		//set speed
		double speed = 0;
		switch(weaponType){
			case "Sword": speed = 0.5; break;
			case "Lance": speed = 0.25; break;
			case "Axe": speed = 0.1; break;
		}
		//random rarity
		String weaponRarity="Common";
		int rarityNumber = randomInt(0,100);
		if(rarityNumber >= 0 && rarityNumber <= 50){
			weaponRarity=getRarity(0);
		}
		else if(rarityNumber > 50 && rarityNumber <= 80){
			weaponRarity=getRarity(1);
		}
		else if(rarityNumber > 80 && rarityNumber <= 95){
			weaponRarity=getRarity(2);
		}
		else if(rarityNumber > 95){
			weaponRarity=getRarity(3);
		}
		
		//change stats based on rarity
		switch(weaponRarity){
			case "Common": break;
			case "Rare": weaponDmgMultiplier = weaponDmgMultiplier + 0.5; weaponAccMultiplier = weaponAccMultiplier + 0.5;break;
			case "Very Rare": weaponDmgMultiplier = weaponDmgMultiplier + 1; weaponAccMultiplier = weaponAccMultiplier + 1;break;
			case "Legendary": weaponDmgMultiplier = weaponDmgMultiplier + 2; weaponAccMultiplier = weaponAccMultiplier + 2;break;
		}
		
		//TODO: Random chance of creating extreme weapon and add "of ..." -> chance 1% to add 2 spd to sword -> "Sword of Speed" // +2 dmg "Sword of Damage"
		
		//create Weapon
		Weapon weapon= new Weapon(weaponType, weaponName, weaponRarity, weaponDmgMultiplier, weaponAccMultiplier, speed);
		return weapon;
	}
	
	public double randomDouble(double min, double max){
		double random = ThreadLocalRandom.current().nextDouble(min, max+0.1);
		double roundOff = (double) Math.round(random * 10) / 10;
		return roundOff;
	}
	public int randomInt(int min, int max){
		int random = ThreadLocalRandom.current().nextInt(min, max + 1);
		return random;
	}
	
	/**
	 * Create Random Damage Multipliers for a Type of Weapon (Sword/Lance/Axe/Dagger)
	 * @param Type of Weapon
	 * @return double value, rounded to 2nd decimal to either 5 or 0 (1.23=1.25; 1.1=1.0 and so on)
	 */
	public double randomDamage(String Type){
		double x=0;
		switch(Type){
			case "Sword": x = ThreadLocalRandom.current().nextDouble(0.75, 1.25); break;//generate random variable between 0.7-1 and send it OR just return directly?
			case "Lance":x = ThreadLocalRandom.current().nextDouble(1, 1.5); break;
			case "Axe":x= ThreadLocalRandom.current().nextDouble(1.25, 1.75); break;
			case "Dagger":x= ThreadLocalRandom.current().nextDouble(0.5, 1); break;
			//case type.get(2):Type = type.get(2); break;
	}
		//System.out.println(x);
		BigDecimal bd = new BigDecimal(x);
		return roundToHalf(bd.setScale(2,BigDecimal.ROUND_HALF_EVEN).doubleValue());
	}
	
	/**
	 * Create Random Accuracy Multipliers for a Type of Weapon (Sword/Lance/Axe/Dagger)
	 * @param Type of Weapon
	 * @return double value, rounded to double decimals
	 */
	public double randomAccuracy(String Type){
		double x=0;
		switch(Type){
			case "Sword": x = ThreadLocalRandom.current().nextDouble(0.75, 1.25); break;
			case "Lance":x = ThreadLocalRandom.current().nextDouble(0.5, 1); break;
			case "Axe":x= ThreadLocalRandom.current().nextDouble(0.65, 1.1); break;
			case "Dagger":x= ThreadLocalRandom.current().nextDouble(0.75, 1.25); break;
	}
		
		BigDecimal bd = new BigDecimal(x);
		return roundToHalf(bd.setScale(2,BigDecimal.ROUND_HALF_EVEN).doubleValue());
	}
	
	/**
	 * Function to round Values to .05 or .00
	 * @param Number to be rounded
	 * @return Rounded Number
	 */
	public static double roundToHalf(double d) {
	    return Math.round(d * 20) / 20.0;
	}
	
	
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