package com.petkov.SpringAno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component("samsung") 
public class Samsung {
	
	@Autowired
	@Qualifier("mediatek")
	MobileProcessor cpu;
	
	
	public MobileProcessor getCpu() {
		return cpu;
	}
	public void setCpu(MobileProcessor cpu) {
		this.cpu = cpu;
	}
	public void config() {
		System.out.println("S7, 12MP, Octacore");
		cpu.proccess();
	}
}
