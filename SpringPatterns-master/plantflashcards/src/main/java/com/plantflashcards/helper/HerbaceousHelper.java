package com.plantflashcards.helper;

import java.util.Map;

import org.json.simple.JSONObject;

public class HerbaceousHelper extends PlantHelper {
	@Override
	public void typeSpecificJSON(JSONObject jsonObject) {
		Map<String, String> additionalProperties = plant.getAdditionalProperties();
		jsonObject.put("flowerColor", additionalProperties.get("flowerColor"));
		jsonObject.put("flowerTime", additionalProperties.get("flowerTime"));
		
	}
}
