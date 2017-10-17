package core;

import java.util.ArrayList;
import java.util.Scanner;

import character.Player;
import character.Weapon;
import character.WeaponGenerator;

public class GameOptions {

	/**
	 * This function creates a new game.
	 */
	public void newGame(){

		String difficulty="normal";
		
		for(boolean b=true;b==true;){
			System.out.println("Select difficulty: ");
			Scanner difficultyIn = new Scanner(System.in);
			difficulty = difficultyIn.nextLine();		
			difficultyIn.close();
			
			if(difficulty.equalsIgnoreCase("easy") || difficulty.equalsIgnoreCase("normal") || difficulty.equalsIgnoreCase("hard")){
				/*|| difficulty.equals(1) || difficulty.equals(2) || difficulty.equals(3)*/
				System.out.println("Difficulty set.");
				b=false;
			}
			else System.out.println("Fuck you, set up a real difficulty or get out of here!");
		}
		
		
		System.out.println("Enter a name for your character: ");
		Scanner nameIn = new Scanner(System.in);
		String name = nameIn.nextLine();
		nameIn.close();
		
		System.out.println("Generating character...");
		Player pl = new Player(name);
		
		System.out.println("Generating weapons...");
		ArrayList<Weapon> WeaponList = new ArrayList<Weapon>();
		WeaponGenerator generate = new WeaponGenerator();
		
		WeaponList.addAll(generate.createBaseWeapons());
		
		System.out.println("Please choose a starting weapon [Starts from 1]: \n\n");
		for(int i=0;i<WeaponList.size();i++){
			System.out.println(WeaponList.get(i).toString());
		}
		
		Scanner weaponInv = new Scanner(System.in);
		int weapToAdd = weaponInv.nextInt();
		weaponInv.close();
		pl.addToInventory(WeaponList.get(weapToAdd-1));
		System.out.println(pl.toString());
		pl.printInventory();
		
		
		System.out.println("Equipping Weapon...");
		
		pl.setEquipWeapon(1);
		
		pl.printEquippedWeapon();
		
		System.out.println("Fetching cadavers... \n Killing children... \n Blowing candles... \n");
		
		GamePlay gp = new GamePlay();
		gp.setVariableInstance(pl, difficulty);
		
		//Enter village and start game
		System.out.println("Enjoy!");
		
		gp.startGame();
		
	}
	
	
	
}
