package com.plantflashcards.ui;

import java.util.Map;

public class Vine implements PlantDecorator {

	@Override
	public String getLabel() {
		return "Vine";
	}

	@Override
	public String getTemplate() {
		return "fragments/vine";
	}

	@Override
	public void processSubmission(Map<String, String> params, Plant plant) {
		Map<String, String> additionalProperties = plant.getAdditionalProperties();
		String maxLength = params.get("maxLength");
		additionalProperties.put("maxLength", maxLength);
		additionalProperties.put(Plant.HELPER, "vineHelper");
	}

}
