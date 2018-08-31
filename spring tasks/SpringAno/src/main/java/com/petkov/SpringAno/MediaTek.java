package com.petkov.SpringAno;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("mediatek")

public class MediaTek implements MobileProcessor {

	public void proccess() {
		System.out.println("shittiest processor");

	}

}
