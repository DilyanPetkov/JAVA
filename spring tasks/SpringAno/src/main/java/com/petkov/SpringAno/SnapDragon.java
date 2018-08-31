package com.petkov.SpringAno;

import org.springframework.stereotype.Component;

@Component("snapdragon")
public class SnapDragon implements MobileProcessor {

	
	public void proccess() {
		System.out.println("Snapdragon octacore");
	}

}
