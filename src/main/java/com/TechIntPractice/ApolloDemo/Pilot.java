package com.TechIntPractice.ApolloDemo;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public @Data class Pilot {
	private String dbID;
	private String firstName;
	private String lastName;
	private Mission currentMission;	
}
