package entities;

import java.util.Arrays;
import java.util.List;

import character.Weapon;
import character.WeaponGenerator;

public class Monster {
	
	
	private List<String> enemyType = Arrays.asList("Skeleton", "Zombie"); 
	
	private double maxHealth = 100;
	private double health = 100;
	private double baseDamage = 0;
	private double baseAccuracy = 0;
	private double baseSpeed = 0;
	
	private int goldDrop = 0;
	
	private Weapon weapon; // generate random weapon from weapongenerator
	
	public Monster(double type, double mHealth, double bDamage, double bAccuracy, double bSpeed, int goldValue){
		setMaxHealth(mHealth); setHealth(mHealth); setDamage(bDamage); setAccuracy(bAccuracy); setSpeed(bSpeed); setGoldDrop(goldValue); generateWeapon();
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
	public void setHealth(double Health){ //monster.getHealth()-getBaseDamage()*Dmg Multipliers
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
