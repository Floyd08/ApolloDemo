package com.TechIntPractice.ApolloDemo;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.ToString;

public @ToString class CampaignModel {
	
	private static CampaignModel model;
	private static CampaignState state;
	@Getter private static PilotDAO pilotDAO;
	
	private CampaignModel() {
		state = new CampaignState();
		pilotDAO = new PilotDAO();
	}
	
	public static CampaignModel getModel() {
		if (model == null) {
			model = new CampaignModel();
		}
		return model;
	}
	
	public void loadState(String stateJSON) {
		
		try {
			
			CampaignState newState = CampaignState.parseState(stateJSON);
			model.setState(newState);
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	private void setState(CampaignState newState) {
		 state = newState;
	}
	
	public CampaignState getState() {
		return state;
	}
}
