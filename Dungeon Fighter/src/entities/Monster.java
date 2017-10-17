package entities;

public class Monster {
	private double health = 100;
	private double baseDamage = 100;

	public double getHealth(){
		return health;
	}
	public void setHealth(double Health){ //monster.getHealth()-getBaseDamage()*Dmg Multipliers
		health = Health;
	}
	public double getDamage(){
		return baseDamage;
	}
	public void setDamage(double Damage){
		baseDamage = Damage;
	}
	
}
