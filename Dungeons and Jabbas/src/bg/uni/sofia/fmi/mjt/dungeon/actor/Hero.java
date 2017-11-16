package bg.uni.sofia.fmi.mjt.dungeon.actor;

import bg.uni.sofia.fmi.mjt.dungeon.treasure.*;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Spell;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.Weapon;

public class Hero implements Actor {
	private final int MAX_HEALTH;
	private final int MAX_MANA;
	private String name;
	private int health;
	private int mana;
	private Position position;
	private Weapon weapon;
	private Spell spell;

	public Hero(String name, int health, int mana, Position position) {
		this.name = name;
		this.health = health;
		this.mana = mana;
		this.position = position;
		this.MAX_HEALTH = health;
		this.MAX_MANA = mana;
	}
	
	public Position getPosition() {
		return this.position;
	}

	public void setPosition(int x, int y) {
		position.setX(x);
		position.setY(y);
	}

	public void equip(Weapon weapon) {
		if (this.weapon == null) {
			this.weapon = weapon;
		} else {
			if (this.weapon.getDamage() < weapon.getDamage()) {
				this.weapon = weapon;
			}
		}
	}

	public void learn(Spell spell) {
		if (this.spell == null) {
			this.spell = spell;
		} else {
			if (this.spell.getDamage() < spell.getDamage()) {
				this.spell = spell;
			}
		}
	}

	public void takeHealing(int healingPoints) {
		if (this.isAlive()) {
			if (this.health + healingPoints < MAX_HEALTH) {
				this.health += healingPoints;
			} else {
				this.health = MAX_HEALTH;
			}
		}
	}

	public void takeMana(int manapoints) {
		if (this.mana + manapoints < this.MAX_MANA) {
			this.mana += manapoints;
		} else {
			this.mana = this.MAX_MANA;
		}
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
		return this.health > 0 ? true : false;
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
		if (this.health < damagePoints) {
			this.health = 0;
		} else {
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
