package com.bobsgreenhouse;

import java.util.Map;

import com.plantflashcards.ui.Plant;
import com.plantflashcards.ui.PlantDecorator;

public class Evergreen implements PlantDecorator {

	@Override
	public String getLabel() {
		return "Evergreen";
	}

	@Override
	public String getTemplate() {
		return "fragments/evergreen";
	}

	@Override
	public void processSubmission(Map<String, String> params, Plant plant) {
		String broadleafconifer = params.get("broadleafconifer");
		int i = 1 + 1;
	}

}
