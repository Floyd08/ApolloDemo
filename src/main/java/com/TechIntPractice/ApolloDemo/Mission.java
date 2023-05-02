package com.TechIntPractice.ApolloDemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public @Data class Mission {
	private ObjectiveType obType;
	private String plane;
	private String target;
	
	public static Mission fromJSON(String JSON) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode missionJSON = mapper.readTree(JSON);
		ObjectiveType type = ObjectiveType.valueOf(missionJSON.findValue("obType").asText());
		String plane = missionJSON.findValue("plane").asText();
		String target = missionJSON.findValue("target").asText();
		return new Mission(type, plane, target);
	}
}
