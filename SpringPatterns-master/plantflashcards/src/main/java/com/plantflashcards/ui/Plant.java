package com.plantflashcards.ui;

import java.util.HashMap;
import java.util.Map;

import com.plantflashcards.helper.PlantHelper;

/**
 * The data that represents a plant.
 * @author ucint
 *
 */
public class Plant {
	public static final String HELPER = "HELPER";
	private String genus;
	private String species;
	private String cultivar;
	private String common;
	
	private Map<String, String> additionalProperties;
	
	public Plant() {
		setAdditionalProperties(new HashMap<String,String>());
		additionalProperties.put(HELPER, "plantHelper");
	}
	
	public String accept(PlantHelper plantHelper) {
		return plantHelper.visit(this);
	}
	
	public String getGenus() {
		return genus;
	}
	public void setGenus(String genus) {
		this.genus = genus;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getCultivar() {
		return cultivar;
	}
	public void setCultivar(String cultivar) {
		this.cultivar = cultivar;
	}
	public String getCommon() {
		return common;
	}
	public void setCommon(String common) {
		this.common = common;
	}

	public Map<String, String> getAdditionalProperties() {
		return additionalProperties;
	}

	public void setAdditionalProperties(Map<String, String> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}
}
