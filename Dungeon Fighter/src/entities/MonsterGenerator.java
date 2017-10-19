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
		double mHealth = 0;
		double bDamage = 0;
		double bAccuracy = 0;
		double bSpeed = 0;
		int goldValue = 0;
		int level = (gp.getDungeonsCleared() / 10);
		switch(level){
			case 0:
			case 1: mHealth = randomDouble(50, 75); bDamage = randomDouble(10, 20); bAccuracy = randomDouble(0.25, 0.5); bSpeed = randomInt(1, 5);break;
			case 2: mHealth = randomDouble(50, 75); bDamage = randomDouble(10, 20); bAccuracy = randomDouble(0.25, 0.5); bSpeed = randomInt(1, 5);break;
			case 3: mHealth = randomDouble(50, 75); bDamage = randomDouble(10, 20); bAccuracy = randomDouble(0.25, 0.5); bSpeed = randomInt(1, 5);break;
			case 4: mHealth = randomDouble(50, 75); bDamage = randomDouble(10, 20); bAccuracy = randomDouble(0.25, 0.5); bSpeed = randomInt(1, 5);break;
			case 5: mHealth = randomDouble(50, 75); bDamage = randomDouble(10, 20); bAccuracy = randomDouble(0.25, 0.5); bSpeed = randomInt(1, 5);break;
		}
		
		if(type == getEnemyType(0)){
			mHealth += 10;
		}
		
		//calculateValue(mHealth, bDamage, bAccuracy, bSpeed);
		goldValue = calculateValue(mHealth, bDamage, bAccuracy, bSpeed);

		
		Monster monster = new Monster(type, mHealth, bDamage, bAccuracy, bSpeed, goldValue, level);
		return monster;
	}

	
	public int calculateValue(double mHealth, double bDamage, double bAccuracy, double bSpeed){
		int value=0;
		double v=0;
		v = (mHealth/10+bDamage/5+bAccuracy*4+bSpeed/10);
		if(v>0) value = (int) (v + 0.5);
		else value = (int) (v - 0.5);
		
		return value;
	}

	public String getEnemyType(int i){
		return enemyType.get(i);
	}
	
	public double randomDouble(double min, double max){
		double random = ThreadLocalRandom.current().nextDouble(min, max+0.001);
		double roundOff = (double) Math.round(random * 10) / 10;
		return roundOff;
	}
	public int randomInt(int min, int max){
		int random = ThreadLocalRandom.current().nextInt(min, max + 1);
		return random;
	}
}
