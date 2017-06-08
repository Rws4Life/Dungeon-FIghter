package dao;

import java.util.ArrayList;
import java.util.List;

public interface DAO {
	/**
	 * Retrieve every element of the class provided.
	 * 
	 * @param c The class by which to look for the elements.
	 * @return ArrayList of type 'T'.
	 */
	public <T> ArrayList<T> getAllElements(Class<?> c);
	
	/**
	 * Remove the provided Element of type 'T' permanently.
	 * 
	 * @param t Element to delete.
	 * @return Boolean if operation succeeded.
	 */
	public <T> boolean removeElement(T t);
	
	/**
	 * Persistently save a list of elements.
	 * 
	 * @param c Parameter of any type through use of wildcard.
	 * @param t List-parameter which has to be saved.
	 * @return Boolean if operation succeeded.
	 */
	public <T> boolean saveList(Class<?> c, List<T> t);
}
