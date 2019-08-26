package com.revature.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.GroceryItem;
import com.revature.models.GroceryList;
import com.revature.repositories.GroceryItemRepository;

@Service
public class GroceryItemService {
	
	private GroceryItemRepository itemRepo;
	
	@Autowired
	public GroceryItemService(GroceryItemRepository itemRepo) {
		super();
		this.itemRepo = itemRepo;
	}
	
	@Transactional(readOnly=true, isolation=Isolation.READ_COMMITTED)
	public Optional<GroceryList> getById(int id) {
		return itemRepo.findById(id);
	}

	@Transactional
	public GroceryItem add(GroceryItem newItem) {
		if (newItem == null) return null;
		return newItem;
	}

	@Transactional
	public boolean delete(int id) {
		itemRepo.deleteById(id);
		Optional<GroceryList> item = getById(id);
		if(item == null) return true;
		return false;
	}

}
