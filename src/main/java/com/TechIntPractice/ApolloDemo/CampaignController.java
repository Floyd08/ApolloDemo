package com.TechIntPractice.ApolloDemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "http://18.191.37.210")
public class CampaignController {
	
//	@PostMapping("/importState")
//	public void parseJSON(@RequestBody String stateJSON) {
//		System.out.println("Import request received");		
//		CampaignModel.getModel().loadState(stateJSON);
//	}
	
	@PostMapping("/importState")
	public ResponseEntity<String> parseJSON(@RequestParam MultipartFile stateFile) {
		String json = "";
		System.out.println("Import request received");
		try ( InputStream inputStream = stateFile.getInputStream();
				BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) 
		{
			
			while ( fileReader.ready() ) {
				json += fileReader.readLine();
			}
			CampaignModel.getModel().loadState(json);
			System.out.println(CampaignModel.getModel().getState().toString());
			return new ResponseEntity<>("Upload Successful", HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return new ResponseEntity<>("Upload Failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
