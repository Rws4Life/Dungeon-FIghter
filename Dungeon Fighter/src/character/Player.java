package character;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String characterClass;
	private String name;
	private double maxHealth = 100;
	private double health = 100;
	private double baseDamage = 0; //Basic Damage player can do from Weapon Base damage * Difficulty Multiplier ->set by CharacterClass
	private double baseAccuracy = 0;
	private double baseSpeed = 0;
	
	
	Weapon weaponManagement = new Weapon();
	
	private ArrayList<Weapon> inventory = new ArrayList<Weapon>();
	private Weapon equippedWeapon;
	
	
	//Constructor
	public Player (){
	}
	public Player (String Class, String Name, int MaxHealth, double Damage, double Accuracy, double Speed){
		characterClass = Class; name = Name; maxHealth = MaxHealth; health = MaxHealth; baseDamage = Damage; baseAccuracy = Accuracy; baseSpeed = Speed;
	}
	
	
	//Get and Set Methods for Player
	public String getCharacterClass(){
		return characterClass;
	}
	public void setCharacterClass(String CharacterClass){
		characterClass = CharacterClass;
	}
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
	public double getBaseDamage(){
		return baseDamage;
	}
	public void setBaseDamage(int inputDamage){
		baseDamage = inputDamage;
	}
	public double getBaseAccuracy(){
		return baseAccuracy;
	}
	public void setBaseAccuracy(double inputAccuracy){
		baseAccuracy = inputAccuracy;
	}
	public double getSpeed(){
		return baseSpeed;
	}
	public void setSpeed(double inputSpeed){
		baseSpeed = inputSpeed;
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
	public Weapon getEquipWeapon(){
		return equippedWeapon;
	}
	public void setEquipWeapon(int chosenWeapon){
		equippedWeapon = inventory.get(chosenWeapon-1);
	}
	
	
	
	//Printing Functions
	
	public String toString(){
		return new String("Name: " + getName() + "\n" + "Health: " + getHealth() + "/" + getMaxHealth() + "\n \n");
	}
	
	/*public void printPerson(){
		if(getEquipWeapon() == null){
			System.out.println("Name: " + getName() + System.lineSeparator() +
					"Health: " + getHealth() + "/" + getMaxHealth() + System.lineSeparator() +
					"Equipped Weapon: None " + System.lineSeparator());
		}
		else{
		System.out.println("Name: " + getName() + System.lineSeparator() +
				"Health: " + getHealth() + "/" + getMaxHealth() + System.lineSeparator() +
				"Equipped Weapon: " + getEquipWeapon().getName() + System.lineSeparator());
		printInventory();
		}
	}*/
	
	
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
