package core;

import java.util.Scanner;

public class GameOptions {
	private String name;
	private int money;
	private int health;
	
	
	public void newGame(){
		System.out.println("Enter a name for your character: ");
		Scanner nameIn = new Scanner(System.in);
		name = nameIn.nextLine();
	}
	
	
	
}
