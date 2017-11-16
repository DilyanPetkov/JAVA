package bg.uni.sofia.fmi.mjt.dungeon.treasure;

import bg.uni.sofia.fmi.mjt.dungeon.actor.Hero;

public class Weapon implements Treasure{
	private String name;
	private int damage;
	public Weapon(String name, int damage){
		this.name = name;
		this.damage = damage;
	}
	public String getName()	{
		return this.name;
	}
	public int getDamage(){
		return this.damage;
	}
	@Override
	public String collect(Hero h){
		h.equip(this);
		String a = "Weapon found! Damage points: " + this.damage;
		return a;
	}
	

}
