package com.revature.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.GroceryList;
import com.revature.services.GroceryListService;

@RestController
@RequestMapping("/grocery-lists")
public class GroceryListController {

	private GroceryListService listService;

	@Autowired
	public GroceryListController(GroceryListService listService) {
		super();
		this.listService = listService;
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<GroceryList> getAllStudySets() {
		return this.listService.getAll();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public GroceryList addGroceryList(@RequestBody GroceryList newList) {
		System.out.println(newList);
		GroceryList addedList = listService.add(newList);
		return addedList;
	}
	
	@DeleteMapping(value="/{id}")
	public void deleteGrocerySet(@PathVariable int id) {
		boolean wasDeleted = listService.delete(id);
		if(!wasDeleted) System.out.println("No grocery list with id, " + id + ", found.");
	}
	
}
