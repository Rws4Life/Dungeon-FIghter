package character;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

public class Player {
	private String name;
	private int maxHealth = 100;
	private int health = 100;
	private int damage = 0;
	private int accuracy = 0;
	
	
	Weapon weaponManagement = new Weapon();
	
	//private String equippedWeapon = weaponManagement.getWeapon(0);
	private ArrayList<Weapon> inventory = new ArrayList<Weapon>();
	
	//Constructor
	public Player ( String Name){
		name = Name;
	}
	
	
	
	public String getName(){
		return name;
	}
	public void setName(String inputName){
		name = inputName;
	}
	public int getMaxHealth(){
		return maxHealth;
	}
	public void setMaxHealth(int inputMaxHealth){
		maxHealth = inputMaxHealth;
	}
	public int getHealth(){
		return health;
	}
	public void setHealth(int inputHealth){
		health = inputHealth;
	}
	public int getDamageDealt(){
		return damage;
	}
	public void setDamageDealt(int inputDamageDealt){
		damage = inputDamageDealt;
	}
	
	public String toString(){
		return new String("Name: " + getName() + "\n" + "Health: " + getHealth() + "/" + getMaxHealth() + "\n \n");
	}
	
	public void addToInventory(Weapon Weapon){	
    	inventory.add(Weapon);
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
