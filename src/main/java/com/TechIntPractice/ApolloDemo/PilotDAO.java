package com.TechIntPractice.ApolloDemo;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;

@Repository
public class PilotDAO {
	private MongoDatabase db;
	private MongoCollection<Document> pilotCOL;
	private ObjectMapper mapper = new ObjectMapper();
	
	public PilotDAO () {
		db = DataConnection.getInstance().getDB();
		pilotCOL = db.getCollection("Pilots");
	}
	
	public void createPilot(String firstName, String lastName, Mission newMission) throws JsonProcessingException {
		
		String missionJSON = mapper.writeValueAsString(newMission);
		pilotCOL.insertOne(new Document().append("firstName", firstName)
				.append("lastName", lastName)
				.append("mission", missionJSON));		
	}
	
	public void deletePilot(String id) {
		
		ObjectId ident = new ObjectId(id);
		Bson query = eq("_id", ident);
		pilotCOL.deleteOne(query);
	}
	
	public ArrayList<Pilot> retrievePilots() {
		
		ArrayList<Pilot> pilots = new ArrayList<Pilot>();
		try (MongoCursor<Document> cursor = pilotCOL.find().iterator()) {
			while (cursor.hasNext()) {
				Document doc = cursor.next();
				String dbID = doc.get("_id", ObjectId.class).toString();
				Mission mission = Mission.fromJSON(doc.get("mission").toString());
				String firstName = doc.get("firstName").toString();
				String lastName = doc.get("lastName").toString();
				pilots.add(new Pilot(dbID, firstName, lastName, mission));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return pilots;
	}
}
