package character;

import java.io.Serializable;

public class Weapon implements Serializable{
	/**
	 * http://frequal.com/java/PracticalSerialVersionIdGuidelines.html
	 */
	private static final long serialVersionUID = 2191198455047530167L;
	
    private String type;
    private String name;
    private String rarity;
    private double dmgMultiplier;
    private double accMultiplier;
    private double speed;
    
    public Weapon(){
    	
    }
    public Weapon(String Type, String Name, String Rarity, double DmgMultiplier, double AccMultiplier, double Speed){
    	setType(Type); setName(Name); setRarity(Rarity); setDmgMultiplier(DmgMultiplier); setAccMultiplier(AccMultiplier); setSpeed(Speed);
    }
    
    
    //-----------------------------------------------------------------------------
    //Getter and Setter
    public void setType(String Type){
    	type = Type;
    }
    public String getType(){
    	return type;
    }
    
    public void setName(String Name){
    	name = Name;
    }
    public String getName(){
    	return name;
    }
    
    public void setRarity(String Rarity){
    	rarity = Rarity;
    }
    public String getRarity(){
    	return rarity;
    }
    
    public void setDmgMultiplier(double DmgMultiplier){
    	dmgMultiplier = DmgMultiplier;
    }
    public double getDmgMultiplier(){
    	return dmgMultiplier;
    }
    
    public void setAccMultiplier(double AccMultiplier){
    	accMultiplier = AccMultiplier;
    }
    public double getAccMultiplier(){
    	return accMultiplier;
    }
    public void setSpeed(double Speed){
    	speed = Speed;
    }
    public double getSpeed(){
    	return speed;
    }
    
    //-----------------------------------------------------------------------------
    
    
    
    public String toString(){
    	return new String("Type: " + getType() + System.lineSeparator() +
    			"Name: " + getName() + System.lineSeparator() +
    			"Rarity: " + getRarity() + System.lineSeparator() +
    			"Damage Multiplier: " + getDmgMultiplier() + System.lineSeparator() +
    			"Accuracy Multiplier: " + getAccMultiplier() + System.lineSeparator() +
    			"Speed: " + getSpeed() + System.lineSeparator());
    }
    
    /*public void setWeapon(){
    	weapon.add("Sword"); weapon.add("Lance"); weapon.add("Axe");
    }
    
    public Weapon getWeapon(int i){ //TURN TO WEAPON
    	return weapon.get(i);
    }
    
    public String getWeaponName(int i){ //TURN TO WEAPON
    	return weapon.get(i);
    }
    
    public int getWeaponID(String Weapon){
    	int WepID = 0;
    	switch(Weapon){
    	case "Sword": WepID=0;break;
    	case "Lance": WepID=1;break;
    	case "Axe": WepID=2;break;
    	}
    	return WepID;
    }
    
    public void printwep(String Weapon){
    	//System.out.println(weapon[getWeaponID(Weapon)]);
    	System.out.println(weapon.get(getWeaponID(Weapon)));
    }*/
    
    

    //print out the String array here
   /* public void printWeapons(){
        for (int i=0; i<weapon.size(); i++)
        {
            System.out.println(i + ". " + weapon.get(i));
        }
    }*/
}
