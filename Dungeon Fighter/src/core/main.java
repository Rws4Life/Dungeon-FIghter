package core;

import java.util.Scanner;

import character.Player;
import character.Weapon;

public class main {

	public static void main(String[] args) {
		Weapon weps = new Weapon();
		//Scanner nameIn = new Scanner(System.in);
		
		Player pl = new Player("John");
		weps.setWeapon();
		
		pl.addInventory("Sword");
		pl.printInventory();
		pl.addInventory(weps.getWeapon(2));
		pl.printInventory();
		pl.addInventory(weps.getWeapon(1));
		pl.printInventory();
		/*int option;
		System.out.println(
				  "########################### \n"
				+ "Welcome to Dungeon Fighter! \n"
				+ "########################### \n \n \n"
				+ "What do you want to do? \n"
				+ "1. New Game \n"
				+ "2. Load Game \n \n \n");
		Scanner input = new Scanner(System.in);
		
		option = input.nextInt();
		if(option == 1){
			gameOptions newG = new gameOptions();
			newG.newGame();
		}
		if(option == 2){
			System.out.println("Not implemented yet");
		}*/

		
	}

}
