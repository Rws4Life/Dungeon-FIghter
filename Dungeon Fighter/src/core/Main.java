package core;


import java.util.Scanner;



public class Main {

	public static void main(String[] args) {
		
		
		
		
		
		int option;
		System.out.println(
				  "########################### \n"
				+ "Welcome to Dungeon Fighter! \n"
				+ "########################### \n \n \n"
				+ "What do you want to do? \n"
				+ "1. New Game \n"
				+ "2. Load Game \n \n \n");
		Scanner input = new Scanner(System.in);
		option = input.nextInt();
		//input.close();
		
		if(option == 1){
			GameOptions newG = new GameOptions();
			newG.newGame();
			
			newG.saveGame();
			
			newG.loadGame();
		}
		if(option == 2){
			System.out.println("Not implemented yet");
		}

		input.close();
	}

}

/*Weapon weps = new Weapon();
	//Scanner nameIn = new Scanner(System.in);
	
	Player pl = new Player("John");
	ArrayList<Weapon> WeaponList = new ArrayList<Weapon>();
	WeaponGenerator generate = new WeaponGenerator();
	
	WeaponList.addAll(generate.createBaseWeapons()); 
	
	
	for(int i=0;i<WeaponList.size();i++){
		System.out.println(WeaponList.get(i).toString());
		}
	
	pl.addToInventory(WeaponList.get(1));
	pl.printInventory();
	pl.addToInventory(WeaponList.get(2));
	pl.printInventory();
	
	pl.setEquipWeapon(0);
	pl.printEquippedWeapon();
	
	pl.addInventory(WeaponList.add(0));
	pl.printInventory();
	pl.addInventory(weps.getWeapon(2));
	pl.printInventory();
	pl.addInventory(weps.getWeapon(1));
	pl.printInventory();*/
