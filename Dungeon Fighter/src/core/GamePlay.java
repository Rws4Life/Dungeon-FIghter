package core;

import java.util.ArrayList;
import java.util.Scanner;

import character.Player;
import character.Weapon;
import character.WeaponGenerator;

public class GamePlay {

	//Save money in Gameplay to not overcomplicate transactions
	/**
	 * Different variables -> send to Player? //From GOption
	 */
	private Player pl;
	private int money;
	private String location;
	private String difficulty;
	
	//Master list of all existing weapons, excluding inventory of player
	private ArrayList<Weapon> weaponList = new ArrayList<Weapon>();
	
	public ArrayList<Weapon> getWeaponList(){
		return weaponList;
	}
	
	//For difficulties
	private double dmgPlayerMultiplier;
	private double dmgEnemyMultiplier;
	private double accPlayerMultiplier;
	private double accEnemyMultiplier;
	private double enemyHealthMultiplier;
	
	WeaponGenerator generate = new WeaponGenerator();
	
	public void setVariableInstance(Player Player, String Difficulty){
		pl = Player;
		difficulty = Difficulty;
		location = "Village";
		switch(difficulty){
		case "easy": money = 1000; 
		dmgPlayerMultiplier = 1.5; dmgEnemyMultiplier = 0.5; 
		accPlayerMultiplier = 1.5; accEnemyMultiplier = 1; 
		enemyHealthMultiplier = 0.75; break;
		
		case "normal": money = 500; 
		dmgPlayerMultiplier = 1; dmgEnemyMultiplier = 1;
		accPlayerMultiplier = 1; accEnemyMultiplier = 1; 
		enemyHealthMultiplier = 1; break;
		
		case "hard": money = 0; 
		dmgPlayerMultiplier = 0.75; dmgEnemyMultiplier = 1.5;
		accPlayerMultiplier = 0.75; accEnemyMultiplier = 1.5; 
		enemyHealthMultiplier= 2; break;
		}
		
		System.out.println("Set difficulty: " + difficulty + "\n Set player: " + pl.getName());
	}
	
	
	
	//Start in Village -> What do you want to do?
	public void startGame(){
		welcomePlayer();
		String option = optionsVillage();
		if(option=="1" || option=="dungeon"){
			
		}
		
		
		
		
	}
	
	
	public void welcomePlayer(){
		String hashies="";
		for(int i=0; i<pl.getName().length();i++){
			hashies = hashies + "#";
		}
		System.out.println("###########"+hashies+"\n"+ "Welcome, " + pl.getName() + "!!\n" + "###########"+hashies+"\n\n\n");
		
	
	}
	
	public String optionsVillage(){
		System.out.println("You are currently in your village! What do you wanna do? \n"
				+ "1. Go to dungeon \n"
				+ "2. Placeholder Text \n");
		Scanner optionIn = new Scanner(System.in);
		String option = optionIn.nextLine();
		optionIn.close();
		return option;
	}
	
	public void goIntoDungeon(){
		//Choose length of dungeon
		//Set monsters and stuff
		
	}
	
	public void fight(){
		
	}
	
	
	
	
	
	//Getter and Setter Methods
	public int getMoney(){
		return money;
	}
	public void setMoney(int inputMoney){
		money = inputMoney;
	}
	public double getDmgPlayerMultiplier(){
		return dmgPlayerMultiplier;
	}
	public double getDmgEnemyMultiplier(){
		return dmgEnemyMultiplier;
	}
	public double getAccPlayerMultiplier(){
		return accPlayerMultiplier;
	}
	public double getAccEnemyMultiplier(){
		return accEnemyMultiplier;
	}
	public String getDifficulty(){
		return difficulty;
	}
	
	public String getLocation(){
		return location;
	}
	public void setLocation(String Location){
		location=Location;
	}
	
	//add to weapon list // remove from weapon list // get from weapon list
	public void addToWeaponList(Weapon weaponToAdd){
		weaponList.add(weaponToAdd);
	}

	
	public void removeFromWeaponList(int index){
		weaponList.remove(index);
	}
	
	public Weapon getWeaponFromList(int index){
		return weaponList.get(index);
	}
	
	//load functions
	public void loadListToWeaponList(ArrayList<Weapon> weaponList){
		this.weaponList = weaponList;
	}
	public void loadPlayer(Player player){
		pl = player;
	}
	public void loadDifficulty(String diff){
		setVariableInstance(pl, diff);
	}
	
	public Player getPlayer(){
		return pl;
	}
	
}
