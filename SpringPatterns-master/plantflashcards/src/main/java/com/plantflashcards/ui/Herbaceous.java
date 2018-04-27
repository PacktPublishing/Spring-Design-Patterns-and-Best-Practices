package com.plantflashcards.ui;

import java.util.Map;

public class Herbaceous implements PlantDecorator {

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "Herbaceous Plant (Flower)";
	}

	@Override
	public String getTemplate() {
		// TODO Auto-generated method stub
		return "fragments/herbaceous";
	}

	@Override
	public void processSubmission(Map<String, String> params, Plant plant) {
		Map<String, String> additionalProperties = plant.getAdditionalProperties();
		additionalProperties.put(Plant.HELPER, "herbaceousPlantHelper");

	}

}
