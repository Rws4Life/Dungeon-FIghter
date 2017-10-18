package core;

import java.util.ArrayList;
import java.util.Scanner;

import character.CharacterClass;
import character.Player;
import character.Weapon;
import character.WeaponGenerator;

public class GameOptions {

	/**
	 * This function creates a new game.
	 */
	public void newGame(){

		System.out.println("---------------------------------");
		System.out.println("--D U N G E O N   F I G H T E R--");
		System.out.println("-------  N E W   G A M E  -------");
		System.out.println("---------------------------------");
		System.out.println(System.lineSeparator() + "Welcome to the character creation screen!" + System.lineSeparator() + System.lineSeparator());
		
		
		
		//Difficulty
		String difficulty="";
		for(boolean b=true;b==true;){
			System.out.println("Select difficulty: ");
			@SuppressWarnings("resource")
			Scanner difficultyIn = new Scanner(System.in);
			difficulty = difficultyIn.nextLine();
			
			
			
			if(difficulty.equalsIgnoreCase("easy") || difficulty.equalsIgnoreCase("normal") || difficulty.equalsIgnoreCase("hard")){
				/*|| difficulty.equals(1) || difficulty.equals(2) || difficulty.equals(3)*/
				System.out.println("Difficulty set.");
				b=false;
			}
			else System.out.println("Fuck you, set up a real difficulty or get out of here!");
		}
		
		
		//Name
		System.out.println("Enter a name for your character: ");
		Scanner nameIn = new Scanner(System.in);
		String name = nameIn.nextLine();
		
		//Creating Player
		System.out.println("Generating character...");
		Player pl = new Player();
		
		//Choosing Class
		System.out.println("Choose a class: " + System.lineSeparator() + "1. Warrior" + System.lineSeparator() + "2. Hunter" + System.lineSeparator());
		Scanner classChosen = new Scanner(System.in);
		String chosenClass = classChosen.nextLine();
		
		CharacterClass create = new CharacterClass();
		if(chosenClass.equals("1") || chosenClass.equalsIgnoreCase("warrior")){
			pl = create.getWarriorClass(name);
		}
		
		System.out.println(pl.toString());
		
		//Generation Weapons
		System.out.println("Generating weapons...");
		ArrayList<Weapon> WeaponList = new ArrayList<Weapon>();
		WeaponGenerator generate = new WeaponGenerator();
		
		WeaponList.addAll(generate.createBaseWeapons());
		
		//Choosing starting Weapon and adding to inventory/equipping
		System.out.println("Please choose a starting weapon [Starts from 1]: \n\n");
		for(int i=0;i<WeaponList.size();i++){
			System.out.println(WeaponList.get(i).toString());
		}
		
		Scanner weaponInv = new Scanner(System.in);
		int weapToAdd = weaponInv.nextInt();
		
		pl.addToInventory(WeaponList.get(weapToAdd-1));
		System.out.println(pl.toString());
		pl.printInventory();
		
		
		System.out.println("Equipping Weapon...");
		
		pl.setEquipWeapon(1);
		pl.printEquippedWeapon();
		
		//Funny loading screen and setting up Gameplay
		System.out.println("Fetching cadavers... \n Killing children... \n Blowing candles... \n");
		
		GamePlay gp = new GamePlay();
		gp.setVariableInstance(pl, difficulty);
		
		//Enter village and start game -> Going onto GamePlay
		System.out.println("Enjoy!");
		
		gp.startGame();
		
		
		//Note to self: Close Scanners sometime
		//difficultyIn.close();
		nameIn.close();
		classChosen.close();
		weaponInv.close();
	}
	
	
	
}
