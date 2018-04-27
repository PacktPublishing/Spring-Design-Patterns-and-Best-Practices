package com.plantflashcards.ui;

import java.util.Map;

/**
 * A decorator design pattern that provides attributes that are specific to a plant type or subtype
 * @author ucint
 *
 */
public interface PlantDecorator {
	
	/**
	 * Human-readable label that will allow the user to decide whether or not to apply this decorator.
	 * @return a label that describes the decorator.
	 */
	String getLabel();
	
	/**
	 * HTML template that contains the attributes that a user may wish to populate for this plant type.
	 * @return HTML template
	 */
	String getTemplate();
	
	/**
	 * How to handle request parameter (name value pairs) of the submitted form
	 * @param params request parameters
	 */
	void processSubmission(Map<String,String> params, Plant plant);

}
