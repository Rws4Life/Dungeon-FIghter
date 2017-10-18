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
	
	//dungeon statistics
	private int dungeonsCleared; //-> if 10 dungeons cleared, add some new weapons to the shop?
	private int bossDungeonsCleared;
	
	//Master list of all existing weapons, excluding inventory of player
	private ArrayList<Weapon> weaponList = new ArrayList<Weapon>();
	
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
		case "easy": setMoney(1000); 
		setDmgPlayerMultiplier(1.5); setDmgEnemyMultiplier(0.5); 
		setAccPlayerMultiplier(1.5); setAccEnemyMultiplier(1); 
		setEnemyHealthMultiplier(0.75); break;
		
		case "normal": setMoney(500); 
		setDmgPlayerMultiplier(1); setDmgEnemyMultiplier(1); 
		setAccPlayerMultiplier(1); setAccEnemyMultiplier(1); 
		setEnemyHealthMultiplier(1);; break;
		
		case "hard": setMoney(0); 
		setDmgPlayerMultiplier(0.75); setDmgEnemyMultiplier(1.5); 
		setAccPlayerMultiplier(0.75); setAccEnemyMultiplier(1.5); 
		setEnemyHealthMultiplier(2); break;
		}
	}
	
	
	
	//Start in Village -> What do you want to do?
	public void startGame(){
		welcomePlayer();
		String option = optionsVillage();
		if(option=="1" || option=="dungeon"){
			//chooseDungeonType(); -> make a Dungeon Object with length and such
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
	
	
	
	
	//-----------------------------------------------------------------------------------------------------------------------------------------
	//Variable related functions---------------------------------------------------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------------------------
	
	//Getter and Setter Methods
	public Player getPlayer(){
		return pl;
	}
	
	public double getDmgPlayerMultiplier(){
		return dmgPlayerMultiplier;
	}
	public void setDmgPlayerMultiplier(double multiplier){
		dmgPlayerMultiplier = multiplier;
	}
	public double getDmgEnemyMultiplier(){
		return dmgEnemyMultiplier;
	}
	public void setDmgEnemyMultiplier(double multiplier){
		dmgEnemyMultiplier = multiplier;
	}
	public double getAccPlayerMultiplier(){
		return accPlayerMultiplier;
	}
	public void setAccPlayerMultiplier(double multiplier){
		accPlayerMultiplier = multiplier;
	}
	public double getAccEnemyMultiplier(){
		return accEnemyMultiplier;
	}
	public void setAccEnemyMultiplier(double multiplier){
		accEnemyMultiplier = multiplier;
	}
	public double getEnemyHealthMultiplier(){
		return enemyHealthMultiplier;
	}
	public void setEnemyHealthMultiplier(double multiplier){
		enemyHealthMultiplier = multiplier;
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
	
	//dungeon statistics
	public int getDungeonsCleared(){
		return dungeonsCleared;
	}
	public void setDungeonsCleared(int dungeonsClearSet){
		dungeonsCleared=dungeonsClearSet;
	}
	public void addDungeonsCleared(){
		dungeonsCleared = dungeonsCleared+1;
	}
	public int getBossDungeonsCleared(){
		return bossDungeonsCleared;
	}
	public void setBossDungeonsCleared(int dungeonsClearSet){
		bossDungeonsCleared=dungeonsClearSet;
	}
	public void addBossDungeonsCleared(){
		bossDungeonsCleared = bossDungeonsCleared+1;
	}
	
	
	//money functions - add, subtract, money checks and so on -> Add potion that increases Money found (multiply by x1.5)
	public int getMoney(){
		return money;
	}
	public void setMoney(int inputMoney){
		money = inputMoney;
	}
	public void addMoney(int inputMoney){
		money = money + inputMoney;
	}
	public void subMoney(int inputMoney){
		money = money - inputMoney;
	}
	
	//add to weapon list // remove from weapon list // get from weapon list
	public ArrayList<Weapon> getWeaponList(){
		return weaponList;
	}
	
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
	
	
	
}
