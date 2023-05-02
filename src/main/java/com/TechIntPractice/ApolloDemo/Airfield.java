package com.TechIntPractice.ApolloDemo;

import java.util.ArrayList;
import java.util.Random;

import lombok.Data;

public @Data class Airfield {
	private String name;
	private ArrayList<String> airplanes;
	
	public String randomAirplane() {
		
		Random geny = new Random();
		int index = geny.nextInt(airplanes.size());
		return airplanes.get(index);
	}
}
