package character;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Weapon implements Serializable{
	//Type - if Type then stat change
    //private String[] weapon = {"Sword", "Lance", "Axe"};
    private String type;
    private String name;
   private String rarity;
    //rarity.add("Common");// "Rare", "Very Rare", "Legendary";
    private double dmgMultiplier;
    private double accMultiplier;
    
    public Weapon(){
    	
    }
    public Weapon(String Type, String Name, String Rarity, double DmgMultiplier, double AccMultiplier){
    	type = Type; name = Name; rarity = Rarity; dmgMultiplier = DmgMultiplier; accMultiplier = AccMultiplier;
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
    
    //-----------------------------------------------------------------------------
    
    
    
    public String toString(){
    	return new String("Type: " + getType() + System.lineSeparator() +
    			"Name: " + getName() + System.lineSeparator() +
    			"Rarity: " + getRarity() + System.lineSeparator() +
    			"Damage Multiplier: " + getDmgMultiplier() + System.lineSeparator() +
    			"Accuracy Multiplier: " + getAccMultiplier() + System.lineSeparator());
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
