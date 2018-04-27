package com.plantflashcards.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.plantflashcards.helper.PlantHelper;

@Controller
@ImportResource({"/WEB-INF/classes/applicationContext.xml"})
public class HomePageController {
	
	@Autowired
	private PlantAttributeGroups plantAttributeGroups;
	
	// The decorators that apply for our plants.
	private List<PlantDecorator> plantDecorators;
	
	// All of the saved plants.
	private List<Plant> allPlants;
	
	public HomePageController() {
		plantDecorators = new ArrayList<PlantDecorator>();
		allPlants = new ArrayList<Plant>();
	}

	@RequestMapping("/home")
	public String home(@RequestParam(value="name", required=false, defaultValue="Friend") String name, Model model) {
		model.addAttribute("name", name);
		return "home";
	}
	
	@RequestMapping("/selectattributes")
	public String selectAttributes(Model model) {
		plantDecorators = new ArrayList<PlantDecorator>();
		// pass all possible decorators to our form.
		model.addAttribute("components", plantAttributeGroups.getDecorators().keySet());
		return "selectattributes";
	}
	
	@RequestMapping("/addplant")
	public String addPlant(@RequestParam Map<String,String> requestParams, Model model) {
		// get all keys of the selected attributes.
		Set<String> selectedKeys = requestParams.keySet();
		
		// a collection of templates that correspond to the user's selection
		List<String> templates = new ArrayList<String>();
		
		// iterate over the selected keys, and get the template identifier.
		for (String key : selectedKeys) {
			PlantDecorator plantDecorator = plantAttributeGroups.getDecorators().get(key);

			if (plantDecorator != null) {
				// a collection containing ONLY the selected decorators.
				plantDecorators.add(plantDecorator);
				String template = plantDecorator.getTemplate();
				templates.add(template);
			}
		}
		
		model.addAttribute("components", templates);
		model.addAttribute("plant", new Plant());
		return "addplant";
	}
	
	@RequestMapping("/saveplant")
	public String savePlant(Plant plant, @RequestParam Map<String,String> requestParams) {
		// implement the command pattern to process our decorators.
		// iterate over our Decorators, and invoke the command method
		for (PlantDecorator plantDecorator : plantDecorators) {
			plantDecorator.processSubmission(requestParams, plant);
		}
		// add the plant submitted to our collection of saved plants.
		allPlants.add(plant);
		return "saveplant";
	}
	
	@RequestMapping(value="/generateJSON", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody String generateJSON() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/classes/applicationContext.xml");
			
		// StringBuilder to contain our JSON.
		StringBuilder json = new StringBuilder();
		
		// iterate over our collection of plants, and invoke the visitor.
		for (Plant plant : allPlants) {
			Map<String, String> additionalProperties = plant.getAdditionalProperties();
			String helperBean = additionalProperties.get(Plant.HELPER);
			PlantHelper plantHelper = context.getBean(helperBean, PlantHelper.class);
			String plantJSON = plant.accept(plantHelper);
			json.append(plantJSON);
		}
		
		return json.toString();
	}
	
}
