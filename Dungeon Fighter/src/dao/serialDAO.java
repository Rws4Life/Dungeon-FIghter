package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class serialDAO implements DAO{
	@SuppressWarnings("unchecked")
	@Override
	public <T> ArrayList<T> getAllElements(Class<?> t) {
		ArrayList<T> elements = null;
		File f = new File("C:\\Users\\Rws\\Desktop\\Dungeon Fighter\\Save.xml");
		
		/*
		 * Hint: Calling '.exists' on a file also returns true if
		 *  the file is a path! I may have saved you some coffee ;)
		 */
		if(f != null && f.isFile()){
			try {
				FileInputStream fis = new FileInputStream(f.getAbsolutePath());
				ObjectInputStream ois = new ObjectInputStream(fis);
				elements = ((ArrayList<T>) ois.readObject());

				ois.close();
				fis.close();
			}catch(IOException e){} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		return elements;
	}

	@Override
	public <T> boolean removeElement(T t) {
		@SuppressWarnings("unchecked")
		Class<T> cl = (Class<T>) t.getClass();
		ArrayList<T> elementsToSave = this.<T>getAllElements(cl);
		for(T type : elementsToSave)
			if(type.equals(t)){
				elementsToSave.remove(t);
				return this.saveList(cl , elementsToSave);
			}

		return false;
	}

	@Override
	public <T> boolean saveList(Class<?> c, List<T> t) {
		if("C:\\Users\\Rws\\Desktop\\Dungeon Fighter\\Save.xml" != null) 
			System.out.println("Save file: " + "C:\\Users\\Rws\\Desktop\\Dungeon Fighter\\Save.xml");
		
		try {
			FileOutputStream fos = new FileOutputStream("C:\\Users\\Rws\\Desktop\\Dungeon Fighter\\Save.xml");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(t);

			oos.close();
			fos.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

		return true;
	}

	/**
	 * Little helper method to wire a provided class to its save file.
	 * 
	 * @param t	Parameter which is used to determine the right save file.
	 * @return	The file found at the path.
	 */
	//private <T> File getFileByType(Class<T> t){

		//return new File(PathHelper.getRootPathAndAppendFileEnding(t.getSimpleName()));
		
		/*
		if(t.equals(Auction.class)){
			return new File(PathHelper.getPathAuctionsFile()).getAbsoluteFile();
		}

		if(t.equals(User.class)){
			return new File(PathHelper.getPathUsersFile());
		}

		return null;*/
	//}
}
