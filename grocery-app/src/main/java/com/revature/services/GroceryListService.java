package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.GroceryList;
import com.revature.repositories.GroceryListRepository;

@Service
public class GroceryListService {

	private GroceryListRepository listRepo;
	
	@Autowired	
	public GroceryListService(GroceryListRepository listRepo) {
		super();
		this.listRepo = listRepo;
	}
	
	@Transactional(readOnly=true, isolation=Isolation.READ_COMMITTED)
	public List<GroceryList> getAll() {
		return(List<GroceryList>) listRepo.findAll();
	}
	
	@Transactional(readOnly=true, isolation=Isolation.READ_COMMITTED)
	public GroceryList getById(int id) {
		Optional<GroceryList> _list = listRepo.findById(id);
		if(!_list.isPresent()) return null;
		return _list.get();
	}

	@Transactional
	public GroceryList add(GroceryList newList) {
		if(newList == null) return null;
		return listRepo.save(newList);
	}

	@Transactional
	public boolean delete(int id) {
		listRepo.deleteById(id);
		GroceryList list = getById(id);
		if(list == null) return true;
		return false;
	}

}
