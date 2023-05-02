package com.TechIntPractice.ApolloDemo;

import java.util.Random;

public enum ObjectiveType {
	CloseAirSupport, GroundStrike, StrategicBombing, 
	BattlefieldAirInterdiction, FighterSweep;
	
	private static ObjectiveType[] type = ObjectiveType.values();
	
	public static ObjectiveType getType(int index) {
		return type[index];
	}
	
	public static ObjectiveType randomType() {
		Random geny = new Random();
		return getType(geny.nextInt(type.length));
	}
}
