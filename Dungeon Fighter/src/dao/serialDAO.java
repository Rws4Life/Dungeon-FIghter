package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import character.Player;
import character.Weapon;
import core.GamePlay;

public class serialDAO {
	
		private boolean PcOrLap=false; //true if PC, false if laptop

	public <T> boolean saveList(ArrayList<Weapon> weaponList/*, ArrayList<Monster> monsterList*/, Player player, String difficulty, int dungeonsCleared, int bossDungeonsCleared) { //get gameplay as parameter
		 
		if("C:\\Users\\Rws\\Desktop\\Dungeon Fighter\\Save.txt" != null){
			System.out.println("Save file: " + "C:\\Users\\Rws\\Desktop\\Dungeon Fighter\\Save.txt");
		}
		if("C:\\Users\\rws4l_000\\Desktop\\Dungeon Fighter\\Dungeon-Fighter\\SaveLap.txt" != null){
			System.out.println("Save file: " + "C:\\Users\\rws4l_000\\Desktop\\Dungeon Fighter\\Dungeon-Fighter\\SaveLap.txt");
		}
		try {
			if(PcOrLap==true){
				FileOutputStream fos = new FileOutputStream("C:\\Users\\Rws\\Desktop\\Dungeon Fighter\\Save.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				//gp.getMonsterList().writeObject()
				oos.writeObject(weaponList);
				//oos.writeObject(monsterList);
				oos.writeObject(player);
				oos.writeUTF(difficulty);
				oos.writeInt(dungeonsCleared);
				oos.writeInt(bossDungeonsCleared);

				oos.close();
				fos.close();
			}
			if(PcOrLap==false){
				FileOutputStream fos = new FileOutputStream("C:\\Users\\rws4l_000\\Desktop\\Dungeon Fighter\\Dungeon-Fighter\\SaveLap.txt");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				//gp.getMonsterList().writeObject()
				oos.writeObject(weaponList);
				//oos.writeObject(monsterList);
				oos.writeObject(player);
				oos.writeUTF(difficulty);
				oos.writeInt(dungeonsCleared);
				oos.writeInt(bossDungeonsCleared);

				oos.close();
				fos.close();
			}
			
			

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

		return true;
	}

	@SuppressWarnings("unchecked")
	public void loadList(GamePlay gp) {//Make class Gamedata which contains lists or make void and set inside lists
		//ArrayList<Monsters> monsters = null;
		File f = new File("");
		if(PcOrLap==true){
			File f2 = new File("C:\\Users\\Rws\\Desktop\\Dungeon Fighter\\Save.txt");
			f=f2;
		}
		if(PcOrLap==false){
			File f2 = new File("C:\\Users\\rws4l_000\\Desktop\\Dungeon Fighter\\Dungeon-Fighter\\SaveLap.txt");
			f=f2;
		}

		
		/*
		 * Hint: Calling '.exists' on a file also returns true if
		 *  the file is a path! I may have saved you some coffee ;)
		 */
		if(f != null && f.isFile()){
			try {
				FileInputStream fis = new FileInputStream(f.getAbsolutePath());
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				//monsters = ((ArrayList<Monsters>) ois.readObject());
				//gp.setMonsterList(monsters)
				gp.loadListToWeaponList(((ArrayList<Weapon>) ois.readObject()));
				gp.loadPlayer((Player) ois.readObject());
				gp.loadDifficulty((String) ois.readUTF());
				gp.loadDungeonsCleared((int) ois.readInt());
				gp.loadBossDungeonsCleared((int) ois.readInt());

				ois.close();
				fis.close();
			}catch(IOException e){} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

	}
	
}
