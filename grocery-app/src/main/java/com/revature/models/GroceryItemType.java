package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="grocery_type")
public class GroceryItemType {

	@Id
	private int id;
	
	@Column(name="name")
	@NotNull
	@OneToMany
	private String name;

	public GroceryItemType() {
		super();
	}

	public GroceryItemType(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public GroceryItemType(int id) {
		this.id = id; 
		switch (id) {
		case 1: name = "food";
		case 2: name = "clothing";
		case 3: name = "electronics";
		case 4: name = "sundries";
		default: name = "miscellaneous";
		}
	}
	
	public GroceryItemType(String name) {
		this.name = name; 
		switch (name) {
		case "food": id = 1;
		case "clothing": id = 2;
		case "electronics": id = 3;
		case "sundries": id = 4;
		default: name = "miscellaneous";
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "GroceryItemType [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		GroceryItemType other = (GroceryItemType) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
