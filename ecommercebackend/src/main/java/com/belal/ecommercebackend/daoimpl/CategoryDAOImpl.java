package com.belal.ecommercebackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.belal.ecommercebackend.dao.CategoryDAO;
import com.belal.ecommercebackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	public static List<Category> categories = new ArrayList<>();

	static {
		Category category = new Category();

		// adding 1st category
		category.setId(1);
		category.setName("Mobile");
		category.setDescription("This is the description for Mobile!");
		category.setImageURL("CAT_1.png");
		categories.add(category);

		// adding 2nd category
		category = new Category();
		category.setId(2);
		category.setName("Television");
		category.setDescription("This is the description for Television!");
		category.setImageURL("CAT_2.png");
		categories.add(category);

		// adding 3rd category
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is the description for Laptop!");
		category.setImageURL("CAT_3.png");
		categories.add(category);

	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {

		// enhanced for loop
		for (Category category : categories) {

			if (category.getId() == id)
				return category;
		}

		return null;

	}

}
