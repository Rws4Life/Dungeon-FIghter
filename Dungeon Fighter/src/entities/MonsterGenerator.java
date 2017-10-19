package entities;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import core.GamePlay;

public class MonsterGenerator {
	
	//GamePlay gp = new GamePlay(); SHOULD NOT BE A NEW INSTANCE - GAMEPLAY IS GOTTEN FROM DUNGEON TO MONSTER GENERATOR
	
	private List<String> enemyType = Arrays.asList("Skeleton", "Zombie", "Spider"); //Lich King, Ghost, Eldritch?
	
	
	public String generateEnemyType(int i){
		return enemyType.get(i);
	}

	
	public Monster generateMonster(GamePlay gp){ //string type, double mHealth, double bDamage, double bAccuracy, double bSpeed, int goldValue, int level
		String type = generateEnemyType(randomInt(0, 2));
		int level = (gp.getDungeonsCleared() / 10);
		
		
		
		
		
		Monster monster = new Monster();
		return monster;
	}


	
	
	public double randomDouble(double min, double max){
		double random = ThreadLocalRandom.current().nextDouble(min, max+0.1);
		double roundOff = (double) Math.round(random * 10) / 10;
		return roundOff;
	}
	public int randomInt(int min, int max){
		int random = ThreadLocalRandom.current().nextInt(min, max + 1);
		return random;
	}
}
