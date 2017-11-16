package bg.uni.sofia.fmi.mjt.dungeon.treasure;

import bg.uni.sofia.fmi.mjt.dungeon.actor.Hero;

public class ManaPotion implements Treasure{
	private int manaPoints;
	public ManaPotion(int manapoints){
		this.manaPoints = manapoints;
	}
	public int heal(){
		return this.manaPoints;
	}
	@Override
	public String collect(Hero h) {
		String a = "Mana potion found! " + this.heal() +  " mana points added to your hero!";
		h.takeMana(this.manaPoints);
		return a;
	}

}
