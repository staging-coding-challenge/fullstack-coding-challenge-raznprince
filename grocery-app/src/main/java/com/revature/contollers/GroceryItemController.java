package com.revature.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.GroceryItem;
import com.revature.models.GroceryList;
import com.revature.services.GroceryItemService;

@RestController
@RequestMapping("/grocery-lists/{id}/items")
public class GroceryItemController {

	private GroceryItemService itemService;

	@Autowired
	public GroceryItemController(GroceryItemService itemService) {
		super();
		this.itemService = itemService;
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public GroceryItem addGroceryItem(@RequestBody GroceryItem newItem) {
		System.out.println(newItem);
		GroceryItem addedItem = itemService.add(newItem);
		return addedItem;
	}
	
	@DeleteMapping(value="/{itemId}")
	public void deleteGroceryItem(@PathVariable int id) {
		boolean wasDeleted = itemService.delete(id);
		if(!wasDeleted) System.out.println("No grocery item with id, " + id + ", found.");
	}
	
}
