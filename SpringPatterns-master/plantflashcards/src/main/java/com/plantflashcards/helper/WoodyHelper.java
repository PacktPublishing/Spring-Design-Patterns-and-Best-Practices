package com.plantflashcards.helper;

import java.util.Map;

import org.json.simple.JSONObject;

public class WoodyHelper extends PlantHelper {

	@Override
	public void typeSpecificJSON(JSONObject jsonObject) {
		Map<String, String> additionalProperties = plant.getAdditionalProperties();
		jsonObject.put("height", additionalProperties.get("height"));
		jsonObject.put("fallColor", additionalProperties.get("fallColor"));
		
	}
	
}
