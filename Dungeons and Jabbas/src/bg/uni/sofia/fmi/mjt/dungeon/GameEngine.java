package bg.uni.sofia.fmi.mjt.dungeon;
import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import bg.uni.sofia.fmi.mjt.dungeon.actor.*;
import bg.uni.sofia.fmi.mjt.dungeon.treasure.*;
public class GameEngine{
	private char[][] map;
	private Hero hero;
	private Enemy[] enemies;
	private Treasure[] treasures;
	public GameEngine(char[][] map, Hero hero, Enemy[] enemies, Treasure[] treasures){
		this.map = map;
		this.hero = hero;//asdsad
		this.enemies = enemies;
		this.treasures = treasures;
	}
	public char[][] getMap(){
		return this.map;
	}
	public boolean inMap(int x, int y){
		if(x < 0 || x > map[0].length || y < 0 || y > map.length){
			return false;
		}
		return true;
	}
	public String move(int x, int y){
		if(inMap(x,y) == false){
			return "Wrong move. There is an obstacle and you cannot bypass it.";
		}
		if(map[x][y] == '#')
			return "Wrong move. There is an obstacle and you cannot bypass it.";
		if(map[x][y] == '.'){
			map[hero.getPosition().getY()][hero.getPosition().getX()] = '.';
			hero.setPosition(x, y);
			map[x][y] = 'H'; 
			return "You moved successfully to the next position.";
		}
		if(map[x][y] == 'T'){
			String temp = treasures[0].collect(this.hero);
			this.treasures = Arrays.copyOfRange(this.treasures, 1, this.treasures.length);
			map[hero.getPosition().getY()][hero.getPosition().getX()] = '.';
			hero.setPosition(x, y);
			map[x][y] = 'H';
			return temp;
		}
		if(map[x][y] == 'E'){
			while(hero.isAlive()){
				enemies[0].takeDamage(hero.attack());
				if(enemies[0].isAlive()){
					hero.takeDamage(enemies[0].attack());
				}
				else{
					break;
				}
			}
			if(hero.isAlive() == false){
				return "Hero is dead! Game over!";
			}
			else{
				map[hero.getPosition().getY()][hero.getPosition().getX()] = '.';
				hero.setPosition(x, y);
				map[x][y] = 'H';
				this.enemies = Arrays.copyOfRange(this.enemies, 1, this.enemies.length);
				return "Enemy died.";
				
			}
		}
		if(map[x][y] == 'G'){
			map[hero.getPosition().getY()][hero.getPosition().getX()] = '.';
			hero.setPosition(x, y);
			map[x][y] = 'H';
			return "You have successfully passed through the dungeon. Congrats!";
		}
		return "Unknown command entered.";
		
	}
	public String makeMove(int command)
	{
		switch(command){
		case 0:
			return this.move(hero.getPosition().getX()/*-1*/, hero.getPosition().getY()-1);
		case 1:
			return this.move(hero.getPosition().getX()-1, hero.getPosition().getY()/*-1*/);
		case 2:
			return this.move(hero.getPosition().getX()/*+1*/, hero.getPosition().getY()+1);
		case 3:
			return this.move(hero.getPosition().getX()+1, hero.getPosition().getY()/*+1*/);
		default: 
			return "Unknown command entered.";
		}
	}	
}
