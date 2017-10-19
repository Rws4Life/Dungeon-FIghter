package entities;

import character.Weapon;
import character.WeaponGenerator;

public class Monster {
	
	
	
	private String enemyType;
	private double maxHealth = 100;
	private double health = 100;
	private double baseDamage = 0;
	private double baseAccuracy = 0;
	private double baseSpeed = 0;
	public int level = 0;
	
	private int goldDrop = 0;
	
	private Weapon weapon;
	
	public Monster(){
		
	}
	
	public Monster(String type, double mHealth, double bDamage, double bAccuracy, double bSpeed, int goldValue, int Level){
		setEnemyType(type); setMaxHealth(mHealth); setHealth(mHealth); 
		setDamage(bDamage); setAccuracy(bAccuracy); setSpeed(bSpeed); 
		setGoldDrop(goldValue); setLevel(Level); generateWeapon();
	}
	
	
	
	
	public String getEnemyType(){
		return enemyType;
	}
	public void setEnemyType(String EnemyType){
		enemyType = EnemyType;
	}
	public double getMaxHealth(){
		return maxHealth;
	}
	public void setMaxHealth(double MaxHealth){
		maxHealth = MaxHealth;
	}
	public double getHealth(){
		return health;
	}
	public void setHealth(double Health){ //monster.getHealth()-pl.getBaseDamage()*pl.Dmg Multipliers
		health = Health;
	}
	public double getDamage(){
		return baseDamage;
	}
	public void setDamage(double damage){
		baseDamage = damage;
	}
	public double getAccuracy(){
		return baseAccuracy;
	}
	public void setAccuracy(double accuracy){
		baseAccuracy = accuracy;
	}
	public double getSpeed(){
		return baseSpeed;
	}
	public void setSpeed(double speed){
		baseSpeed = speed;
	}
	public int getLevel(){
		return level;
	}
	public void setLevel(int Level){
		level = Level;
	}
	
	public int getGoldDrop(){
		return goldDrop;
	}
	public void setGoldDrop(int GoldDropValue){
		goldDrop = GoldDropValue;
	}
	
	
	public void generateWeapon(){
		WeaponGenerator wpGen = new WeaponGenerator();
		weapon = wpGen.generateWeapon();
	}
	public Weapon getWeapon(){
		return weapon;
	}
}
