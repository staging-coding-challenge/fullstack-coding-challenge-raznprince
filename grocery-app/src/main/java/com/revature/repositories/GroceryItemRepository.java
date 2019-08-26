package com.revature.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.GroceryList;

@Repository
public interface GroceryItemRepository extends CrudRepository<GroceryList, Integer>{

}
