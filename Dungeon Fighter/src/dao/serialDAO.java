package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import character.Weapon;

public class serialDAO {

	public <T> boolean saveList(ArrayList<Weapon> weaponList/*, ArrayList<Monster> monsterList*/) { //get gameplay as parameter
		if("C:\\Users\\Rws\\Desktop\\Dungeon Fighter\\Save.txt" != null) 
			System.out.println("Save file: " + "C:\\Users\\Rws\\Desktop\\Dungeon Fighter\\Save.txt");
		
		try {
			FileOutputStream fos = new FileOutputStream("C:\\Users\\Rws\\Desktop\\Dungeon Fighter\\Save.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			//gp.getMonsterList().writeObject()
			oos.writeObject(weaponList);
			//oos.writeObject(monsterList);

			oos.close();
			fos.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

		return true;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Weapon> loadList() {//Make class Gamedata which contains lists or make void and set inside lists
		ArrayList<Weapon> weapons = null;
		//ArrayList<Monsters> monsters = null;
		File f = new File("C:\\Users\\Rws\\Desktop\\Dungeon Fighter\\Save.txt");
		
		/*
		 * Hint: Calling '.exists' on a file also returns true if
		 *  the file is a path! I may have saved you some coffee ;)
		 */
		if(f != null && f.isFile()){
			try {
				FileInputStream fis = new FileInputStream(f.getAbsolutePath());
				ObjectInputStream ois = new ObjectInputStream(fis);
				weapons = ((ArrayList<Weapon>) ois.readObject());
				//monsters = ((ArrayList<Monsters>) ois.readObject());
				//gp.setMonsterList(monsters)

				ois.close();
				fis.close();
			}catch(IOException e){} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		return weapons;
	}
	
}
