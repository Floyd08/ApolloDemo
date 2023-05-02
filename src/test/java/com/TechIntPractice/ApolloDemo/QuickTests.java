package com.TechIntPractice.ApolloDemo;

import java.util.ArrayList;

public class QuickTests {

	public static void main(String[] args) {
		
		Mission newMission;
		CampaignModel model = CampaignModel.getModel();
		PilotDAO pDAO = CampaignModel.getPilotDAO();
		model.loadState("{\r\n"
				+ "  \"airfields\": [\r\n"
				+ "    {\r\n"
				+ "      \"name\": \"Asch\",\r\n"
				+ "      \"airplanes\": [\r\n"
				+ "        \"P-51\",\r\n"
				+ "        \"P-38\"\r\n"
				+ "      ]\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"name\": \"Aachen\",\r\n"
				+ "      \"airplanes\": [\r\n"
				+ "        \"P-51\",\r\n"
				+ "        \"P-47\"\r\n"
				+ "      ]\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"objectives\": [\r\n"
				+ "    {\r\n"
				+ "      \"name\": \"Munchen Munitions depot\"\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"name\": \"Dortmund Airfield\"\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"name\": \"Duisberg Marshalling Yard\"\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}");
		
		//Tests begin
//		System.out.println(model.getState().toString());
//		for (int i = 0; i < 5; ++i) {
//			newMission = model.getState().generateMission();
//			System.out.println(newMission.toString());
//		}
		
		//Pilot p1 = new Pilot("Jimmy", "James", model.getState().generateMission());
		//Pilot p2 = new Pilot("Jonny", "Johnson", model.getState().generateMission());
		
		try {
			//pDAO.createPilot("Jimmy", "James", model.getState().generateMission());
			//pDAO.createPilot("Jonny", "Johnson", model.getState().generateMission());
			ArrayList<Pilot> pilots = pDAO.retrievePilots();
			System.out.println(pilots.toString());
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		pDAO.deletePilot("644067b0dd0f9b0a66401c2a");
		ArrayList<Pilot> pilots = pDAO.retrievePilots();
		System.out.println(pilots.toString());
	}

}
