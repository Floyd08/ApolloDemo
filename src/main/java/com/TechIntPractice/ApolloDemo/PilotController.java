package com.TechIntPractice.ApolloDemo;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "http://18.191.37.210")
public class PilotController {
	
	CampaignModel model = CampaignModel.getModel();
	PilotDAO pDAO = CampaignModel.getPilotDAO();
	ObjectMapper mapper = new ObjectMapper();

	@PostMapping("/createPilot")
	public void createPilot(@RequestBody String nameJSON) {
		try {
			JsonNode fullName = mapper.readTree(nameJSON);
			String firstName = fullName.findValue("firstName").asText();
			String lastName = fullName.findValue("lastName").asText();
			Mission newMission = model.getState().generateMission();
			pDAO.createPilot(firstName, lastName, newMission);
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	@DeleteMapping("/deletePilot")
	public void deletePilot(@RequestParam String id) {
		System.out.println("id: " + id);
		pDAO.deletePilot(id);
	}
	
	@GetMapping("/retrievePilots")
	public ArrayList<Pilot> retrievePilots() {
		return pDAO.retrievePilots();
	}
}





