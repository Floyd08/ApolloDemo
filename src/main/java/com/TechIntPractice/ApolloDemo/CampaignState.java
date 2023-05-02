package com.TechIntPractice.ApolloDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public @Data class CampaignState {
	private ArrayList<Airfield> airfields;
	private ArrayList<String> objectives;
	
	
	public static CampaignState parseState(String stateJSON) throws JsonMappingException, JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode stateObj = mapper.readTree(stateJSON);
		
		JsonNode airfieldsJSON = stateObj.findValue("airfields");
		Airfield[] airfieldsArray = mapper.readValue(airfieldsJSON.toString(), Airfield[].class);
		ArrayList<Airfield> airfields = new ArrayList<Airfield>(Arrays.asList(airfieldsArray));
		
		JsonNode objectivesJSON = stateObj.findValue("objectives");
		Iterator<JsonNode> oblIterator = objectivesJSON.elements();
		ArrayList<String> objectives = new ArrayList<String>();
		while (oblIterator.hasNext()) {
			objectives.add(oblIterator.next().get("name").toString());
		}
		
		return new CampaignState(airfields, objectives);
	}
	
	public Mission generateMission() {
		ObjectiveType missionType = ObjectiveType.randomType();
		String missionPlane = this.randomAirfield().randomAirplane();
		String missionObjective = this.randomObjective();
		
		return new Mission(missionType, missionPlane, missionObjective);
	}
	
	public Airfield randomAirfield() {
		
		Random geny = new Random();
		int index = geny.nextInt(airfields.size());
		return airfields.get(index);
	}
	
	public String randomObjective() {
		
		Random geny = new Random();
		int index = geny.nextInt(objectives.size());
		return objectives.get(index);
	}

}




