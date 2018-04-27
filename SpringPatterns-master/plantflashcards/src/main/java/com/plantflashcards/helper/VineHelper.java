package com.plantflashcards.helper;

import java.util.Map;

import org.json.simple.JSONObject;

public class VineHelper extends PlantHelper {

	@Override
	public void typeSpecificJSON(JSONObject jsonObject) {
		Map<String, String> additionalProperties = plant.getAdditionalProperties();
		jsonObject.put("maxLength", additionalProperties.get("maxLength"));

	}

}
