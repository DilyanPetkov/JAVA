package bg.uni.sofia.fmi.mjt.dungeon.treasure;

import bg.uni.sofia.fmi.mjt.dungeon.actor.Hero;

public class HealthPotion implements Treasure{
	private int healthPoints;
	public HealthPotion(int healthPoints){
		this.healthPoints = healthPoints;
	}
	public int heal(){
		return this.healthPoints;
	}
	@Override
	public String collect(Hero h) {
		String a = "Health potion found! " + this.heal() +  " health points added to your hero!";
		h.takeHealing(this.healthPoints);
		return a;
	}

}
