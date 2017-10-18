package core;

import java.util.ArrayList;
import java.util.Scanner;

import character.CharacterClass;
import character.Player;
import character.Weapon;
import character.WeaponGenerator;
import dao.serialDAO;

public class GameOptions {
	//TODO: Add Line Separators instead of \n to all prints
	GamePlay gp = new GamePlay();

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
			else System.out.println("Set up a real difficulty or get out of here!");
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
		else if(chosenClass.equals("2") || chosenClass.equalsIgnoreCase("hunter")){
			pl = create.getHunterClass(name);
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
		WeaponList.remove(weapToAdd-1);
		
		System.out.println("Equipping Weapon...");
		
		pl.setEquipWeapon(1);
		pl.printEquippedWeapon();
		
		//Funny loading screen and setting up Gameplay
		System.out.println("Fetching cadavers... \n Killing children... \n Blowing candles... \n");
		
		
		gp.setVariableInstance(pl, difficulty);
		gp.setDungeonsCleared(0);
		gp.setBossDungeonsCleared(0);
		
		//add untaken weapons into weapon list in gameplay
		for(int i=0; i<WeaponList.size();i++){
			gp.addToWeaponList(WeaponList.get(i));
		}
		
		//Enter village and start game -> Going onto GamePlay
		System.out.println("Enjoy!");
		
		gp.startGame();
		
		
		//Note to self: Close Scanners sometime
		//difficultyIn.close();
		nameIn.close();
		classChosen.close();
		weaponInv.close();
	}
	
	public void saveGame(){
		
		serialDAO dao = new serialDAO();
		dao.saveList(gp.getWeaponList(), gp.getPlayer(), gp.getDifficulty());
	}
	
	public void loadGame(){
		
		serialDAO dao = new serialDAO();
		dao.loadList(gp);
		//ArrayList<Weapon> listweap = dao.loadList();
		System.out.println(gp.getPlayer().toString());
		gp.getPlayer().printInventory();
		System.out.println(gp.getAccEnemyMultiplier());
		
		for(int i=0; i<gp.getWeaponList().size();i++){
			System.out.println(gp.getWeaponFromList(i).getName());
		}
		
		
		//System.out.println(listweap.get(0).toString());
		
		
	}
	
}
