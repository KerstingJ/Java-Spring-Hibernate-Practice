package com.luv2code.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {
	
	private String[] fortunes = new String[] {"You'll do great!", "It's gonna be an ok day", "Someone's going to die"};
	private Random rand = new Random();

	@Override
	public String getFortune() {

		return fortunes[rand.nextInt(fortunes.length)];
	}

}
