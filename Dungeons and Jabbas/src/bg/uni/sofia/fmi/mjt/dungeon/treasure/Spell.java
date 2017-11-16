package bg.uni.sofia.fmi.mjt.dungeon.treasure;

import bg.uni.sofia.fmi.mjt.dungeon.actor.Hero;

public class Spell implements Treasure{
	private String name;
	private int damage;
	private int manaCost;
	public Spell(String name, int damage, int manaCost){
		this.name = name;
		this.damage = damage;
		this.manaCost = manaCost;
	}
	@Override
	public String collect(Hero h) {
		String a =  "Spell found! Damage points: " + this.damage + ", Mana cost: " + this.manaCost;
		h.learn(this);
		return a;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getManaCost() {
		return manaCost;
	}
	public void setManaCost(int manaCost) {
		this.manaCost = manaCost;
	}
	
}