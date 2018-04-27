package com.plantflashcards.helper;

import org.json.simple.JSONObject;

import com.plantflashcards.ui.Plant;

public abstract class PlantHelper {

	private String nativeRegion;
	private EvergreenHelper evergreenHelper;
	protected Plant plant;
	
	public String visit(Plant plant) {
		
		this.plant = plant;
		return generateJSON();
	}
	
	public String getNativeRegion() {
		return nativeRegion;
	}
	public void setNativeRegion(String nativeRegion) {
		this.nativeRegion = nativeRegion;
	}
	public EvergreenHelper getEvergreenHelper() {
		return evergreenHelper;
	}
	public void setEvergreenHelper(EvergreenHelper evergreenHelper) {
		this.evergreenHelper = evergreenHelper;
	}
	
	public String generateJSON() {
		String returnValue = "";
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("genus", plant.getGenus());
		jsonObject.put("species", plant.getSpecies());
		jsonObject.put("common", plant.getCommon());
		jsonObject.put("cultivar", plant.getCultivar());
		
		// reach into our subclasses and ask them to generate any JSON they wish.
		typeSpecificJSON(jsonObject);
		
		return jsonObject.toString();
	}
	
	/**
	 * A hook into our subclasses to see if they want to generate specific JSON.
	 * @return
	 */
	public abstract void typeSpecificJSON(JSONObject jsonObject);
	
}
