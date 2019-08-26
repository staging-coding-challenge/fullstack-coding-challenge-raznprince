package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="grocery_list")
public class GroceryList {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name")
	@NotNull
	private String name;
	
	@Column(name="items")
	@JoinTable(
		name="GROCERY_LIST_ITEMS",
		joinColumns=@JoinColumn(name="grocery_list_id"),
		inverseJoinColumns=@JoinColumn(name="grocery_item_id")			
	)
	@ManyToMany
	private List<GroceryItem> items;
	
	public GroceryList() {
		super();
	}

	public GroceryList(int id, List<GroceryItem> items, String name) {
		super();
		this.id = id;
		this.items = items;
		this.name = name;
	}

	@Override
	public String toString() {
		return "GroceryList [id=" + id + ", items=" + items + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroceryList other = (GroceryList) obj;
		if (id != other.id)
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
		
}
