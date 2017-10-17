package character;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

public class Player {
	private String name;
	private double maxHealth = 100;
	private double health = 100;
	private double baseDamage = 10; //Basic Damage player can do from Weapon Base damage * Difficulty Multiplier
	private double baseAccuracy = 0;
	
	
	Weapon weaponManagement = new Weapon();
	
	
	private ArrayList<Weapon> inventory = new ArrayList<Weapon>();
	private Weapon equippedWeapon;
	
	
	//Constructor
	public Player ( String Name){
		name = Name;
	}
	
	
	//Get and Set Methods for Player
	public String getName(){
		return name;
	}
	public void setName(String inputName){
		name = inputName;
	}
	public double getMaxHealth(){
		return maxHealth;
	}
	public void setMaxHealth(int inputMaxHealth){
		maxHealth = inputMaxHealth;
	}
	public double getHealth(){
		return health;
	}
	public void setHealth(int inputHealth){
		health = inputHealth;
	}
	public double getDamageDealt(){
		return baseDamage;
	}
	public void setDamageDealt(double inputDamageDealt){
		baseDamage = inputDamageDealt;
	}
	
	
	//Manage Inventory and Equipping Weapons
	public void addToInventory(Weapon Weapon){	
    	inventory.add(Weapon);
    }
	
	public void deleteFromInventory(Weapon Weapon){
		inventory.remove(Weapon);
	}
	
	/*public void clearInventory(){
		inventory.removeAll();
	}*/
	
	public void setEquipWeapon(int chosenWeapon){
		equippedWeapon = inventory.get(chosenWeapon-1);
	}
	
	public Weapon getEquipWeapon(){
		return equippedWeapon;
	}
	
	//Printing Functions
	
	public String toString(){
		return new String("Name: " + getName() + "\n" + "Health: " + getHealth() + "/" + getMaxHealth() + "\n \n");
	}
	
	public void printEquippedWeapon(){
		System.out.println("Equipped Weapon: " + equippedWeapon.getName());
	}
	
	public void printInventory(){
		String inv = "";
		inv = "Weapons in Inventory:";
		for(int i = 0; i < inventory.size(); i++) {  
			if(inventory.size() == 1){
				inv = inv + "[" + inventory.get(i).getName() + "]"; break; //make it tostring or so later
			}
			if(i==0){
				inv = inv+ "[" + inventory.get(i).getName() + ", ";
			}
			else if(i==inventory.size()-1 ){
				inv = inv + inventory.get(i).getName() + "]";
			}
			else{
				inv = inv + inventory.get(i).getName() + ", ";
			}
		}  
		System.out.println(inv);
	}
}
