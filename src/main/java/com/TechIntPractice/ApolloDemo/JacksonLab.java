package com.TechIntPractice.ApolloDemo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonLab {

	public static void main(String[] args) throws Exception {

		String JSON = "{\r\n"
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
				+ "}";
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(JSON);
		JsonNode airfieldsJSON = node.findValue("airfields");
		System.out.printf(airfieldsJSON.toString());
	}

}
