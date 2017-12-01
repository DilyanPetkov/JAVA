package bg.uni.sofia.fmi.mjt.dungeon.actor;

import bg.uni.sofia.fmi.mjt.dungeon.treasure.Spell;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Weapon;

public class Enemy implements Actor{
	private String name;
	private int health;
	private int mana;
	private Weapon weapon;
	private Spell spell;
	public Enemy(String name, int health, int mana, Weapon weapon, Spell spell){
		this.name = name;
		this.health = health;
		this.mana = mana;
		this.weapon = weapon;
		this.spell = spell;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public int getHealth() {
		// TODO Auto-generated method stub
		return this.health;
	}

	@Override
	public int getMana() {
		// TODO Auto-generated method stub
		return this.mana;
	}

	@Override
	public boolean isAlive() {
		// TODO Auto-generated method stub
		return this.health >0 ? true : false;
	}

	@Override
	public Weapon getWeapon() {
		// TODO Auto-generated method stub
		return this.weapon;
	}

	@Override
	public Spell getSpell() {
		// TODO Auto-generated method stub
		return this.spell;
	}

	@Override
	public void takeDamage(int damagePoints) {
		if(this.health < damagePoints){
			this.health=0;
		}
		else{
			this.health -= damagePoints;
		}
	}

	@Override
	public int attack() {
		if(this.weapon != null && this.spell != null)
		{
			if(this.mana >= spell.getManaCost())
			{
				if(weapon.getDamage() > spell.getDamage())
				{
					return this.weapon.getDamage();
				}
				else
				{
				this.mana -= spell.getManaCost();
				return this.spell.getDamage();
				}
			}
			else
			{
			return this.weapon.getDamage();
			}
		}
		if(this.weapon != null){
			return this.weapon.getDamage();
		}
		if(this.spell !=null && this.mana >= spell.getManaCost()){
			this.mana -= spell.getManaCost();
			return this.spell.getDamage();
		}
		return 0;//
	}

}
